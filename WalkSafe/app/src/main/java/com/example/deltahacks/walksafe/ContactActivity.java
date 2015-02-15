package com.example.deltahacks.walksafe;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;


public class ContactActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_contact, menu);
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


    /**
     * Moves to AddActivity
     */
    public void moveToAdd(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, AddActivity.class);
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }

    /**
     * Moves to RemoveActivity
     */
    public void moveToRemove(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, RemoveActivity.class);
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }

    public void returnToMain(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, MainActivity.class);
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }

    public void save(View view) throws FileNotFoundException, UnsupportedEncodingException {

        Intent nextIntent = new Intent(this, SaveActivity.class);
        Intent intent = getIntent();
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");

        ArrayList<Contact> contactList = contactManager.getContacts();
        BufferedWriter infoWriter = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(this.getApplicationContext().getFilesDir().toString() + "/contacts.txt"), "UTF-8"));
        try {
            for (Contact c : contactList) {
                infoWriter.write(c.getContactName() + ", " + c.getContactNumber());
            }
            infoWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }
}
