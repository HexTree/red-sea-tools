package kaust.orientationapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class TravelBus extends ActionBarActivity {

    WebView wv;
    String url = "http://camelab.net/kbus/";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_bus);

        wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        wv.loadUrl(url);
    }
}