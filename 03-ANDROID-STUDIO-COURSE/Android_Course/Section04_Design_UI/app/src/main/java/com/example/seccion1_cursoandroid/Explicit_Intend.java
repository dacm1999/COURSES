package com.example.seccion1_cursoandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class Explicit_Intend extends AppCompatActivity {

    private TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);
        //Activar flecha para ir atras
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        txt1 = findViewById(R.id.txt1);

        //Vamos a recoger los datos del intent
        Bundle bundle = getIntent().getExtras();

        if(bundle != null && bundle.getString("greeter") != null){
            String greeter = bundle.getString("greeter");
            Toast.makeText(Explicit_Intend.this, greeter, Toast.LENGTH_SHORT).show();
            txt1.setText(greeter);
        }else{
            Toast.makeText(Explicit_Intend.this, "It's empty!", Toast.LENGTH_SHORT).show();
        }
    }
}