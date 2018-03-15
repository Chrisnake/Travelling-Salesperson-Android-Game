package com.example.android.graphgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class LineView extends View {

    Paint paint;
    private PointF pointCircle;
    static ArrayList<PointF> points = new ArrayList<PointF>();
    static ArrayList<Integer> weights = new ArrayList<Integer>();
    static ArrayList<Integer> userPath = new ArrayList<Integer>();

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

        drawLine(canvas); //Draw the lines between the points
        drawCircle(canvas); //Draw the nodes
        drawWeights(canvas); //Draw the weights
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

    //This class gets the array list of nodes (points) and then puts puts it into this class so the drawline occurs.
    public static ArrayList<PointF> getPoints (ArrayList<PointF> point)
    {
        points = point; //ACTS AS A SETTER FOR THE CLASS
        return points;
    }

    public static ArrayList<Integer> getWeights (ArrayList<Integer> weight)
    {
        weights = weight; //ACTS AS A SETTER FOR THE CLASS
        return weights;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }

    public int whatNode(float userX, float userY) //Check what node the user is on
    {
        int thisNode = 0;
        for(int i = 0; i < points.size() - 1; i++)
        {
            if (userX > points.get(i).x - 40 && userX < points.get(i).x + 40 && userY > points.get(i).y - 40 && userY < points.get(i).y + 40) //checks if user touches a node i
            {
                i = thisNode;
            }
            else //If the user didnt touch a node.
            {
                thisNode = -1;
            }
        }
        return thisNode;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) //On touch event on the canvas
    {
        float x = event.getX();
        float y = event.getY();

        if (whatNode(x, y) > 0) //If the user touches a node
        {
            if (x > points.get(whatNode(x,y)).x - 40 && x < points.get(whatNode(x,y)).x + 40 && y > points.get(whatNode(x,y)).y - 40 && y < points.get(whatNode(x,y)).y + 40) //If user touches the canvas where there is a circle
            {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        Log.i(MainActivity.DEBUGTAG, "I PRESSED ON A CIRCLE!");
                        break;
                    case MotionEvent.ACTION_UP:
                        Log.i(MainActivity.DEBUGTAG, "MY FINGER LEFT A CIRCLE");
                        //userPath.add(i); //Add node to user path
                        break;
                }
            }
        }
        else //If the user didnt touch the canvas where there is a circle
        {
            String message = String.format("Coordinates (%.2f, %.2f)", x, y);
            Log.d(MainActivity.DEBUGTAG, message); //Debug tag for showing coordinates in the DDMS system.
            //TODO: NEAREST NODE CODE
        }
        return true;
    }
}

