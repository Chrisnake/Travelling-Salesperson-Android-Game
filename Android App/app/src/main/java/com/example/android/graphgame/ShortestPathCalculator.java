package com.example.android.graphgame;

import java.util.ArrayList;
import java.util.Collections;

/*
    USED TO CALCULATE THE SHORTEST PATH OF THE LEVEL THE USER IS PLAYING,
    RESULT OF THIS CLASS IS WHAT THE USERS ANSWER IS COMPARED TO
 */
public class ShortestPathCalculator {

    public static int levelid;
    public static ArrayList <Integer> shortestPath = new ArrayList<Integer>(ELV1Activity.L1E.size()); //

    public static int sum;

    public ShortestPathCalculator(int levelid)
    {
        this.levelid = levelid;
    }

    public static void main()
    {

    }

    public static ArrayList<Integer> randomFirstTour()
    {
        int N = ELV1Activity.L1N.size();
        ArrayList<Integer> firstTour = new ArrayList<Integer>(N);
        for(int i = 0 ; i < N ; i++)
        {
            firstTour.add(i); //Add i
        }
        Collections.shuffle(firstTour); //Shuffle the list
        return firstTour;
    }

    public static double tourCost (int N, ArrayList<Integer> t ,double[][] d )
    {
        double s = 0.0;

        for(int i = 0 ; i < (N - 1) ; i++)
        {
            int a = t.get(i); //current node
            int b = t.get(i + 1); //next node
            s = s + d[a][b];
        }

        return s;
    }

}
