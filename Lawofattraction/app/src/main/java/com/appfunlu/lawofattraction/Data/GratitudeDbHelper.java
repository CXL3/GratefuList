package com.appfunlu.lawofattraction.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GratitudeDbHelper extends SQLiteOpenHelper {

    /* THe name of the database */
    private static final String DATABASE_NAME = "gratitude.db";
    /* The version number */
    private static final int DATABASE_VERSION = 1;

    /**
     * I have created a constructor that takes a context
     * @param context
     */
    public GratitudeDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    /* Override OnCreate method*/
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        /*The string with a SQL statement created a table to hold Gratitude data. */
        final String SQL_CREATE_GRATITUDE_TABLE = "CREATE TABLE " + GratitudeContract.GratitudeEntry.TABLE_NAME + " (" +
                GratitudeContract.GratitudeEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                GratitudeContract.GratitudeEntry.COLUMN_GRATEFUL_LIST + " TEXT NOT NULL, " +
                "); ";
        /* Execute the SQL. */
        sqLiteDatabase.execSQL(SQL_CREATE_GRATITUDE_TABLE);
    }

    /* Override onUpgrade method */
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        /* drop table query and then recreat it. only use it when I change data version. */
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + GratitudeContract.GratitudeEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);

    }
}
