package de.rubbs.sfgtt.mail.api;

import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiNamespace;
import com.google.api.server.spi.config.Named;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import de.rubbs.sfgtt.db.OfyService;
import de.rubbs.sfgtt.db.mail.MailList;
import de.rubbs.sfgtt.db.mail.Player;
import de.rubbs.sfgtt.mail.Util;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 04.12.16.
 */
@Slf4j
@Api(name="sfgTTApi", version="v1",
        namespace = @ApiNamespace(ownerDomain = "de.rubbs.sfgtt.api",
                ownerName = "de.rubbs.sfgtt.api",
                packagePath = ""),
        clientIds = {Constants.WEB_CLIENT_ID, Constants.ANDROID_CLIENT_ID, Constants.IOS_CLIENT_ID},
        audiences = {Constants.ANDROID_AUDIENCE})
public class SfgTTApi {

    // MailLists
    @ApiMethod(name = "createMailList")
    public static MailList createMailList(@Named("name") String name) {

        MailList response = new MailList();
        response.setName(name);

        // save in datastore
        OfyService.ofy().save().entity(response).now();

        return response;
    }

    @ApiMethod(name = "addPlayerToList")
    public static MailList addPlayerToList(@Named("listName") String listName, @Named("playerName") String playerName){

        // load player
        List<Player> players = OfyService.ofy().load().type(Player.class).filter("name =", playerName).list();
        if(players == null || players.size() != 1){
            log.error("loading player " + playerName + " failed");
            return null;
        }

        // load list
        List<MailList> lists = OfyService.ofy().load().type(MailList.class).filter("name =", listName).list();
        if(lists == null || lists.size() != 1){
            log.error("loading list " + listName + " failed");
            return null;
        }

        MailList actList = lists.get(0);

        List<Ref<Player>> playerList = actList.getPlayers();
        if(playerList == null){
            playerList = new ArrayList<>();
        }
        playerList.add(Ref.create(Key.create(Player.class, players.get(0).getId())));

        actList.setPlayers(playerList);

        OfyService.ofy().save().entity(actList).now();
        return actList;
    }

    @ApiMethod(name = "deleteMailList")
    public void deleteMailList(@Named("name") String name) {

        List<MailList> MailListsToDelete = OfyService.ofy().load().type(MailList.class).filter("name =", name).list();
        // save in datastore
        for(MailList t : MailListsToDelete){
            OfyService.ofy().delete().key(Key.create(MailList.class, t.getId())).now();
        }
    }

    @ApiMethod(name = "MailLists")
    public List<MailList> listMailLists() {
        List<MailList> response = OfyService.ofy().load().type(MailList.class).list();

        return response;
    }

    private MailList loadMailList(String name){
        List<MailList> MailListsToDelete = OfyService.ofy().load().type(MailList.class).filter("name =", name).list();
        if(MailListsToDelete.isEmpty())
            return null;
        return MailListsToDelete.get(0);
    }


    // player
    @ApiMethod(name = "createPlayer")
    public static Player createPlayer(@Named("name") String name, @Named("email") String email) {

        List<Player> playerList = OfyService.ofy().load().type(Player.class).filter("name =", name).list();
        if(playerList != null && !playerList.isEmpty())
            return playerList.get(0);

        Player response = new Player();
        response.setEmail(email);
        response.setName(name);

        // save in datastore
        OfyService.ofy().save().entity(response).now();

        return response;
    }

    @ApiMethod(name = "deletePlayer")
    public void deletePlayer(@Named("name") String name) {

        List<Player> MailListsToDelete = OfyService.ofy().load().type(Player.class).filter("name =", name).list();
        // save in datastore
        for(Player t : MailListsToDelete){
            OfyService.ofy().delete().key(Key.create(Player.class, t.getId())).now();
        }
    }

    @ApiMethod(name = "playersOfList")
    public List<Player> listPlayers(@Named("name") String list) {

        return Util.getList(list);
    }

    @ApiMethod(name = "init")
    public void init() {
        Util.initDatastore();
    }
}
