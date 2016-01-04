package de.rubbs.sfgtt.mail;

import com.google.appengine.api.utils.SystemProperty;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public abstract class MailHandlerBase implements Filter {

    private Pattern pattern = null;

    protected MailHandlerBase(String pattern) {
        if (pattern == null || pattern.trim().length() == 0)
        {
            throw new IllegalArgumentException("Expected non-empty regular expression");
        }
        this.pattern = Pattern.compile("/_ah/mail/" + pattern);
    }

    @Override public void init(FilterConfig config) throws ServletException { }

    @Override public void destroy() { }

    /**
     * Process the message. A message will only be passed to this method
     * if the servletPath of the message (typically the recipient for
     * appengine) satisfies the pattern passed to the constructor. If
     * the implementation returns false, control is passed
     * to the next filter in the chain. If the implementation returns
     * true, the filter chain is terminated.
     *
     * The Matcher for the pattern can be retrieved via
     * getMatcherFromRequest (e.g. if groups are used in the pattern).
     */
    protected abstract boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, MessagingException, IOException;

    @Override
    public void doFilter(ServletRequest sreq, ServletResponse sres, FilterChain chain)
            throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) sreq;
        HttpServletResponse res = (HttpServletResponse) sres;

        log.info(req.getServletPath());

        Matcher m = applyPattern(req);

        try {
            if (m != null && processMessage(req, res)) {
                return;
            }
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        chain.doFilter(req, res); // Try the next one

    }

    private Matcher applyPattern(HttpServletRequest req) {
        Matcher m = pattern.matcher(req.getServletPath());
        if (!m.matches()) m = null;

        req.setAttribute("matcher", m);
        return m;
    }

    protected Matcher getMatcherFromRequest(ServletRequest req) {
        return (Matcher) req.getAttribute("matcher");
    }

    protected MimeMessage getMessageFromRequest(ServletRequest req) throws ServletException {
        MimeMessage message = (MimeMessage) req.getAttribute("mimeMessage");
        if (message == null) {
            try {
                Properties props = new Properties();
                Session session = Session.getDefaultInstance(props, null);
                message = new MimeMessage(session, req.getInputStream());
                req.setAttribute("mimeMessage", message);

            } catch (MessagingException e) {
                throw new ServletException("Error processing inbound message", e);
            } catch (IOException e) {
                throw new ServletException("Error processing inbound message", e);
            }
        }
        return message;
    }


    /**
     * Return the primary text content of the message.
     */
    protected ParseResultDTO getText(Part p) throws
            MessagingException, IOException {

        boolean textIsHtml;
        if (p.isMimeType("text/*")) {
            String s = (String)p.getContent();
            textIsHtml = p.isMimeType("text/html");
            return new ParseResultDTO(textIsHtml, s);
        }

        if (p.isMimeType("multipart/alternative")) {
            // prefer html text over plain text
            Multipart mp = (Multipart)p.getContent();
            ParseResultDTO text = null;
            for (int i = 0; i < mp.getCount(); i++) {
                Part bp = mp.getBodyPart(i);
                if (bp.isMimeType("text/plain")) {
                    if (text == null)
                        text = getText(bp);
                    continue;
                } else if (bp.isMimeType("text/html")) {
                    ParseResultDTO s = getText(bp);
                    if (s != null)
                        return s;
                } else {
                    return getText(bp);
                }
            }
            return text;
        } else if (p.isMimeType("multipart/*")) {
            Multipart mp = (Multipart)p.getContent();
            for (int i = 0; i < mp.getCount(); i++) {
                ParseResultDTO s = getText(mp.getBodyPart(i));
                if (s != null)
                    return s;
            }
        }

        return null;
    }

    protected MimeMessage prepareSendMessage(MimeMessage rcvMsg) throws MessagingException, IOException {
        Properties properties = new Properties();
        Session session = Session.getDefaultInstance(properties);

        MimeMessage msgToSend = new MimeMessage(session);
        msgToSend.setFrom(new InternetAddress("no-reply@" + SystemProperty.applicationId.get() + ".appspotmail.com"));

        msgToSend.setSubject(rcvMsg.getSubject());
        msgToSend.addRecipient(Message.RecipientType.TO, rcvMsg.getFrom()[0]);
        msgToSend.setReplyTo(rcvMsg.getFrom());

        // read content
        ParseResultDTO result = getText(rcvMsg);
        log.debug("content  " +  result.getContent());
        if(result.isHtml()) {
            msgToSend.setText(result.getContent(), "utf-8", "html");
        }
        else{
            msgToSend.setText(result.getContent());
        }

        return msgToSend;
    }



}