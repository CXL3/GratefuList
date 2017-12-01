package com.appfunlu.lawofattraction.Adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appfunlu.lawofattraction.R;

/**
 * From GratitudeAdapter, extend RecyclerView.Adapter<GratitudeAdapter.GratitudeViewHolder>
 */

public class GratitudeAdapter extends RecyclerView.Adapter<GratitudeAdapter.GratitudeViewHolder> {

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

    }


    /**
     * This method simply returns the number of items to display.
     * @return 0 for now.
     */
    @Override
    public int getItemCount() {
        return 0;

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
