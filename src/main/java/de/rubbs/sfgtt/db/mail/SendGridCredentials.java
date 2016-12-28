package de.rubbs.sfgtt.db.mail;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import lombok.Data;

/**
 * Created by ruben on 28.12.16.
 */
@Data
@Entity
public class SendGridCredentials {

    @Id
    String username;
    String password;
}
