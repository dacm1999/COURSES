package com.example.seccion1_cursoandroid;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    private Button btnExplicit;
    private Button btnImplicit;
    private Toolbar toolbarMain;
    private final String greeter = "Hello from the other side";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Forzar y cargar icono en el action bar
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        getSupportActionBar().setIcon(R.mipmap.ic_launcher);



        btnExplicit = findViewById(R.id.btnExplicit); // Obtén la referencia del botón una sola vez
        btnExplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Explicit_Intend.class);
                intent.putExtra("greeter", greeter);
                startActivity(intent);
            }
        });

        btnImplicit = findViewById(R.id.btnImplicit);
        btnImplicit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Implicit_Intend.class);
                startActivity(intent);
            }
        });

    }

}
