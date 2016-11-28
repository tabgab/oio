package com.anoniq.gabort.oio;

import android.app.Application;

import com.anoniq.gabort.oio.player.Player;

import java.util.ArrayList;

/**
 * Created by gabort on 11/28/2016.
 */

public class OioApplication extends Application {

    private ArrayList<Player> visitorRoster;
    private ArrayList<Player> homeRoster;

    @Override
    public void onCreate() {
        super.onCreate();

        // Create an array list to hold roster data
        if(null== visitorRoster) {
            visitorRoster = new ArrayList<Player>();
        }
        if(null== homeRoster) {
            homeRoster = new ArrayList<Player>();
        }
    }

    public ArrayList<Player> getvisitorRoster(){
        return visitorRoster;
    }

    public ArrayList<Player> gethomeRoster(){
        return homeRoster;
    }

    public void setVisitorRoster (ArrayList<Player> visitorRoster){
        this.visitorRoster = visitorRoster;
    }

    public void setHomeRoster (ArrayList<Player> homeRoster){
        this.homeRoster = homeRoster;
    }

    public void addVisitorRoster (Player p){
        assert(null != p);
        if (null == visitorRoster){
            visitorRoster = new ArrayList<Player>();
        }
        visitorRoster.add(p);
    }

    public void addHomeRoster (Player p){
        assert(null != p);
        if (null == homeRoster){
            homeRoster = new ArrayList<Player>();
        }
        homeRoster.add(p);
    }


}
