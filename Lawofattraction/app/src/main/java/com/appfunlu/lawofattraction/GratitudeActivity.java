package com.appfunlu.lawofattraction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.appfunlu.lawofattraction.Adapters.GratitudeAdapter;

public class GratitudeActivity extends AppCompatActivity {


    private GratitudeAdapter mGratitudeAdapter;
    private RecyclerView mGratitudeRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gratitude_list);

        mGratitudeRecyclerView = (RecyclerView) this.findViewById(R.id.grateful_layout_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mGratitudeRecyclerView.setLayoutManager(layoutManager);

        mGratitudeAdapter = new GratitudeAdapter();
        mGratitudeRecyclerView.setAdapter(mGratitudeAdapter);

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
