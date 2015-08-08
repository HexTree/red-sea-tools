package kaust.orientationapp;


import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
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

        int[] Icon = {R.drawable.i_hub,R.drawable.student_life,R.drawable.student_life,R.drawable.maintenance,R.drawable.community_info,
                R.drawable.it,R.drawable.community_info,R.drawable.mail,R.drawable.taxi,R.drawable.taxi,R.drawable.taxi,R.drawable.medical,R.drawable.emergency,R.drawable.goverment_affairs};

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
        int i=0;
        for (String contact : ListContacts){
            String[] fields = contact.split(",");
            listContact.add(new Contact(
                    BitmapFactory.decodeResource(getResources(), Icon[i]),
                    fields[0], fields[1], fields[2]));
            i++;
        }

        PhonebookAdapter adapter = new PhonebookAdapter(this, listContact);
        lvPhone.setAdapter(adapter);

    }

}