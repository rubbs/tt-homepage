package de.rubbs.sfgtt.db.mail;

import com.googlecode.objectify.Ref;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import lombok.Builder;
import lombok.Data;

/**
 * Created by ruben on 29.11.15.
 */
@Data
@Entity
public class Player {
    @Id
    Long id;
    @Index
    String name;
    String email;

    public Player(){}

    public Player(String name, String email){
        this.name = name;
        this.email = email;
    }


}

