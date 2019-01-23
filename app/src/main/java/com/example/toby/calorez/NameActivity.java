package com.example.toby.calorez;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class NameActivity extends AppCompatActivity implements View.OnClickListener{
    private EditText etName;
    private Button nextBtn;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        init();
    }

    public void init() {
        nextBtn = findViewById(R.id.button1);
        etName = findViewById(R.id.editText);

        nextBtn.setOnClickListener(this);
    }

    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.button1:
                GoalActivity.name = etName.getText().toString();
                startActivity(new Intent(this, GenderActivity.class));
                break;
        }
    }
}
