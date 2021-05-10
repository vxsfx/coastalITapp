package com.example.coastalitapp;


import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;


public class mapScreen extends AppCompatActivity {

    public FusedLocationProviderClient location;
    //    private static final int LOCATION_PERMISSION_REQUEST_CODE = 1;

    //private GoogleMap map;

    public SupportMapFragment mapFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapscreen);

        mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);


        location = LocationServices.getFusedLocationProviderClient(this);


        Log.i("aaaaaaaaaaaaa", "cccccccccccccccccccccccccccc");


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED){
            Log.i("debugorooo_1", "aaaa");
            getcurrentlocation();
        }
        else{
            Log.i("debug","else");
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 44);
        }
    }


    public void getcurrentlocation(){
        Log.i("12343dfsg", "sdfjhfdfd89");
        Task<Location> task = location.getLastLocation();
        task.addOnSuccessListener(new OnSuccessListener<Location>(){
           @Override
           public void onSuccess(Location location_){
               Log.i("checking", "check");

               //not worky????
               if (location_!=null){
                   Log.i("checke", "valid");
                   mapFragment.getMapAsync(new OnMapReadyCallback(){
                   @Override
                   public void onMapReady(GoogleMap googleMap){
                       //latitude and longitude
                       LatLng latlng = new LatLng(location_.getLatitude(), location_.getLongitude());

                       //here be the stuffs
                        MarkerOptions options = new MarkerOptions().position(latlng).title("YOU AM HERE");

                        googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latlng, 10));
                        googleMap.addMarker(options);
                   }
               });}
           }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 44){
            //might move &&
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                Log.i("aaaaaaaaaaaa", "bbbbbbbbbbbbbbbbbbbb");
                getcurrentlocation();
            }
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
                Intent intent = new Intent(mapScreen.this, mainScreen.class);
                startActivity(intent);

                finish();
            }
        }
        return false;
    }
}