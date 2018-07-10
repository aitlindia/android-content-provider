package com.aitl.aitlcontact;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private ContactAdapter adapter,adapter1;
    private List<MyContact> contactList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listViewContact);

        contactList = ContactModel.getAllContacts(this);

        adapter = new ContactAdapter(this,contactList);
        listView.setAdapter(adapter);
    }
}
