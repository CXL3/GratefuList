package com.appfunlu.lawofattraction.Data;

import android.provider.BaseColumns;

public class VisionContract {

    /**
     * I created the inner class that defines that table contents of the Table.
     * This class that implements the BaseColumns interface.
     */
    public static final class VisionEntry implements BaseColumns {

        /* I have created static final members for the table name and the db column.*/
        public static final String TABLE_NAME = "Vision";
        public static final String COLUMN_VISION_LIST = "visionList";
        public static final String COLUMN_TIMESTAMP = "timestamp2";


    }

}