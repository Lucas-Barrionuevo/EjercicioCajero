
package com.mycompany.cajeroautomatico;

import java.util.HashMap;

public class Tarjeta {
    String cuit, numeroDeTarjeta, pin;
    public Tarjeta(String numeroDeTarjeta, String pin, String cuit) {
        this.numeroDeTarjeta = numeroDeTarjeta;
        this.pin = pin;
        this.cuit = cuit;
    }

    public Tarjeta() {
    }

    public String getNumeroDeTarjeta() {
        return numeroDeTarjeta;
    }

    public String getPin() {
        return pin;
    }

    public String getCuit() {
        return cuit;
    }
    
}
