package com.example.calculointereses;

public class CalculoInteres {
    private double dinero;
    private int tasa;
    private  int dias;

    public CalculoInteres(double dinero, int tasa, int dias) {
        this.dinero = dinero;
        this.tasa = tasa;
        this.dias = dias;
    }

    public double pago() {
        double calculoPago = 0;
        calculoPago = (((dinero * (tasa))/100) *dias ) + dinero;
        return calculoPago;
    }
}
