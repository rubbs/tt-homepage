package de.rubbs.sfgtt;

import com.fasterxml.jackson.databind.ObjectMapper;
import de.rubbs.sfgtt.db.Player;
import de.rubbs.sfgtt.mail.Util;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * only temporary to view mail addresses on frontend
 * Created by ruben on 27.12.15.
 */
public class MailAddressServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        String team = req.getParameter("team");
        if(team == null)
            return;


        List<Player> p = null;

        ObjectMapper mapper = new ObjectMapper();
        PrintWriter out = resp.getWriter();

        if(team.equals("herren1")){
            out.println(mapper.writeValueAsString(Util.getHerren1()));
        }
        else if(team.equals("herren2")){
            out.println(mapper.writeValueAsString(Util.getHerren2()));
        }
        else if(team.equals("herren3")){
            out.println(mapper.writeValueAsString(Util.getHerren3()));
        }
        else if(team.equals("abteilungsrat")){
            out.println(mapper.writeValueAsString(Util.getAbteilungsrat()));
        }
    }
}
