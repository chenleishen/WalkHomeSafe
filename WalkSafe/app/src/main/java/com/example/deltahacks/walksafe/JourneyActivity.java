package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;


public class JourneyActivity extends ActionBarActivity {

    public View v;
    private User jane = new User();
    final Runnable checkAgainSignal = new Runnable() {
        @Override
        public void run() {
            checkAgain(v);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);
        Intent intent = getIntent();
        try {
            int journeyNum = (int) intent.getSerializableExtra("journeyKey");
            jane.start(journeyNum, checkAgainSignal);
        } catch (Exception ex) {
            jane.start(1, checkAgainSignal);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_journey, menu);
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


    public void homeSafe(View view){
        jane.gotHome(checkAgainSignal);
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, MainActivity.class);
        startActivity(nextIntent);
    }

   public void helpMe(View view) {
        Intent intent = getIntent();
//        Intent nextIntent = new Intent(this, .class);
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        ArrayList<Contact> contactList = contactManager.getContacts();
        String sms = "I have not arrived home at the expected time. Please give me a call ASAP.";
        try {
            SmsManager smsManager = SmsManager.getDefault();
            for (Contact c: contactList){
                String phoneNo = c.getContactNumber();
                smsManager.sendTextMessage(phoneNo, null, sms, null, null);
            }
            //smsManager.sendTextMessage(", null, sms, null, null);

            Toast.makeText(getApplicationContext(), "Your friends have been alerted!",
                    Toast.LENGTH_LONG).show();

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "SMS failed!",
                    Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
            //    startActivity(nextIntent);
        }

    public void checkAgain(View view) {
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, WaitActivity.class);
        startActivity(nextIntent);
    }
}
