package de.rubbs.sfgtt.db;

import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Id;
import com.googlecode.objectify.annotation.Index;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 *
 * Created by ruben on 28.12.15.
 */

@Entity
public class Match {
    @com.googlecode.objectify.annotation.Id Long id;
    private Date date;

    @Index private Team home;
    @Index private Team away;
    private String age;
    private String location;

    private static DateFormat df = new SimpleDateFormat("dd.MM.yyyy HH:mm");


    public Match(){}

    public Match(String[] csvLine){
        parse(csvLine);
    }

    public void parse(String[] csvLine){
        try {
            df.setTimeZone(TimeZone.getTimeZone("Europe/Berlin"));
            this.date = df.parse(csvLine[0]);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        this.home = new Team(csvLine, true);
        this.away = new Team(csvLine, false);
        this.location = csvLine[11] + " " + csvLine[12] + " " + csvLine[13] + " " + csvLine[14];
        this.age = csvLine[5];
    }

    public String getSummary(){
        return home.getName() + " " + home.getNumber()
                + " : "
                + away.getName() + " " + away.getNumber();
    }

    public Team getHome() {
        return home;
    }

    public void setHome(Team home) {
        this.home = home;
    }

    public Team getAway() {
        return away;
    }

    public void setAway(Team away) {
        this.away = away;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
