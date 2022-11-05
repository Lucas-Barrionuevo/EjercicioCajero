
package com.mycompany.cajeroautomatico;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public abstract class Cuenta {
    private String alias;
    double saldo;
    private int tipo;
    private double descubierto;

    public Cuenta(int tipo, String alias, double saldo, double descubierto) {
        this.alias = alias;
        this.saldo = saldo;
        this.tipo = tipo;
        this.descubierto = descubierto;
    }
    public Cuenta() {
 
    }

    public Cuenta(int tipo, String alias, double saldo) {
        this.alias = alias;
        this.saldo = saldo;
        this.tipo = tipo;
    }

    public double getDescubierto() {
        return descubierto;
    }

    public void setDescubierto(double descubierto) {
        this.descubierto = descubierto;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getAlias() {
        return alias;
    }

    public double getSaldo() {
        return saldo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public void ingresarDinero(double importe){
        this.saldo = (this.saldo + importe) ;
    }
    public void consultarAlias(Cuenta cuenta){
        System.out.println("Su alias es: "+cuenta.getAlias());
    }

}
