package com.example.personal.proyecto1;

import android.content.Intent;
import android.print.PrintManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Button boton= (Button) findViewById(R.id.btingresar);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = ((EditText)findViewById(R.id.txtUsuario)).getText().toString();
                String password = ((EditText)findViewById(R.id.txtPass)).getText().toString();
                if(usuario.equals("admin") && password.equals("admin") )
                {
                    Intent nuevoform =new Intent(Principal.this,Secundario.class);
                    startActivity(nuevoform);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Invalido!", Toast.LENGTH_SHORT ).show();
                }
            }
        });
    }
}
