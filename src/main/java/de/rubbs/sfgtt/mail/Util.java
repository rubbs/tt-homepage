package de.rubbs.sfgtt.mail;

import de.rubbs.sfgtt.db.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 29.11.15.
 */
public class Util {

    public static List<Player> getHerren1() {

        List<Player> p = new ArrayList<>();

        p.add(Player.builder().name("Christof Schwarz").email("christofschwarz62@gmx.de").build());
        p.add(Player.builder().name("Tilman Schwarz").email("tilman.schwarz@gmx.de").build());
        p.add(Player.builder().name("Falk Waidelich").email("falk.waidelich@yahoo.de").build());
        p.add(Player.builder().name("Alfred Gauss").email("alfred.gauss@t-online.de").build());
        p.add(Player.builder().name("Ruben Schwarz").email("schwarzruben@gmail.com").build());
        p.add(Player.builder().name("Reinhold Gehring").email("rgehring@t-online.de").build());
        p.add(Player.builder().name("Moritz Stumvoll").email("mstumvoll@web.de").build());

        return p;
    }

    public static List<Player> getHerren2() {

        List<Player> p = new ArrayList<>();

        p.add(Player.builder().name("Moritz Stumvoll").email("mstumvoll@web.de").build());
        p.add(Player.builder().name("Clemens Böttinger").email("clemens-boettinger@arcor.de").build());
        p.add(Player.builder().name("Meinhard Schwarz").email("meinhard.schwarz@gmx.de").build());
        p.add(Player.builder().name("Steffen Benesch").email("steffenbenesch@web.de").build());
        p.add(Player.builder().name("Benjamin Kruppa").email("benjamin_kruppa@gmx.de").build());
        p.add(Player.builder().name("Klaus Waidelich").email("kwaidelich@t-online.de").build());
        p.add(Player.builder().name("Gerhard Vetter").email("stefanie.vetter@t-online.de").build());
        p.add(Player.builder().name("Steffi Vetter").email("stefanie.vetter@t-online.de").build());
        p.add(Player.builder().name("Simon Klass").email("simon.klass@onlinehome.de").build());
        p.add(Player.builder().name("Andrea Breitling").email("andrea.breitling@web.de").build());

        return p;

    }

    public static List<Player> getHerren3() {
        List<Player> p = new ArrayList<>();

        p.add(Player.builder().name("Simon Klass").email("simon.klass@onlinehome.de").build());
        p.add(Player.builder().name("Thomas Gabel").email("thomas-gabel@gmx.net").build());
        p.add(Player.builder().name("Klaus Stahl").email("klaus-stahl@gmx.net").build());
        p.add(Player.builder().name("Manuel Bühler").email("buehler.manuel@yahoo.de").build());
        p.add(Player.builder().name("Ralf Rentschler").email("ralf.rentschler@gmx.net").build());
        p.add(Player.builder().name("Jan Reeß").email("jan-reess@t-online.de").build());
        p.add(Player.builder().name("Reinhard Böttinger").email("r.boettinger@outlook.de").build());
        p.add(Player.builder().name("Kathrin Szomolay").email("Kathi_Schulze@gmx.de").build());
        p.add(Player.builder().name("Andre Pilarski").email("apurimac@gmx.de").build());
        p.add(Player.builder().name("Steffen Bechtold").email("steffen.bechtold@gmx.de").build());
        p.add(Player.builder().name("Monika Haag").email("haag-monika@t-online.de").build());
        p.add(Player.builder().name("Daniel Stumvoll").email("dstumvoll@web.de ").build());
        p.add(Player.builder().name("Lukas Maier").email("lukas.maier8@gmail.com").build());
        p.add(Player.builder().name("Deborah Schwarz").email("debbyschwarz@gmx.de").build());
        p.add(Player.builder().name("Florian Gehring").email("floriangehring@gmx.de").build());
        p.add(Player.builder().name("Timo Koch").email("timo-koch@t-online.de").build());

        return p;
    }

    public static List<Player> getAbteilungsrat() {
        List<Player> p = new ArrayList<>();

        p.add(Player.builder().name("Ruben Schwarz").email("schwarzruben@gmail.com").build());
        p.add(Player.builder().name("Thomas Gabel").email("thomas-gabel@gmx.net").build());
        p.add(Player.builder().name("Jan Reeß").email("jan-reess@t-online.de").build());
        p.add(Player.builder().name("Reinhard Böttinger").email("r.boettinger@outlook.de").build());
        p.add(Player.builder().name("Kathrin Szomolay").email("Kathi_Schulze@gmx.de").build());
        p.add(Player.builder().name("Christof Schwarz").email("christofschwarz62@gmx.de").build());
        p.add(Player.builder().name("Tilman Schwarz").email("tilman.schwarz@gmx.de").build());
        p.add(Player.builder().name("Clemens Böttinger").email("clemens-boettinger@arcor.de").build());
        p.add(Player.builder().name("Steffi Vetter").email("stefanie.vetter@t-online.de").build());
        p.add(Player.builder().name("Moritz Stumvoll").email("mstumvoll@web.de").build());

        return p;
    }
}
