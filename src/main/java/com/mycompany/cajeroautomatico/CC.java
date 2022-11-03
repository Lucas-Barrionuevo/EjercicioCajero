
package com.mycompany.cajeroautomatico;
public class CC extends Cuenta implements OperacionesARS {
    double descubierto;

    public CC(int tipo, String alias, double saldo, double descubierto) {
        super(tipo,alias,saldo);
        this.descubierto = descubierto;
    }

    public CC() {
    }

    @Override
    public void comprarDolares(double compra, Cuenta cuentaEnDolares){
        if (this.saldo >= (compra*161.50)){
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
        }if (this.saldo < importe){
            if (this.descubierto + this.saldo >= importe){
                this.saldo = this.saldo + this.descubierto - importe;
                this.descubierto = 0;
                System.out.println("Se utilizo el descubierto para realizar la transaccion, ya que su saldo era insuficiente");
            }else {
                System.out.println("No tiene saldo para realizar la extraccion");
            }
        }       
    }
}
