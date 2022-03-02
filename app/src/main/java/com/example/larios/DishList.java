package com.example.larios;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupMenu;

import androidx.appcompat.app.AppCompatActivity;

public class DishList extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {
    private LinearLayout layout;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dish_list);

        Button close = findViewById(R.id.close_dishes);
        close.setOnClickListener(v -> finish());

        Intent intent = getIntent();

        layout = findViewById(R.id.linear);
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT Nombre FROM Platos", null);
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                button = new Button(this);
                button.setText(cursor.getString(0));
                button.setOnClickListener(v -> {
                    intent.putExtra("plato", cursor.getString(0));
                    setResult(1);
                });
                layout.addView(button);
                cursor.moveToNext();
            }
        }
        cursor.close();
        Button filter = findViewById(R.id.filter);
        filter.setOnClickListener(this::showPopUpFilter);
    }

    protected void showPopUpFilter(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.inflate(R.menu.popup_table);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        //Este switch contiene los filtros de la carta
        switch (item.getItemId()){
            case R.id.Carnes:
                filter("Carnes");
                return true;
            case  R.id.Pescados:
                filter("Pescados");
                return true;
            case R.id.Arroces:
                filter("Arroces");
                return true;
            case R.id.Bebidas:
                filter("Bebidas");
                return true;
            case R.id.Postres:
                filter("Postres");
                return true;
            default: return false;
        }
    }
    private void filter(String filtro){
        layout.removeAllViews();
        DBHelper dbHelper = new DBHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = database.rawQuery("SELECT Nombre FROM Platos WHERE Categoria='" + filtro + "'", null);
        if (cursor.moveToFirst()) {
            for (int i = 0; i < cursor.getCount(); i++) {
                button = new Button(this);
                button.setText(cursor.getString(0));
                layout.addView(button);
                cursor.moveToNext();
            }
        }
        cursor.close();
    }
}