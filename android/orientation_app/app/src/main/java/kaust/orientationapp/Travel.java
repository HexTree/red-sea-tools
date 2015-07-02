package kaust.orientationapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;


public class Travel extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
    }

    public void open_maps(View view){
        Intent intent = new Intent(this, TravelMaps.class);
        this.startActivity(intent);
    }

    public void open_lite(View view){
        Intent intent = new Intent(this, TravelLite.class);
        this.startActivity(intent);
    }
}
