package com.example.deltahacks.walksafe;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import android.content.Intent;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ContactManager contactManager = new ContactManager();

        try {
            BufferedReader contactReader = new BufferedReader
                    (new FileReader(this.getApplicationContext().getFilesDir().toString() + "/contacts.txt"));
            String contactLine = null;
            String[] contactInfo;
            while ((contactLine = contactReader.readLine()) != null) {
                contactInfo = contactLine.split(",");
                String name = contactInfo[1];
                String number= contactInfo[2];
                contactManager.addContact(new Contact(name, number));
            }
            contactReader.close();
            /**
             * replicate for duration
             */
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (NumberFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ContactListFullException e) {
            e.printStackTrace();
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.contact_list_item, contactManager.getContacts());
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    public void goToSettings(){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, ContactActivity.class);
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }

}
