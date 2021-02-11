package com.example.calculointereses;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    private TextView resultadoPago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        resultadoPago = (TextView) findViewById(R.id.tvResult); //El nombre es el del layout Resultado
        impresion();
    }

    private void impresion () {
        Bundle recogeDatos = getIntent().getExtras();
        //Para recoger uun dato por el getIntent y por el putExtra
        double datoPago = recogeDatos.getDouble("pago");
        resultadoPago.setText( datoPago+ " ");
    }
}