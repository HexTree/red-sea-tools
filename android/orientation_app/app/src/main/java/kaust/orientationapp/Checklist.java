package kaust.orientationapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.util.ArrayList;


public class Checklist extends ActionBarActivity {

    MyCustomAdapter dataAdapter = null;
    public String[] ListItems = new String[]{};
    SharedPreferences settings;
    Toast mToast;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        mToast = Toast.makeText(getApplicationContext(), "Tap on each tab for details.", Toast.LENGTH_LONG);
        mToast.show();
        
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

    }

    private void displayListView() {

        //Array list of tasks
        ArrayList<Task> taskList = new ArrayList<Task>();
        Task task;

        for (String item : ListItems){
            String[] parts = item.split(",");
            task = new Task(parts[0], parts[1], false);
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
                // When clicked, show a toast with the task hint
                Task task = (Task) parent.getItemAtPosition(position);
                mToast.setText(task.getHint());
                mToast.show();
            }
        });

    }

    private class MyCustomAdapter extends ArrayAdapter<Task> {

        private ArrayList<Task> taskList;

        public MyCustomAdapter(Context context, int textViewResourceId,
                               ArrayList<Task> taskList) {
            super(context, textViewResourceId, taskList);
            this.taskList = new ArrayList<>();
            this.taskList.addAll(taskList);
        }

        private class ViewHolder {
            TextView name;
            CheckBox code;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            Log.v("ConvertView", String.valueOf(position));

            if (convertView == null) {
                LayoutInflater vi = (LayoutInflater)getSystemService(
                        Context.LAYOUT_INFLATER_SERVICE);
                convertView = vi.inflate(R.layout.task, null);

                holder = new ViewHolder();
                holder.name = (TextView) convertView.findViewById(R.id.task);
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
//                        "Clicked on Checkbox: " + task.getName() + cb.isChecked(),
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
//            "Set Checkbox: " + task.getName() + isChecked,
//            Toast.LENGTH_SHORT).show();

            return convertView;
        }
    }
}
