package de.rubbs.sfgtt.db;

import lombok.Data;

import java.util.Date;

/**
 *
 * Created by ruben on 28.12.15.
 */
@Data
public class Match {
    Date date;
    Team home;
    Team away;
    String age;
    String location;
}
