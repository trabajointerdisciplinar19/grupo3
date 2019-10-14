package com.example.personal.proyecto1;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Tarea extends AppCompatActivity {
    Button btmostrar, btexaminar;
    private EditText txtexaminar, txtdescripcion;
    private final int PICKER  =1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tarea);
        txtdescripcion = (EditText) findViewById(R.id.txtdescripcion);
        txtexaminar = (EditText) findViewById(R.id.txtexaminar);
        btmostrar = (Button) findViewById(R.id.btMostrar);
        btexaminar = (Button) findViewById(R.id.btexaminar);

        btexaminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Pickfile();
            }
        });




        btmostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                startActivity(new Intent(Tarea.this, mostrar.class));
            }
        });
    }

    private void Pickfile(){
        Intent intent= new Intent(Intent.ACTION_GET_CONTENT);
        intent. setType("file /*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        try{
            startActivityForResult(
                    Intent.createChooser(intent,"seleccione un archivo para subir"),PICKER
            );

        }catch (android.content.ActivityNotFoundException ex){
            //Toast.makeText(this,"Por favor, instale un administrador de archivos.", Toast.LENGTH_SHORT).show();
        }
    }
    protected void onActivityResult (int requestCode , int resultCode, Intent data){
        switch (requestCode) {
            case PICKER:
                if (resultCode== RESULT_OK){
                    String FilePath = data. getData().getPath();
                    txtexaminar.setText(FilePath);
                }
            break;

        }
    }





    public void GuardarDatos(View view) {
        String descripcion = txtdescripcion.getText().toString();
        String examinar= txtexaminar.getText().toString();

        BasedeDatos basedeDatos = new BasedeDatos(this, "DEMODB", null, 1);

        SQLiteDatabase db = basedeDatos.getWritableDatabase();
        if (db != null) {
            ContentValues registronuevo = new ContentValues();
            registronuevo.put("descripcion", descripcion);
            registronuevo.put("examinar",examinar);

            db.insert("Tarea", null, registronuevo);
            Toast.makeText(this, "Datos Almacenados", Toast.LENGTH_SHORT).show();
        }
    }
}
