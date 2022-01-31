package com.example.larios;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;

//Clase de menu de admin
public class MainActivity3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    //Boton que se usa para gestionar las acciones sobre las mesas

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
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
        table1.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table1;
        });
        table2.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table2;
        });
        table3.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table3;
        });
        table4.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table4;
        });
        table5.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table5;
        });
        table6.setOnClickListener(v-> {
            showPopUpTable(v);
            button = table6;
        });
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
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()){
            case R.id.Rename:
                renameTable();
                return true;
            case  R.id.Delete:
                // FIXME: 31/01/2022 Implementar metodo para borrar mesas, mismo problema que renombrar
                return true;
            case R.id.Asign:
                // FIXME: 31/01/2022 Implementar metodo para asignar mesas a camareros, mismo problema que renombrar
                return true;
            default: return false;
        }
    }

    // FIXME: 31/01/2022 Averiguar porque no se renobra correctamente la mesa

    //Metodo  para renombrar las mesas
    public void renameTable(){
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        final View popUp = getLayoutInflater().inflate(R.layout.rename_table, null);
        dialogBuilder.setView(popUp);
        EditText editText = findViewById(R.id.rename_table);
        Button renameC = findViewById(R.id.rename_confirm);
        AlertDialog dialog = dialogBuilder.create();
        dialog.show();
//        button.setText(editText.getText().toString());


    }
    public void addWaiter(){

    }
}