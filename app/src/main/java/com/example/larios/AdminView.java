package com.example.larios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.PopupMenu;

//Clase de menu de admin
public class AdminView extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Boton que se usa para gestionar las acciones sobre las mesas

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_view);
        //Boton que gestiona la salida al log in
        Button close = findViewById(R.id.appCompatButton_LogOut);
        close.setOnClickListener(v -> finish());
        Button table1 = findViewById(R.id.button1);
        Button table2 = findViewById(R.id.button2);
        Button table3 = findViewById(R.id.button3);
        Button table4 = findViewById(R.id.button4);
        Button table5 = findViewById(R.id.button5);
        Button table6 = findViewById(R.id.button6);
        Button addW = findViewById(R.id.add_waiter);

        //Llamadas al menu de metodos y asignaciones para gestionar las mesas
        table1.setOnClickListener(this::showPopUpTable);
        table2.setOnClickListener(this::showPopUpTable);
        table3.setOnClickListener(this::showPopUpTable);
        table4.setOnClickListener(this::showPopUpTable);
        table5.setOnClickListener(this::showPopUpTable);
        table6.setOnClickListener(this::showPopUpTable);
        // FIXME: 31/01/2022 Implementar metodo addWaiter para que conecte a la base de datos
        addW.setOnClickListener(v -> addWaiter());
    }
    //Metodo que gestiona el menu pop up
    public void showPopUpTable(View view){
        PopupMenu popupMenu = new PopupMenu(this, view);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.admin_popup_table);
        popupMenu.show();
    }
    //Implementacion de metodo para gestionar las opciones del menu
//    @Override
//    public boolean onMenuItemClick(MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.Rename:
////                renameTable();
//                return true;
//            case  R.id.Delete:
////                button.setVisibility(View.INVISIBLE);
//                return true;
//            case R.id.Asign:
//                // FIXME: 31/01/2022 Implementar metodo para asignar mesas a camareros, mismo problema que renombrar
//                return true;
//            default: return false;
//        }
//    }

    // FIXME: 31/01/2022 Averiguar porque no se renobra correctamente la mesa

    //Metodo  para renombrar las mesas
//    public void renameTable(){
//        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
//        final View popUp = getLayoutInflater().inflate(R.layout.rename_table, null);
//        dialogBuilder.setView(popUp);
//        EditText editText = findViewById(R.id.rename_table);
//        Button button1 = findViewById(R.id.button8);
//        AlertDialog dialog = dialogBuilder.create();
//        dialog.show();
//        dialog.setCanceledOnTouchOutside(true);
//        String s = editText.getText().toString();
//        dialog.setOnCancelListener(view -> {
//            button.setText("a");
//            Toast.makeText(this, s, Toast.LENGTH_SHORT).show();
//        });
//    }
    public void addWaiter(){
        startActivity(new Intent(this, CreateWaiter.class));
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        return false;
    }
}