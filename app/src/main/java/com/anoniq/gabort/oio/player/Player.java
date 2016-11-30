package com.anoniq.gabort.oio.player;

/**
 * Created by gabort on 11/28/2016.
 *
 * This object holds the data of each player present in the Roster of a TeamRoster (homeRoster and visitorRoster)
 * ArrayLists
 */
public class Player {

    public String playerJerseyNumber;
    public Integer playerLine;
    public boolean playerIsOnIce;
    public Integer jerseynum;

    public void setPlayerJerseyNumber (Integer jerseynum) {
        this.playerJerseyNumber = Integer.toString(jerseynum);
        this.jerseynum = jerseynum;
    }

    public void setPlayerJerseyNumberStr(String playerJerseyNumber) {
        this.playerJerseyNumber = playerJerseyNumber;
        this.jerseynum = Integer.valueOf(playerJerseyNumber);
    }

    public String getPlayerJerseyNumberStr() {
        return playerJerseyNumber;
    }

    public Integer getPllayerJerseyNumberInt() {
        return jerseynum;
    }

    public boolean isPlayerIsOnIce (Integer jerseynum){
        //Check if the player with the "jerseynum" jersey number is on ice or not.
        return false; // TODO Change this to the actual method!!!
    }

    public boolean isPlayerIsOnIce (String playerJerseyNumber){
        //Check if the player with the "playerJerseyNumber" jersey number is on ice or not.
        return false; // TODO Change this to the actual method!!!
    }

    public void setPlayerIsOnIce(boolean b) {
        this.playerIsOnIce = b;
    }

    public void setPlayerLine(Integer i) {
        this.playerLine = i;
    }

    /*public String toString() {
        if (this.playerIsOnIce){
        return playerJerseyNumber + "from Line" + playerLine.toString() + "is on ice.";}
        else{
            return playerJerseyNumber + "from Line" + playerLine.toString() + "is not on ice.";
        }
    }*/
}

