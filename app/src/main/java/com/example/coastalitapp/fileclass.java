package com.example.coastalitapp;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


//moved as other static not worky with this
public class fileclass extends AppCompatActivity {
    private static final String file = "saveddata.json";
    //save data method (called for individual objects)
    public void save(itemClass[] items) {
        //store data tojson string
        StringBuilder sb = new StringBuilder();
        String json;//???

        sb.append("{");

        //do ships + crew before

        for (itemClass item : items) {
            String name = item.name;
            String cost = String.valueOf(item.cost);
            String weight = String.valueOf(item.weight);
            String profit = String.valueOf(item.profit);
            String total = String.valueOf(item.total);

            String itemjson = " \"${name}\":{ \"total\":${total},\"weight\": ${weight}, \"cost\": ${cost}, \"profit\":${profit} }";
            sb.append(itemjson);
        }
        sb.append("}");
        json = sb.toString();
        Log.i("jsonsojso", json);

        FileOutputStream fos = null;

        try {
            fos = openFileOutput(file, MODE_PRIVATE);
            fos.write(json.getBytes());
        } catch (FileNotFoundException e) {
            Log.i(e.toString(), "problem saving");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public itemClass[] load(itemClass[] items){
        //while(true){ totaltoadd = allprofitsadded * multiplier * (crew/ships);           total+=totaltoadd;  }
        String json = null;
        FileInputStream fis = null;
        try {
            fis = openFileInput(file);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader br = new BufferedReader(isr);
            StringBuilder sb = new StringBuilder();//arg br removed
            String lineText;

            while ( (lineText=br.readLine()) != null){
                sb.append(lineText);
            };
            json = sb.toString();
        }
        catch(FileNotFoundException e){
            Log.e(String.valueOf(e), "problem lodaing data");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                }catch(IOException e){ e.printStackTrace();}
            }
        }
        if(json != null){
            JSONObject mainobj = new JSONObject(json);//full json//need to except

            //unused here atm
            /*
            int score = mainobj.getInt("score");
            float mult = mainobj.getDouble("mult");
            JSONObject crewjson = mainobj.getJSONObject("crew");//rum json
            JSONObject shipsjson = mainobj.getJSONObject("ships");//rum json
            */

            //iterate json with array of itemClasses
            for (itemClass item : items){
                //item(args gathered)

                JSONObject itemobj = mainobj.getJSONObject(item.name);
                item.total = itemobj.getInt("total");
                item.cost = itemobj.getInt("cost");
                item.weight = itemobj.getInt("weight");
                item.profit = itemobj.getInt("profit");
            }
        }
        return items;///???? need to figure out how work now of loop
    }
}
