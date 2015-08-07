package kaust.orientationapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
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
            public void onChangeMonth(int month, int year) {
                Calendar newmonth = new GregorianCalendar();
                HashMap<Date,Integer> abDays = new HashMap<Date,Integer> ();
                int mmax = 0;
                if(month == 4 || month == 9 || month == 6 || month == 11){
                    mmax=31;
                }else if(month == 2){
                    mmax = 29;
                }else{
                    mmax = 32;
                }


                for(int i=1;i<mmax;i++) {
                    newmonth.set(2015, month-1, i);
                    abDays.put(newmonth.getTime(), R.color.caldroid_black);
                }
                caldroidFragment.setTextColorForDates(abDays);
                caldroidFragment.refreshView();
            }


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
        Calendar mincalendar = new GregorianCalendar(2015,Calendar.AUGUST , 1);
        Calendar selectedday = new GregorianCalendar();
        args.putInt(CaldroidFragment.MONTH, mincalendar.get(Calendar.MONTH) + 1);
        args.putInt(CaldroidFragment.YEAR, mincalendar.get(Calendar.YEAR));
        HashMap<Date,Integer> orientDays = new HashMap<Date,Integer> ();
        for(int i=9;i<23;i++){
            selectedday.set(2015, Calendar.AUGUST, i);
                orientDays.put(selectedday.getTime(), R.color.light_blue);
        }


        args.putInt(CaldroidFragment.THEME_RESOURCE, R.style.CaldroidDefaultDark);
        caldroidFragment.setArguments(args);
        caldroidFragment.setBackgroundResourceForDates(orientDays);

        FragmentTransaction t = getSupportFragmentManager().beginTransaction();
        t.replace(R.id.container_body, caldroidFragment);
        t.commit();

        }


    }
