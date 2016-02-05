package de.rubbs.sfgtt.db;

import com.googlecode.objectify.annotation.Entity;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * Created by ruben on 29.11.15.
 */
@Builder
@Data
@Entity
public class Player {
    String name;
    String email;
    List<String> teams;
}

