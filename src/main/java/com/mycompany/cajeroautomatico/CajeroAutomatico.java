
package com.mycompany.cajeroautomatico;

import java.io.IOException;

public class CajeroAutomatico {
    public static void main(String[] args) throws IOException {
        Consola consola = new Consola();
        Cliente cliente = new Cliente();
        CC cc = new CC ();
        CAPesos ca = new CAPesos();
        CADolares dol = new CADolares();
        Movimiento movimiento = new Movimiento();
        LectorDeArchivos lector = new LectorDeArchivos();
        
        
        String numTarjeta = consola.bienvenida();
        String pin =  consola.pin();
        cliente.validacion(numTarjeta, pin);
        for (Cuenta cuenta: cliente.getMisCuentas()){
            if(cuenta.getTipo() == 1){
                ca.setTipo(cuenta.getTipo());
                ca.setSaldo(cuenta.getSaldo());
                ca.setAlias(cuenta.getAlias());
            }if(cuenta.getTipo() == 2){
                cc.setTipo(cuenta.getTipo());
                cc.setSaldo(cuenta.getSaldo());
                cc.setAlias(cuenta.getAlias());
                cc.setDescubierto(cuenta.getDescubierto());
            }if(cuenta.getTipo() == 3){
                dol.setTipo(cuenta.getTipo());
                dol.setSaldo(cuenta.getSaldo());
                dol.setAlias(cuenta.getAlias());
            }        
        }
        int num = consola.menuPrincipal();
        if (num ==1 ){
            num = consola.consultas();
            if (num==1){
                cliente.consultarMovimientos(cliente.getAlias());
            }if (num==2){
                System.out.println("Su alias es: " + cliente.getAlias());
            }else {
                System.out.println("Introdujo un numero incorrecto");
            }
            num = 0;
        }if (num==2){
            num = consola.tipoDeCuentaARS();
            double monto = consola.monto();
            if (num == 1){
                ca.retirarEfectivo(monto);
                num= consola.extracionExitosa(monto);
                if (num==1){
                    movimiento.imprimirTicket(ca.getAlias(), monto, "extraccion");
                }
                if (num==2){
                }else{
                    System.out.println("Introdujo un numero incorrecto");
                }
            }if (num == 2){
                cc.retirarEfectivo(monto);
                num = consola.extracionExitosa(monto);
                if (num==1){
                    movimiento.imprimirTicket(cc.getAlias(), monto, "extraccion");
                }
                if (num==2){
                }else { 
                    System.out.println("Introdujo un numero incorrecto");
                }
            }else {
                System.out.println("Introdujo un numero incorrecto");
            }
            num=0;
        }if (num==3){
            num=consola.tipoDeCuenta();
            double monto = consola.monto();
            if (num==1){
                ca.ingresarDinero(monto);
                num = consola.depositoExitoso(monto);
                if (num==1) {
                    movimiento.imprimirTicket(ca.getAlias(), monto, "Deposito");
                }if (num==2){
                }
            }if (num ==2){
                cc.ingresarDinero(monto);
                num = consola.depositoExitoso(monto);
                if (num==1) {
                    movimiento.imprimirTicket(cc.getAlias(), monto, "Deposito");
                }if (num==2){
                }
            }if (num==3){
                dol.ingresarDinero(monto);
                num = consola.depositoExitoso(monto);
                if (num==1) {
                    movimiento.imprimirTicket(dol.getAlias(), monto, "Deposito");
                }if (num==2){
                }
            }else {
                System.out.println("Numero incorrecto");
            }
            num=0;
        }if (num==4){
            String alias = consola.ingreseAlias();
            for(Cuenta cuenta: lector.getCuentas()){
                if(cuenta.getAlias() == alias){
                    num = consola.tipoDeCuentaARS();
                    double monto = consola.monto();
                    if(num==1){
                        num = consola.transferenciaExitosa(monto);
                        if (num==1){
                            System.out.println("La transferencia se revirtio con exito");
                        }if (num==2){
                            ca.transferirDinero(monto, cuenta);
                            movimiento.imprimirTicket(alias, monto, "Transferencia");
                        }if (num==3){
                            ca.transferirDinero(monto, cuenta);
                        }
                    }if (num==2){
                        num = consola.transferenciaExitosa(monto);
                        if (num==1){
                            System.out.println("La transferencia se revirtio con exito");
                        }if (num==2){
                            cc.transferirDinero(monto, cuenta);
                            movimiento.imprimirTicket(alias, monto, "Transferencia");
                        }if (num==3){
                            ca.transferirDinero(monto, cuenta);
                        }
                    }
                }
            }
            num=0;
        }if (num==5){
            consola.tipoDeCuentaARS();
            if (num==1){
                double monto= consola.monto();
                ca.retirarEfectivo(monto);
                dol.ingresarDinero(monto);
                num= consola.comprarDolaresExitosa(monto);
                if (num==1){
                    movimiento.imprimirTicket(ca.getAlias(), monto, "Compra Dolares");
                }if (num==2){
                }
            }if (num==2){
                double monto= consola.monto();
                cc.retirarEfectivo(monto);
                dol.ingresarDinero(monto);
                num= consola.comprarDolaresExitosa(monto);
                if (num==1){
                    movimiento.imprimirTicket(cc.getAlias(), monto, "Compra Dolares");
                }if (num==2){
                    
                }
            }else {
                System.out.println("Numero Incorrecto");
            }
        }
            num=0;
        if (num ==0){
            consola.despedida();
        }else {
            System.out.println("Introdujo un numero incorrecto");
            consola.despedida();
        }
    }
}
