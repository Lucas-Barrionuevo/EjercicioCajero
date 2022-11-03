
package com.mycompany.cajeroautomatico;

import java.util.HashMap;

public class Tarjeta {
    int numeroDeTarjeta, pin, cuit;
    public Tarjeta(int numeroDeTarjeta, int pin, int cuit) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.pin = pin;
        this.cuit = cuit;
    }

    public Tarjeta() {
    }

    public int getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public int getPin() {
        return pin;
    }

    public int getCuit() {
        return cuit;
    }
    
}
