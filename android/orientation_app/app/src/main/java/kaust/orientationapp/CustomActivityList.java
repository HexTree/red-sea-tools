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
            switch (actItem.getnum()) {

                case 1:
                    St_Arrange = actItem.getitems1().split(";");
                    holder.time.setText(St_Arrange[2]);
                    holder.L1 = new LinearLayout(parent.getContext());
                    holder.L1.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize(), LayoutParams.MATCH_PARENT);
                    holder.L1.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L1);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
                    holder.tv = new TextView(parent.getContext());
                    for(int i=3;i<St_Arrange.length;i++) {
                        holder.tv.append(St_Arrange[i]+"\n");
                        holder.tv.setGravity(Gravity.CENTER);
                        holder.tv.setLayoutParams(holder.lpView);
                    }
                    holder.L1.addView(holder.tv);

                    break;
                case 2:
                    St_Arrange = actItem.getitems1().split(";");
                    holder.time.setText(St_Arrange[2]);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize()/2, LayoutParams.MATCH_PARENT);
                    holder.L1 = new LinearLayout(parent.getContext());
                    holder.L1.setOrientation(LinearLayout.VERTICAL);
                    holder.L1.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L1);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.tv = new TextView(parent.getContext());
                    for(int i=3;i<St_Arrange.length;i++) {
                        holder.tv.append(St_Arrange[i]+"\n");
                        holder.tv.setGravity(Gravity.CENTER);
                        holder.tv.setLayoutParams(holder.lpView);
                    }
                    holder.L1.addView(holder.tv);

                    St_Arrange = actItem.getitems2().split(";");
                    holder.L2 = new LinearLayout(parent.getContext());
                    holder.L2.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize()/2, LayoutParams.MATCH_PARENT);
                    holder.L2.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L2);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.tv2 = new TextView(parent.getContext());
                    for(int i=0;i<St_Arrange.length;i++) {
                        holder.tv2.append(St_Arrange[i]+"\n");
                        holder.tv2.setGravity(Gravity.CENTER);
                        holder.tv2.setLayoutParams(holder.lpView);
                    }
                    holder.L2.addView(holder.tv2);
                    break;
                case 3:
                    St_Arrange = actItem.getitems1().split(";");
                    holder.time.setText(St_Arrange[2]);
                    holder.L1 = new LinearLayout(parent.getContext());
                    holder.L1.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize()/3, LayoutParams.MATCH_PARENT);
                    holder.L1.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L1);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.tv = new TextView(parent.getContext());
                    //LinearLayout.LayoutParams lpView = new LinearLayout.LayoutParams(this.size, this.size);
                    for(int i=3;i<St_Arrange.length;i++) {
                        holder.tv.append(St_Arrange[i]+"\n");
                        holder.tv.setGravity(Gravity.CENTER);
                        holder.tv.setLayoutParams(holder.lpView);
                    }
                    holder.L1.addView(holder.tv);

                    St_Arrange = actItem.getitems2().split(";");
                    holder.L2 = new LinearLayout(parent.getContext());
                    holder.L2.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize()/3, LayoutParams.MATCH_PARENT);
                    holder.L2.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L2);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.tv2 = new TextView(parent.getContext());
                    for(int i=0;i<St_Arrange.length;i++) {
                        holder.tv2.append(St_Arrange[i]+"\n");
                        holder.tv2.setGravity(Gravity.CENTER);
                        holder.tv2.setLayoutParams(holder.lpView);
                    }
                    holder.L2.addView(holder.tv2);

                    St_Arrange = actItem.getitems3().split(";");
                    holder.L3 = new LinearLayout(parent.getContext());
                    holder.L3.setOrientation(LinearLayout.VERTICAL);
                    holder.linLayoutParam = new LayoutParams(actItem.getsize()/3, LayoutParams.MATCH_PARENT);
                    holder.L3.setLayoutParams(holder.linLayoutParam);
                    holder.mainL.addView(holder.L3);
                    holder.lpView = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
                    holder.tv3 = new TextView(parent.getContext());
                    for(int i=0;i<St_Arrange.length;i++) {
                        holder.tv3.append(St_Arrange[i]+"\n");
                        holder.tv3.setGravity(Gravity.CENTER);
                        holder.tv3.setLayoutParams(holder.lpView);
                    }
                    holder.L3.addView(holder.tv3);
                    break;
                default:
                    break;
            }

       return convertView;
    }

    static class ViewHolder {
        LinearLayout L1;
        LinearLayout L2;
        LinearLayout L3 ;
        LinearLayout mainL;
        LinearLayout Main;
        TextView tv;
        TextView tv2;
        TextView tv3;
        TextView time;
        LinearLayout.LayoutParams linLayoutParam = null;
        LinearLayout.LayoutParams lpView = null;
    }

}
