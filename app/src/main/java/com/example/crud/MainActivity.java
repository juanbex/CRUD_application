package com.example.crud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText user,password,date,email;
    Button bt_guardar, bt_mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.editTextTextPersonName2);
        password = findViewById(R.id.editTextTextPassword2);
        date = findViewById(R.id.editTextDate2);
        email = findViewById(R.id.editTextTextEmailAddress2);

        bt_guardar = findViewById(R.id.button4);
        bt_mostrar = findViewById(R.id.button2);

        bt_guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(user.getText().toString(), date.getText().toString());
            }
        });

        bt_mostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Page2.class));
            }
        });
    }

    private void guardar(String nombre, String apellido){
        BaseHelper helper = new BaseHelper(this,"Demo",null,1);
        SQLiteDatabase db = helper.getWritableDatabase();
        try{
            ContentValues c = new ContentValues();
            c.put("Nombre",nombre);
            c.put("Apellido",apellido);
            db.insert("PERSONAS", String.valueOf(2),c);
            db.close();
            Toast.makeText(this,"Registro insertado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}