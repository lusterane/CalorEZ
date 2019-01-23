package com.example.toby.calorez;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.Goal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

public class GoalActivity extends AppCompatActivity implements View.OnClickListener{
    private static final String TAG = "GoalActivity";

    static String name;
    static String gender;
    static String dob;
    private int goal;
    private Button fatBtn;
    private Button muscleBtn;
    private Button healthBtn;
    private SQLiteDatabase database;

    static final int BURN_FAT = 0;
    static final int BUILD_MUSCLE = 1;
    static final int MAINTAIN_HEALTH = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        fatBtn = findViewById(R.id.fatBtn);
        fatBtn.setOnClickListener(this);
        muscleBtn = findViewById(R.id.muscleBtn);
        muscleBtn.setOnClickListener(this);
        healthBtn = findViewById(R.id.healthBtn);
        healthBtn.setOnClickListener(this);
    }
    private void addData(){
        database = new DatabaseHelper(this).getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(DBContract.Profile.COLUMN_NAME, name);
        contentValues.put(DBContract.Profile.COLUMN_GOAL, goal);
        contentValues.put(DBContract.Profile.COLUMN_GENDER, gender);
        contentValues.put(DBContract.Profile.COLUMN_DOB, "asd");


        long nextID = database.insert(DBContract.Profile.TABLE_NAME, null, contentValues);
        MainActivity.toastMessage(this, "Next Profile table ID: " + nextID);
        Log.d(TAG, "addData: Profile database is created");
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.fatBtn: // goal is burn fat
                goal = BURN_FAT;
                break;
            case R.id.muscleBtn: // goal is build muscle
                goal = BUILD_MUSCLE;
                break;
            case R.id.healthBtn: // goal is maintain health
                goal = MAINTAIN_HEALTH;
                break;
        }
        addData();
        startActivity(new Intent(this, MainActivity.class));
    }
}
