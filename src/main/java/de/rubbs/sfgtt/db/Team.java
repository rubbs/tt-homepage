package de.rubbs.sfgtt.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;
import lombok.Data;

/**
 * Created by ruben on 28.12.15.
 */

@Entity
@Data
public class Team {
    @Id
    public long id;
    @Index
    private String name;
    private int number;
    private int points;

    public Team(){}

    public Team(String name, int number, int points){
        this.name = name;
        this.number = number;
        this.points = points;
    }

    public Team(String[] csvLine, boolean isHome){
        if(isHome) {
            this.name = csvLine[17];
            this.number = Integer.parseInt(csvLine[19]);
            this.points = Integer.parseInt(csvLine[25]);
        }
        else{
            this.name = csvLine[22];
            this.number = Integer.parseInt(csvLine[24]);
            this.points = Integer.parseInt(csvLine[26]);
        }
    }
}
