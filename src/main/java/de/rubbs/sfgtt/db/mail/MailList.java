package de.rubbs.sfgtt.db.mail;

import com.google.api.server.spi.config.AnnotationBoolean;
import com.google.api.server.spi.config.ApiResourceProperty;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import com.googlecode.objectify.annotation.Load;
import de.rubbs.sfgtt.db.OfyService;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ruben on 20.04.16.
 */
@Data
@Entity
public class MailList {
    @Id
    Long id;

    @Index
    String name;

    @Index
    @Load    List<Ref<Player>> players;

    @ApiResourceProperty(ignored = AnnotationBoolean.TRUE)
    public List<Ref<Player>> getPlayers(){
        return players;
    }

    public List<Player> loadPlayers()
    {
        if(players != null)
            return new ArrayList<Player>(OfyService.ofy().load().refs(players).values());
        return new ArrayList<Player>();
    }


}
