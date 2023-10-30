package com.example.concesionario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void IrALogin(View v){
        Intent intento=new Intent(this, Login.class);
        startActivity(intento);
    }
    public void IrARegistro(View v){
        Intent intento=new Intent(this, Login.class);
        intento.putExtra("switch_activado", true);
        startActivity(intento);
    }

}