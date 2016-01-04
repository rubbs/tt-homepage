package de.rubbs.sfgtt.mail;

import de.rubbs.sfgtt.db.Player;
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
 * Handle Emails to Herren 3
 * Created by ruben on 29.11.15.
 */
@Slf4j
public class HandleHerren3Mail extends MailHandlerBase {

    public HandleHerren3Mail(){
        super("herren3@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, MessagingException {

        log.info("Mail to Herren 3");
        ///
        // send message
        ///
        MimeMessage rcvMsg = getMessageFromRequest(req);
        MimeMessage msgToSend = prepareSendMessage(rcvMsg);
        msgToSend.addRecipient(Message.RecipientType.BCC, new InternetAddress("schwarzruben+herren3@gmail.com"));


        //TODO load players
        for(Player p : Util.getHerren3()) {
            msgToSend.addRecipient(Message.RecipientType.CC, new InternetAddress(p.getEmail()));
        }

        Transport.send(msgToSend);
        return true;
    }
}
