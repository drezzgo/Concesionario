package com.example.concesionario;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import com.example.concesionario.databinding.ActivityHomeAdBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeAD extends AppCompatActivity {
    ActivityHomeAdBinding binding;
    BottomNavigationView bottomNavigationView;

    /*private static final int HISTORIAL_ID = R.id.historial;
    private static final int CARROS_ID = R.id.carros;
    private static final int SUCURSALES_ID = R.id.sucursales;
    private static final int EMPLEADOS_ID = R.id.empleados;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeAdBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        remplazarFragmento(new FragmentoHistorial());
        binding.bottomNavigationView.setBackground(null);

        /*binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case HISTORIAL_ID:
                    remplazarFragmento(new FragmentoHistorial());
                    break;

                case CARROS_ID:
                    remplazarFragmento(new FragmentoCarros());
                    break;

                case SUCURSALES_ID:
                    remplazarFragmento(new FragmentoSucursales());
                    break;

                case EMPLEADOS_ID:
                    remplazarFragmento(new FragmentoEmpleados());
                    break;
            }
            return true;
        });*/
    }

    private void remplazarFragmento (Fragment fragment){
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.intento, fragment);
        fragmentTransaction.commit();
    }

}