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

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class VisionDbHelper extends SQLiteOpenHelper {

    /* THe name of the database */
    private static final String DATABASE_NAME = "vision.db";
    /* The version number */
    private static final int DATABASE_VERSION = 2;

    /**
     * I have created a constructor that takes a context
     *
     * @param context
     */
    public VisionDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    /* Override OnCreate method*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase2) {
        /*The string with a SQL statement created a table to hold data. */
        final String SQL_CREATE_VISION_TABLE = "CREATE TABLE " + VisionContract.VisionEntry.TABLE_NAME + " (" +
                VisionContract.VisionEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                VisionContract.VisionEntry.COLUMN_VISION_LIST + " TEXT NOT NULL, " +
                VisionContract.VisionEntry.COLUMN_TIMESTAMP + " TIMESTAMP DEFAULT CURRENT_TIMESTAMP" +
                "); ";
        /* Execute the SQL. */
        sqLiteDatabase2.execSQL(SQL_CREATE_VISION_TABLE);
    }


    /* Override onUpgrade method */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase2, int oldVersion, int newVersion) {
         /* drop table query and then recreat it. only use it when I change data version. */
        sqLiteDatabase2.execSQL("DROP TABLE IF EXISTS " + VisionContract.VisionEntry.TABLE_NAME);
        onCreate(sqLiteDatabase2);
    }
}



