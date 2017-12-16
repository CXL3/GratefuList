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

import com.appfunlu.lawofattraction.Adapters.VisionAdapter;
import com.appfunlu.lawofattraction.Data.VisionContract;
import com.appfunlu.lawofattraction.Data.VisionDbHelper;

public class VisionActivity extends AppCompatActivity{


    private VisionAdapter mVisionAdapter;
    private RecyclerView mVisionRecyclerView;
    private SQLiteDatabase vDb;
    private EditText mVisionInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vision_list);


        /**
         * We get a reference to the Vision List's RecyclerView by using findViewById.
         */
        mVisionRecyclerView = (RecyclerView) this.findViewById(R.id.vision_layout_list);
        mVisionInput = (EditText) this.findViewById(R.id.vision_list_input);


        /**
         * created vLayoutManager. And set vLayoutManager on mVisionRecyclerView;
         */
        LinearLayoutManager vLayoutManager = new LinearLayoutManager(this);
        mVisionRecyclerView.setLayoutManager(vLayoutManager);

        /**
         * Create a DB helper.
         * Get a writable data reference.
         */
        VisionDbHelper dbHelper2 = new VisionDbHelper(this);
        vDb = dbHelper2.getWritableDatabase();

        /**
         * Use the getVlist method and store all the result in vCursor
         */
        Cursor vCursor = getVList();


        /**
         * set mVisionAdapter equals to a new VisionAdapter
         * Setting the adaptor to the RecyclerView.
         * pass the vCursor to the adapter.
         */

        mVisionAdapter = new VisionAdapter(this, vCursor);
        mVisionRecyclerView.setAdapter(mVisionAdapter);

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

                long id2 = (long) viewHolder.itemView.getTag();
                removeVList(id2);
                mVisionAdapter.swapCursor(getVList());
            }

        }).attachToRecyclerView(mVisionRecyclerView);
    }


    /**
     * Created a method called getGList to query the gDb
     * and get call the vision list.
     *
     * @return Cursor containing the vision list.
     */
    private Cursor getVList() {
        return vDb.query(
                VisionContract.VisionEntry.TABLE_NAME,
                null,
                null,
                null,
                null,
                null,
                VisionContract.VisionEntry.COLUMN_TIMESTAMP
        );
    }

    /**
     * Created a method to add the list to the vDb.
     * Created ContentValues to pass the vValues.
     * Insert a new row in the database.
     */
    private long addVList(String visionList) {

        ContentValues vValues = new ContentValues();
        vValues.put(VisionContract.VisionEntry.COLUMN_VISION_LIST, visionList);

        return vDb.insert(VisionContract.VisionEntry.TABLE_NAME, null, vValues);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.vision_menu, menu);
        return true;
    }
    /**
     *If you click the save button, the new list will be added to the database.
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int itemThatWasClickedId = item.getItemId();

        if (itemThatWasClickedId == R.id.save_v_tab) {

            addVList(mVisionInput.getText().toString());
            mVisionAdapter.swapCursor(getVList());
            mVisionInput.getText().clear();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * This will remove the list with the specific ID.
     */
    private boolean removeVList(long id2) {
        return vDb.delete(VisionContract.VisionEntry.TABLE_NAME,
                VisionContract.VisionEntry._ID + "=" + id2, null) > 0;
    }

}
