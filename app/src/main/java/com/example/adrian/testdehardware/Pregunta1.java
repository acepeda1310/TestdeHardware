package com.example.adrian.testdehardware;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Pregunta1 extends AppCompatActivity implements Spinner.OnItemSelectedListener, View.OnClickListener {

    Button siguiente;
    Spinner respuestas;
    int respuestaFinal=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pregunta_1);
        siguiente=(Button)findViewById(R.id.buttonSiguiente1);
        respuestas=(Spinner)findViewById(R.id.spinner1);

        String[] listaRespuestas={"No contesta","Fuente de alimentacion", "Memoria RAM", "Procesador", "Placa base"};
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,listaRespuestas);

        respuestas.setAdapter(adaptador);
        respuestas.setOnItemSelectedListener(this);
        siguiente.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, Pregunta2.class);
        intent.putExtra("resp1", respuestaFinal);

        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        respuestaFinal=position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        respuestaFinal=0;
    }
}
