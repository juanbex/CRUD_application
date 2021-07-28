package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Page3 extends AppCompatActivity {

    EditText user,password,date,email;
    Button bt_modificar,bt_eliminar;
    int id;
    String nombre, fecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page3);

        Bundle b = getIntent().getExtras();

        if(b != null){

            id = b.getInt("Id");
            nombre = b.getString("Nombre");
            fecha = b.getString("Apellido");

        }

        user = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword2);
        date = findViewById(R.id.editTextDate2);
        email = findViewById(R.id.editTextTextEmailAddress2);

        bt_modificar = findViewById(R.id.button4);
        bt_eliminar= findViewById(R.id.button5);

        //PILAS ACA PARA RECORDAR
        user.setText(nombre);
        date.setText(fecha);

        bt_modificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //!!!!!CASI QUE NO
                modificar(id, user.getText().toString(), date.getText().toString());
                onBackPressed();
            }
        });

        bt_eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                eliminar(id);
                onBackPressed();
            }
        });
    }

    private void modificar (int id, String nombre, String fecha){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "UPDATE PERSONAS SET NOMBRE= '" + nombre +"', APELLIDO= '" + fecha + "' WHERE id=" + id;
        db.execSQL(sql);
        db.close();
    }

    private void eliminar(int id){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        String sql = "DELETE from PERSONAS WHERE id="+id;
        db.execSQL(sql);
        db.close();
    }
}