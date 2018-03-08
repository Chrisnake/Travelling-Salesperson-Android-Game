package com.example.android.graphgame;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import java.util.ArrayList;

public class LineView extends View {

    Paint paint;
    private PointF pointCircle;
    static ArrayList<PointF> points = new ArrayList<PointF>();

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
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(20);
        //TODO: I need to find a way to get the points array list data from one class and put it into this class...

        for(int i = 0; i < points.size(); i++)
        {
            while(i != points.size() - 1) //WHILE i is not equal to the size of the points array, - 1, then keep drawing
            {
                canvas.drawLine(points.get(i).x, points.get(i).y, points.get(i + 1).x, points.get(i + 1).y, paint);
                //This draws the line and gets the points from the points array list that has been inputted from another class.
                //It then gets the x value of point and then y, and then gets the point at the position above the point before.
                //In simple terms it gets node 1, and then point 2 and then paints it.
            }
        }
    }

    public static void addPoint (PointF point)
    {
        points.add(point); //Add the specific point into the array list
        updateArray(points);
    }

    public static void updateArray (ArrayList<PointF> point)
    {
        points = point; //ACTS AS A SETTER FOR THE CLASS
    }

    //This class gets the array list of nodes (points) and then puts puts it into this class so the drawline occurs.
    public static ArrayList<PointF> getPoints (ArrayList<PointF> point)
    {
        points = point; //ACTS AS A SETTER FOR THE CLASS
        return points;
    }
    public void setPointCircle(PointF point)
    {
        pointCircle = point;
    }

    public void draw()
    {
        invalidate();
        requestLayout();
    }
}