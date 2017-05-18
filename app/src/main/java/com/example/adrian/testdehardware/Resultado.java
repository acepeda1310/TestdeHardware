package com.example.adrian.testdehardware;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Resultado extends AppCompatActivity implements View.OnClickListener{

    Button inicio;
    TextView correctas;
    TextView erroneas;
    TextView sinContestar;
    TextView notaFinal;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.resultado);
        inicio=(Button)findViewById(R.id.buttonInicio);
        correctas=(TextView)findViewById(R.id.pCorrectas);
        erroneas=(TextView)findViewById(R.id.pErroneas);
        sinContestar=(TextView)findViewById(R.id.pSinContestar);
        notaFinal=(TextView)findViewById(R.id.notaFinal);
        completar();
        inicio.setOnClickListener(this);
    }

    private void completar() {
        Bundle bundle=getIntent().getExtras();
        int resp1=bundle.getInt("resp1");
        int resp2=bundle.getInt("resp2");
        int resp3=bundle.getInt("resp3");
        int resp4=bundle.getInt("resp4");
        int contaCorrecta=0;
        int contaErronea=0;
        int contaSinCont=0;
        if(resp1==0){
            contaSinCont++;
        } else if(resp1==4){
            contaCorrecta++;
        } else{
            contaErronea++;
        }
        if(resp2==0){
            contaSinCont++;
        } else if(resp2==3){
            contaCorrecta++;
        } else{
            contaErronea++;
        }
        if(resp3==0){
            contaSinCont++;
        } else if(resp3==2){
            contaCorrecta++;
        } else{
            contaErronea++;
        }
        if(resp4==0){
            contaSinCont++;
        } else if(resp4==1){
            contaCorrecta++;
        } else{
            contaErronea++;
        }
        correctas.setText(Integer.toString(contaCorrecta));
        erroneas.setText(Integer.toString(contaErronea));
        sinContestar.setText(Integer.toString(contaSinCont));
        notaFinal.setText(Double.toString(contaCorrecta*2.5-contaErronea));
    }



    @Override
    public void onClick(View v) {
        Intent intent=new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
