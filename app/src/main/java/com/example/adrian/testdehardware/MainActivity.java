package com.example.adrian.testdehardware;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button comenzar;
    Button salir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        comenzar=(Button)findViewById(R.id.buttonComenzar);
        salir=(Button)findViewById(R.id.buttonSalir);
        comenzar.setOnClickListener(this);
        salir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        switch(v.getId()){
            case(R.id.buttonComenzar):
                intent=new Intent(this, Pregunta1.class);
                break;
            default:
                intent=new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
        }
        startActivity(intent);
    }
}
