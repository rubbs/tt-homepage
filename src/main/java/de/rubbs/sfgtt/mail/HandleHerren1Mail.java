package de.rubbs.sfgtt.mail;

import com.google.appengine.labs.repackaged.org.json.JSONException;
import lombok.extern.slf4j.Slf4j;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handle Emails to MailList Herren 1
 * Created by ruben on 28.11.15.
 */
@Slf4j
public class HandleHerren1Mail extends MailHandlerBase {


    public HandleHerren1Mail(){
        super("herren1@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, MessagingException, IOException, JSONException {

        MimeMessage rcvMsg = getMessageFromRequest(req);
        log.info("Mail to Herren 1 from " );
        for(Address f : rcvMsg.getFrom()){
            log.info(f.toString());
        }

        sendgridSend(rcvMsg, Util.getList("Herren 1"));




        return true;
    }


}
