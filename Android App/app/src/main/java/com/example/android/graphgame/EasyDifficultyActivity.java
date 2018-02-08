package com.example.android.graphgame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//Easy difficulty class where the user accesses all the easy levels.
public class EasyDifficultyActivity extends AppCompatActivity
{
//TODO: Find a way to implement the 3 stars on each level and access the database to see how many stars the user has won on individual levels
//TODO: Start coding different levels and planning different layouts depending on the difficulties
//TODO: Try and find a more simple and code efficient way to coding level

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_difficulty);

        Button ELV1 = (Button) findViewById(R.id.ELV1); //Creating a level button that when clicked will access the certain level.

        ELV1.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View view) //This method will occur when it is clicked.
            {
                Intent intent = new Intent(EasyDifficultyActivity.this, ELV1Activity.class); //Points it to the DifficultySelectActivity.
                startActivity(intent);
            }
        });
    }
}
