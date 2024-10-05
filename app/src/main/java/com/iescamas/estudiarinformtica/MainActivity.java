package com.iescamas.estudiarinformtica;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner spCiclos, spPoblacion, spTipos;
    Button btn_borrar;
    TextView txt_info;
    String ciclo,poblacion,tipo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spCiclos = findViewById(R.id.sp_Ciclos);
        spPoblacion = findViewById(R.id.sp_Poblacion);
        spTipos = findViewById(R.id.sp_Tipos);
        btn_borrar = findViewById(R.id.btn_Borrar);
        txt_info = findViewById(R.id.txt_Info);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.Ciclos, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCiclos.setAdapter(adapter);

        spCiclos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                ciclo = spCiclos.getSelectedItem().toString();
                mostrarMensaje(ciclo,poblacion,tipo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.Poblaciones, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spPoblacion.setAdapter(adapter2);

        spPoblacion.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                poblacion = spPoblacion.getSelectedItem().toString();
                mostrarMensaje(ciclo,poblacion,tipo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.Tipos, android.R.layout.simple_spinner_item);
        adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTipos.setAdapter(adapter3);

        spTipos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                tipo = spTipos.getSelectedItem().toString();
                mostrarMensaje(ciclo,poblacion,tipo);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {}
        });

        btn_borrar.setOnClickListener(view -> txt_info.setText(""));



    }

    private void mostrarMensaje(String ciclo, String poblacion,String tipo){
        txt_info.setText(ciclo+" "+ "en "+poblacion+ " de forma "+ tipo);
    }


    }
