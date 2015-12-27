package de.rubbs.sfgtt.mail;

import com.google.appengine.api.utils.SystemProperty;
import lombok.extern.slf4j.Slf4j;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Properties;

/**
 * Handle Emails to Team Herren 1
 * Created by ruben on 28.11.15.
 */
@Slf4j
public class HandleHerren1Mail extends MailHandlerBase {


    public HandleHerren1Mail(){
        super("herren1@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, MessagingException, IOException {

        MimeMessage rcvMsg = getMessageFromRequest(req);
        log.info("Mail to Herren 1 from " );

        for(Address f : rcvMsg.getFrom()){
            log.info(f.toString());
        }

        // read content
        ParseResultDTO result = getText(rcvMsg);
        log.debug("content  " +  result.getContent());

        ///
        // send message
        ///

//        Properties properties = new Properties();
//        Session session = Session.getDefaultInstance(properties);
//
//        MimeMessage msgToSend = new MimeMessage(session);
//        msgToSend.setFrom(new InternetAddress("no-reply@" + SystemProperty.applicationId.get() + ".appspotmail.com"));
//
//        msgToSend.setSubject(rcvMsg.getSubject());
//        msgToSend.addRecipient(Message.RecipientType.TO, rcvMsg.getFrom()[0]);
//        msgToSend.addRecipient(Message.RecipientType.BCC, new InternetAddress("schwarzruben+herren1@gmail.com"));
//        msgToSend.setReplyTo(rcvMsg.getFrom());
//
//        //TODO load players
//
//        if(result.isHtml()) {
//            msgToSend.setText(result.getContent(), "utf-8", "html");
//        }
//        else{
//            msgToSend.setText(result.getContent());
//        }
//
//        Transport.send(msgToSend);
        return true;
    }


}
