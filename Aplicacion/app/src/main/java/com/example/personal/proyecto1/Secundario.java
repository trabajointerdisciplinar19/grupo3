package com.example.personal.proyecto1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Secundario extends AppCompatActivity {
Button bttareas, btrecursos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundario);
        bttareas = (Button) findViewById(R.id.bttareas);
        btrecursos = (Button) findViewById(R.id.btrecursos);
        bttareas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(Secundario.this, Tarea.class));
            }
        });
        btrecursos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(Secundario.this, Recursos.class));
            }
        });
    }
}
