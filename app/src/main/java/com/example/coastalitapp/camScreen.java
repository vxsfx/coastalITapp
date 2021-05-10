package com.example.coastalitapp;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;

public class camScreen extends AppCompatActivity {

    Button scanButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.camscreen);

        scanButton = findViewById(R.id.scanbutton);

        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                IntentIntegrator intent = new IntentIntegrator(camScreen.this);
                intent.setCaptureActivity(Capture.class);
            }
        });
    }




    float x1,y1, x2, y2;

    public boolean onTouchEvent(MotionEvent touchEvent) {
        if (touchEvent.getAction() == MotionEvent.ACTION_DOWN) {
            x1 = touchEvent.getX();
            y1 = touchEvent.getY();
        } else if (touchEvent.getAction() == MotionEvent.ACTION_UP) {
            x2 = touchEvent.getX();
            y2 = touchEvent.getY();
            if (x1 < x2) {
                Intent intent = new Intent(camScreen.this, mainScreen.class);
                startActivity(intent);

                finish();
            }
        }
        return false;
    }
}
