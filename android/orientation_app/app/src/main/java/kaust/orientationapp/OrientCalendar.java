package kaust.orientationapp;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.CalendarView;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by uchman21 on 6/20/15.
 */
@TargetApi(11)
public class OrientCalendar extends ActionBarActivity {

    CalendarView calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calendar);

        //initializes the calendarview
        SetupCalendar();
    }

    public void SetupCalendar(){
        Calendar mincalendar = new GregorianCalendar(2015,Calendar.AUGUST , 1);
        Calendar maxcalendar = new GregorianCalendar(2015,Calendar.AUGUST , 31);
        Calendar selectedday = new GregorianCalendar(2015,Calendar.AUGUST , 9);
        calender = (CalendarView) findViewById(R.id.calendarView);
        calender.setMaxDate(maxcalendar.getTimeInMillis());
        calender.setMinDate(mincalendar.getTimeInMillis());
        calender.setDate(selectedday.getTimeInMillis(), true, true);
        calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                if(dayOfMonth>8 && dayOfMonth <23) {
                    Intent calendarIntent = new Intent(OrientCalendar.this, CalendarOp.class);
                    calendarIntent.putExtra("day", dayOfMonth);
                    startActivity(calendarIntent);
                }
            }
        });

    }



 }
