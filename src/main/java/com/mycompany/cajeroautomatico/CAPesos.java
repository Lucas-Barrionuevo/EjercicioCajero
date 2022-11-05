
package com.mycompany.cajeroautomatico;
public class CAPesos extends Cuenta implements OperacionesARS {

    public CAPesos(int tipo, String alias, double saldo) {
        super(tipo, alias,saldo);
    }


    public CAPesos() {
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
 
    @Override
    public void comprarDolares(double compra, Cuenta cuentaEnDolares){
        if (saldo >= (compra*161.50)){
        this.saldo = this.saldo - (compra*161.50);
        cuentaEnDolares.setSaldo(cuentaEnDolares.getSaldo() + compra);
        }else {
            System.out.println("No tiene dinero en cuenta para realizar esa compra");
        }
    }
    @Override
    public void transferirDinero(double importe, Cuenta cuentaDestino){
        if (this.saldo >= importe) {
            this.saldo = this.saldo - importe;
            cuentaDestino.setSaldo(cuentaDestino.getSaldo() + importe);
        }else {
            System.out.println("No tiene saldo suficiente para realizar la transferencia");
        }
    }
    @Override
    public void retirarEfectivo(double importe){
        if (this.saldo >= importe){
            this.saldo = this.saldo - importe;
        }else {
            System.out.println("No tiene saldo para realizar la extraccion");
        }       
    }
}
