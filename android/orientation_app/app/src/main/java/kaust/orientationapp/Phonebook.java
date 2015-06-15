package kaust.orientationapp;


import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class Phonebook extends ActionBarActivity {

    private ListView lvPhone;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);

        lvPhone = (ListView)findViewById(R.id.listPhone);

        List<Contact> listContact = new ArrayList<>();
        listContact.add(new Contact(
                BitmapFactory.decodeResource(getResources(), R.drawable.avatar_pete),
                "Pete Houston", "010-9817-6331", "pete.houston.17187@gmail.com"));
        listContact.add(new Contact(
                BitmapFactory.decodeResource(getResources(), R.drawable.avatar_lina),
                "Lina Cheng", "046-7764-1142", "lina.cheng011@sunny.com"));
        listContact.add(new Contact(
                BitmapFactory.decodeResource(getResources(), R.drawable.avatar_jenny),
                "Jenny Nguyen", "0913-223-498", "jenny_in_love98@yahoo.com"));
        PhonebookAdapter adapter = new PhonebookAdapter(this, listContact);
        lvPhone.setAdapter(adapter);
    }
}