package de.rubbs.sfgtt.mail;

import com.google.appengine.api.utils.SystemProperty;
import de.rubbs.sfgtt.db.Player;
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

        ///
        // send message
        ///
        MimeMessage msgToSend = prepareSendMessage(rcvMsg);
        msgToSend.addRecipient(Message.RecipientType.BCC, new InternetAddress("schwarzruben+herren1@gmail.com"));


        //TODO load players
        for(Player p : Util.getHerren1()) {
            msgToSend.addRecipient(Message.RecipientType.CC, new InternetAddress(p.getEmail()));
        }

        Transport.send(msgToSend);
        return true;
    }


}
