package com.example.android.graphgame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

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
        addTouchListener(); //adding the touch listener
        //Add node 0 to arraylist of players current position (their starting position)
        //Set current score to 0
    }

    public static void main(String args[])
    {
        ArrayList<Levels> Level1 = new ArrayList<Levels>(); //Creating the matrix for level1
        ArrayList <Node> L1N = new ArrayList <Node>();
        ArrayList <Edge> L1E = new ArrayList <Edge>();

        int g[][] = {{0,1,2},
                     {1,0,3},
                     {2,3,0}};

        Levels Matrix = new Levels(levelid, g); //I have created a level above in the form of a 2D array and have inputted the information into level 1.
        Level1.add(Matrix);

        Node node1 = new Node(levelid, 10, 50, 20); //Node 1 at x coordinate 10, and y coordinate 20.
        Node node2 = new Node(levelid, 5, 25, 40);
        Node node3 = new Node(levelid, 15, 25, 10);

        Edge edge1 = new Edge(levelid, 0, 1, 1);
        Edge edge2 = new Edge(levelid, 0, 2, 2);
        Edge edge3 = new Edge(levelid, 2, 3, 3);

        //TODO: Create a method that loads the nodes and edges which can easily be switched when the database is introduced
        L1N.add(node1); //ADDING THE NODES
        L1N.add(node2);
        L1N.add(node3);

        L1E.add(edge1); //ADDING THE EDGES
        L1E.add(edge2);
        L1E.add(edge3);

        //TODO: Maybe put this method inside the Node class to clean the code up
        for (int i = 0; i < L1N.size(); i++) //For drawing a circle: the for loop iterates through the Level Nodes and gets the X and Y values
        {
            double rx = L1N.get(i).getX(); //Gets the Node at level 1 at index i and then gets the X coordinates of that node
            double ry = L1N.get(i).getY();
            //TODO: draw a small circle at rx, ry, This will be the node that is drawn/
        }

        for (int i = 0; i < L1E.size(); i++) //For drawing the edge weights: the for loop iterates through the edges and then
        {
            int fromNode = L1E.get(i).getFromNode(); //gets the *from* node from the edges
            int toNode = L1E.get(i).getToNode(); //gets the *to* node from the edges
            int wNode = L1E.get(i).getWeight(); //gets the *weight* from the to and from nodes above

            double rxFrom = L1N.get(fromNode).getX(); //Gets the from and to nodes and calculates the middle of the line.
            double ryFrom = L1N.get(fromNode).getY();
            double rxTo = L1N.get(toNode).getX();
            double ryTo = L1N.get(toNode).getY();

            //Work out where to put the edge weight
            double wX = rxFrom + (rxTo - rxFrom) / 2.0; //+ offset to get the writing in the middle
            double wY = ryFrom + (ryTo - ryFrom) / 2.0;  //+ offset to get the writing in the middle

            //TODO: Find a way to draw a line from Node A to Node B using the drawLine function in android studios
            //drawLine(rxFrom, rxTo, ryFrom, ryTo); //Double check paramater order
        }
    }

    private void addTouchListener() //Creating an on touch listener that listens when the user touches the screen.
    {
        ImageView background = (ImageView)findViewById(R.id.Background); //Links the image view with the Background id.
        background.setOnTouchListener(new View.OnTouchListener() //Sets an on touch listener on the background.
        {
            @Override
            public boolean onTouch(View v, MotionEvent event)
            {
                float x = event.getX(); //Get the values of x and y when touched.
                float y = event.getY();
                String message = String.format("Coordinates (%.2f, %.2f)", x, y);
                Log.d(MainActivity.DEBUGTAG, message); //Debug tag for showing coordinates in the DDMS system.
                return false;
            }
        });
    }
}
