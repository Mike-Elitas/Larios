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
public class WaiterView extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


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
            startActivity(intent);
        });
        table2.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            startActivity(intent);
        });
        table3.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            startActivity(intent);
        });
        table4.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            startActivity(intent);
        });
        table5.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            startActivity(intent);
        });
        table6.setOnClickListener(v -> {
            intent.putExtra("button", v.getId());
            startActivity(intent);
        });
    }

    /* FIXME: 31/01/2022 Añadir la funcionalidad completa a las mesas
    -Gestion de la cuenta
    -Pago
    -Borrar elementos*/

        //Este metodo crea un popUp con la informacion de las mesas (beta)


    //Este metodo implementa el metodo onMenuItemClick para gestionar el item de este menu que se clica
    public void showPopUpTable(View view){
        //Generacion de un menu con los items alojados en la layout popup_table
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_table);
        popupMenu.show();
    }

    // FIXME: 31/01/2022 Asignar las query a cada opcion
    //Este metodo gestiona la opcion seleccionada en y realiza el metodo asociado en el switch
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        DBHelper dbHelper = new DBHelper(this);
        Intent intent = new Intent(this, DishList.class);
        //Este switch contiene los filtros de la carta
        switch (item.getItemId()){
            case R.id.Carnes:
                intent.putExtra("array", dbHelper.getPlatos("Carnes"));
                startActivityForResult(intent, 1);
                return true;
            case  R.id.Pescados:
                intent.putExtra("array", dbHelper.getPlatos("Pescados"));
                startActivityForResult(intent, 1);
                return true;
            case R.id.Bebidas:
                intent.putExtra("array", dbHelper.getPlatos("Bebidas"));
                startActivityForResult(intent, 1);
                return true;
            default: return false;
        }
    }
}