package com.appfunlu.lawofattraction;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class QuotesActivity extends AppCompatActivity{

    private TextView mQuotes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inspirational_quotes);

        mQuotes = (TextView) findViewById(R.id.quotes_display);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.quotes_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == R.id.vision_tab3) {
            Context context = QuotesActivity.this;
            Class destinationActivity5 = MainActivity.class;
            Intent startMainActivityIntent = new Intent(context, destinationActivity5);
            startActivity(startMainActivityIntent);
            return true;
        }

        if (itemThatWasClickedId == R.id.quotes_tab3) {
            Context context = QuotesActivity.this;
            Class destinationActivity6 = VisionActivity.class;
            Intent startVisionActivityIntent = new Intent(context, destinationActivity6);
            startActivity(startVisionActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
