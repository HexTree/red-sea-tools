package kaust.orientationapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.CalendarView;
import android.widget.Toast;

import com.roomorama.caldroid.CaldroidFragment;
import com.roomorama.caldroid.CaldroidListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;

/**
 * Created by uchman21 on 6/20/15.
 */
public class OrientCalendar extends ActionBarActivity {

    CalendarView calender;
    boolean enter = true;
    long dayM;
    Toast mToast;

    CaldroidFragment caldroidFragment = new CaldroidFragment();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calendar_frag);
        mToast = Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG);
        //initializes the calendarview
        final Calendar firstday = new GregorianCalendar(2015,Calendar.AUGUST , 8);
        final Calendar lastday = new GregorianCalendar(2015,Calendar.AUGUST , 23);
        final Calendar currentday = Calendar.getInstance();
        SetupCalendar();
        final CaldroidListener listener = new CaldroidListener() {

            @Override
            public void onSelectDate(Date date, View view) {
                if (date.after(firstday.getTime()) && date.before(lastday.getTime())) {
                    Intent calendarIntent = new Intent(OrientCalendar.this, CalendarOp.class);
                    String newstring = new SimpleDateFormat("EEE, MMM d, yyy").format(date);
                    int day = Integer.parseInt(new SimpleDateFormat("d").format(date));
                    calendarIntent.putExtra("date", newstring);
                    calendarIntent.putExtra("day", day);
                    startActivity(calendarIntent);
                }else{
                    if (date.before(currentday.getTime()) || date.after(currentday.getTime())) {
                        caldroidFragment.moveToDate(firstday.getTime());
                    } else {
                        caldroidFragment.moveToDate(currentday.getTime());
                    }
                    mToast.setText("The Event is from the 9th to the 22nd of August 2015");
                    mToast.show();
                }
            }
        };

        caldroidFragment.setCaldroidListener(listener);
    }

    public void SetupCalendar(){
        Bundle args = new Bundle();
        Calendar cal = Calendar.getInstance();
        Calendar mincalendar = new GregorianCalendar(2015,Calendar.AUGUST , 1);
        Calendar maxcalendar = new GregorianCalendar(2015,Calendar.AUGUST , 31);
        Calendar selectedday = new GregorianCalendar();
        args.putInt(CaldroidFragment.MONTH, mincalendar.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, mincalendar.get(Calendar.YEAR));
        HashMap<Date,Integer> orientDays = new HashMap<Date,Integer> ();
        for(int i=9;i<23;i++){
            selectedday.set(2015,Calendar.AUGUST,i);
            orientDays.put(selectedday.getTime(),R.drawable.kaust_logo2);
        }


        args.putInt(CaldroidFragment.THEME_RESOURCE, com.caldroid.R.style.CaldroidDefaultDark);
        caldroidFragment.setArguments(args);
        caldroidFragment.setBackgroundResourceForDates(orientDays);
        caldroidFragment.setMaxDate(maxcalendar.getTime());
        caldroidFragment.setMinDate(mincalendar.getTime());

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.container_body, caldroidFragment);
        t.commit();


        }


    }
