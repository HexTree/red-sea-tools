package kaust.orientationapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.GridView;
import android.widget.ImageButton;


import java.util.ArrayList;
import java.util.Calendar;


public class MainMenu extends ActionBarActivity {
//    GridView gv;
    Context context;
    ImageButton About,Calendar,Checklist,Phone,WebLinks,Travel;
//    ArrayList prgmName;
//    public static String [] prgmNameList={"About","Calendar","Checklist", "Phone book","Web links", "Travel"};
//
//    // drawable icons for the buttons go here
//    public static int [] prgmImages={R.drawable.about,R.drawable.calendar,R.drawable.checklist,R.drawable.phonebook,R.drawable.weblinks,R.drawable.taxi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main_menu);
//        gv=(GridView) findViewById(R.id.gridView1);
//        gv.setAdapter(new MenuAdapter(this, prgmNameList,prgmImages));
        setContentView(R.layout.home);
        About = (ImageButton) findViewById(R.id.about);
        Calendar = (ImageButton) findViewById(R.id.calendar);
        Checklist = (ImageButton) findViewById(R.id.checklist);
        Phone = (ImageButton) findViewById(R.id.phone);
        WebLinks = (ImageButton) findViewById(R.id.weblist);
        Travel = (ImageButton) findViewById(R.id.travel);

        setup();

    }


    public void setup(){
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, About.class);
                startActivity(intent);
            }
        });

        Calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, OrientCalendar.class);
                startActivity(intent);
            }
        });

        Checklist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Checklist.class);
                startActivity(intent);
            }
        });

        Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Phonebook.class);
                startActivity(intent);
            }
        });

        WebLinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, WebLink.class);
                startActivity(intent);
            }
        });

        Travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainMenu.this, Travel.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
