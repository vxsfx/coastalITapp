package com.example.coastalitapp;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

public class NaviSwipe extends Activity{


    float x1,y1, x2, y2;

    Intent change;

    public NaviSwipe(Intent intent){
        change = intent;
        Log.i("lmnop","swipyydoo");
    }
    @Override
    public boolean onTouchEvent(MotionEvent touchEvent) {
        Log.i("wee","wee");
        if (touchEvent.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = touchEvent.getX();
            y1 = touchEvent.getY();
        } else if (touchEvent.getAction() == MotionEvent.ACTION_UP) {
            x2 = touchEvent.getX();
            y2 = touchEvent.getY();
            if (x1 < x2) {
                Log.i("hello", "heljkdsghjdfhgkdo");
                startActivity(change);
                finish();
            }
        }

        return false;
    }
}
