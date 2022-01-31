package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText user = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPassword);
        button.setOnClickListener(view -> {

            if (user.getText().toString().trim().equals("Paco") &&
                    pass.getText().toString().trim().equals("1234")){
                startActivity(new Intent(this, MainActivity2.class));
                button.setBackgroundColor(getColor(R.color.teal_200));
                user.setHintTextColor(Color.BLACK);
                pass.setHintTextColor(Color.BLACK);
            } else {
                user.setHintTextColor(Color.RED);
                pass.setHintTextColor(Color.RED);
                button.setBackgroundColor(Color.RED);
            }
            user.setText("");
            pass.setText("");

        });
    }
}