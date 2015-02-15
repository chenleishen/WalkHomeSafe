package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class JourneyActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_journey);
        startJourney();
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

    public void startJourney(){
        Intent intent = getIntent();
    //    Intent nextIntent = new Intent(this, MainActivity.class);
        User jane = new User();
        int journeyNum = (int) intent.getSerializableExtra("journeyKey");
        jane.start(journeyNum);
    //    startActivity(nextIntent);
    }
    public void homeSafe(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, MainActivity.class);
        startActivity(nextIntent);
    }

//    public void helpMe(){
//        Intent intent = getIntent();
//        Intent nextIntent = new Intent(this, .class);
//        startActivity(nextIntent);
//    }

}
