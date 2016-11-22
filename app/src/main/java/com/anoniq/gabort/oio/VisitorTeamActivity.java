package com.anoniq.gabort.oio;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;


public class VisitorTeamActivity extends AppCompatActivity {
   public static Integer numberofplayersonice=0; //This keeps track of how many buttons are selected.


    //DisplayMetrics display = this.getResources().getDisplayMetrics();

    //int display_width = display.widthPixels;
    //int display_height = display.heightPixels;
    //int btnWidth = (int)(display_width*0.1);  // Use this to scale the width of buttons dynamically on diff. devices.


    private static Integer incnumplayers(Integer increment) {
            numberofplayersonice = numberofplayersonice+increment;
        return numberofplayersonice;
    }
    private static Integer decnumplayers(Integer decrement) {
            if(numberofplayersonice-decrement>=0) {
                numberofplayersonice=numberofplayersonice-decrement;
                return numberofplayersonice;
            }
            else{
                return numberofplayersonice;
            }
    }

    public Integer getnumplayers() {
            return this.numberofplayersonice;
        }

    public void setnumplayers(Integer numberofplayersonice) {
            numberofplayersonice = this.numberofplayersonice;
    }

    public void numPlayersTextUpdate (String myStrg){
        TextView t;
        //TODO How the fuck do I change the text of the TextView with id "toomanytext"?
        t = (TextView)findViewById(R.id.toomanytext);
        t.setText(myStrg);

    }

    public void setPlayersTextRed()  {
        findViewById(R.id.toomanytext).setBackgroundColor(Color.parseColor("#FF0000"));
    }

    public void setPlayersTextGreen()  {
        findViewById(R.id.toomanytext).setBackgroundColor(Color.parseColor("#00FF00"));
    }


    public void editButtonText(final Button b){


        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.jerseynumbereditor);

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_VARIATION_NORMAL);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String jsy = input.getText().toString();
                if (jsy.equals("")){
                    input.setError("Entry is wrong or empty. Enter numbers only.");

                }
                else{
                    b.setText(jsy);
                }
            }
        });
        builder.setNegativeButton(R.string.calcel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        builder.show();
    }

    public void pressMe(PlayerButton pbtn){
        if (pbtn.isOnIce()){
            pbtn.setSelected(false);
            pbtn.playerisonice = false;
            VisitorTeamActivity.decnumplayers(1);
            if (numberofplayersonice <= 6) setPlayersTextGreen();
            if (numberofplayersonice > 6) setPlayersTextRed();
            String updStrg = numberofplayersonice.toString();
            numPlayersTextUpdate(updStrg);
        }
        else {
            pbtn.setSelected(true);
            pbtn.playerisonice = true;
            VisitorTeamActivity.incnumplayers(1);
            if (numberofplayersonice <= 6) setPlayersTextGreen();
            if (numberofplayersonice > 6) setPlayersTextRed();
            String updStrg = numberofplayersonice.toString();
            numPlayersTextUpdate(updStrg);

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitor_team);


        Button goBackHome = (Button)findViewById(R.id.gobackhome);
        goBackHome.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                finish();
            return true;}
        });

        final PlayerButton pf1 = (PlayerButton)findViewById(R.id.playerf1);
        pf1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf1);
            }
        });
        pf1.setOnLongClickListener(new View.OnLongClickListener(){
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf1);
                return true;}
        });

        final PlayerButton pf2 = (PlayerButton)findViewById(R.id.playerf2);
        pf2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf2);
            }
        });

        final PlayerButton pf3 = (PlayerButton)findViewById(R.id.playerf3);
        pf3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf3);
            }
        });

        final PlayerButton pf4 = (PlayerButton)findViewById(R.id.playerf4);
        pf4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf4);
            }
        });

        final PlayerButton pf5 = (PlayerButton)findViewById(R.id.playerf5);
        pf5.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf5);
            }
        });

        final PlayerButton pf6 = (PlayerButton)findViewById(R.id.playerf6);
        pf6.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf6);
            }
        });

        final PlayerButton pf7 = (PlayerButton)findViewById(R.id.playerf7);
        pf7.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf7);
            }
        });

        final PlayerButton pf8 = (PlayerButton)findViewById(R.id.playerf8);
        pf8.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf8);
            }
        });

        final PlayerButton pf9 = (PlayerButton)findViewById(R.id.playerf9);
        pf9.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf9);
            }
        });

        final PlayerButton pf10 = (PlayerButton)findViewById(R.id.playerf10);
        pf10.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf10);
            }
        });

        final PlayerButton pf11 = (PlayerButton)findViewById(R.id.playerf11);
        pf11.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf11);
            }
        });

        final PlayerButton pf12 = (PlayerButton)findViewById(R.id.playerf12);
        pf12.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pf12);
            }
        });

        final PlayerButton pd1 = (PlayerButton)findViewById(R.id.playerd1);
        pd1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd1);
            }
        });

        final PlayerButton pd2 = (PlayerButton)findViewById(R.id.playerd2);
        pd2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd2);
            }
        });

        final PlayerButton pd3 = (PlayerButton)findViewById(R.id.playerd3);
        pd3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd3);
            }
        });

        final PlayerButton pd4 = (PlayerButton)findViewById(R.id.playerd4);
        pd4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd4);
            }
        });

        final PlayerButton pd5 = (PlayerButton)findViewById(R.id.playerd5);
        pd5.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd5);
            }
        });

        final PlayerButton pd6 = (PlayerButton)findViewById(R.id.playerd6);
        pd6.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd6);
            }
        });

        final PlayerButton pd7 = (PlayerButton)findViewById(R.id.playerd7);
        pd7.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd7);
            }
        });

        final PlayerButton pd8 = (PlayerButton)findViewById(R.id.playerd8);
        pd8.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pd8);
            }
        });

        final PlayerButton pex1 = (PlayerButton)findViewById(R.id.playerex1);
        pex1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pex1);
            }
        });

        final PlayerButton pex2 = (PlayerButton)findViewById(R.id.playerex2);
        pex2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pex2);
            }
        });

        final PlayerButton pex3 = (PlayerButton)findViewById(R.id.playerex3);
        pex3.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pex3);
            }
        });

        final PlayerButton pex4 = (PlayerButton)findViewById(R.id.playerex4);
        pex4.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pex4);
            }
        });

        final PlayerButton pgk1 = (PlayerButton)findViewById(R.id.playergk1);
        pgk1.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pgk1);
            }
        });

        final PlayerButton pgk2 = (PlayerButton)findViewById(R.id.playergk2);
        pgk2.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                pressMe(pgk2);
            }
        });


    }
    }



