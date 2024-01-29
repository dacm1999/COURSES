package com.example.cursoandroid;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
public class MainActivity extends AppCompatActivity {

    @Override
    //onCreate es como el main, es desde aqui donde inicia el programa
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //

    }



    /*@Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "OnStart", Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume", Toast.LENGTH_LONG).show();
    }

    //ES PARCIALMENTE VISIBLE - CUANDO CAMBIO DE APP
    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "onPause", Toast.LENGTH_LONG).show();
    }

    //CUANDO CAMBI DE APP
    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "onStop", Toast.LENGTH_LONG).show();
    }

    //CUANDO RESTAURO LA APP
    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart", Toast.LENGTH_LONG).show();
    }

    //CUANDO CIERRO UNA APP
    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy", Toast.LENGTH_LONG).show();
        super.onDestroy();
    }*/


}