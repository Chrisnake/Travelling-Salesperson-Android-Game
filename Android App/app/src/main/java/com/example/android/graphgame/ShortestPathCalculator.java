package com.example.android.graphgame;

import java.util.ArrayList;
import java.util.Collections;

/*
    USED TO CALCULATE THE MINIMUM SHORTEST PATH CALCULATE OF THE LEVEL THE USER IS PLAYING,
    RESULT OF THIS CLASS IS WHAT THE USERS ANSWER IS COMPARED TO
 */
public class ShortestPathCalculator {

    public static int levelid; //id OF THE LEVEL
    public static ArrayList <Integer>  t = ELV1Activity.edgeWeight;
    public static double sum = tourCost(t.size(),t);//Sum of the minimum path

    //Hold the levelid to retrieve answers from database
    public ShortestPathCalculator(int levelid)
    {
        this.levelid = levelid;
    }


    public static double tourCost (int N , ArrayList <Integer>  t )
    {
        double s = 0.0;

        for(int i = 0 ; i < N ; i++)
        {
            s += t.get(i);
        }

        sum = s ; //Total sum equals the cost of the tour
        return sum;
    }

}
