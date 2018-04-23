package com.example.android.graphgame;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;


import java.util.ArrayList;

public class LineView extends View {

    Paint paint;
    static ArrayList<PointF> points = new ArrayList<PointF>(); //points: all the points on the graph
    static ArrayList<Integer> weights = new ArrayList<Integer>(); //weights: the weights between the points
    static ArrayList<Integer> userPath = new ArrayList<Integer>(); //userPath: the user path that they take
    static ArrayList<Edge> edges = new ArrayList<Edge>(); //edges: the arcs in an Edge arraylist
    static int userScore = 0;

    public LineView(Context context)
    {
        super(context);
        paint = new Paint();
    }

    public LineView(Context context, @Nullable AttributeSet attrs)
    {
        super(context, attrs);
        paint = new Paint();
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        userPath.add(0);
        drawLine(canvas); //Draw the lines between the points
        drawCircle(canvas); //Draw the nodes
        drawWeights(canvas); //Draw the weights
        drawScore(canvas); //Draw the score
    }

    public void drawLine(Canvas canvas)
    {
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(10);

        for(int i = 0; i < points.size() - 1; i++)
        {
            canvas.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y, paint);
            //This draws the line and gets the points from the points array list that has been inputted from another class.
            //It then gets the x value of point and then y, and then gets the point at the position above the point before.
            //In simple terms it gets node 1, and then point 2 and then paints it.
        }

