package com.anoniq.gabort.oio;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.anoniq.gabort.oio.player.Player;

import java.util.ArrayList;

public class PenaltyBoxAttendantActivityLayout extends AppCompatActivity {

    public static Integer numberofplayersonice = 0; //This keeps track of how many buttons are selected.
    public String[] currentLine = new String[7]; // This is where the text equivalent of selected players on ice will be stored.
    public ArrayList<Player> visitorRoster = new ArrayList<>();

    private static Integer incnumplayers(Integer increment) {
        numberofplayersonice = numberofplayersonice + increment;
        return numberofplayersonice;
    }

    private static Integer decnumplayers(Integer decrement) {
        if (numberofplayersonice - decrement >= 0) {
            numberofplayersonice = numberofplayersonice - decrement;
            return numberofplayersonice;
        } else {
            return numberofplayersonice;
        }
    }

    public Integer getnumplayers() {
        return numberofplayersonice;
    }

    public void setnumplayers(Integer numberofplayersonice) {
        numberofplayersonice = PenaltyBoxAttendantActivityLayout.numberofplayersonice;
    }

    public void numPlayersTextUpdate(String myStrg) {
        TextView t;
        t = (TextView) findViewById(R.id.toomanytext);
        t.setText(myStrg);

    }

    public void setPlayersTextRed() {
        findViewById(R.id.toomanytext).setBackgroundColor(Color.parseColor("#FF0000"));
    }

    public void setPlayersTextGreen() {
        findViewById(R.id.toomanytext).setBackgroundColor(Color.parseColor("#00FF00"));
    }


