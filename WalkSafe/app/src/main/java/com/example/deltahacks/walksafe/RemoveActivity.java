package com.example.deltahacks.walksafe;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class RemoveActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_remove, menu);
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

    public void remove(View view){
        Intent intent = getIntent();
        Intent nextIntent = new Intent(this, ContactActivity.class);
        EditText nameText = (EditText) findViewById(R.id.remove_name);
        String name = nameText.getText().toString();
        ContactManager contactManager = (ContactManager) intent.getSerializableExtra("managerKey");
        try {
            contactManager.deleteContact(name);
            nextIntent.putExtra("managerKey", contactManager);
            startActivity(nextIntent);
        } catch (MissingContactException e) {
            Toast.makeText(getApplicationContext(), "Contact does not exist. Please try again.",
                    Toast.LENGTH_LONG).show();
        }

    }
}
