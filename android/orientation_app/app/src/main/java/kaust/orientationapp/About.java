package kaust.orientationapp;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;


/**
 * Created by Mencella on 29/06/2015.
 */
public class About extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.about);
        TextView txt = (TextView) findViewById(R.id.abouttext1);
        TextView txt2 = (TextView) findViewById(R.id.abouttext2);
        TextView txt3 = (TextView) findViewById(R.id.abouttext3);
        Typeface font = Typeface.createFromAsset(getAssets(), "Chantelli_Antiqua.ttf");
        txt.setTypeface(font);
        txt2.setTypeface(font);
        txt3.setTypeface(font);
    }
}
