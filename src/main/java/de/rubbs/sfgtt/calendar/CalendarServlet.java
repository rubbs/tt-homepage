package de.rubbs.sfgtt.calendar;

import biweekly.Biweekly;
import biweekly.ICalendar;
import biweekly.component.VEvent;
import biweekly.property.Summary;
import biweekly.util.Duration;
import de.rubbs.sfgtt.db.Match;
import de.rubbs.sfgtt.db.OfyService;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * provide caldav info about matches
 * Created by ruben on 06.01.16.
 */
@Slf4j
public class CalendarServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("calendar get");

        // check which team is requested
        String team = req.getParameter("team");
        int teamNumber = 1;
        List<Match> matches = new ArrayList<>();

        if(null != team) {
            if (team.equals("h1")) {
                teamNumber = 1;
            } else if (team.equals("h2")) {
                teamNumber = 2;
            } else if (team.equals("h3")) {
                teamNumber = 3;
            }

            // query matches from Datastore
            matches.addAll(OfyService.ofy().load().type(Match.class).filter("home.name ==", "SF Gechingen").filter("home.number ==", teamNumber).list());
            matches.addAll(OfyService.ofy().load().type(Match.class).filter("away.name ==", "SF Gechingen").filter("away.number ==", teamNumber).list());
        }
        else{
            // query for all matches
            matches.addAll(OfyService.ofy().load().type(Match.class).list());
        }

        log.info("found " + matches.size() +  " matches for team " + team);


        // create ical
        ICalendar ical = new ICalendar();

        for(Match m : matches){
            VEvent event = new VEvent();
            Summary summary = event.setSummary(m.getSummary());

            event.setDateStart(m.getDate());

            Duration duration = new Duration.Builder().hours(3).build();
            event.setDuration(duration);
            ical.addEvent(event);
        }

        resp.getWriter().print(Biweekly.write(ical).go());

    }
}
