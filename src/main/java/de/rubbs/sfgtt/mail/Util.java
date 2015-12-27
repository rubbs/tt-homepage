package de.rubbs.sfgtt.mail;

import de.rubbs.sfgtt.db.Player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 29.11.15.
 */
public class Util {

    static List<Player> getHerren1() {

        List<Player> p = new ArrayList<>();

        p.add(Player.builder().name("").email("").build());

        p.add(Player.builder().name("Christof Schwarz").email("christofschwarz62@gmx.de").build());
        p.add(Player.builder().name("Tilman Schwarz").email("tilman.schwarz@gmx.de").build());
        p.add(Player.builder().name("Falk Waidelich").email("falk.waidelich@yahoo.de").build());
        p.add(Player.builder().name("Alfred Gauss").email("alfred.gauss@t-online.de").build());
        p.add(Player.builder().name("Ruben Schwarz").email("schwarzruben@gmail.com").build());
        p.add(Player.builder().name("Reinhold Gehring").email("rgehring@t-online.de").build());
        p.add(Player.builder().name("Moritz Stumvoll").email("mstumvoll@web.de").build());

        return p;
    }
}
