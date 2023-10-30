package com.example.concesionario;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class Login extends AppCompatActivity {
    private UsuarioDAO usuarioDAO;
    CardView tarjeta;
    @SuppressLint("UseSwitchCompatOrMaterialCode")
    Switch switch1;
    LinearLayout contenidoOriginal;
    EditText emailEditText, passwordEditText;
    Button login_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //base de datos
        usuarioDAO = new UsuarioDAO(this);
        usuarioDAO.open();
        //datos de prueba
        usuarioDAO.inicializarDatosDeEjemplo();

        tarjeta = findViewById(R.id.Caja);
        switch1 = findViewById(R.id.switch1);
        boolean switchActivado = getIntent().getBooleanExtra("switch_activado", false);
        switch1.setChecked(switchActivado);

        contenidoOriginal = findViewById(R.id.contenidoOriginal);

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
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        //Al darle click al boton deberia iniciar sesion
        login_bt = findViewById(R.id.login_bt);
        login_bt.setOnClickListener(view -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();

            // Verificar en la base de datos
            UsuarioDAO.Usuario usuario = usuarioDAO.buscarUsuarioPorEmail(email);

            if (usuario != null) {
                if (usuario.getPassword().equals(password)) {
                    // Contraseña correcta, puedes iniciar sesión
                    Toast.makeText(Login.this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                    //Para saber que funciones tendra en la APP
                    String rol = usuario.getRol();

                    if ("admi".equals(rol)) {
                        // Usuario con rol "admi", redirige a la actividad de sucursales
                        Intent intent = new Intent(Login.this, HomeAD.class);
                        startActivity(intent);
                    } //else if ("vendedor".equals(rol)) {
                        // Usuario con rol "vendedor", redirige a la actividad de vendedor, etc.
                    //}
                } else {
                    // Contraseña incorrecta
                    Toast.makeText(Login.this, "Contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            } else {
                // Usuario no encontrado
                Toast.makeText(Login.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
            }
        });
    }
    protected void onDestroy() {
        super.onDestroy();

        // Cerrar la base de datos cuando ya no se necesite
        usuarioDAO.close();
    }
}
