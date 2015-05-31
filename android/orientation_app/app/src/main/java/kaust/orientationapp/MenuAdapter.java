package kaust.orientationapp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends BaseAdapter{

    String [] result;
    Context context;
    int [] imageId;
    private static LayoutInflater inflater=null;
    public MenuAdapter(MainMenu mainActivity, String[] prgmNameList, int[] prgmImages) {
        result=prgmNameList;
        context=mainActivity;
        imageId=prgmImages;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return result.length;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class Holder
    {
        TextView tv;
        ImageView img;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            convertView = inflater.inflate(R.layout.feature, null);

            holder=new Holder();
            holder.tv = (TextView) convertView.findViewById(R.id.textView1);
            holder.img = (ImageView) convertView.findViewById(R.id.imageView1);

            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.tv.setText(result[position]);
        holder.img.setImageResource(imageId[position]);

        convertView.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
//                Toast.makeText(context, "You Clicked " + result[position], Toast.LENGTH_LONG).show();
                if (result[position].equals("Checklist")) {
                    Intent intent = new Intent(context, Checklist.class);
                    context.startActivity(intent);
                }
            }
        });

        return convertView;
    }

}
