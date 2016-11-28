package com.anoniq.gabort.oio;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.*;
import android.provider.BaseColumns;
import android.text.GetChars;


/**
 * Created by gabort on 11/23/2016.
 */

public final class OioDatabase {

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private void OioDatabaseContract() {
    }
    /* Inner class that defines the table contents */
    public static class OioDatabaseEntry implements BaseColumns {
        public static final String TABLE_NAME = "playerList";
        public static final String COLUMN_NAME_BUTTON_NUMBER = "btn_number";
        public static final String COLUMN_NAME_JERSEY_NUMBER = "jersey_n";
        public static final String COLUMN_NAME_ON_ICE = "on_ice";
    }

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + OioDatabaseEntry.TABLE_NAME + " (" +
                    OioDatabaseEntry._ID + " INTEGER PRIMARY KEY," +
                    OioDatabaseEntry.COLUMN_NAME_BUTTON_NUMBER + TEXT_TYPE + COMMA_SEP +
                    OioDatabaseEntry.COLUMN_NAME_JERSEY_NUMBER + TEXT_TYPE + COMMA_SEP + OioDatabaseEntry.COLUMN_NAME_ON_ICE+" )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + OioDatabaseEntry.TABLE_NAME;


    public class OioDbHelper extends SQLiteOpenHelper {
        // If you change the database schema, you must increment the database version.
        public static final int DATABASE_VERSION = 1;
        public static final String DATABASE_NAME = "OioDatabase.db";

        public OioDbHelper(Context context) {
            super(context, DATABASE_NAME, null, DATABASE_VERSION);
        }

        public void onCreate(SQLiteDatabase db) {
            db.execSQL(SQL_CREATE_ENTRIES);
        }

        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            // This database is only a cache for online data, so its upgrade policy is
            // to simply to discard the data and start over
            db.execSQL(SQL_DELETE_ENTRIES);
            onCreate(db);
        }

        public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            onUpgrade(db, oldVersion, newVersion);
        }

    }

    public void putDataOiODb(String key, String data, String onice) {
        // String key is the button number of the button being updated.
        // String data holds the jersey number of the player for that button.

        // Gets the data repository in write mode
        SQLiteDatabase db = OioDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(OioDatabase.OioDatabaseEntry.COLUMN_NAME_BUTTON_NUMBER, key);
        values.put(OioDatabase.OioDatabaseEntry.COLUMN_NAME_JERSEY_NUMBER, data);
        values.put(OioDatabaseEntry.COLUMN_NAME_ON_ICE, onice);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(OioDatabase.OioDatabaseEntry.TABLE_NAME, null, values);
    }

    public String getDataOiODb(String mySelection) {
    SQLiteDatabase db = OioDbHelper.getReadableDatabase();

    // Define a projection that specifies which columns from the database
    // you will actually use after this query.
    String[] projection = {
            OioDatabaseEntry._ID,
            OioDatabaseEntry.COLUMN_NAME_BUTTON_NUMBER,
            OioDatabaseEntry.COLUMN_NAME_JERSEY_NUMBER,
            OioDatabaseEntry.COLUMN_NAME_ON_ICE};

            // Filter results WHERE "title" = 'My Title'
            String selection = OioDatabaseEntry.COLUMN_NAME_BUTTON_NUMBER + " = ?";
        String[] selectionArgs = {"My Title"};

        // How you want the results sorted in the resulting Cursor
        String sortOrder =
                OioDatabaseEntry.COLUMN_NAME_JERSEY_NUMBER + " DESC";

        Cursor c = db.query(
                OioDatabaseEntry.TABLE_NAME,                     // The table to query
                projection,                               // The columns to return
                selection,                                // The columns for the WHERE clause
                selectionArgs,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                sortOrder                                 // The sort order
        );
        return mySelection;
        }
}// End of DB Class





