package com.appfunlu.lawofattraction;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;

import com.appfunlu.lawofattraction.Adapters.GratitudeAdapter;
import com.appfunlu.lawofattraction.Data.GratitudeContract;
import com.appfunlu.lawofattraction.Data.GratitudeDbHelper;

public class GratitudeActivity extends AppCompatActivity {


    private GratitudeAdapter mGratitudeAdapter;
    private RecyclerView mGratitudeRecyclerView;
    private SQLiteDatabase gDb;
    private EditText mGratitudeInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gratitude_list);


        /**
         * We get a reference to the Gratitude's RecyclerView by using findViewById.
         */
        mGratitudeRecyclerView = (RecyclerView) this.findViewById(R.id.grateful_layout_list);
        mGratitudeInput = (EditText) this.findViewById(R.id.grateful_input_box);


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
         * Use the getGlist method and store all the result in gCursor
         */
        Cursor gCursor = getGList();


        /**
         * set mGratitudeAdapter equals to a new GratitudeAdapter
         * Setting the adaptor to the RecyclerView.
         * pass the gCursor to the adapter.
         */

        mGratitudeAdapter = new GratitudeAdapter(this, gCursor);
        mGratitudeRecyclerView.setAdapter(mGratitudeAdapter);

        /**
         * Use ItemTouchHelper.SimpleCallback to drag item around, and to delete the list by swiping
         */

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback (ItemTouchHelper.UP | ItemTouchHelper.DOWN, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                final int fromPosition = viewHolder.getAdapterPosition();
                final int toPosition = target.getAdapterPosition();

                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {

                long id = (long) viewHolder.itemView.getTag();
                removeGList(id);
                mGratitudeAdapter.swapCursor(getGList());
            }

        }).attachToRecyclerView(mGratitudeRecyclerView);
    }

    /**
     * Created a method called getGList to query the gDb
     * and get call the grateful list.
     *
     * @return Cursor containing the grateful list.
     */
    private Cursor getGList() {
        return gDb.query(
                GratitudeContract.GratitudeEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                GratitudeContract.GratitudeEntry.COLUMN_TIMESTAMP
        );
    }

    /**
     * Created a method to add the list to the gDb.
     * Created ContentValues to pass the gValues.
     * Insert a new row in the database.
     */
    private long addGList(String gratitudeList) {

        ContentValues gValues = new ContentValues();
        gValues.put(GratitudeContract.GratitudeEntry.COLUMN_GRATEFUL_LIST, gratitudeList);

        return gDb.insert(GratitudeContract.GratitudeEntry.TABLE_NAME, null, gValues);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.grateful_menu, menu);
        return true;
    }


    /**
     *If you click the save button, the new list will be added to the database.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == R.id.save_g_tab) {

            addGList(mGratitudeInput.getText().toString());
            mGratitudeAdapter.swapCursor(getGList());
            mGratitudeInput.getText().clear();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This will remove the list with the specific ID.
     */
    private boolean removeGList(long id) {
        return gDb.delete(GratitudeContract.GratitudeEntry.TABLE_NAME,
                GratitudeContract.GratitudeEntry._ID + "=" + id, null) > 0;
    }

}
