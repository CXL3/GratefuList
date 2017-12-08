package com.appfunlu.lawofattraction;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.appfunlu.lawofattraction.Adapters.GratitudeAdapter;
import com.appfunlu.lawofattraction.Data.GratitudeDbHelper;

public class GratitudeActivity extends AppCompatActivity {


    private GratitudeAdapter mGratitudeAdapter;
    private RecyclerView mGratitudeRecyclerView;
    private SQLiteDatabase gDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gratitude_list);


        /**
         * We get a reference to the Gratitude's RecyclerView by using findViewById.
         */
        mGratitudeRecyclerView = (RecyclerView) this.findViewById(R.id.grateful_layout_list);


        /**
         * created gLayoutManager. And set gLayoutManager on mGratitudeRecyclerView;
         */
        LinearLayoutManager gLayoutManager = new LinearLayoutManager(this);
        mGratitudeRecyclerView.setLayoutManager(gLayoutManager);

        /**
         * Create a DB helper.
         * Get a writable data reference.
         */
        GratitudeDbHelper dbHelper = new GratitudeDbHelper(this);
        gDb = dbHelper.getWritableDatabase();


        /**
         * set mGratitudeAdapter equals to a new GratitudeAdapter
         * Setting the adaptor to the RecyclerView.
         */

        mGratitudeAdapter = new GratitudeAdapter();
        mGratitudeRecyclerView.setAdapter(mGratitudeAdapter);


    }

    /**
     * When the user click on the save button
     */
    public void saveGratitudeList(View view) {

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grateful_menu, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == R.id.vision_tab) {
            Context context = GratitudeActivity.this;
            Class destinationActivity1 = VisionActivity.class;
            Intent startVisionActivityIntent = new Intent(context, destinationActivity1);
            startActivity(startVisionActivityIntent);
            return true;
        }

        if (itemThatWasClickedId == R.id.quotes_tab) {
            Context context = GratitudeActivity.this;
            Class destinationActivity2 = QuotesActivity.class;
            Intent startQuotesActivityIntent = new Intent(context, destinationActivity2);
            startActivity(startQuotesActivityIntent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
