package kaust.orientationapp;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by uchman21 on 6/27/15.
 */
public class WebLink extends ActionBarActivity {
    public String[] ListItems = new String[]{};
    public String[] WebListItems = new String[]{};
    ArrayList<Plist> webitemlist;
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //sets the main layout of the activity
        setContentView(R.layout.web_list);
        lv = (ListView) findViewById(R.id.web_list);
        try {
            Resources ResFiles = getResources();
            InputStream ReadDbFile = ResFiles.openRawResource(R.raw.weblinks);
            byte[] Bytes = new byte[ReadDbFile.available()];
            ReadDbFile.read(Bytes);
            String DbLines = new String(Bytes);
            ListItems = DbLines.split("\n"); // Split the content by line
        } catch (Exception e) {
        }


        SetupWeb();
    }

    private void SetupWeb(){

        webitemlist = new ArrayList<Plist>();
        for (int i=0;i<ListItems.length;i++){
            WebListItems = ListItems[i].split(",");
            Plist getter = new Plist();
            getter.settitle(WebListItems[0]);
            Log.d("kkkkk",WebListItems[0]);
            getter.seturl(WebListItems[1]);
            webitemlist.add(getter);
        }
        lv.setAdapter(new CustomWebListAdapter(WebLink.this, webitemlist));


        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // When clicked
                Plist getweblink = webitemlist.get(position);
                Intent intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getweblink.url()));
                startActivity(intent);

            }
        });
    }

   private class CustomWebListAdapter extends BaseAdapter {
        private ArrayList listData;
        private LayoutInflater layoutInflater;
        private Context context;

        public CustomWebListAdapter(Context context, ArrayList listData) {
            this.listData = listData;
            layoutInflater = LayoutInflater.from(context);
            this.context = context;
        }


        @Override
        public int getCount() {
            return listData.size();
        }

        @Override
        public Object getItem(int position) {
            return listData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;

            if (convertView == null) {
                convertView = layoutInflater.inflate(R.layout.webitem, null);

                holder = new ViewHolder();
                holder.WebItem = (TextView) convertView.findViewById(R.id.webtext);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            Plist webItem = (Plist) listData.get(position);
            holder.WebItem.setText(webItem.title());

            return convertView;
        }

        private class ViewHolder {
            TextView WebItem;
//        LinearLayout.LayoutParams lpView = null;
        }


    }
}



