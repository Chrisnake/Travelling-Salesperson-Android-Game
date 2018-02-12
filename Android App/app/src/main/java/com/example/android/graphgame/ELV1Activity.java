package com.example.android.graphgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class ELV1Activity extends AppCompatActivity
{
    static int levelid = 1;
//TODO: Research how to input our nodes/dots onto the phone screen and keep the nodes/dots at the same position even when the screen resolution changes
//TODO: Find a way to input the nodes and allow the user to click on a node to draw a line.
//TODO: After the user clicks on a node and a new line is drawn, add the weight onto the total weight to show the users score
//TODO: Once the user has gone from the starting node and has gone through all of the streets, end the level and move onto another activity.

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_elv1);
    }

    public static void main(String args[])
    {
        ArrayList<Levels> Level1 = new ArrayList<Levels>(); //Creating the matrix for level1
        ArrayList <Node> L1N = new ArrayList <Node>();

        int g[][] = {{0,1,2},
                     {1,0,3},
                     {2,3,0}};
        Levels Matrix = new Levels(levelid, g); //I have created a level above in the form of a 2D array and have inputted the information into level 1.
        Level1.add(Matrix);

        Node node1 = new Node(levelid, 10, 50, 20); //Node 1 at x coordinate 10, and y coordinate 20.
        Node node2 = new Node(levelid, 5, 25, 40);
        Node node3 = new Node(levelid, 15, 25, 10);

        L1N.add(node1);
        L1N.add(node2);
        L1N.add(node3);
    }

    //TODO: We need to learn how to use ontouch listeners and which classes to put them in. This is for when the user touches the screen and it automatically goes to the nearest node
    private View.OnTouchListener handleTouch = new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            int x = (int) event.getX(); //The x coordinate of where the user touches the screen
            int y = (int) event.getY(); //The y coordinate of where the user touches the screen

            switch (event.getAction())
            {
                case MotionEvent.ACTION_DOWN:
                    Log.i("TAG", "touched down");
                    break;
                case MotionEvent.ACTION_MOVE:
                    Log.i("TAG", "moving: (" + x + ", " + y + ")");
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i("TAG", "touched up");
                    break;
            }
            return true;
        }
    };


}
