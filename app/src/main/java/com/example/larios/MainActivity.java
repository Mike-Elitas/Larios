package com.example.larios;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

//Clase de logIn
public class MainActivity extends AppCompatActivity {
    //suppressLint new api se usa para sortear un requerimento del codigo que no se puede contemplar en apis bajas
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Instanciacion de los elementos
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.button);
        EditText user = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPassword);


        //Descomentar las dos lineas de abajo para crear los usuarios y volver a comentar o borrar una vez hecho
        DBHelper dbHelper = new DBHelper(this);
//        SQLiteDatabase database = dbHelper.getWritableDatabase();
//        dbHelper.onCreate(database);

        button.setOnClickListener(view -> {
            //Uso de Query para validar usuario mas info en DBHelper>getUser()
            if(dbHelper.getUser(user.getText().toString(), pass.getText().toString())){
                startActivity(new Intent(this, MainActivity3.class));
                button.setBackgroundColor(getColor(R.color.teal_200));
                user.setHintTextColor(Color.BLACK);
                pass.setHintTextColor(Color.BLACK);

                //Temporal uso para modo camarero hasta que se implemente distincion de admin
            } else if (user.getText().toString().equals("Paco2") && pass.getText().toString().equals("1234")){
                startActivity(new Intent(this, MainActivity2.class));
                button.setBackgroundColor(getColor(R.color.teal_200));
                user.setHintTextColor(Color.BLACK);
                pass.setHintTextColor(Color.BLACK);
                //Cambio de interfaz para mostrar fallo de inicio de sesión
            } else {
                user.setHintTextColor(Color.RED);
                pass.setHintTextColor(Color.RED);
                button.setBackgroundColor(Color.RED);
            }
            //Reiniciar campos tras inicio o intento fallido de sesion
            user.setText("");
            pass.setText("");

        });
    }
}