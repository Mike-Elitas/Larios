package com.example.larios;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


//Clase para gestionar la base de datos de SQL
public class DBHelper extends SQLiteOpenHelper {
     public DBHelper(Context context){
         super (context, DATABASE_NOMBRE, null, DATABASE_VERSION);
     }

     //Instancion de los datos de la BBDD y de sus tablas
     private  final SQLiteDatabase db = getWritableDatabase();
     private static final int DATABASE_VERSION = 1;
     private static final String DATABASE_NOMBRE = "Larios";
     private static final String TABLE_1 = "CREATE TABLE Empleados (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Contraseña TEXT NOT NULL, Admin INTEGER NOT NULL DEFAULT 0)";
     private static final String TABLE_2 = "CREATE TABLE Platos (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre TEXT NOT NULL, Categoria TEXT NOT NULL,Precio INTEGER NOT NULL)";
     private static final String TABLE_3 = "CREATE TABLE Mesas (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre)";
    private static final String TABLE_4 = "CREATE TABLE Ingredientes (ID INTEGER PRIMARY KEY AUTOINCREMENT, Nombre)";
     //Este metodo contiene el SQL que se ejecuta cuando se crea la base de datos por primera vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_1);
        db.execSQL(TABLE_2);
        db.execSQL(TABLE_3);
        db.execSQL(TABLE_4);
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña, Admin) Values ('Paco', '1234', 1)");
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña) Values ('Maria', '123')");
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña) Values ('Mariano', '123')");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Croquetas variadas', 'Entrantes', 9)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Tabla de embutidos ibéricos', 'Entrantes', 12)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Paella de marisco', 'Arroces', 14.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Paella de verduras', 'Arroces', 12.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Paella de marisco', 'Arroces', 13)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Paella Valenciana', 'Arroces', 13)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Arroz Negro', 'Arroces', 13.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Arroz de Bogavante', 'Arroces', 18)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Solomillo a la brasa', 'Carnes', 24)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Chuletón a la brasa', 'Carnes', 50)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Entrecot a la brasa', 'Carnes', 18)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Dorada a la sal', 'Pescados', 22)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Lubina a la espalda', 'Pescados', 22)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Bacalao con costra de allioli', 'Pescados', 24)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Parrillada de pescado y marisco', 'Pescados', 40)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Coulant', 'Postres', 4.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Tarta de queso', 'Postres', 4.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Yogurt natural', 'Postres', 4.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Agua', 'Bebidas', 2.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Refresco', 'Bebidas', 3)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Cerveza', 'Bebidas', 2.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Café', 'Bebidas', 1.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Té', 'Bebidas', 1.5)");
        db.execSQL("INSERT INTO Platos (Nombre, Categoria, Precio) Values ('Cortado', 'Bebidas', 1.5)");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 1')");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 2')");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 3')");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 4')");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 5')");
        db.execSQL("INSERT INTO Mesas (Nombre) Values ('Mesa 6')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Verduras')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Aceitunas')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Harina')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Lácteos')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Carne')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Pescado')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Marisco')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Arroz')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Pasta')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Azuúcar')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Chocolate')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Huevos')");
        db.execSQL("INSERT INTO Ingredientes (Nombre) Values ('Frutos secos')");
        // FIXME: 31/01/2022 Agregar los platos
    }

    //El metodo upgrade elimina los registros anteriores y los suplanta por datos nuevos incrementando el int de su version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Empleados");
        db.execSQL("DROP TABLE Platos");
        db.execSQL("DROP TABLE Mesas");
        db.execSQL("DROP TABLE Ingredientes");
        onCreate(db);

        }
    //Este metodo recibe por parametros los campos de usuario y contraseña en el log in y comprueba que existan
    public boolean getUser(String empleado, String password){

        //Query que recoge el nombre de usuario que sea identico al recibido en el primer parametro
        Cursor cursor = db.rawQuery("SELECT * FROM Empleados WHERE Nombre= " + "'" +  empleado + "'", null);
        /*Este primer if se asegura de que la comprobacionse ejecute sobre el primer resultado
         (solo se espera uno pero da error de no ser contemplado)
         y compara que los campos de usuario y contraseña coincidan en la base de datos*/
        if (cursor.moveToFirst() && (empleado.equals(cursor.getString(1)) &&
                password.equals(cursor.getString(2)))){
            cursor.close();
            return true;
        } else return false;
    }

    //Metodo que comprueba si el usuario recibido por parametro esta registrado en la base de datos como admin
    public boolean isAdmin(String empleado) {
        Cursor cursor = db.rawQuery("SELECT * FROM Empleados WHERE Nombre= " + "'" + empleado + "'", null);
        /*Esta query comprueba al igual que get user la linea del usuario pasado por parametro
        pero mira la columna Admin que contendrá 1 si el usuario es admin y sera null de no serlo*/
        if (cursor.moveToFirst() && (empleado.equals(cursor.getString(1)) &&
                cursor.getString(3).equals("1"))) {
            //Esta comprobacion comprueba que la contraseña (segundo parametro) sea la del usuario introducido
            cursor.close();
            return true;
        } else return false;
    }

}
