package de.rubbs.sfgtt.db;

import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

/**
 * Created by ruben on 28.12.15.
 */

@Index
public class Team {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
