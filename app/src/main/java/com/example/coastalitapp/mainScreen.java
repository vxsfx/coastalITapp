package com.example.coastalitapp;
//public for display, private for background
//here be buttons and the main screen

import android.annotation.SuppressLint;
import android.app.Activity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.SensorEvent;
import android.os.Bundle;

import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class mainScreen extends Activity{

    int points;
    int fleetSize;
    int crewSize;
    String shipType;


    //constructor
    public mainScreen() {// get user save data
        shipType = "rowboat";
        points = 10;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.layout);

        final TextView totalCrew = findViewById(R.id.totalCrew);
        final Button buyCrew = findViewById(R.id.buyCrew);
        buyCrew.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                crewSize++;
                String crewText = Integer.toString(crewSize);
                totalCrew.setText(crewText);
            }
        });
        final TextView totalShips = findViewById(R.id.totalShips);
        final Button buyShips = findViewById(R.id.buyShips);
        buyShips.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fleetSize++;
                String fleetText = Integer.toString(fleetSize);
                totalShips.setText(fleetText);
            }
        });
        //does not work on other class file ??????????????????????????????????????????????????????????????????????????
        class itemButton {

            private String costString;  //ignore may be final, may change in future with upgrades
            private String profitString;
            private String weightString;


            itemButton(int quantity, int weight, int cost, int profit,
                       String weightText, String costText, String profitText, String buyText) {

                //pass a class as argument instead
/*
                //change to load from mainloop where item = mainloop.get(itemname)->passed from args above
                itemClass item = new itemClass("rum", quantity, weight, cost, profit);
                //part that wont work elsewhere
                final int weightId = getResources().getIdentifier(weightText, "id", getPackageName());
                final int costId = getResources().getIdentifier(costText, "id", getPackageName());
                final int profitId = getResources().getIdentifier(profitText, "id", getPackageName());

                final TextView weightEl = findViewById(weightId);
                final TextView costEl = findViewById(costId);
                final TextView profitEl = findViewById(profitId);

                costString = Integer.toString(cost);
                costEl.setText(costString);
*/
                final int buyId = getResources().getIdentifier(buyText, "id", getPackageName());
                final Button BuyEl = findViewById(buyId);
                BuyEl.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        if (points >= cost) {
                      /*      points -= item.cost;
                            item.quantity++;
                            item.Calculate();

                            profitString = Integer.toString(item.totalProfit);
                            profitEl.setText(profitString);

                            weightString = Integer.toString(item.totalWeight);
                            weightEl.setText(weightString);*/
                        }
                    }
                });
            }
        }

        itemButton rumButton = new itemButton(0, 1, 1, 2, "weightRum", "costRum", "profitRum", "buyRum");
        //may need relative layout

        int rotation = getResources().getConfiguration().orientation;

        if (rotation == Configuration.ORIENTATION_PORTRAIT){
            Log.i("orientated port","portariat");
        }
        else{
            Log.i("orientation", "landscape");
        }




    }
        //swiper code
        float x1,y1, x2, y2;

        public boolean onTouchEvent(MotionEvent touchEvent) {
            if (touchEvent.getAction() == MotionEvent.ACTION_DOWN) {
                x1 = touchEvent.getX();
                y1 = touchEvent.getY();
            } else if (touchEvent.getAction() == MotionEvent.ACTION_UP) {
                x2 = touchEvent.getX();
                y2 = touchEvent.getY();
                if (x1 < x2) {
                    Intent intent = new Intent(mainScreen.this, mapScreen.class);
                    startActivity(intent);

                    finish();
                }
                if (x2 < x1){
                    Intent intent = new Intent(mainScreen.this, camScreen.class);
                    startActivity(intent);
                    finish();
                }
            }
            return false;
        }
}