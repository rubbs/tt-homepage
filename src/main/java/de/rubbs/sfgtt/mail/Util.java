package de.rubbs.sfgtt.mail;

import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.util.Closeable;
import de.rubbs.sfgtt.db.OfyService;
import de.rubbs.sfgtt.db.mail.MailList;
import de.rubbs.sfgtt.db.mail.Player;
import de.rubbs.sfgtt.mail.api.SfgTTApi;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 29.11.15.
 */
@Slf4j
public class Util {

    public static List<Player> getList(String list){
        // load list
        Closeable session;
        session = ObjectifyService.begin();
        List<MailList> lists = OfyService.ofy().load().type(MailList.class).filter("name =", list).list();
        if(lists == null || lists.size() != 1){
            log.error("loading list " + list + " failed");
            return null;
        }

        MailList actList = lists.get(0);

        List<Player> players = actList.loadPlayers();

        session.close();

        return players;
    }

    public static void initDatastore(){
        Closeable session;
        session = ObjectifyService.begin();

        // delete all players and lists
        OfyService.ofy().delete().entities(OfyService.ofy().load().type(MailList.class).list()).now();
        OfyService.ofy().delete().entities(OfyService.ofy().load().type(Player.class).list()).now();


        // create lists
        SfgTTApi.createMailList("Herren 1");
        SfgTTApi.createMailList("Herren 2");
        SfgTTApi.createMailList("Herren 3");
        SfgTTApi.createMailList("Abteilungsrat");

        // create Herren 1
        for(Player p : getHerren1()){
            SfgTTApi.createPlayer(p.getName(), p.getEmail());
            SfgTTApi.addPlayerToList("Herren 1", p.getName());
        }

        for(Player p : getHerren2()){
            SfgTTApi.createPlayer(p.getName(), p.getEmail());
            SfgTTApi.addPlayerToList("Herren 2", p.getName());
        }

        for(Player p : getHerren3()){
            SfgTTApi.createPlayer(p.getName(), p.getEmail());
            SfgTTApi.addPlayerToList("Herren 3", p.getName());
        }

        for(Player p : getAbteilungsrat()){
            SfgTTApi.createPlayer(p.getName(), p.getEmail());
            SfgTTApi.addPlayerToList("Abteilungsrat", p.getName());
        }

        session.close();
    }

    private static List<Player> getHerren1() {

        List<Player> p = new ArrayList<>();

        p.add(new Player("Christof Schwarz", "christofschwarz62@gmx.de"));
        p.add(new Player("Tilman Schwarz", "tilman.schwarz@gmx.de"));
        p.add(new Player("Falk Waidelich", "falk.waidelich@yahoo.de"));
        p.add(new Player("Alfred Gauss", "alfred.gauss@t-online.de"));
        p.add(new Player("Ruben Schwarz", "schwarzruben@gmail.com"));
        p.add(new Player("Reinhold Gehring", "rgehring@t-online.de"));
        p.add(new Player("Moritz Stumvoll", "mstumvoll@web.de"));

        return p;
    }

    private static List<Player> getHerren2() {

        List<Player> p = new ArrayList<>();

        p.add(new Player("Moritz Stumvoll", "mstumvoll@web.de"));
        p.add(new Player("Clemens Böttinger", "clemens-boettinger@arcor.de"));
        p.add(new Player("Meinhard Schwarz", "meinhard.schwarz@gmx.de"));
        p.add(new Player("Steffen Benesch", "steffenbenesch@web.de"));
        p.add(new Player("Benjamin Kruppa", "benjamin_kruppa@gmx.de"));
        p.add(new Player("Steffi Vetter", "stefanie.vetter@t-online.de"));
        p.add(new Player("Simon Klass", "simon.klass@onlinehome.de"));
        p.add(new Player("Andrea Breitling", "andrea.breitling@web.de"));

        return p;

    }

    private static List<Player> getHerren3() {
        List<Player> p = new ArrayList<>();

        p.add(new Player("Jan Reeß", "jan-reess@t-online.de"));
        p.add(new Player("Thomas Gabel", "thomas-gabel@gmx.net"));
        p.add(new Player("Reinhard Böttinger", "r.boettinger@outlook.de"));
        p.add(new Player("Klaus Stahl", "klaus-stahl@gmx.net"));
        p.add(new Player("Kathrin Szomolay", "Kathi_Schulze@gmx.de"));
        p.add(new Player("Andre Pilarski", "andre.pi@posteo.de"));
        p.add(new Player("Steffen Bechtold", "steffen.bechtold@gmx.de"));
        p.add(new Player("Daniel Stumvoll", "dstumvoll@web.de "));
        p.add(new Player("Lukas Maier", "lukas.maier8@gmail.com"));
        p.add(new Player("Deborah Schwarz", "debbyschwarz@gmx.de"));
        p.add(new Player("Florian Gehring", "floriangehring@gmx.de"));
        p.add(new Player("Timo Koch", "timo-koch@t-online.de"));
        p.add(new Player("Michael Siefke", "mail@michael-siefke.de"));

        return p;
    }

    private static List<Player> getAbteilungsrat() {
        List<Player> p = new ArrayList<>();

        p.add(new Player("Thomas Gabel", "thomas-gabel@gmx.net"));
        p.add(new Player("Jan Reeß", "jan-reess@t-online.de"));
        p.add(new Player("Kathrin Szomolay", "Kathi_Schulze@gmx.de"));
        p.add(new Player("Steffi Vetter", "stefanie.vetter@t-online.de"));
        p.add(new Player("Moritz Stumvoll", "mstumvoll@web.de"));

        return p;
    }
}
