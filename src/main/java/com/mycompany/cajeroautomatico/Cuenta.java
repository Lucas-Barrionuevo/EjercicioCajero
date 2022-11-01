
package com.mycompany.cajeroautomatico;
public abstract class Cuentas {
    private String alias;
    private double saldo;
    private int tipo;

    public Cuentas(int tipo, String alias, double saldo) {
        this.alias = alias;
        this.saldo = saldo;
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
    
}
