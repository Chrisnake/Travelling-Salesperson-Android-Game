package com.example.android.graphgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Play extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);
        Levels.getEdge();
    }
}
