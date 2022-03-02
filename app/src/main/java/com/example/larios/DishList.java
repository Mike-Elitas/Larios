package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.widget.Button;

import java.util.ArrayList;

public class DishList extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_list);
        Intent intent = getIntent();
        ArrayList<Parcelable> arrayList = intent.getParcelableArrayListExtra("array");
        for (int i = 0; i < arrayList.size(); i++) {
            Button button = new Button(this);
            button.setText((CharSequence) arrayList.get(i));
            button.setOnClickListener(v -> setResult(1));

        }
    }
}