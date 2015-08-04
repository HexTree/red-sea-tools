package kaust.orientationapp;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;


import java.util.ArrayList;


public class MainMenu extends ActionBarActivity {
    GridView gv;
    Context context;
    ArrayList prgmName;
    public static String [] prgmNameList={"About","Calendar","Checklist", "Phone book","Web links", "Travel"};

    // drawable icons for the buttons go here
    public static int [] prgmImages={R.drawable.about,R.drawable.calendar,R.drawable.checklist,R.drawable.phonebook,R.drawable.weblinks,R.drawable.taxi};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        gv=(GridView) findViewById(R.id.gridView1);
        gv.setAdapter(new MenuAdapter(this, prgmNameList,prgmImages));
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
