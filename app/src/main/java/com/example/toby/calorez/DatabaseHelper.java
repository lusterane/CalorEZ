package com.example.toby.calorez;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by toby on 3/25/2018.
 */

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "main_database";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // create table
        sqLiteDatabase.execSQL(DBContract.Profile.CREATE_TABLE);
        sqLiteDatabase.execSQL(DBContract.Food.CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.Profile.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBContract.Food.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
    // returns all
    public Cursor getProfileData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DBContract.Profile.TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    /*
        Gets all the value of food table
        Used in FoodListActivity to show all logged foods
     */
    public Cursor getFoodData(){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + DBContract.Food.TABLE_NAME;
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    public Cursor getFoodID(String name){
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT " + DBContract._ID + " FROM " + DBContract.Food.TABLE_NAME +
                " WHERE " + DBContract.Food.COLUMN_NAME + " = '" + name + "'";
        Cursor data = db.rawQuery(query, null);
        return data;
    }
    /*
        Gets the a specific row of values
        @param _ID This is the corresponding row used
        @param projection This is the columns specified
     */
    public Cursor getFoodValue(String name, String[] projection){
        SQLiteDatabase db = this.getWritableDatabase();

        // columns for the 'WHERE' clause
        String selection = DBContract.Food.COLUMN_NAME + " = ?";
        // values for the 'WHERE' clause
        String[] selectionArgs = { name };
        // sort order
        //String sortOrder = DBContract.Food.COLUMN_CALORIES + " DESC";

        Cursor cursor = db.query(
                DBContract.Food.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null, null, null
                //sortOrder
        );
        return cursor;
    }

}
