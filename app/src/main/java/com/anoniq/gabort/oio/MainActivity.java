package com.anoniq.gabort.oio;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button populatebutton = (Button)findViewById(R.id.populatebutton);


        Button visitorteambutton = (Button)findViewById(R.id.visitorteambutton);

        visitorteambutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, VisitorTeamActivity2.class);
                startActivity(intent);
            }

        });

        Button hometeambutton = (Button)findViewById(R.id.hometeambutton);

        hometeambutton.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v){
                Intent intent = new Intent(MainActivity.this, HomeTeamActivity.class);
                startActivity(intent);
            }

        });

    }

}