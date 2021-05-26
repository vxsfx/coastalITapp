package com.example.coastalitapp;

import android.app.AppComponentFactory;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static android.content.Context.MODE_PRIVATE;
import static androidx.camera.core.CameraX.getContext;
//file need var file loc


//
//DISABLE IF NO WORKY
//

public class mainloop{

    //public String[] items = {"rum"};//change to itemClasses

    //defalualt atarting values
    public static itemClass[] items = {
            new itemClass("Rum", 0, 10, 10, 2 ),
            new itemClass("Salt",0, 10, 100, 5)
    };
    //itemclass(name, cost, weight, total, profit)


    public int totalscore = 0;
    public float multiplier = 1;

    public int ships = 1;
    public int crew = 1;

    //satic part of class not obj
    //runny bit, should runs on launch     unknown how to get atts from otherclass while this runs      cannot reload info may lessen performance
    public static void main(String[] args) {
        //start loopy
        Log.i("mmmmmaaaaaaaaiiinnn","mainclass");
        fileclass test = new fileclass();
        test.save(items);
        while(true){Log.i("runn", "running");}
        //items = test.load(items)
    }



}
