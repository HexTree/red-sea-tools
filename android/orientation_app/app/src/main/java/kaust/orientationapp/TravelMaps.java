package kaust.orientationapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import kaust.orientationapp.maps.MapsWithMeApi;

public class TravelMaps extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_maps);

        MapsWithMeApi.showPointOnMap(this, 22.31132, 39.10270, "Student Centre");
    }
}
