package com.example.sebastiao97.poi;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.osmdroid.config.Configuration;
import org.osmdroid.views.POImap;
import org.osmdroid.util.GeoPoint;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class PointsOfInterest extends Activity implements View.OnClickListener

{

    POImap mv;

    public void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button submitButton = (Button) findViewById(R.id.submitButton);
        submitButton.setOnClickListener(this);

        // this line tells OpenStreetMap about our app.
        // If you miss this out, you might get banned from OSM servers
        Configuration.getInstance().load
                (this, PreferenceManager.getDefaultSharedPreferences(this));

        mv = (MapView)findViewById(R.id.map1);

        mv.setBuiltInZoomControls(true);
        mv.getController().setZoom(12);
        mv.getController().setCenter(new GeoPoint(40.1,22.5));
    }

    @Override
    public void onClick(View view) {
        EditText latitudeEditText = (EditText) findViewById(R.id.latitude);
        double latitude = Double.parseDouble(latitudeEditText.getText().toString());

        EditText longitudeEditText = (EditText) findViewById(R.id.longitude);
        double longitude = Double.parseDouble(longitudeEditText.getText().toString());

        mv.getController().setCenter(new GeoPoint(latitude,longitude));
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu_hello_map, menu);
        return true;
    }



}