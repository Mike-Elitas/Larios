package com.example.larios;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class Table extends AppCompatActivity {
    private LinearLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table);
        layout = findViewById(R.id.linearLayout);
        Intent intent = new Intent(this, DishList.class);
        int i = getIntent().getIntExtra("button", 0);

        TextView tv = findViewById(R.id.table_Name);
        tv.setText(getIntent().getStringExtra("name"));

        Button close = findViewById(R.id.appCompatButton_Close);
        close.setOnClickListener(v -> finish());

        Button add = findViewById(R.id.appCompatButton_add);
        add.setOnClickListener(v -> startActivityForResult(intent,1));
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==1){
            Button button = new Button(this);
            button.setText(getIntent().getStringExtra("plato"));
            layout.addView(button);
        }
    }
}