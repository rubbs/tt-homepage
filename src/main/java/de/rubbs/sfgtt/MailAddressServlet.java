package de.rubbs.sfgtt;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * only temporary to view mail addresses on frontend
 * Created by ruben on 27.12.15.
 */
@Slf4j
public class MailAddressServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String name = "Herren 1";

//        // search for team
//        List<MailList> teams = OfyService.ofy().load().type(MailList.class).filter("name", name).list();
//
//        MailList mailTeam;
//
//        if (teams == null || teams.isEmpty()) {
////            create new team
//            mailTeam = new MailList();
//            mailTeam.setName("Herren 1");
//            Key<MailList> key = OfyService.ofy().save().entity(mailTeam).now();
//            if (key != null) {
//                mailTeam.setId(key.getId());
//            }
//        }
//        else{
//            log.info("found " + teams.size() + " teams");
//            mailTeam = teams.get(0);
//        }
//
//        log.info("actualt team: " + mailTeam.getName());
//
//
//        Player p1 = Player.builder().name("Fred").email("fred@fred.com").build();
//
//        // save p1 to datastore
//        Key<Player> key = OfyService.ofy().save().entity(p1).now();
//        if(key != null){
//            p1.setId(key.getId());
//        }
//
//        mailTeam. getPlayers().add(Ref.create(key));
//
//        OfyService.ofy().save().entity(mailTeam).now();



//        String team = req.getParameter("team");
//        if(team == null)
//            return;


//        ObjectMapper mapper = new ObjectMapper();
//        PrintWriter out = resp.getWriter();
//
//        if(team.equals("herren1")){
//            out.println(mapper.writeValueAsString(Util.getHerren1()));
//        }
//        else if(team.equals("herren2")){
//            out.println(mapper.writeValueAsString(Util.getHerren2()));
//        }
//        else if(team.equals("herren3")){
//            out.println(mapper.writeValueAsString(Util.getHerren3()));
//        }
//        else if(team.equals("abteilungsrat")){
//            out.println(mapper.writeValueAsString(Util.getAbteilungsrat()));
//        }
    }
}
