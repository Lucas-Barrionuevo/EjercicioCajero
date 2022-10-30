
package com.mycompany.cajeroautomatico;
public class CC extends Cuentas {
    private double descubierto;

    public CC(int tipo, String alias, double saldo, double descubierto) {
        super(tipo,alias,saldo);
        this.descubierto = descubierto;
    }
    
}