        canvas.drawLine(points.get(0).x, points.get(0).y, points.get(points.size() - 1).x, points.get(points.size() - 1).y, paint);
    }

    public void drawCircle(Canvas canvas)
    {
        paint.setColor(Color.RED);
        canvas.drawCircle(points.get(0).x, points.get(0).y, 20, paint); //Paint the first node red
        paint.setColor(Color.BLACK);
        for(int i = 1; i < points.size() - 1; i++)
        {
            canvas.drawCircle(points.get(i).x, points.get(i).y, 20, paint);
        }

        canvas.drawCircle(points.get(points.size() - 1).x, points.get(points.size() - 1).y, 20, paint);
    }

    public void drawWeights(Canvas canvas)
    {
        paint.setColor(Color.GRAY);
        paint.setTextSize(80);
        for(int i = 0; i < points.size(); i++) {
            if (i == points.size() - 1) {
                String convert = Integer.toString(weights.get(i));
                Log.i(MainActivity.DEBUGTAG, convert);
                PointF To = points.get(0); //Get the To node
                PointF From = points.get(points.size() - 1); //Get the From node

                Float x = From.x + (To.x - From.x) / 2; //Calculates the middle x value
                Float y = From.y + (To.y - From.y) / 2; //Calculates the middle y value
                canvas.drawText(convert, x, y, paint);
            } else {
                PointF To = points.get(i); //Get the To node
                PointF From = points.get(i + 1); //Get the From node

                Float x = From.x + (To.x - From.x) / 2 - 80; //Calculates the middle x value
                Float y = From.y + (To.y - From.y) / 2; //Calculates the middle y value

                String convert = Integer.toString(weights.get(i)); //Converts the int weight at position i to a string
                Log.i(MainActivity.DEBUGTAG, convert);
                canvas.drawText(convert, x, y, paint);
            }
        }
    }

    public void drawScore(Canvas canvas)
    {
        paint.setColor(Color.BLACK);
        paint.setTextSize(270);
        String convert = Integer.toString(userScore); //TODO: How to change value of score when userScore updates
        canvas.drawText(convert,450,350, paint);
    }

    //This method gets the array list of nodes (points) and then puts puts it into this class so the drawline occurs.
    public static ArrayList<PointF> getPoints (ArrayList<PointF> point)
    {
        points = point; //ACTS AS A SETTER FOR POINTS ARRAYLIST
        return points;
    }

    public static ArrayList<Integer> getWeights (ArrayList<Integer> weight)
    {
        weights = weight; //ACTS AS A SETTER FOR WEIGHTS ARRAYLIST
        return weights;
    }

    public static ArrayList<Edge> getEdges (ArrayList<Edge> edge)
    {
       edges = edge; //ACTS AS A SETTER FOR EDGES ARRAYLIST
       return edges;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }

    public int currentNode() //This method returns what node the user is currently on
    {
        int thisNode = userPath.get(userPath.size() - 1); //Get's the size of userPath, -1 and this will always be the most updated node.
        return thisNode;
    }

    public boolean NodeLink(int toNode) //This method checks if there is a link between the current node and the TO node.
    {
        boolean check = true;
        int fromNode = currentNode();
        for(int i = 0; i < edges.size(); i++) //goes through edges array list to check whether there is a link.
        {
            if(edges.get(i).hasLink(fromNode,toNode))
            {
                check = true;
                Log.d(MainActivity.DEBUGTAG, "THERE IS A LINK");
                break;
            }
            else
            {
                check = false;
            }
        }
        return check;
    }

    public int LinkWeight(int toNode) //This method checks if there is a link between the current node and the TO node.
    {
        int weight;
        if(toNode == 0) //If they are returning back to their starting node and are finished.
        {
            weight = weights.get(weights.size());
        }
        else
        {
            weight = weights.get(toNode - 1);

            String message = "Weight of node touched: " + Integer.toString(weight);
            Log.d(MainActivity.DEBUGTAG, message);
            Log.d(MainActivity.DEBUGTAG, "THERE IS A LINK");
            String message2 = "Weight of arc: " + Integer.toString(weight);
            Log.d(MainActivity.DEBUGTAG, message2);
        }
        return weight;
    }

    public int whatNode(float userX, float userY) //Check what node the user is on
    {
        int thisNode = -1;

        for(int i = 0; i < points.size(); i++)
        {
            if (userX > points.get(i).x - 40 && userX < points.get(i).x + 40 && userY > points.get(i).y - 40 && userY < points.get(i).y + 40) //checks if user touches a node i
            {
                thisNode = i;
                String message = "Node Touched: " + Integer.toString(thisNode);
                Log.d(MainActivity.DEBUGTAG, message);
                break;
            }
        }
        return thisNode;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) //On touch event on the canvas
    {
        float x = event.getX();
        float y = event.getY();
        int toNode = whatNode(x, y);

        if (toNode != -1 && NodeLink(toNode)) //If the user touched node is ACTUALLY a node, AND IF the nodelink is true.
        {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(MainActivity.DEBUGTAG, "I PRESSED ON A CIRCLE!");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(MainActivity.DEBUGTAG, "MY FINGER LEFT A CIRCLE");
                        userPath.add(toNode); //Add node to user path
                        userScore = userScore + LinkWeight(toNode); //Updating the user score
                        String message = "UserScore: " + Integer.toString(userScore);
                        Log.i(MainActivity.DEBUGTAG, message);
                        break;
                }
        }
        else if (toNode != -1 && !NodeLink(toNode)) //If the user touched node is ACTUALLY a node, BUT there is no link.
        {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i(MainActivity.DEBUGTAG, "I PRESSED ON A CIRCLE THAT DOES NOT HAVE A LINK!");

                    break;
                case MotionEvent.ACTION_UP:
                    Log.i(MainActivity.DEBUGTAG, "MY FINGER LEFT A CIRCLE THAT DOES NOT HAVE A LINK!");
                    break;
            }
        }
        else if (toNode == 0) //If the user touches the starting node, with the assumption that they cannot go back.
        {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    Log.i(MainActivity.DEBUGTAG, "I PRESSED BACK ONTO THE STARTING NODE");
                    break;
                case MotionEvent.ACTION_UP:
                    Log.i(MainActivity.DEBUGTAG, "I'M FINISHED!");
                    userPath.add(toNode); //Add node to user path
                    userScore = userScore + LinkWeight(toNode); //Updating the user score
                    //TODO: MOVE USER TO NEW PAGE AFTER COMPLETION.
                    break;
            }
        }
        else if (toNode == -1) //If the user didnt touch the canvas where there is a circle
        {
            String message = String.format("Coordinates(No node touched): (%.2f, %.2f)", x, y);
            Log.d(MainActivity.DEBUGTAG, message); //Debug tag for showing coordinates in the DDMS system.
            //TODO: NEAREST NODE CODE
        }
        return true;
    }
}

