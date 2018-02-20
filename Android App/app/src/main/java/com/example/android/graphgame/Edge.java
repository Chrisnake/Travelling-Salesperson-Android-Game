package com.example.android.graphgame;

/**
 * Created by christianvillegas on 23/01/2018.
 */

//Store an edge, from node i to j with weigh w
public class Edge extends Object
{
    public int i,j,w;

    Edge(int levelid, int ii, int jj, int ww)
    {
        i = ii; //i is a vertices that connects with j
        j = jj; //j is a vertices that connects with i
        w = ww; //w is the weight of the edge
    }

    public void Print() //This method prints out the edge.
    {
        System.out.print("(");
        System.out.print(i);
        System.out.print(",");
        System.out.print(j);
        System.out.print(",");
        System.out.print(w);
        System.out.print(")");
    }

    public int getFromNode() { return i; } //Getting the Edge from the node

    public int getToNode() { return j; }

    public int getWeight() { return w; }
}