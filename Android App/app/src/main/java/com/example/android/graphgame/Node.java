package com.example.android.graphgame;
import java.util.ArrayList;
public class Node extends Object
{
    int levelid,nodenumber;
    double x, y;
    int ScreenX = 1280; //Example X - In Android Studios use function to get screen X
    int ScreenY = 720;	//Example Y - In Android Studios use function to get screen Y


    Node(int lid, double xx, double yy, int pp)
    {
        levelid = lid; //levelid is the level id and is a global variable
        x = ConvertX(xx);
        y = ConvertY(yy);
        nodenumber = pp; //nodenumber is the number of the node. For example node A = 1.
    }

    public void setX(double xx)
    {
        x = xx;
    }

    public void setY(double yy)
    {
        y = yy;
    }

    public double getX ()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

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

    public void Print() //This method prints out the node position
    {
        System.out.print("(");
        System.out.print(x);
        System.out.print(",");
        System.out.print(y);
        System.out.print(")");
    }
}
