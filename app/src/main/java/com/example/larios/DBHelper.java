package com.example.larios;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Array;


//Clase para gestionar la base de datos de SQL
public class DBHelper extends SQLiteOpenHelper {
     public DBHelper(Context context){
         super (context, "Userdata.db", null, 1);
     }

     //Instancion de los datos de la BBDD y de sus tablas
     private static final int DATABASE_VERSION = 1;
     private static final String DATABASE_NOMBRE = "Larios";
     private static final String TABLE_1 = "CREATE TABLE Empleados (" + "ID INTEGER PRIMARY KEY AUTOINCREMENT," + "Nombre TEXT NOT NULL," + "Contraseña TEXT NOT NULL," + "Admin INTEGER NOT NULL DEFAULT 0" + ")";
     private static final String TABLE_2 = "CREATE TABLE Platos (" + "ID INTEGER PRIMARY KEY AUTOINCREMENT," + "Nombre TEXT NOT NULL," + "Categoria TEXT NOT NULL," + "Precio INTEGER NOT NULL"  + ")";


     //Este metodo contiene el SQL que se ejecuta cuando se crea la base de datos por primera vez
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_1);
        db.execSQL(TABLE_2);
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña) Values ('Maria', '123')");
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña) Values ('Manolo', '12345')");
        db.execSQL("INSERT INTO Empleados (Nombre, Contraseña, Admin) Values ('Paco', '1234', 1)");
        // FIXME: 31/01/2022 Agregar los platos
    }

    //El metodo upgrade elimina los registros anteriores y los suplanta por datos nuevos incrementando el int de su version
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE Empleados");
        db.execSQL("DROP TABLE Platos");
        onCreate(db);

        }
    //Este metodo recibe por parametros los campos de usuario y contraseña en el log in y comprueba que existan
    public boolean getUser(String empleado, String password){
        SQLiteDatabase db = getWritableDatabase();
        //Query que recoge el nombre de usuario que sea identico al recibido en el primer parametro
        Cursor cursor = db.rawQuery("SELECT * FROM Empleados WHERE Nombre= " + "'" +  empleado + "'", null);
        //Este primer if se asegura de que la comprobacion se ejecute sobre el primer resultado(solo se espera uno pero da error de no ser contemplado)
        if (cursor.moveToFirst()){
            //Esta comprobvacion comprueba que la contraseña (segundo parametro) sea la del usuario introducido
            if (empleado.equals(cursor.getString(1)) && password.equals(cursor.getString(2))) ;
        }
        return true;
    }

    // FIXME: 31/01/2022 No se como tratar la query en la app exactamente asi que no lo he sacado, volver mas adelante
    //Metodo para extrar los platos por categoria
    public String[] getPlatos(String filtro){
        SQLiteDatabase db = getWritableDatabase();
        String[] platos = new String[100];
        Cursor cursor = db.rawQuery("SELECT Nombre FROM Platos WHERE Categoria= " + "'" +  filtro + "'", null);
        if (cursor.moveToFirst()){
            for (int i = 0; i < cursor.getColumnCount(); i++) {

            }
        } return platos;
    }
}
