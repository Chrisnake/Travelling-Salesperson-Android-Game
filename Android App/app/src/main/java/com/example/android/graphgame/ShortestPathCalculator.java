package com.example.android.graphgame;

import java.util.ArrayList;
import java.util.Collections;

/*
    USED TO CALCULATE THE MINIMUM SHORTEST PATH CALCULATE OF THE LEVEL THE USER IS PLAYING,
    RESULT OF THIS CLASS IS WHAT THE USERS ANSWER IS COMPARED TO
 */
public class ShortestPathCalculator {

    public static int levelid; //id OF THE LEVEL
    public static ArrayList <Integer> shortestPath = new ArrayList<Integer>(ELV1Activity.L1E.size()); // Hold the edges weight

    public static double sum; //Sum of the minimum path

    public ShortestPathCalculator(int levelid)
    {
        this.levelid = levelid;
    }

    public static void main()
    {
        //Get the level
        ArrayList <Integer>  t = ELV1Activity.edgeWeight;
        //Calculate the answer
        tourCost(t.size(),t);
        //Return the level answer
        returnAnswer();
    }

    public static void tourCost (int N , ArrayList <Integer>  t )
    {
        double s = 0.0;

        for(int i = 0 ; i < t.size() ; i++)
        {
            s += t.get(i);
        }

        sum = s ; //Total sum equals the cost of the tour
    }

    public static double returnAnswer()
    {
        return sum;
    }
}
