package de.rubbs.sfgtt.mail;

import lombok.extern.slf4j.Slf4j;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by ruben on 29.11.15.
 */
@Slf4j
public class HandleAbteilungsratMail extends MailHandlerBase  {

    public HandleAbteilungsratMail(){
        super("abteilungsrat@(.*)");
    }

    @Override
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException {

        log.info("Mail to Abteilungsrat");
        return true;
    }
}
