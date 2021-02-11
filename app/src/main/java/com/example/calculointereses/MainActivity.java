package com.example.calculointereses;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText cantDinero;
    private EditText tasaInteres;
    private SeekBar barraDias;
    private TextView resultadoDias;
    private TextView pagoTotal;
    private double resultadoPago;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casteo();
        //Tv dias vamos a ver el progreso del seekbar
        resultadoDias.setText(barraDias.getProgress()+ " / " +  barraDias.getMax());
        //SeekBar
        barraDias.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progreso = 0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progreso = progreso + 1;
                resultadoDias.setText(barraDias.getProgress()+ " / " +  barraDias.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void casteo() {
        cantDinero = (EditText) findViewById(R.id.etCantDinero);
        tasaInteres = (EditText) findViewById(R.id.etTasa);
        barraDias = (SeekBar) findViewById(R.id.sbDias);
        resultadoDias = (TextView) findViewById(R.id.tvDias);
        pagoTotal = (TextView) findViewById(R.id.tvResultado);

    }
    public  void limpiar (View view) {
        cantDinero.setText("");
        tasaInteres.setText("");
        pagoTotal.setText("");
    }
    public void calculo (View view) {
        double cant_dinero = Double.parseDouble(cantDinero.getText().toString());
        int tasaI = Integer.parseInt(tasaInteres.getText().toString());
        int dias = barraDias.getProgress();
        // Ejemplificar o crear el objeto
        CalculoInteres calculoInteres = new CalculoInteres(cant_dinero, tasaI, dias);
        resultadoPago = calculoInteres.pago();
        pagoTotal.setText("El pago total es:" + resultadoPago);
        Toast.makeText(this, ""+ pagoTotal.getText().toString(), Toast.LENGTH_SHORT).show();
    }

    public void mandarResultado(View view) {
        Intent resultado = new Intent(this, Resultado.class);
         resultado.putExtra("pago", resultadoPago);
        startActivity(resultado);
    }
}