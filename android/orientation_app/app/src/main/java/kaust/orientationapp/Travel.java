package kaust.orientationapp;


import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Toast;


public class Travel extends ActionBarActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        if(!isNetworkAvailable()) {
            Toast mToast = Toast.makeText(getApplicationContext(), "You must be connected to an internet source to use these live.", Toast.LENGTH_LONG);
            mToast.show();
        }
    }

    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
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
