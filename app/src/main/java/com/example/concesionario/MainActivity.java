package com.example.concesionario;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText email, password;
    Button Login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        Login = findViewById(R.id.Login);

        Login.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // Obtiene el email y la contraseña ingresados por el usuario
                String emaill = email.getText().toString();
                String passwordd = password.getText().toString();

                // Realiza la validación del inicio de sesión
                if (isValidLogin(emaill, passwordd)){
                    //Intent intent = new Intent(MainActivity.this, DashboardActivity.class);
                    //startActivity(intent);
                }else{
                    Toast.makeText(MainActivity.this, "Inicio de sesión incorrecto", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean isValidLogin(String email, String password) {
        // Aquí debes implementar la lógica para verificar las credenciales en tu base de datos.
        // Esto puede variar según el tipo de base de datos que estés utilizando.
        // Realiza la consulta a la base de datos y verifica si el usuario y la contraseña son válidos.
        // Retorna true si son válidos, de lo contrario, retorna false.
        // Puedes utilizar una clase de base de datos o una API de acceso a datos para esta lógica.
        // Aquí solo se muestra una estructura de ejemplo.

        // Simulación de un inicio de sesión exitoso (debes reemplazarlo con tu lógica real):
        return email.equals("usuario@correo.com") && password.equals("contrasena123");
    }
}