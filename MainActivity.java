package com.example.cs16mmc.lineview;

import android.graphics.PointF;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    PointF pointA = new PointF(200,500);
    PointF pointB = new PointF(900,400);
    PointF pointC = new PointF(700,100);


    PointF pointCircleA = new PointF(200,500);
    PointF pointCircleB = new PointF(900,400);
    PointF pointCircleC = new PointF(700,100);
    int radius = 100; //Radius of the circles


    private LineView mLineView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mLineView =(LineView) findViewById(R.id.lineView);

        mLineView.setPointA(pointA);
        mLineView.setPointB(pointB);
        mLineView.setPointC(pointC);
        mLineView.setPointCircle(pointCircleA);
        mLineView.draw();
        mLineView.setPointCircle(pointCircleB);
        mLineView.draw();
        mLineView.setPointCircle(pointCircleC);
        mLineView.draw();
    }
}
