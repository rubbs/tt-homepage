package de.rubbs.sfgtt.mail;


import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
    protected boolean processMessage(HttpServletRequest req, HttpServletResponse res) throws ServletException {

        log.info("Mail to Herren 2");
        return true;
    }


}
