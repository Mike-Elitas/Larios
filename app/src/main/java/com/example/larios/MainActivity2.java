package com.example.larios;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

//Clase de menu de camarero
public class MainActivity2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
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

        //Llamadas al metodo que muesta la información de las mesas
        table1.setOnClickListener(view -> createTablePopUp());
        table2.setOnClickListener(view -> createTablePopUp());
        table3.setOnClickListener(view -> createTablePopUp());
        table4.setOnClickListener(view -> createTablePopUp());
        table5.setOnClickListener(view -> createTablePopUp());
        table6.setOnClickListener(view -> createTablePopUp());
    }

    /* FIXME: 31/01/2022 Añadir la funcionalidad completa a las mesas
    -Gestion de la cuenta
    -Pago
    -Borrar elementos*/

        //Este metodo crea un popUp con la informacion de las mesas (beta)
    public void createTablePopUp(){
        //Instancia de la View que aloja la distribucion de las mesa
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popUp = getLayoutInflater().inflate(R.layout.table, null);

        Button close = popUp.findViewById(R.id.appCompatButton_Close);
        Button add = popUp.findViewById(R.id.appCompatButton_add);
        Button delete = popUp.findViewById(R.id.appCompatButton_Delete);
        Button pay = findViewById(R.id.appCompatButton_Pay);
        //Creacion de un dialog (funciona como un popUp)
        dialogBuilder.setView(popUp);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();

        //El boton close gestiona que se cierre el pop up al clicarse
        close.setOnClickListener(v -> dialog.dismiss());
        //El boton add muestra un menu con los filtros de los elementos a añadir
        add.setOnClickListener(this::showPopUpTable);
    }

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

        //Este switch contiene los filtros de la carta
        switch (item.getItemId()){
            case R.id.Carnes:
                Toast.makeText(this, "Carne", Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.Pescados:
                Toast.makeText(this, "Pescado", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.Bebidas:
                Toast.makeText(this, "Bebidas", Toast.LENGTH_SHORT).show();
                return true;
            default: return false;
        }
    }
}