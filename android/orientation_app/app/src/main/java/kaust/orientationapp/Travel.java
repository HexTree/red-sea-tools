package kaust.orientationapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import kaust.orientationapp.maps.MapsWithMeApi;

public class Travel extends ActionBarActivity {

//    WebView wv;
//    String url = "https://www.openstreetmap.org/#map=16/22.3165/39.1051";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);

        MapsWithMeApi.showPointOnMap(this, 0, 0, "a");


//        wv = (WebView) findViewById(R.id.webView);
//        WebSettings settings = wv.getSettings();
//        settings.setJavaScriptEnabled(true);
//        wv.loadUrl(url);
    }
}
