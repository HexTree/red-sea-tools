package kaust.orientationapp;


import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class Phonebook extends ActionBarActivity {

    public String[] ListContacts = new String[]{};

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonebook);


        try {
            Resources ResFiles = getResources();
            InputStream ReadDbFile = ResFiles.openRawResource(R.raw.contacts);
            byte[] Bytes = new byte[ReadDbFile.available()];
            ReadDbFile.read(Bytes);
            String DbLines = new String(Bytes);
            ListContacts = DbLines.split("\n"); // Split the content by line
        } catch (Exception e) {
        }

        ListView lvPhone = (ListView)findViewById(R.id.listPhone);
        List<Contact> listContact = new ArrayList<>();
        for (String contact : ListContacts){
            String[] fields = contact.split(",");
            listContact.add(new Contact(
                    BitmapFactory.decodeResource(getResources(), R.drawable.personal),
                    fields[0], fields[1], fields[2]));
        }

        PhonebookAdapter adapter = new PhonebookAdapter(this, listContact);
        lvPhone.setAdapter(adapter);

    }

}