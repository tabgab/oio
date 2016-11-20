package com.anoniq.gabort.oio;

import java.util.HashMap;

/**
 * Created by gabort on 11/14/2016.
 */

public class TeamRoster {
    // create a hashmap to store the positions and jersey numbers of the VISITOR team.
    public HashMap<String, Integer> visitorMap = new HashMap<String, Integer>();
    // create a hashmap to store the positions and jersey numbers of the HOME team.
    public HashMap<String, Integer> homeMap = new HashMap<String, Integer>();

    //Load dummy data into hashmaps.


public  void LoadMyMapWithDummyData (){
    //HOME TEAM
    TeamRoster.this.homeMap.put("F1.1",91);
    TeamRoster.this.homeMap.put("F1.2",92);
    TeamRoster.this.homeMap.put("F1.3",93);
    TeamRoster.this.homeMap.put("D1.1",94);
    TeamRoster.this.homeMap.put("D1.2",95);
    TeamRoster.this.homeMap.put("F2.1",96);
    TeamRoster.this.homeMap.put("F2.2",97);
    TeamRoster.this.homeMap.put("F2.3",98);
    TeamRoster.this.homeMap.put("D2.1",99);
    TeamRoster.this.homeMap.put("D2.2",90);
    TeamRoster.this.homeMap.put("F3.1",89);
    TeamRoster.this.homeMap.put("F3.2",88);
    TeamRoster.this.homeMap.put("F3.3",87);
    TeamRoster.this.homeMap.put("D3.1",86);
    TeamRoster.this.homeMap.put("D3.2",85);
    TeamRoster.this.homeMap.put("GK1",1);
    TeamRoster.this.homeMap.put("GK2",30);

    //VISITOR TEAM
    TeamRoster.this.visitorMap.put("F1.1",91);
    TeamRoster.this.visitorMap.put("F1.2",92);
    TeamRoster.this.visitorMap.put("F1.3",93);
    TeamRoster.this.visitorMap.put("D1.1",94);
    TeamRoster.this.visitorMap.put("D1.2",95);
    TeamRoster.this.visitorMap.put("F2.1",96);
    TeamRoster.this.visitorMap.put("F2.2",97);
    TeamRoster.this.visitorMap.put("F2.3",98);
    TeamRoster.this.visitorMap.put("D2.1",99);
    TeamRoster.this.visitorMap.put("D2.2",90);
    TeamRoster.this.visitorMap.put("F3.1",89);
    TeamRoster.this.visitorMap.put("F3.2",88);
    TeamRoster.this.visitorMap.put("F3.3",87);
    TeamRoster.this.visitorMap.put("D3.1",86);
    TeamRoster.this.visitorMap.put("D3.2",85);
    TeamRoster.this.visitorMap.put("GK1",1);
    TeamRoster.this.visitorMap.put("GK2",30);
        }


}
