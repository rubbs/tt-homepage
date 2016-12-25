package de.rubbs.sfgtt.mail;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import lombok.extern.slf4j.Slf4j;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ruben on 29.11.15.
 */
@Slf4j
public class HandleAbteilungsratMail extends MailHandlerBase  {

    public HandleAbteilungsratMail(){
        super("abteilungsrat@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, MessagingException, JSONException {

        log.info("Mail to Abteilungsrat");
        MimeMessage rcvMsg = getMessageFromRequest(req);
        sendgridSend(rcvMsg, Util.getList("Abteilungsrat"));
        return true;
    }
}
