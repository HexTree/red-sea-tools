package kaust.orientationapp;

import android.annotation.TargetApi;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by uchman21 on 6/20/15.
 */
@TargetApi(11)
public class CalendarOp extends ActionBarActivity {

    ListView lv;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calendarclick);
        lv = (ListView) findViewById(R.id.listView);

        day = getIntent().getIntExtra("day",0);
        //initializes the calendarview
        SetupCalendar();
    }

    public void SetupCalendar() {
        new LoadAllItems(day).execute();
    }


    private class LoadAllItems extends AsyncTask<Boolean, Boolean, Boolean> {
        private int date;
        int dpWidth = 0, dpHeight = 0;
        ArrayList itemlist;

        LoadAllItems(int mdate) {
            date = mdate;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            DisplayMetrics metrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(metrics);
            float logicalDensity = metrics.density;
            Log.d("ddddddd","ddddd"+logicalDensity);
            dpHeight = (int) Math.ceil(metrics.heightPixels);
            dpWidth = (int) Math.ceil(metrics.widthPixels);
            String TName = "activity" + date + ".txt";
        }

        protected Boolean doInBackground(Boolean... args) {

            itemlist = new ArrayList<String[]>();
            String[] thisLine = new String[3];
            StringBuffer buf = new StringBuffer();
            InputStream is = CalendarOp.this.getResources().openRawResource(R.raw.activity16);
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                if (is != null) {
                    while ((thisLine[0] = reader.readLine()) != null) {
                        buf.append(thisLine[0] + "\n");
                        String[] BrLine = thisLine[0].split(";");
                        if (Integer.parseInt(BrLine[0]) > 1) {
                            int t = 1;
                            while (t < Integer.parseInt(BrLine[0])) {
                                thisLine[t] = reader.readLine();
                                t = t +1;
                            }
                        }
                        Plist getter = new Plist();
                        getter.setitems1(thisLine[0]);
                        getter.setitems2(thisLine[1]);
                        getter.setitems3(thisLine[2]);
                        getter.setsize(dpWidth);
                        switch (BrLine[1]){
                            case "Green":
                                getter.setcolor(Color.GREEN/*Color.parseColor("#636161")*/);
                                break;
                            case "Blue":
                                getter.setcolor(Color.BLUE);
                                break;
                            case "Red":
                                getter.setcolor(Color.RED);
                                break;
                            case "Yellow":
                                getter.setcolor(Color.YELLOW);
                                break;
                            default:
                                    getter.setcolor(Color.YELLOW);
                                break;
                        }
                        getter.setnum(Integer.parseInt(BrLine[0]));
                        itemlist.add(getter);
                    }
                }
                return true;
            } catch (IOException e) {
                Toast.makeText(getApplicationContext(),
                        "Problems: " + e.getMessage(), Toast.LENGTH_LONG).show();
            } finally {
                try {
                    is.close();
                } catch (Throwable ignore) {
                    Toast.makeText(getApplicationContext(),
                            "Problems2: " + ignore.getMessage(), Toast.LENGTH_LONG).show();
                }
            }
            Toast.makeText(getBaseContext(),
                    buf.toString(), Toast.LENGTH_LONG).show();
            return false;

        }

        protected void onPostExecute(final Boolean success) {

            if (success == true) {
                Log.d("su","kkkkkkkkkkkkkk");
                lv.setAdapter(new CustomActivityList(CalendarOp.this, itemlist));

            }

        }


    }
}
