package kaust.orientationapp;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by uchman21 on 6/23/15.
 */
public class CustomActivityList extends BaseAdapter{
    private ArrayList listData;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomActivityList(Context context, ArrayList listData) {
        this.listData = listData;
        layoutInflater = LayoutInflater.from(context);
        this.context = context;
    }
//
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

        String St_Arrange[];
            holder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.activity_layout, null);
            holder.mainL = (LinearLayout) convertView.findViewById(R.id.ML);
            holder.Main = (LinearLayout) convertView.findViewById(R.id.Main);
            holder.time = (TextView) convertView.findViewById(R.id.timeT);
            convertView.setTag(holder);

        Plist actItem = (Plist) listData.get(position);
        Log.d("bbbbbbb",actItem.getitems1());
        holder.Main.setBackgroundColor(actItem.getcolor());
//            switch (actItem.getnum()) {
//
//                case 1:
                    St_Arrange = actItem.getitems1().split(";");
                    holder.time.setText(St_Arrange[2]);
                    holder.L1 = new LinearLayout(parent.getContext());
                    holder.L1.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.linLayoutParam.gravity=Gravity.CENTER;
                    holder.L1.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L1);
                    holder.lpView = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
                    holder.lpView.gravity = Gravity.CENTER;
                    holder.tv = new TextView(parent.getContext());
                    for(int i=3;i<St_Arrange.length;i++) {
                        holder.tv.append(St_Arrange[i]+"\n");
                        holder.tv.setGravity(Gravity.CENTER);
                        holder.tv.setLayoutParams(holder.lpView);
                    }
                    holder.L1.addView(holder.tv);



       return convertView;
    }

    static class ViewHolder {
        LinearLayout L1;
       LinearLayout mainL;
        LinearLayout Main;
        TextView tv;
        TextView time;
        LinearLayout.LayoutParams linLayoutParam = null;
        LinearLayout.LayoutParams lpView = null;
    }

}
