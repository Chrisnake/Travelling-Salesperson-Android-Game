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
    public static ArrayList <PointF> nodePoints = new ArrayList<PointF>(); //Store the points in a Point arraylist as it iterates through all the nodes
    public static ArrayList <Integer> edgeWeight = new ArrayList<Integer>();
    public static ArrayList <Node> L1N = new ArrayList <Node>();
    public static ArrayList <Edge> L1E = new ArrayList <Edge>();

//TODO: Find a way to input the nodes and allow the user to click on a node to draw a line.
//TODO: After the user clicks on a node and a new line is drawn, add the weight onto the total weight to show the users score
//TODO: Once the user has gone from the starting node and has gone through all of the streets, end the level and move onto another activity.

    public static void main()
    {
        Node node1 = new Node(levelid, 10, 40); //Node 1 at x coordinate 10, and y coordinate 20.
        Node node2 = new Node(levelid, 5, 20);
        Node node3 = new Node(levelid, 15, 20);

        Edge edge1 = new Edge(levelid, 0, 1, 1);
        Edge edge2 = new Edge(levelid, 0, 2, 2);
        Edge edge3 = new Edge(levelid, 1, 2, 3);

        //TODO: Create a method that loads the nodes and edges which can easily be switched when the database is introduced
        L1N.add(node1); //ADDING THE NODES
        L1N.add(node2);
        L1N.add(node3);

        L1E.add(edge1); //ADDING THE EDGES
        L1E.add(edge2);
        L1E.add(edge3);

        nodestoArray();
        weightstoArray();
    }

    public static void nodestoArray()
    {
        for (int i = 0; i < L1N.size(); i++) //For drawing a circle: the for loop iterates through the Level Nodes and gets the X and Y values
        {
            int rx = L1N.get(i).getX(); //Gets the Node at level 1 at index i and then gets the X coordinates of that node
            int ry = L1N.get(i).getY();
            nodePoints.add(new PointF(rx,ry)); //Add the point from the specific node
        }
    }

    public static void weightstoArray()
    {
        for(int i = 0; i < L1E.size(); i++)
        {
            edgeWeight.add(L1E.get(i).getWeight()); //Gets the edge weight from the Edge instance and adds it to the edge weight array
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        main();
        LineView lineview;
        super.onCreate(savedInstanceState);

        lineview = new LineView(this);
        lineview.getPoints(nodePoints);
        lineview.getWeights(edgeWeight);
        lineview.draw();
        setContentView(lineview);

    }
}


