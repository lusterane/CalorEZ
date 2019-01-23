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
import android.widget.EditText;

public class CaloriesEntryActivity extends AppCompatActivity implements View.OnClickListener{
    private static String TAG = "CaloriesEntryActivity";

    Button btnLog;
    EditText etFood;
    EditText etCalories;
    SQLiteDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories_entry);

        init();
    }

    private void init(){
        database = new DatabaseHelper(this).getWritableDatabase();

        btnLog = findViewById(R.id.button5);
        etFood = findViewById(R.id.editText2);
        etCalories = findViewById(R.id.editText3);

        btnLog.setOnClickListener(this);

    }

    private boolean enterData(){

        ContentValues values = new ContentValues();
        values.put(DBContract.Food.COLUMN_NAME, (etFood.getText()).toString());
        values.put(DBContract.Food.COLUMN_CALORIES, (etCalories.getText()).toString());

        long result = database.insert(DBContract.Food.TABLE_NAME, null, values);
        Log.d(TAG, "enterData: " + "Added Name : " + etFood.getText().toString() + " Calories: " +etCalories.getText().toString());
        MainActivity.toastMessage(this, "Next ID: " + result);
        if(result == -1)
            return false;
        else
            return true;
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.button5: // update
                enterData();
                startActivity(new Intent(this, CaloriesActivity.class));
                break;
        }
    }
}
