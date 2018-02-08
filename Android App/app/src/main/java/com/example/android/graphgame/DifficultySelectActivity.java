package com.example.android.graphgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DifficultySelectActivity extends AppCompatActivity
{
    public static int StarCount = 56; //Use a public integer that is accessible in every class which counts the stars that the user has.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_difficulty_select); //On create, open the activitylevelselect xml file.

        Button EasyButton = (Button) findViewById(R.id.easydbutton); //Creating a button and relating it to the levelsbutton id.

        EasyButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent intent = new Intent(DifficultySelectActivity.this, EasyDifficultyActivity.class); //Points it to the DifficultySelectActivity.
                startActivity(intent);
            }
        });

        final Button IntermediateButton = (Button) findViewById(R.id.intermediatedbutton); //Creating a button and relating it to the intermeddiate id.
        if (StarCount < 25) //If the user has not earned enough stars to access the intermediate difficulty!
        {
            IntermediateButton.setEnabled(false); //Makes the grey button unclickable
        }

        IntermediateButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                {
                    Intent intent = new Intent(DifficultySelectActivity.this, IntermediateDifficultyActivity.class); //Points it to the DifficultySelectActivity.
                    startActivity(intent);
                }
            }
        });

        final Button HardButton = (Button) findViewById(R.id.harddbutton); //Creating a button and relating it to the hardbutton id.
        if (StarCount < 50) //If the user has not earned enough stars to access the hard difficulty!
        {
            HardButton.setEnabled(false);
        }

        HardButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view)
            {
                {
                    Intent intent = new Intent(DifficultySelectActivity.this, HardDifficultyActivity.class); //Points it to the DifficultySelectActivity.
                    startActivity(intent);
                }
            }
        });
    }
}
