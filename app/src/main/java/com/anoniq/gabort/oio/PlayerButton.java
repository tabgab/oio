package com.anoniq.gabort.oio;

/**
 * Created by gabort on 11/17/2016.
 */
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;

public class PlayerButton extends Button{
    Boolean playerisonice=false;



    public PlayerButton(Context context) {
            super(context);
            // TODO Auto-generated constructor stub
        }

        public PlayerButton(Context context, AttributeSet attrs) {
            super(context, attrs);
            // TODO Auto-generated constructor stub
            initPlayerButton(attrs);
        }

        public PlayerButton(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            // TODO Auto-generated constructor stub
            initPlayerButton(attrs);
        }

        private void initPlayerButton(AttributeSet attrs){
            TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.player_Button);
            String Jersey = a.getString(R.styleable.player_Button_jersey);
            String Position = a.getString(R.styleable.player_Button_position);
            String Onice = a.getString(R.styleable.player_Button_onice);
            //setText(Text1 + "\n" + Text2);
            a.recycle();
        }

    private void updatePlayerButton(AttributeSet attrs){
        TypedArray a = getContext().obtainStyledAttributes(attrs,R.styleable.player_Button);
        String Jersey = a.getString(R.styleable.player_Button_jersey);
        String Position = a.getString(R.styleable.player_Button_position);
        setText(Position + " " + Jersey);
        a.recycle();
    }

    public boolean isOnIce() {
        return playerisonice;

    }

    public void setOnIce(View v, String myStrg) {

        TypedArray a = getContext().obtainStyledAttributes(R.styleable.player_Button);
        // TODO set the onice property programatically
        v.setTag(R.attr.onice, myStrg);
    }

    }

