package com.example.android.graphgame;

import android.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;


/**
 * Created by Mehmet on 27/01/2018.
 */

public class Highscores extends AppCompatActivity {

    /* Connect this Class to the activity_highscores.xml */


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(com.example.android.graphgame.R.layout.activity_highscores);
    };
}
