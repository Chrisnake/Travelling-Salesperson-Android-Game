package com.example.cs16mmc.lineview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;


public class LineView extends View {

    private Paint paint = new Paint();

    private PointF pointA,pointB,pointC,pointCircle;


    public LineView(Context context) {
        super(context);
    }

    public LineView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public LineView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas)
    {

        //Drawing edges
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        canvas.drawLine(pointA.x,pointA.y,pointB.x,pointB.y, paint);
        canvas.drawLine(pointA.x,pointA.y,pointC.x,pointC.y, paint);
        canvas.drawLine(pointC.x,pointC.y,pointB.x,pointB.y, paint);
        paint.setColor(Color.BLACK);

        //Drawing nodes
        canvas.drawCircle(200,500,20,paint); //A
        canvas.drawCircle(900,400,20,paint); //B
        canvas.drawCircle(700,100,20,paint); //C
        paint.setTextSize(100);

        //Drawing node names
        paint.setColor(Color.DKGRAY);
        paint.setTextSize(100);
        canvas.drawText("A", 110, 500 , paint);
        canvas.drawText("B", 950, 400 , paint);
        canvas.drawText("C", 700, 80  , paint);

        //Drawing weights
        paint.setColor(Color.BLUE);
        paint.setTextSize(85);
        canvas.drawText("3", (200+700)/2, ((500+100)/2)-40 , paint); //Between A and C
        canvas.drawText("8", (200+900)/2, ((500+400)/2)+80 , paint); //Between A and B
        canvas.drawText("6", (900+700)/2, ((400+100)/2)-20 , paint); //Between B and C
        super.onDraw(canvas);
    }

    public void setPointA(PointF point)
    {
        pointA = point;
    }

    public void setPointB(PointF point)
    {
        pointB = point;
    }
    public void setPointC(PointF point)
    {
        pointC = point;
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
