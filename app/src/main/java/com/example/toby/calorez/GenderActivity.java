package com.example.toby.calorez;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.constraint.solver.Goal;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class GenderActivity extends AppCompatActivity implements View.OnClickListener{
    private Button maleButton;
    private Button femaleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);

        init();
    }
    private void init(){
        maleButton = findViewById(R.id.button2);
        maleButton.setOnClickListener(this);
        femaleButton = findViewById(R.id.button);
        femaleButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button: // female
                GoalActivity.gender = "FEMALE";
                startActivity(new Intent(GenderActivity.this, GoalActivity.class));
                break;
            case R.id.button2: // male
                GoalActivity.gender = "MALE";
                startActivity(new Intent(GenderActivity.this, GoalActivity.class));
                break;
        }
    }

}
