package com.appfunlu.lawofattraction.Data;

import android.provider.BaseColumns;

/*
 * This defines the table and column names for the gratitude database.
 */
public class GratitudeContract {

    /**
     * I created the inner class that defines that table contents of the Gratitude Table.
     * This class that implements the BaseColumns interface.
     */
    public static final class GratitudeEntry implements BaseColumns {

        /* I have created static final members for the table name and the db column.*/
        public static final String TABLE_NAME = "Gratitude";
        public static final String COLUMN_GRATEFUL_LIST = "gratefulList";
        public static final String COLUMN_TIMESTAMP = "timestamp";


    }

}