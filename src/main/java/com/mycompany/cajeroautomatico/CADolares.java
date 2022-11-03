
package com.mycompany.cajeroautomatico;
public class CADolares extends Cuenta{
    
    public CADolares(int tipo, String alias, double saldo) {
        super(tipo, alias, saldo);
    }

    public CADolares() {
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

}
