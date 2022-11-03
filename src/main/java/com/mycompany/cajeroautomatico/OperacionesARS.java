
package com.mycompany.cajeroautomatico;
public interface OperacionesARS  {
    
    public void comprarDolares(double compra, Cuenta cuentaEnDolares);

    public void transferirDinero(double importe, Cuenta cuentaDestino);

    public void retirarEfectivo(double importe);
}
