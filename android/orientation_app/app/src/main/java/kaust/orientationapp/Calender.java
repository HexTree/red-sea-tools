package kaust.orientationapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;

/**
 * Created by uchman21 on 6/20/15.
 */

public class Calender extends Activity {

    CalendarView calender;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calender);

        //initializes the calendarview
        SetupCalender();
    }

    public void SetupCalender(){

        calender = (CalendarView) findViewById(R.id.calendarView);

    }



 }
