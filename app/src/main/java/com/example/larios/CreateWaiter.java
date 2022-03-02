package com.example.larios;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class CreateWaiter extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_waiter);
        EditText name = findViewById(R.id.newName);
        EditText pass = findViewById(R.id.newPass);
        CheckBox admin = findViewById(R.id.checkBox);
        Button button = findViewById(R.id.submit_waiter);
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        button.setOnClickListener(v -> {
            if (admin.isChecked())
                database.execSQL("INSERT INTO Empleados (Nombre, Contraseña, Admin) Values ('" + name.getText().toString() + "', '" + pass.getText().toString() + "', 1)");
            else database.execSQL("INSERT INTO Empleados (Nombre, Contraseña) Values ('" + name.getText().toString() + "', '" + pass.getText().toString() + "')");
            finish();
        });

    }
}