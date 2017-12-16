package com.appfunlu.lawofattraction.Adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appfunlu.lawofattraction.Data.VisionContract;
import com.appfunlu.lawofattraction.R;

public class VisionAdapter extends RecyclerView.Adapter<VisionAdapter.VisionViewHolder> {

    /** the calling context variable.
     * the cursor variable
     */
    private Context vContext;
    private Cursor visionCursor;

    /**
     * Added Adapter constructor to accept the context and count
     * @param context the calling context
     * @param cursor the db cursor with vision data to display
     */

    public VisionAdapter(Context context, Cursor cursor){
        this.vContext = context;
        this.visionCursor = cursor;
    }
    /**
     * Override the onCreateViewHolder method, since the ViewHolder is created.
     * @param viewGroup viewGroup The ViewGroup that the ViewHolders are contained within.
     * @return A new VisionViewHolder that holds the View for each list item
     */
    @Override
    public VisionViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {

        Context vContext = viewGroup.getContext();
        LayoutInflater inflater = LayoutInflater.from(vContext);

        boolean shouldAttachToParentImmediately = false;
        View view = inflater.inflate(R.layout.v_recycler_list_item, viewGroup, shouldAttachToParentImmediately);

        return new VisionViewHolder(view);
    }



    /**
     * Override onBindViewHolder.
     * It is is called by the RecyclerView to display the data at the specified position.
     * @param vViewholder The ViewHolder which should be updated to represent the contents of the
    item at the given position in the data set.
     * @param position The position of the item within the adapter's data set.
     */
    @Override
    public void onBindViewHolder(VisionViewHolder vViewholder, int position) {

        /**
         * passing in the current binding position
         * return false if there's no data there or it's out of the bounds of the cursor
         */
        if (!visionCursor.moveToPosition(position))

            return;

        /**
         * Call getString on the cursor to get the vision list. set the string result to
         */
        String vision = visionCursor.getString(visionCursor.getColumnIndex(VisionContract.VisionEntry.COLUMN_VISION_LIST));

        long id2 = visionCursor.getLong(visionCursor.getColumnIndex(VisionContract.VisionEntry._ID));


        /* Display the cursor String on the Vision page's Textview visionFinalView */
        vViewholder.visionFinalView.setText(vision);

        vViewholder.itemView.setTag(id2);
    }



    /**
     * This method simply returns the number of items to display.
     * @return the getCount of the cursor.
     */
    @Override
    public int getItemCount() {
        return visionCursor.getCount();}

    /**
     * Swaps the Cursor currently held in the adapter with a new one
     */
    public void swapCursor(Cursor newCursor) {

        if (visionCursor != null) visionCursor.close();

        visionCursor = newCursor;

        if (newCursor != null) {

            this.notifyDataSetChanged();
        }
    }

    /**
     * Created a class within VisionAdapter called VisionViewHolder.
     * It extends from the RecyclerView.ViewHolder.
     * This class will hold the Vision list  in the recycler view
     * Created a TextView called visionFinalView.
     * It will show the Vision List that the users inputted.
     */
    class VisionViewHolder extends RecyclerView.ViewHolder {

        TextView visionFinalView;

        /**
         * Created a constructor for VisionViewHolde that accepts a view as a parameter.
         * call super on (itemView) and then find visionFinalView by ID
         */

        public VisionViewHolder(View itemView) {
            super(itemView);
            visionFinalView = (TextView) itemView.findViewById(R.id.v_recycler_text);



        }
    }

}
