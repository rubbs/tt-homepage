package de.rubbs.sfgtt.mail;


import com.google.appengine.labs.repackaged.org.json.JSONException;
import de.rubbs.sfgtt.db.mail.Player;
import lombok.extern.slf4j.Slf4j;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handle Emails to Herren 2
 * Created by ruben on 28.11.15.
 */
@Slf4j
public class HandleHerren2Mail extends MailHandlerBase {

    public HandleHerren2Mail(){
        super("herren2@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, MessagingException, JSONException {

        log.info("Mail to Herren 2");
        MimeMessage rcvMsg = getMessageFromRequest(req);
        sendgridSend(rcvMsg, Util.getList("Herren 2"));
        return true;
    }


}
