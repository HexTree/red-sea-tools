package kaust.orientationapp;


import android.content.Context;
import android.content.Intent;
import android.provider.Contacts;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PhonebookAdapter extends BaseAdapter {
    private Context mContext;
    private List<Contact> mListContact;

    public PhonebookAdapter(Context context, List<Contact> list) {
        mContext = context;
        mListContact = list;

    }

    @Override
    public int getCount() {
        return mListContact.size();
    }

    @Override
    public Object getItem(int pos) {
        return mListContact.get(pos);
    }

    @Override
    public long getItemId(int pos) {
        return pos;
    }

    @Override
    public View getView(int pos, View convertView, ViewGroup parent) {
        // get selected entry
        final Contact entry = mListContact.get(pos);

        // inflating list view layout if null
        if(convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.contact, null);
        }

        // set avatar
        ImageView ivAvatar = (ImageView)convertView.findViewById(R.id.imgAvatar);
        ivAvatar.setImageBitmap(entry.getAvatar());

        // set name
        TextView tvName = (TextView)convertView.findViewById(R.id.tvName);
        tvName.setText(entry.getName());

        // set phone
        TextView tvPhone = (TextView)convertView.findViewById(R.id.tvPhone);
        tvPhone.setText(entry.getPhone());

        // set email
        TextView tvEmail = (TextView)convertView.findViewById(R.id.tvEmail);
        tvEmail.setText(entry.getEmail());

        Button myButton = (Button)convertView.findViewById(R.id.button1);
        myButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // Creates a new Intent to insert a contact
                Intent intent = new Intent(ContactsContract.Intents.Insert.ACTION);
                // Sets the MIME type to match the Contacts Provider
                intent.setType(ContactsContract.RawContacts.CONTENT_TYPE);

                intent.putExtra(ContactsContract.Intents.Insert.NAME, entry.getName());

                // Inserts an email address
                intent.putExtra(ContactsContract.Intents.Insert.EMAIL, entry.getEmail());

                // Inserts a phone number
                intent.putExtra(ContactsContract.Intents.Insert.PHONE, entry.getPhone());

                mContext.startActivity(intent);
            }
        });

        return convertView;
    }
}
