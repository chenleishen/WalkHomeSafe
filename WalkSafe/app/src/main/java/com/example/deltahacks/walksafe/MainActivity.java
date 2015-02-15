package com.example.deltahacks.walksafe;

import android.support.v7.app.ActionBarActivity;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import android.content.Intent;
import java.util.ArrayList;
import java.util.List;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView;

public class MainActivity extends Activity {
    private Spinner spinner1;
    private Button start;

    ContactManager contactManager = new ContactManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addListenerOnButton();
        addListenerOnSpinnerItemSelection();

<<<<<<< Updated upstream
=======
        //ContactManager contactManager = new ContactManager();
>>>>>>> Stashed changes

        try {
            BufferedReader contactReader = new BufferedReader
                    (new FileReader(this.getApplicationContext().getFilesDir().toString() + "/contacts.txt"));
            String contactLine = null;
            String[] contactInfo;
            while ((contactLine = contactReader.readLine()) != null) {
                contactInfo = contactLine.split(",");
                String name = contactInfo[0];
                String number = contactInfo[1];
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
        }

        CustomAdapter adapter = new CustomAdapter(this, R.layout.contact_list_item, contactManager.getContacts());
<<<<<<< Updated upstream
        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);
=======

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

>>>>>>> Stashed changes
    }


    public void addListenerOnSpinnerItemSelection() {
        spinner1 = (Spinner) findViewById(R.id.spinner1);
        spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
    }

    public void addListenerOnButton() {

        spinner1 = (Spinner) findViewById(R.id.spinner1);
        start = (Button) findViewById(R.id.start);

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

    /**
     * Moves to ContactActivity (settings page),
     * allows you to add/delete/update contacts
     */

    public void goToSettings(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, ContactActivity.class);
<<<<<<< Updated upstream
=======
        //ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
>>>>>>> Stashed changes
        nextIntent.putExtra("managerKey", contactManager);
        startActivity(nextIntent);
    }

    /**
     * If new journey is created with correct string, end
     */
    public void submitJourney(View view){
        //Intent intent = getIntent();
        Intent nextIntent = new Intent(this, JourneyActivity.class);
        int journeyID = spinner1.getSelectedItemPosition();
        nextIntent.putExtra("journeyKey", journeyID);
        startActivity(nextIntent);

    }

}
