package com.example.coastalitapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

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
                intent.initiateScan();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        Log.i("debugo_1", "45");

        if(result.getContents() != null){
            Log.i("debugo_2", "48");
            AlertDialog.Builder builder = new AlertDialog.Builder(camScreen.this);

            builder.setTitle("ahhhhhhhh");

            builder.setPositiveButton("poo", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();
                }
            });
        builder.show();
        }else{
            Log.i("you am here thing", "unusful msg");
        }

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
