package com.example.concesionario;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Login extends AppCompatActivity {
    CardView tarjeta;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1;
    LinearLayout contenidoOriginal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tarjeta = findViewById(R.id.Caja);
        switch1 = findViewById(R.id.switch1);
        contenidoOriginal = findViewById(R.id.contenidoOriginal); // Asegúrate de asignar un ID a tu LinearLayout original

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            // Cambiar el contenido de la CardView según el estado del Switch
            if (isChecked) {
                // Mostrar contenido cuando el Switch está activado
                // Inflar el nuevo contenido desde nuevo_contenido.xml
                View caja_registro = LayoutInflater.from(Login.this).inflate(R.layout.caja_registro, tarjeta, false);
                tarjeta.removeAllViews(); // Eliminar el contenido anterior
                tarjeta.addView(caja_registro); // Establecer el nuevo contenido
            } else {
                // Cambiar el contenido cuando el Switch está desactivado
                // Restaurar el contenido original
                tarjeta.removeAllViews(); // Eliminar el contenido anterior
                tarjeta.addView(contenidoOriginal); // Restaurar el contenido original
            }
        });
    }
}