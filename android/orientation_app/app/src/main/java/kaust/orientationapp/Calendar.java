package kaust.orientationapp;

import android.app.Activity;
import android.os.Bundle;
import android.widget.CalendarView;

/**
 * Created by uchman21 on 6/20/15.
 */

public class Calendar extends Activity {

    CalendarView calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.calendar);

        //initializes the calendarview
        SetupCalendar();
    }

    public void SetupCalendar(){

        calendar = (CalendarView) findViewById(R.id.calendarView);

    }



 }
