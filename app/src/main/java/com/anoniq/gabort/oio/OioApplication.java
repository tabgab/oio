package com.anoniq.gabort.oio;

import android.app.Application;

import com.anoniq.gabort.oio.player.Player;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by gabort on 11/28/2016.
 */

public class OioApplication extends Application {

    public ArrayList<Player> visitorRoster;
    public ArrayList<Player> homeRoster;

    @Override
    public void onCreate() {
        super.onCreate();

        // Create an array list to hold roster data
        if (null == visitorRoster) {
            visitorRoster = new ArrayList<Player>();
        }
        if (null == homeRoster) {
            homeRoster = new ArrayList<Player>();
        }
        setUpDummyRosters();
    }

    public void setUpDummyRosters() {
        // This dummy setup method iterates through  i (players) setting up five lines of five players each.


        for (Integer i = 1; i <= 25; i++) {
            //setup player
            Player p = new Player();
            //for the first 5 players
            if (i <= 5) p.setPlayerLine(1);
            if (i <= 10 && i > 5) p.setPlayerLine(2);
            if (i <= 15 && i > 10) p.setPlayerLine(3);
            if (i <= 20 && i > 15) p.setPlayerLine(4);
            if (i <= 25 && i > 20) p.setPlayerLine(5);
            p.setPlayerJerseyNumber(i);
            p.setPlayerIsOnIce(false);

            // Add player to both teams
            addVisitorRoster(p);
            addHomeRoster(p);
        }

        // Add two goalkeepers (line 7), jerseys 99 and 98 for this dummy arrangement.
        Player p = new Player();
        p.setPlayerLine(7);
        p.setPlayerIsOnIce(false);
        p.setPlayerJerseyNumber(99);
        addVisitorRoster(p);
        addHomeRoster(p);

        Player q = new Player();
        q.setPlayerLine(7);
        q.setPlayerIsOnIce(false);
        q.setPlayerJerseyNumber(98);
        addVisitorRoster(q);
        addHomeRoster(q);


    }

    public ArrayList<Player> getvisitorRoster() {
        return visitorRoster;
    }

    public ArrayList<Player> gethomeRoster() {
        return homeRoster;
    }

    public void setVisitorRoster(ArrayList<Player> visitorRoster) {
        this.visitorRoster = visitorRoster;
    }

    public void setHomeRoster(ArrayList<Player> homeRoster) {
        this.homeRoster = homeRoster;
    }

    public void addVisitorRoster(Player p) {
        /*assert(null != p);
        if (null == visitorRoster){
            visitorRoster = new ArrayList<Player>();
        }*/
        visitorRoster.add(p);
    }

    public void addHomeRoster(Player p) {
        assert (null != p);
        if (null == homeRoster) {
            homeRoster = new ArrayList<Player>();
        }
        homeRoster.add(p);
    }

    public boolean visitorRosterHas(Player p) {
        return (visitorRoster.contains(p));
    }

    public boolean homeRosterHas(Player p) {
        return (homeRoster.contains(p));
    }

    public ArrayList<String> getAllJerseysOnIceVisitor() {
        ArrayList<String> jerseyList = new ArrayList<>();
        for (Integer i = 0; i < visitorRoster.size(); i++) {
            if (visitorRoster.get(i).playerIsOnIce) {
                jerseyList.add(visitorRoster.get(i).getPlayerJerseyNumberStr());
            }
        }
        return jerseyList;
    }

    public ArrayList<String> getAllJerseysOnIceHome() {
        ArrayList<String> jerseyList = new ArrayList<>();
        for (Integer i = 0; i < homeRoster.size(); i++) {
            jerseyList.add(homeRoster.get(i).getPlayerJerseyNumberStr());
        }
        return jerseyList;
    }
}
