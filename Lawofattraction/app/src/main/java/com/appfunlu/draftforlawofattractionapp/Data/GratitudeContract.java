/*
 * Copyright 2018.  Xi Lu
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.appfunlu.draftforlawofattractionapp.Data;

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
