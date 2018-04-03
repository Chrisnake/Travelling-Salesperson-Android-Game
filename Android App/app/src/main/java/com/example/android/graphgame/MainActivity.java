package com.example.android.graphgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

//The main activity class is going to be the home page of the application.
public class MainActivity extends AppCompatActivity {
//TODO: Do the designs and change the XML file to make the design look more professional.
//TODO: Add the background to all activities.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button Play = findViewById(R.id.btnPLay); //Creating a button and relating it to Login screen.
        Play.setOnClickListener(new View.OnClickListener() //Using the onclick listener which is activated when a user clicks the level select button.
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent PlayIntent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(PlayIntent);
            }
        });

        Button  Highscores =  findViewById(R.id.btnHighscores); //Creating a button and relating it to Highscores screen.
        Highscores.setOnClickListener(new View.OnClickListener() //Using the onclick listener which is activated when a user clicks the level select button.
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent Highintent = new Intent(MainActivity.this, Highscores.class); //Points it to the Highscores.
                startActivity(Highintent);
            }
        });

        Button Credits = findViewById(R.id.btnCredits); //Creating a button and relating it to the profile id.
        Credits.setOnClickListener(new View.OnClickListener() //Using the onclick listener which is activated when a user clicks the profile button.
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent Creditsintent = new Intent(MainActivity.this, Credits.class); //Points it to the Credits Screen.
                startActivity(Creditsintent);
            }
        });
    }
}
