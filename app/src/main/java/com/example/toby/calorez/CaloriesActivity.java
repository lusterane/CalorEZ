package com.example.toby.calorez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class CaloriesActivity extends AppCompatActivity implements View.OnClickListener{
    //imageButton is add
    ImageButton newEntry;
    ImageButton editEntry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        init();
    }

    private void init(){
        newEntry = findViewById(R.id.newEntryBtn);
        editEntry = findViewById(R.id.editEntryBtn);

        newEntry.setOnClickListener(this);
        editEntry.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.newEntryBtn: // new entry
                startActivity(new Intent(this, CaloriesEntryActivity.class));
                break;
            case R.id.editEntryBtn: // edit entry
                startActivity(new Intent(this, FoodListActivity.class));
                break;
        }
    }
}
