package com.example.android.graphgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;
//The main activity class is going to be the home page of the application.
public class MainActivity extends AppCompatActivity
{
//TODO: Do the designs and change the XML file to make the design look more professional.
//TODO: Add the background to all activities.

    public static final String DEBUGTAG = "CHRISVILLEGASB"; //Creating a DEBUGTAG for DDMS.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        Button LevelSelect = (Button) findViewById(R.id.levelsbutton); //Creating a button and relating it to the levelsbutton id.
        LevelSelect.setOnClickListener(new View.OnClickListener() //Using the onclick listener which is activated when a user clicks the level select button.
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent intent = new Intent(MainActivity.this, DifficultySelectActivity.class); //Points it to the LevelSelectActivity.
                startActivity(intent);
            }
        });

        Button Profile = (Button) findViewById(R.id.profilebutton); //Creating a button and relating it to the profile id.
        Profile.setOnClickListener(new View.OnClickListener() //Using the onclick listener which is activated when a user clicks the profile button.
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class); //Points it to the LevelSelectActivity.
                startActivity(intent);
            }
        });

        Button Play = (Button) findViewById(R.id.playbutton);
        Play.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, Play.class );
                startActivity(intent);
            }
        });
    }
}
