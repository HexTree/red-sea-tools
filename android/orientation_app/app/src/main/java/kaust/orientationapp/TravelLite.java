package kaust.orientationapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;


public class TravelLite extends ActionBarActivity {

    WebView wv;
    String url = "http://rawgit.com/Virtakuono/.kml-repository/master/JeddahPOIs_notext.htm";

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.travel_lite);

        wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
        wv.loadUrl(url);
    }
}