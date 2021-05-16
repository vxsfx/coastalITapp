package com.example.coastalitapp;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;

import static android.content.Context.MODE_PRIVATE;

public class mainloop {

    public int totalscore = 0;
    public float multiplier = 1;

    public int ships = 1;
    public int crew = 1;

    public itemClass itemRum;

    SharedPreferences  mPrefs = getPreferences(MODE_PRIVATE);



    //load data method (called for individual objects)
    public itemClass load(String classname){
        Gson gson = new Gson();
        String json = mPrefs.getString(classname, "");
        return gson.fromJson(json, itemClass.class);
    }

    //save data method (called for individual objects)
    public void save(String classname, itemClass objToSave){
        //set variables of 'myObject', etc.

        //>
        SharedPreferences.Editor prefsEditor = mPrefs.edit();

        //json stuff
        Gson gson = new Gson();
        String json = gson.toJson(objToSave);

        //write data
        prefsEditor.putString(classname, json);
        //write to file
        prefsEditor.commit();



    }

    public void loop(){
        //while(true){ totaltoadd = allprofitsadded * multiplier * (crew/ships);           total+=totaltoadd;  }



    }
}