    public void editButtonText(final Button b) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.jerseynumbereditor);

        // Set up the input
        final EditText input = new EditText(this);
        // Specify the type of input expected;
        input.setInputType(InputType.TYPE_CLASS_NUMBER);
        builder.setView(input);

        // Set up the buttons
        builder.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                // Listen for errors // TODO Listen for errors?

                //get the input from the user
                String jsy = input.getText().toString();
                if (jsy.equals("")) {
                    input.setError("Entry is wrong or empty. Enter numbers only.");
                    dialog.cancel();
                } else {
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
        builder.create();
        builder.show();
    }

    public void pressMe(PlayerButton pbtn) {
        OioApplication app = (OioApplication) getApplication();
        if (pbtn.isOnIce()) {
            pbtn.setSelected(false);
            pbtn.playerisonice = false;
            PenaltyBoxAttendantActivityLayout.decnumplayers(1);
            if (numberofplayersonice <= 6) setPlayersTextGreen();
            if (numberofplayersonice > 6) setPlayersTextRed();
            String updStrg = numberofplayersonice.toString();
            numPlayersTextUpdate(updStrg);
            // and also update the roster for the VISITOR team
            //TODO take care to change this for the home team activity!!!
            String jerseyText = pbtn.getText().toString();
            app.visitorRoster.get(pbtn.getButtonIndexForPlayerArray()).setPlayerJerseyNumberStr(jerseyText);//Find the player associated with the index of this button and change its text.

            app.visitorRoster.get(pbtn.getButtonIndexForPlayerArray()).setPlayerIsOnIce(false); //Find the player associated with the index of this button and set it on ice.

            // Update the text showing which players are on ice in the UI
            ArrayList<String> jersnums = app.getAllJerseysOnIceVisitor();//Get all the jersey numbers on ice.
            String alljerseysonice = ""; // Make sure its empty first.
            // Concatenate the whole thing into a single string.
            for (int n = 0; n < jersnums.size(); n++) {
                alljerseysonice = alljerseysonice + jersnums.get(n) + ",";
            }
            //Update textView4 which displays this on screen.
            TextView t = (TextView) findViewById(R.id.textView4);
            t.setText(alljerseysonice);
        } else {
            pbtn.setSelected(true);
            pbtn.playerisonice = true;
            PenaltyBoxAttendantActivityLayout.incnumplayers(1);
            if (numberofplayersonice <= 6) setPlayersTextGreen();
            if (numberofplayersonice > 6) setPlayersTextRed();
            String updStrg = numberofplayersonice.toString();
            numPlayersTextUpdate(updStrg);
            // and also update the roster for the VISITOR team
            //TODO take care to change this for the home team activity!!!
            // Update the Player object locally.
            String jerseyText = pbtn.getText().toString();
            //TODO CHANGE LINES BELOW TO INDEX REF. or FAILS !!!

            // TODO get index of player with jerseynumber jerseyText
            app.visitorRoster.get(pbtn.getButtonIndexForPlayerArray()).setPlayerJerseyNumberStr(jerseyText);//Find the player associated with the index of this button and change its text.

            app.visitorRoster.get(pbtn.getButtonIndexForPlayerArray()).setPlayerIsOnIce(true); //Find the player assciated with the index of this button and set it on ice.

            // Update the text showing which players are on ice in the UI
            ArrayList<String> jersnums = app.getAllJerseysOnIceVisitor();//Get all the jersey numbers on ice.
            String alljerseysonice = ""; // Make sure its empty first.
            // Concatenate the whole thing into a single string.
            for (int n = 0; n < jersnums.size(); n++) {
                alljerseysonice = alljerseysonice + jersnums.get(n) + ",";
            }
            //Update textView4 which displays this on screen.
            TextView t = (TextView) findViewById(R.id.textView4);
            t.setText(alljerseysonice);
        }
    }

    private String initCurrentLine() {
        // Fill the String array currentLine[] with empty content initially.
        // This array should eventually hold the numbers of players in the ice.

        //TODO or you could simply browse the ArrayList visitorRoster and find the players that are on ice.
        String t = "";
        for (int i = 0; i < currentLine.length; i++) {
            currentLine[i] = "  ";
            t = t + currentLine[i] + ",";
        }
        return t;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penalty_box_attendant_layout);
        //final ArrayList<Player> myRoster = setupLocalCopyOfVisitorRoster(visitorRoster); // get the numbers and positions from the visitorTeamRoster into a local object.

        // Initialize the players on the ice text
        TextView players = (TextView) findViewById(R.id.textView4);
        players.setText(initCurrentLine()); // fill the text field tracking players on ice with blanks initially.

        OioApplication app = (OioApplication) getApplication();
        //setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf1),0);
        //setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf2),1);

        for (Integer i = 0; i <= app.visitorRoster.size(); i++) {
            switch (i) {
                case 0:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf1), i);
                    break;

                case 1:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf2), i);
                    break;

                case 2:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf3), i);
                    break;

                case 3:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd1), i);
                    break;

                case 4:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd2), i);
                    break;

                case 5:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf4), i);
                    break;

                case 6:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf5), i);
                    break;

                case 7:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf6), i);
                    break;

                case 8:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd3), i);
                    break;

                case 9:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd4), i);
                    break;

                case 10:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf7), i);
                    break;

                case 11:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf8), i);
                    break;

                case 12:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf9), i);
                    break;

                case 13:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd5), i);
                    break;

                case 14:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd6), i);
                    break;

                case 15:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf10), i);
                    break;

                case 16:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf11), i);
                    break;

                case 17:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerf12), i);
                    break;

                case 18:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd7), i);
                    break;

                case 19:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerd8), i);
                    break;

                case 20:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerex1), i);
                    break;

                case 21:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerex2), i);
                    break;

                case 23:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerex3), i);
                    break;

                case 24:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playerex4), i);
                    break;

                case 25:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playergk1), i);
                    break;

                case 26:
                    setInitialButtonPropertiesFromArrayList((PlayerButton) findViewById(R.id.playergk2), i);
                    break;

                default:
                    break;
            }
        }


        Button goBackHome = (Button) findViewById(R.id.gobackhome); // A long press will get you back to the MAIN Activity, removing this.
        goBackHome.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                finish();
                return true;
            }
        });

        Button recLines = (Button) findViewById(R.id.reclines); // A long press will record the current line on ice and store it. Max 3.
        recLines.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                RecordLines();
                return true;
            }
        });

        final PlayerButton pf1 = (PlayerButton) findViewById(R.id.playerf1);
        pf1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) { // Short click: add or remove from ice (select)
                pressMe(pf1);
            }
        });
        pf1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) { // Long click: Edit jersey number associated with button. //TODO CHECKS!!! AVOID DUPLICATEST, ETC.
                editButtonText(pf1);
                return true;
            }
        });

        final PlayerButton pf2 = (PlayerButton) findViewById(R.id.playerf2);
        pf2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf2);
            }
        });
        pf2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf2);
                return true;
            }
        });

        final PlayerButton pf3 = (PlayerButton) findViewById(R.id.playerf3);
        pf3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf3);
            }
        });
        pf3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf3);
                return true;
            }
        });

        final PlayerButton pf4 = (PlayerButton) findViewById(R.id.playerf4);
        pf4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf4);
            }
        });
        pf4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf4);
                return true;
            }
        });

        final PlayerButton pf5 = (PlayerButton) findViewById(R.id.playerf5);
        pf5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf5);
            }
        });
        pf5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf5);
                return true;
            }
        });

        final PlayerButton pf6 = (PlayerButton) findViewById(R.id.playerf6);
        pf6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf6);
            }
        });
        pf6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf6);
                return true;
            }
        });

        final PlayerButton pf7 = (PlayerButton) findViewById(R.id.playerf7);
        pf7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf7);
            }
        });
        pf7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf7);
                return true;
            }
        });

        final PlayerButton pf8 = (PlayerButton) findViewById(R.id.playerf8);
        pf8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf8);
            }
        });
        pf8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf8);
                return true;
            }
        });

        final PlayerButton pf9 = (PlayerButton) findViewById(R.id.playerf9);
        pf9.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf9);
            }
        });
        pf9.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf9);
                return true;
            }
        });

        final PlayerButton pf10 = (PlayerButton) findViewById(R.id.playerf10);
        pf10.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf10);
            }
        });
        pf10.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf10);
                return true;
            }
        });

        final PlayerButton pf11 = (PlayerButton) findViewById(R.id.playerf11);
        pf11.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf11);
            }
        });
        pf11.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf11);
                return true;
            }
        });

        final PlayerButton pf12 = (PlayerButton) findViewById(R.id.playerf12);
        pf12.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pf12);
            }
        });
        pf12.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pf12);
                return true;
            }
        });

        final PlayerButton pd1 = (PlayerButton) findViewById(R.id.playerd1);
        pd1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd1);
            }
        });
        pd1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd1);
                return true;
            }
        });

        final PlayerButton pd2 = (PlayerButton) findViewById(R.id.playerd2);
        pd2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd2);
            }
        });
        pd2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd2);
                return true;
            }
        });

        final PlayerButton pd3 = (PlayerButton) findViewById(R.id.playerd3);
        pd3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd3);
            }
        });
        pd3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd3);
                return true;
            }
        });

        final PlayerButton pd4 = (PlayerButton) findViewById(R.id.playerd4);
        pd4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd4);
            }
        });
        pd4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd4);
                return true;
            }
        });

        final PlayerButton pd5 = (PlayerButton) findViewById(R.id.playerd5);
        pd5.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd5);
            }
        });
        pd5.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd5);
                return true;
            }
        });

        final PlayerButton pd6 = (PlayerButton) findViewById(R.id.playerd6);
        pd6.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd6);
            }
        });
        pd6.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd6);
                return true;
            }
        });

        final PlayerButton pd7 = (PlayerButton) findViewById(R.id.playerd7);
        pd7.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd7);
            }
        });
        pd7.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd7);
                return true;
            }
        });

        final PlayerButton pd8 = (PlayerButton) findViewById(R.id.playerd8);
        pd8.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pd8);
            }
        });
        pd8.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pd8);
                return true;
            }
        });

        final PlayerButton pex1 = (PlayerButton) findViewById(R.id.playerex1);
        pex1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pex1);
            }
        });
        pex1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pex1);
                return true;
            }
        });

        final PlayerButton pex2 = (PlayerButton) findViewById(R.id.playerex2);
        pex2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pex2);
            }
        });
        pex2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pex2);
                return true;
            }
        });

        final PlayerButton pex3 = (PlayerButton) findViewById(R.id.playerex3);
        pex3.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pex3);
            }
        });
        pex3.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pex3);
                return true;
            }
        });

        final PlayerButton pex4 = (PlayerButton) findViewById(R.id.playerex4);
        pex4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pex4);
            }
        });
        pex4.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pex4);
                return true;
            }
        });

        final PlayerButton pgk1 = (PlayerButton) findViewById(R.id.playergk1);
        pgk1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pgk1);
            }
        });
        pgk1.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pgk1);
                return true;
            }
        });

        final PlayerButton pgk2 = (PlayerButton) findViewById(R.id.playergk2);
        pgk2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                pressMe(pgk2);
            }
        });
        pgk2.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                editButtonText(pgk2);
                return true;
            }
        });

        // Add listeners for "Player Line Change" buttons.
        final Button l1btn = (Button) findViewById(R.id.lineonebutton);
        l1btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pressMeLine(l1btn, 1);
                return true;
            }
        });

        final Button l2btn = (Button) findViewById(R.id.linetwobutton);
        l2btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pressMeLine(l2btn, 2);
                return true;
            }
        });

        final Button l3btn = (Button) findViewById(R.id.linethreebutton);
        l3btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pressMeLine(l3btn, 3);
                return true;
            }
        });

        final Button l4btn = (Button) findViewById(R.id.linefourbutton);
        l4btn.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                pressMeLine(l4btn, 4);
                return true;
            }
        });

    }

    private void pressMeLine(Button plinebutton, int i) {
        //TODO Add functionality when a Line Button is pressed.
        switch (i) {
            case 1:   // This is Line 1
                findViewById(R.id.playerf1).performClick();
                findViewById(R.id.playerf2).performClick();
                findViewById(R.id.playerf3).performClick();
                findViewById(R.id.playerd1).performClick();
                findViewById(R.id.playerd2).performClick();
                break;
            case 2:   // This is Line 2
                findViewById(R.id.playerf4).performClick();
                findViewById(R.id.playerf5).performClick();
                findViewById(R.id.playerf6).performClick();
                findViewById(R.id.playerd3).performClick();
                findViewById(R.id.playerd4).performClick();
                break;
            case 3:   // This is Line 3
                findViewById(R.id.playerf7).performClick();
                findViewById(R.id.playerf8).performClick();
                findViewById(R.id.playerf9).performClick();
                findViewById(R.id.playerd5).performClick();
                findViewById(R.id.playerd6).performClick();
                break;
            case 4:   // This is Line 4
                findViewById(R.id.playerf10).performClick();
                findViewById(R.id.playerf11).performClick();
                findViewById(R.id.playerf12).performClick();
                findViewById(R.id.playerd7).performClick();
                findViewById(R.id.playerd8).performClick();
                break;
        }
    }

    private void RecordLines() {

        TextView tv1 = (TextView) findViewById(R.id.textView4);
        TextView tv2 = (TextView) findViewById(R.id.textView4old1);
        TextView tv3 = (TextView) findViewById(R.id.textView4old2);
        TextView tv4 = (TextView) findViewById(R.id.textView4old3);

        tv4.setText(tv3.getText());
        tv3.setText(tv2.getText());
        tv2.setText(tv1.getText());
    }

    private void setInitialButtonPropertiesFromArrayList(PlayerButton b, Integer index) {
        OioApplication app = (OioApplication) getApplication();
        b.setText(app.visitorRoster.get(index).playerJerseyNumber);
        b.buttonIndexForPlayerArray = index;
        //This is important, because the index of the button specifies the position of the player in the
        //Arraylist<Player> visitorRoster. If the information is updated, we can use this to access the Array.
    }


}

