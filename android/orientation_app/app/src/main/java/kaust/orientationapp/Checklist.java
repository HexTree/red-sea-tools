package kaust.orientationapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;


public class Checklist extends ActionBarActivity {

    MyCustomAdapter dataAdapter = null;
    public String[] ListItems = new String[]{};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            Resources ResFiles = getResources();
            InputStream ReadDbFile = ResFiles.openRawResource(R.raw.tasks);
            byte[] Bytes = new byte[ReadDbFile.available()];
            ReadDbFile.read(Bytes);
            String DbLines = new String(Bytes);
            ListItems = DbLines.split("\n"); // Split the content by line
        } catch (Exception e) {
        }

        setContentView(R.layout.activity_checklist);

        //Generate list View from ArrayList
        displayListView();

        checkButtonClick();

    }

    private void displayListView() {

        //Array list of tasks
        ArrayList<Task> taskList = new ArrayList<Task>();
        Task task;

        for (String item : ListItems){
            task = new Task(item, false);
            taskList.add(task);
        }

        //create an ArrayAdaptar from the String Array
        dataAdapter = new MyCustomAdapter(this,
                R.layout.task, taskList);
        ListView listView = (ListView) findViewById(R.id.listView1);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked, show a toast with the TextView text
//                Task task = (Task) parent.getItemAtPosition(position);
//                Toast.makeText(getApplicationContext(),
//                        "Clicked on Row: " + task.getName(),
//                        Toast.LENGTH_LONG).show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Task> {

        private ArrayList<Task> taskList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Task> taskList) {
            super(context, textViewResourceId, taskList);
            this.taskList = new ArrayList<Task>();
            this.taskList.addAll(taskList);
        }

        private class ViewHolder {
            TextView name;
            CheckBox code;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final SharedPreferences settings = getPreferences(0);

            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.task, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.code);
                holder.code = (CheckBox) convertView.findViewById(R.id.checkBox1);
                convertView.setTag(holder);

                holder.code.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        CheckBox cb = (CheckBox) v;
                        Task task = (Task) cb.getTag();
                        task.setSelected(cb.isChecked());

                        // Store in shared preferences
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putBoolean(task.getName(), task.isSelected());
                        editor.apply();

//                        Toast.makeText(getApplicationContext(),
//                        "Clicked on Checkbox: " + task.getName() + " is " + cb.isChecked(),
//                        Toast.LENGTH_SHORT).show();
                    }
                });
            }
            else {
                holder = (ViewHolder) convertView.getTag();
            }

            Task task = taskList.get(position);
            holder.name.setText(task.getName());
            boolean isChecked = settings.getBoolean(task.getName(), false);
            holder.code.setChecked(isChecked);
            holder.code.setTag(task);

//            Toast.makeText(getApplicationContext(),
//            "Set Checkbox: " + task.getName() + " " + isChecked,
//            Toast.LENGTH_SHORT).show();

            return convertView;

        }

    }

    private void checkButtonClick() {


        Button myButton = (Button) findViewById(R.id.findSelected);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // List selected items
//                StringBuffer responseText = new StringBuffer();
//                responseText.append("The following were selected...\n");
//
//                ArrayList<Task> taskList = dataAdapter.taskList;
//                for(int i=0;i< taskList.size();i++){
//                    Task task = taskList.get(i);
//                    if(task.isSelected()){
//                        responseText.append("\n" + task.getName());
//                    }
//                }
//
//                Toast.makeText(getApplicationContext(),
//                        responseText, Toast.LENGTH_LONG).show();

            }
        });

    }
}
