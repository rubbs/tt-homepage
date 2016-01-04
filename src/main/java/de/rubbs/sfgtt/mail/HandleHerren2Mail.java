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
 * Handle Emails to Herren 2
 * Created by ruben on 28.11.15.
 */
@Slf4j
public class HandleHerren2Mail extends MailHandlerBase {

    public HandleHerren2Mail(){
        super("herren2@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, MessagingException {

        log.info("Mail to Herren 2");
        ///
        // send message
        ///
        MimeMessage rcvMsg = getMessageFromRequest(req);
        MimeMessage msgToSend = prepareSendMessage(rcvMsg);
        msgToSend.addRecipient(Message.RecipientType.BCC, new InternetAddress("schwarzruben+herren2@gmail.com"));


        //TODO load players
        for(Player p : Util.getHerren2()) {
            msgToSend.addRecipient(Message.RecipientType.CC, new InternetAddress(p.getEmail()));
        }

        Transport.send(msgToSend);
        return true;
    }


}
