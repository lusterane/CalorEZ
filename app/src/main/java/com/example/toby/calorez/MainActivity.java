package com.example.toby.calorez;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button profileActivity;
    private Button caloriesActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(!checkDataBase()) {
            toastMessage(this, "Database exists");
            startActivity(new Intent(this, NameActivity.class));
        }
        init();
    }

    public void init(){
        profileActivity = findViewById(R.id.button3);
        caloriesActivity = findViewById(R.id.button4);

        profileActivity.setOnClickListener(this);
        caloriesActivity.setOnClickListener(this);
    }

    public void toastMessage(String message){
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view){
        switch(view.getId()){
            case R.id.button3: // profile
                startActivity(new Intent(this, ProfileActivity.class));
                break;
            case R.id.button4: // calories
                startActivity(new Intent(this, CaloriesActivity.class));
                break;
        }
    }
    // check if database exists
    private boolean checkDataBase() {
        SQLiteDatabase checkDB = null;
        String path = this.getString(R.string.db_path);
        try {
            checkDB = SQLiteDatabase.openDatabase(path, null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch (SQLiteException e) {
            return false;
        }
        return checkDB != null;
    }

    public static void toastMessage(Context context, String message){
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }
}
