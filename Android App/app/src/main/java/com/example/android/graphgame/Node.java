package com.example.android.graphgame;
import android.content.res.Resources;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class Node extends Object
{
    int levelid,nodenumber;
    double x, y;
    double ScreenX = getScreenWidth(); //Example X - In Android Studios use function to get screen X
    double ScreenY = getScreenHeight();	//Example Y - In Android Studios use function to get screen Y
    ArrayList<Double> DistanceArray = new ArrayList<Double>();


    Node(int lid, double xx, double yy, int pp)
    {
        levelid = lid; //levelid is the level id and is a global variable
        x = ConvertX(xx);
        y = ConvertY(yy);
        nodenumber = pp; //nodenumber is the number of the node. For example node A = 1.
    }

    public static double getScreenWidth()
    {
        Log.d(MainActivity.DEBUGTAG, "Screen X");
        return Resources.getSystem().getDisplayMetrics().widthPixels;
    }

    public static double getScreenHeight()
    {
        Log.d(MainActivity.DEBUGTAG, "Screen Y");
        return Resources.getSystem().getDisplayMetrics().heightPixels;
    }

    public void setX(double xx)
    {
        x = xx;
    }

    public void setY(double yy)
    {
        y = yy;
    }

    public double getX() { return x; }

    public double getY() { return y; }

    public double ConvertX(double x) //Converting X from normal squared paper measurements to on screen measurements.
    {
        double newX;
        newX = ScreenX / 20; //We are dividing by 20 here because this is the MAX X measurements of the squared paper
        x = newX * x;
        setX(x);
        System.out.print(" x coordinate " + x);
        return x;
    }

    public double ConvertY(double y) //Converting Y from normal squared paper measurements to on screen measurements.
    {
        double newY;
        newY = ScreenY / 60; //We are dividing by 20 here because this is the MAX Y measurements of the squared paper
        y = newY * y;
        setY(y);
        System.out.println(" y coordinate " + y);
        return y;
    }

    public Node NearestNode(ArrayList<Node> nodes, double touchX2, double touchY2) //Computing the nearest node where the user touches the screen that is not a node
    {
        double distance;
        double X1 = 600.2; //Find a way to access all the nodes in the specific level
        double Y1 = 334.1;
        double minDist = Double.MAX_VALUE;
        int minNode = -1;

        for(int x = 0; x < nodes.size(); x++)
        {
            X1 = nodes.get(x).getX();
            Y1 = nodes.get(x).getY();
            distance = Math.sqrt((Math.pow(2, touchY2 - Y1) + (Math.pow(2, touchX2 - X1)))); //Calculates difference between touch and nodes
            if(distance < minDist)
            {
                minDist = distance;
                minNode = x;
            }

            DistanceArray.add(distance); //goes through all the nodes and adds the distance into a double arraylist
        }

        double NearestDistance = Collections.min(DistanceArray);
        return nodes.get(minNode);
    }

    public void Print() //This method prints out the node position
    {
        System.out.print("(");
        System.out.print(x);
        System.out.print(",");
        System.out.print(y);
        System.out.print(")");
    }
}
