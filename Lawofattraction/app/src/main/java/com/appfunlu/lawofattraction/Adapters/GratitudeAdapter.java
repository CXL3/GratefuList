package com.appfunlu.lawofattraction.Adapters;


import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appfunlu.lawofattraction.Data.GratitudeContract;
import com.appfunlu.lawofattraction.R;

/**
 * From GratitudeAdapter, extend RecyclerView.Adapter<GratitudeAdapter.GratitudeViewHolder>
 */

public class GratitudeAdapter extends RecyclerView.Adapter<GratitudeAdapter.GratitudeViewHolder> {

    /** the calling context variable.
     * the cursor variable
     */
    private  Context gContext;
    private Cursor gratitudeCursor;

    /**
     * Added Adapter constructor to accept the context and count
     * @param context the calling context
     * @param cursor the db cursor with gratitude data to display
     */

    public GratitudeAdapter(Context context, Cursor cursor){
        this.gContext = context;
        this.gratitudeCursor = cursor;
    }
    /**
     * Override the onCreateViewHolder method, since the ViewHolder is created.
     * @param viewGroup viewGroup The ViewGroup that the ViewHolders are contained within.
     * @return A new GratitudeViewHolder that holds the View for each list item
     */
    @Override
    public GratitudeViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Context gContext = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(gContext);

        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(R.layout.g_recycler_list_item, viewGroup, shouldAttachToParentImmediately);

        return new GratitudeViewHolder(view);
    }



    /**
     * Override onBindViewHolder.
     * It is is called by the RecyclerView to display the data at the specified position.
     * @param gViewholder The ViewHolder which should be updated to represent the contents of the
    item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(GratitudeViewHolder gViewholder, int position) {

        /**
         * passing in the current binding position
         * return null if there's no data there or it's out of the bounds of the cursor
         */
        if (!gratitudeCursor.moveToPosition(position))

            return;

        /**
         * Call getString on the cursor to get the grateful list.
         */
        String grateful = gratitudeCursor.getString(gratitudeCursor.getColumnIndex(GratitudeContract.GratitudeEntry.COLUMN_GRATEFUL_LIST));


        /* Set gViewHolder's gratefulFinalView  text to the grateful list */
        gViewholder.gratefulFinalView.setText(grateful);

    }


    /**
     * This method simply returns the number of items to display.
     * @return the getCount of the cursor.
     */
    @Override
    public int getItemCount() {
        return gratitudeCursor.getCount();

    }

    /**
     * Created a class within GratitudeAdapter called GratitudeViewHolder.
     * It extends from the RecyclerView.ViewHolder.
     * This class will hold the gratitude list  in the recycler view
     * Created a TextView called gratefulFinalView.
     * It will show the Grateful List that the users inputted.
     */
    class GratitudeViewHolder extends RecyclerView.ViewHolder {

        TextView gratefulFinalView;

        /**
         * Created a constructor for GratitudeViewHolde that accepts a view as a parameter.
         * call super on (itemView) and then find gratefulFinalView by ID
         */

        public GratitudeViewHolder(View itemView) {
            super(itemView);
            gratefulFinalView = (TextView) itemView.findViewById(R.id.g_recycler_text);



        }
    }

}
