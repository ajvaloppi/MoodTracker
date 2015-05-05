package com.example.amandavaloppi.moodtracker;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Map;


public class DisplayMessageActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        //Get the message from the intent
        Intent intent = getIntent();
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        Map<String, ?> keys = sharedPref.getAll();
        String message = "";
        for (Map.Entry<String,?> entry : keys.entrySet()){
            //Log.d("map values", entry.getKey() + " : " + entry.getValue().toString());
            message = message + entry.getKey() + " : " + entry.getValue().toString() + '\n';
        }
        //String message = sharedPref.getString("Amanda", "mood");//intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        //create the text view

        textView.setTextSize(20);
        textView.setText(message);
        //set the text view as the activity layout
        setContentView(textView);

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
}
