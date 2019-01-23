package com.example.toby.calorez;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class EditFoodActivity extends AppCompatActivity {
    private static final String TAG = "EditFood";
    private DatabaseHelper mDatabaseHelper;

    private EditText etName;
    private EditText etCalories;
    private Button btnFinish;
    private String name;

    private int ID;
    private int calories;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_food);
        init();
    }
    private void init(){
        etName = findViewById(R.id.foodName);
        etCalories = findViewById(R.id.calories);
        btnFinish = findViewById(R.id.enterDataBtn);

        // get Intent received from last activity
        Intent receivedIntent = getIntent();

        // sets values of received intent
        name = receivedIntent.getStringExtra("name");
        ID = receivedIntent.getIntExtra("id", -1);
        readTable();
        etName.setText(name);
        etCalories.setText(String.valueOf(calories));


    }
    /*
        Updates the values of the food table
        @return returns 1 if successful, 0 otherwise
     */
    private boolean updateEntry(){
        if(!isAcceptableEntry()) {
            Log.d(TAG, "updateEntry: Entry did not update");
            MainActivity.toastMessage(this, "Please enter a value for name and calories");
            return false;
        }
        // gets user changed string values
        name = etName.getText().toString();
        calories = Integer.getInteger(etCalories.getText().toString());

        return true;
    }
    /*
        Checks if user specified values are acceptable
        Name and calories cannot be blank
        @return 1 if is acceptable, 0 otherwise
     */
    private boolean isAcceptableEntry(){
        return !(etName.getText().toString().equals("") || etCalories.getText().toString().equals(""));
    }
    /*
        Reads data from the table and sets it to class variable List item
        @param name name of item corresponding to row
     */
    private void readTable(){
        Log.d(TAG, "readTable: reading table values");
        String[] projection = {
                DBContract._ID,
                //DBContract.Food.COLUMN_NAME,
                DBContract.Food.COLUMN_CALORIES
        };
        Cursor data = mDatabaseHelper.getFoodValue(name, projection);

        List itemIds = new ArrayList<>();
        while(data.moveToNext()) {
            String itemId = data.getString(
                    data.getColumnIndexOrThrow(DBContract._ID));
            itemIds.add(itemId);
        }
        data.close();

        ID = Integer.parseInt(itemIds.get(0).toString());
        //name = itemIds.get(1).toString(); 
        calories = (int)itemIds.get(1);

    }
}
