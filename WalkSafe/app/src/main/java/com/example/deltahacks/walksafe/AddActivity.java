package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class AddActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void addContact(View view) {
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, ContactActivity.class);

        EditText nameText = (EditText) findViewById(R.id.contact_name);
        EditText numberText= (EditText) findViewById(R.id.contact_number);

        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");

        String name = nameText.getText().toString();
        String number = numberText.getText().toString();

        Contact newContact = new Contact(name, number);
        contactManager.addContact(newContact);
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);


        }




    }
}
