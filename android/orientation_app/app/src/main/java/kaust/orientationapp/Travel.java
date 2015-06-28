package kaust.orientationapp;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.net.URI;

public class Travel extends ActionBarActivity {

    WebView wv;
    URI url = URI.create("https://rawgit.com/Virtakuono/.kml-repository/master/JeddahPOIs.htm");
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_travel);
        wv = (WebView) findViewById(R.id.webView);
        WebSettings settings = wv.getSettings();
        settings.setJavaScriptEnabled(true);
//        wv.setScrollBarStyle(WebView.SCROLLBARS_OUTSIDE_OVERLAY);
//        wv.setWebViewClient(new WebViewClient(){
//            boolean
//        });
        wv.loadUrl("https://rawgit.com/Virtakuono/.kml-repository/master/JeddahPOIs.htm");
    }
}
