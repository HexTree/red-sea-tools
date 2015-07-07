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
import android.widget.TextView;
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

    String date1;
    int day;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calendarclick);
        TextView date = (TextView) findViewById(R.id.DtextView);
        lv = (ListView) findViewById(R.id.listView);

        date1 = getIntent().getStringExtra("date");
        day = getIntent().getIntExtra("day",0);
        date.setText(date1);
        //initializes the calendarview
        SetupCalendar();
    }

    public void SetupCalendar() {
        new LoadAllItems(day).execute();
    }

    public InputStream read (int day){
        InputStream ist = null;
        switch (day){
            case 9:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 10:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 11:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 12:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 13:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 14:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 15:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.test);
                break;
            case 16:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity16);
                break;
            case 17:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity17);
                break;
            case 18:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity18);
                break;
            case 19:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity19);
                break;
            case 20:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity20);
                break;
            case 21:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity21);
                break;
            case 22:
                ist = CalendarOp.this.getResources().openRawResource(R.raw.activity22);
                break;
            default:
                break;

        }
        return ist;
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
            InputStream is = read(date);
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
                                getter.setcolor(Color.GREEN);
                                break;
                            case "SkyBlue":
                                getter.setcolor(Color.parseColor("#87ceff"));
                                break;
                            case "Purple":
                                getter.setcolor(Color.parseColor("#9b30ff"));
                                break;
                            case "Brown":
                                getter.setcolor(Color.parseColor("#f4a460"));
                                break;
                            case "White":
                                getter.setcolor(Color.parseColor("#ffffff"));
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
