package kaust.orientationapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;


public class Travel extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        Toast mToast = Toast.makeText(getApplicationContext(), "You must be connected to an internet source to use these.", Toast.LENGTH_LONG);
        mToast.show();
    }

    public void open_maps(View view){
        Intent intent = new Intent(this, TravelMaps.class);
        this.startActivity(intent);
    }

    public void open_lite(View view){
        Intent intent = new Intent(this, TravelBus.class);
        this.startActivity(intent);
    }
}
