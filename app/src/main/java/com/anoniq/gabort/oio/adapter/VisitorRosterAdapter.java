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

public class VisitorRosterAdapter extends BaseAdapter {
    public VisitorRosterAdapter() {
        super();
    }

    private ArrayList<Player> visitorRoster;
    private Context context;

    public VisitorRosterAdapter(ArrayList<Player> visitorRoster, Context context) {
        this.visitorRoster = visitorRoster;
        this.context = context;
    }

    @Override
    public int getCount() {
        return visitorRoster.size();
    }

    @Override
    public Player getItem(int position) {
        return (null == visitorRoster) ? null : visitorRoster.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null; //TODO implement this method
    }
}
