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
 * Handle Emails to Herren 3
 * Created by ruben on 29.11.15.
 */
@Slf4j
public class HandleHerren3Mail extends MailHandlerBase {

    public HandleHerren3Mail(){
        super("herren3@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, MessagingException, JSONException {

        log.info("Mail to Herren 3");
        MimeMessage rcvMsg = getMessageFromRequest(req);
        sendgridSend(rcvMsg, Util.getList("Herren 3"));
        return true;
    }
}
