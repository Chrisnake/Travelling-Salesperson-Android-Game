package com.example.android.graphgame;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.graphics.PointF;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ELV1Activity extends AppCompatActivity
{
    public static int levelid = 1;
    private LineView mLineView;
    public static ArrayList <PointF> nodePoints = new ArrayList<PointF>(); //Store the points in a Point arraylist as it iterates through all the nodes
    public static ArrayList <Node> L1N = new ArrayList <Node>();
    public static ArrayList <Edge> L1E = new ArrayList <Edge>();

//TODO: Research how to input our nodes/dots onto the phone screen and keep the nodes/dots at the same position even when the screen resolution changes
//TODO: Find a way to input the nodes and allow the user to click on a node to draw a line.
//TODO: After the user clicks on a node and a new line is drawn, add the weight onto the total weight to show the users score
//TODO: Once the user has gone from the starting node and has gone through all of the streets, end the level and move onto another activity.

    public static void main(String args[])
    {
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

        //TODO: PUTTING THE NODES INTO ITS OWN POINT ARRAYLIST: Maybe put this method inside the Node class to clean the code up
        for (int i = 0; i < L1N.size(); i++) //For drawing a circle: the for loop iterates through the Level Nodes and gets the X and Y values
        {
            int rx = L1N.get(i).getX(); //Gets the Node at level 1 at index i and then gets the X coordinates of that node
            int ry = L1N.get(i).getY();

            nodePoints.add(new PointF(rx,ry)); //Add the point from the specific node
            //TODO: draw a small circle at rx, ry, This will be the node that is drawn
        }

        //TODO: Maybe put this method inside the Edge class to clean the code up
        for (int i = 0; i < L1E.size(); i++) //For drawing the edge weights: the for loop iterates through the edges and then
        {
            int fromNode = L1E.get(i).getFromNode(); //gets the *from* node from the edges, example: fromNode = 0
            int toNode = L1E.get(i).getToNode(); //gets the *to* node from the edges, example toNode = 1
            PointF from = nodePoints.get(fromNode); //gets the POINT value of the point starting at node position 0.
            PointF to = nodePoints.get(toNode);

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

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        LineView lineview;
        super.onCreate(savedInstanceState);

        lineview = new LineView(this);
        lineview.getPoints(nodePoints);
        lineview.draw();
        setContentView(lineview);
    }
}


