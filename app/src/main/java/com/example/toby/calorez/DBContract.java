package com.example.toby.calorez;

import android.provider.BaseColumns;

import static java.sql.Types.INTEGER;

/**
 * Created by toby on 3/26/2018.
 */

public class DBContract implements BaseColumns {
    private DBContract(){
    }
    public static class Profile{
        public static final String TABLE_NAME = "profile_table";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_DOB = "dob";
        public static final String COLUMN_GENDER = "gender";
        public static final String COLUMN_GOAL = "goal";
        public static final String COLUMN_HEIGHT_US = "height_us"; //ft in
        public static final String COLUMN_HEIGHT_METRIC = "height_metric"; //cm
        public static final String COLUMN_WEIGHT_US = "weight_us";
        public static final String COLUMN_WEIGHT_METRIC = "weight_metric";
        public static final String COLUMN_BODY_FAT = "body_fat";


        public static final String CREATE_TABLE = "CREATE TABLE " +
                TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_GOAL + " INTEGER, " +
                COLUMN_GENDER + " TEXT, " +
                COLUMN_DOB + " TEXT" +
                COLUMN_HEIGHT_US + " INTEGER, " +
                COLUMN_HEIGHT_METRIC + " INTEGER, " +
                COLUMN_WEIGHT_US + " INTEGER, " +
                COLUMN_WEIGHT_METRIC + " INTEGER, " +
                COLUMN_BODY_FAT + " INTEGER" + ")";
    }

    public static class Food{
        public static final String TABLE_NAME =  "food_table";
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_CALORIES = "calories";
        public static final String COLUMN_DATE= "date";
        //nutrition
        public static final String COLUMN_SERVING_SIZE = "serving_size";
        public static final String COLUMN_PROTEIN = "protein";
        public static final String COLUMN_FAT = "fat";
        public static final String COLUMN_SATURATED = "saturated";
        public static final String COLUMN_POLYUNSATURATED = "polyunsaturated";
        public static final String COLUMN_MONOSATURATED = "monosaturated";
        public static final String COLUMN_TRANS = "trans";
        public static final String COLUMN_CHOLESTEROL = "cholesterol";
        public static final String COLUMN_SODIUM = "sodium";
        public static final String COLUMN_POTASSIUM = "potassium";
        public static final String COLUMN_CARB = "carb";
        public static final String COLUMN_DIETARY_FIBER = "dietary_fiber";
        public static final String COLUMN_SUGARS = "sugars";
        public static final String COLUMN_VITAMIN_A = "vitamin_a";
        public static final String COLUMN_VITAMIN_C = "vitamin_c";
        public static final String COLUMN_CALCIUM = "calcium";
        public static final String COLUMN_IRON = "iron";


        public static final String CREATE_TABLE = "CREATE TABLE "
                + TABLE_NAME + " (" +
                _ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_CALORIES + " TEXT, " +
                COLUMN_DATE + " DATETIME, " +
                COLUMN_SERVING_SIZE + " INTEGER, " +
                COLUMN_PROTEIN + " INTEGER, " +
                COLUMN_FAT + " INTEGER, " +
                COLUMN_SATURATED + " INTEGER, " +
                COLUMN_POLYUNSATURATED + " INTEGER, " +
                COLUMN_MONOSATURATED + " INTEGER, " +
                COLUMN_TRANS + " INTEGER, " +
                COLUMN_CHOLESTEROL + " INTEGER, " +
                COLUMN_SODIUM + " INTEGER, " +
                COLUMN_POTASSIUM + " INTEGER, " +
                COLUMN_CARB + " INTEGER, " +
                COLUMN_DIETARY_FIBER + " INTEGER, " +
                COLUMN_SUGARS + " INTEGER, " +
                COLUMN_VITAMIN_A + " INTEGER, " +
                COLUMN_VITAMIN_C + " INTEGER, " +
                COLUMN_CALCIUM + " INTEGER, " +
                COLUMN_IRON + " INTEGER)";
    }
}
