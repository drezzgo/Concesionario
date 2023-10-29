package com.example.concesionario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class Login extends AppCompatActivity {
    EditText Name, Direccion, Password, PasswordC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Name = findViewById(R.id.Name);
        Direccion = findViewById(R.id.Direccion);
        Password = findViewById(R.id.Password);
        PasswordC = findViewById(R.id.PasswordC);
    }


}