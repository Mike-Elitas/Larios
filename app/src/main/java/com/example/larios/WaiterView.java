package com.example.larios;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//Clase de menu de camarero
public class WaiterView extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.waiter_view);
        //Boton de salida hacia el login (finaliza la pantalla)
        Button close = findViewById(R.id.appCompatButton_LogOut);
        close.setOnClickListener(v -> finish());
        //Instancia de los botones que hacen de mesa
        Button table1 = findViewById(R.id.button1);
        Button table2 = findViewById(R.id.button2);
        Button table3 = findViewById(R.id.button3);
        Button table4 = findViewById(R.id.button4);
        Button table5 = findViewById(R.id.button5);
        Button table6 = findViewById(R.id.button6);

        Intent intent = new Intent(this, Table.class);
        //Llamadas al metodo que muesta la información de las mesas
        table1.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table1.getText().toString());
            startActivity(intent);
        });
        table2.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table2.getText().toString());
            startActivity(intent);
        });
        table3.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table3.getText().toString());
            startActivity(intent);
        });
        table4.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table4.getText().toString());
            startActivity(intent);
        });
        table5.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table5.getText().toString());
            startActivity(intent);
        });
        table6.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            intent.putExtra("name", table6.getText().toString());
            startActivity(intent);
        });
    }
}