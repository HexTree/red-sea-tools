package kaust.orientationapp;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import java.io.InputStream;

import kaust.orientationapp.maps.MWMPoint;
import kaust.orientationapp.maps.MapsWithMeApi;

public class TravelMaps extends ActionBarActivity {

    void showMultiplePoints()
    {
        // Open tab separated file
        String[] ListPoi = null;
        try {
            Resources ResFiles = getResources();
            InputStream ReadDbFile = ResFiles.openRawResource(R.raw.poi);
            byte[] Bytes = new byte[ReadDbFile.available()];
            ReadDbFile.read(Bytes);
            String DbLines = new String(Bytes);
            ListPoi = DbLines.split("\n"); // Split the content by line
        } catch (Exception e) {
        }

        // Convert objects to MMWPoints
        final MWMPoint[] points = new MWMPoint[ListPoi.length];
        for (int i = 0; i < ListPoi.length; i++)
        {
            String[] str = ListPoi[i].split("\t");
            float lat = Float.valueOf(str[2]);
            float lon = Float.valueOf(str[3]);
            String name = str[0];
            points[i] = new MWMPoint(lat, lon, name);
        }
        // Show all point on the map, you could also provide some title
        MapsWithMeApi.showPointsOnMap(this, "Jeddah points of interest", points);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_maps);
        //MapsWithMeApi.showPointOnMap(this, 22.31132, 39.10270, "Student Centre");
        showMultiplePoints();

    }
}
