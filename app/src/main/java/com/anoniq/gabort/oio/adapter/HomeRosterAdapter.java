package com.anoniq.gabort.oio.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.anoniq.gabort.oio.player.Player;

import java.util.ArrayList;

/**
 * Created by gabort on 11/29/2016.
 */

public class HomeRosterAdapter extends BaseAdapter {

    private ArrayList<Player> homeRoster;
    private Context context;

    public HomeRosterAdapter(ArrayList<Player> homeRoster, Context context) {
        this.homeRoster = homeRoster;
        this.context = context;
    }

    @Override
    public int getCount() {
        return homeRoster.size();
    }

    @Override
    public Player getItem(int position) {
        return (null == homeRoster) ? null : homeRoster.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        return null; //TODO implement this method!!!
    }
}
