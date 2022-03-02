package com.example.larios;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

//Clase de logIn
public class Login extends AppCompatActivity {
    //suppressLint new api se usa para sortear un requerimento del codigo que no se puede contemplar en apis bajas
    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Instanciacion de los elementos
        setContentView(R.layout.login);
        Button button = findViewById(R.id.button);
        EditText user = findViewById(R.id.editTextTextPersonName);
        EditText pass = findViewById(R.id.editTextTextPassword);


        //Descomentar las dos lineas de abajo para crear los usuarios y volver a comentar o borrar una vez hecho
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        dbHelper.onUpgrade(database, 1, 1);

        button.setOnClickListener(view -> {
            //Uso de Query para validar usuario mas info en DBHelper>getUser()
            if(dbHelper.getUser(user.getText().toString(), pass.getText().toString())){
                //Comprobacion para ver si el usuario es administrador mas info en DBHelper>isAdmin()
                if (dbHelper.isAdmin(user.getText().toString())){
                    startActivity(new Intent(this, AdminView.class));
                } else startActivity(new Intent(this, WaiterView.class));
                button.setBackgroundColor(getColor(R.color.teal_200));
                user.setHintTextColor(Color.BLACK);
                pass.setHintTextColor(Color.BLACK);
                //Cambio de interfaz para mostrar fallo de inicio de sesión
            } else {
                user.setHintTextColor(Color.RED);
                pass.setHintTextColor(Color.RED);
                button.setBackgroundColor(Color.RED);
                Snackbar.make(this, getCurrentFocus(),
                        "Usuario o contraseña incorrectos", Snackbar.LENGTH_LONG).show();
            }
            //Reiniciar campos tras inicio o intento fallido de sesion
            user.setText("");
            pass.setText("");

        });
    }
}