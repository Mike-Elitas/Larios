package com.example.larios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button close = findViewById(R.id.appCompatButton_LogOut);
        close.setOnClickListener(v -> finish());
        Button table1 = findViewById(R.id.button1);
        Button table2 = findViewById(R.id.button2);
        Button table3 = findViewById(R.id.button3);
        Button table4 = findViewById(R.id.button4);
        Button table5 = findViewById(R.id.button5);
        Button table6 = findViewById(R.id.button6);

        table1.setOnClickListener(view -> createTablePopUp());
        table2.setOnClickListener(view -> createTablePopUp());
        table3.setOnClickListener(view -> createTablePopUp());
        table4.setOnClickListener(view -> createTablePopUp());
        table5.setOnClickListener(view -> createTablePopUp());
        table6.setOnClickListener(view -> createTablePopUp());
    }

    public void createTablePopUp(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popUp = getLayoutInflater().inflate(R.layout.table, null);
        Button close = popUp.findViewById(R.id.appCompatButton_Close);
        Button add = popUp.findViewById(R.id.appCompatButton_add);
        Button delete = popUp.findViewById(R.id.appCompatButton_Delete);
        Button pay = findViewById(R.id.appCompatButton_Pay);
        dialogBuilder.setView(popUp);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
        close.setOnClickListener(v -> dialog.dismiss());
        add.setOnClickListener(this::showPopUpTable);
    }

    public void showPopUpTable(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_table);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Carnes:
                Toast.makeText(this, "Carne", Toast.LENGTH_LONG).show();
                return true;
            case  R.id.Pescados:
                Toast.makeText(this, "Pescado", Toast.LENGTH_LONG).show();
                return true;
            case R.id.Bebidas:
                Toast.makeText(this, "Bebidas", Toast.LENGTH_LONG).show();
                return true;
            default: return false;
        }
    }
}