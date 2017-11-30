package com.appfunlu.lawofattraction.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.appfunlu.lawofattraction.R;

public class GratitudeAdapter {


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
