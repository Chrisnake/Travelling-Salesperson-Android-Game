package com.example.android.graphgame;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.PointF;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import android.graphics.Point;

public class Node extends Object
{
    int levelid,nodenumber;
    int x, y;
    double ScreenX = getScreenWidth(); //Example X - In Android Studios use function to get screen X
    double ScreenY = getScreenHeight();	//Example Y - In Android Studios use function to get screen Y
    ArrayList<Double> DistanceArray = new ArrayList<Double>();

    Node(int lid, int xx, int yy)
    {
        levelid = lid; //levelid is the level id and is a global variable
        x = ConvertX(xx);
        y = ConvertY(yy);
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

    public void setX(int xx)
    {
        x = xx;
    }

    public void setY(int yy)
    {
        y = yy;
    }

    public int getX ()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    public int ConvertX(int x) //Converting X from normal squared paper measurements to on screen measurements.
    {
        Double newX;
        Double oldX;
        newX = ScreenX / 20; //We are dividing by 20 here because this is the MAX X measurements of the squared paper
        oldX = newX * x;
        int i = oldX.intValue();
        setX(i);
        System.out.print(" x coordinate " + i);
        return i;
    }

    public int ConvertY(int y) //Converting Y from normal squared paper measurements to on screen measurements.
    {
        Double newY;
        Double oldX;
        newY = ScreenY / 60; //We are dividing by 20 here because this is the MAX Y measurements of the squared paper
        oldX = newY * y;
        int i = oldX.intValue();
        setY(i);
        System.out.println(" y coordinate " + i);
        return i;
    }

    //TODO: I have created an ontouchlistener that successfully gets the x and y values of the on touch, however we just need to find a way to get those values and input it into this methods parameters
    public Node NearestNode(ArrayList<Node> nodes, double touchX2, double touchY2) //Computing the nearest node where the user touches the screen that is not a node
    {
        double distance;
        double X1;
        double Y1;
        double minDist = Double.MAX_VALUE;
        int minNode = -1;

        for(int x = 0; x < nodes.size(); x++) //For loop that iterates through the nodes that are inputted in the parameter
        {
            X1 = nodes.get(x).getX(); //Getting the x position of the first Node
            Y1 = nodes.get(x).getY(); //Getting the y position of the first Node
            distance = Math.sqrt((Math.pow(2, touchY2 - Y1) + (Math.pow(2, touchX2 - X1)))); //Calculates difference between touch and nodes
            if(distance < minDist) //If the distance between the node is less than the distance before then save that distance and index position
            {
                minDist = distance;
                minNode = x;
            }
        }

        return nodes.get(minNode); //returns the node at the the position of the lowest distance
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
