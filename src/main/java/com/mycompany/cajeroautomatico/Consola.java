
package com.mycompany.cajeroautomatico;

import java.util.Scanner;

public class Consola {
    private Scanner entradaDeTeclado;
 
    public Consola (){
        this.entradaDeTeclado = new Scanner (System.in);
    }
    
    private String generarEntrada(String mensaje){
            System.out.println(mensaje);
            return this.entradaDeTeclado.nextLine();
        }
    
    public int bienvenida(){
        System.out.println("Bienvenido/a al banco");
        int numeroDeTarjeta = Integer.parseInt(generarEntrada("Ingrese numero de tarjeta: "));
        return numeroDeTarjeta;
    }
    public int pin(){
        int pin = Integer.parseInt(generarEntrada("Ingrese numero de pin: "));
        return pin;
    }
    public int menuPrincipal(){
        System.out.println("1.Consultar");
        System.out.println("2.Extraccion");
        System.out.println("3.Depositar");
        System.out.println("4.Transferencia");
        System.out.println("5.Comprar Dolares");
        int movimiento = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return movimiento;
    }
    public int consultas(){
        System.out.println("1.Consular movimientos");
        System.out.println("2.Consultar alias");
        int consulta = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return consulta;
    }
    public int tipoDeCuenta(){
        System.out.println("1.Caja de ahorro ARS");
        System.out.println("2.Cuenta Corriente");
        System.out.println("3.Cajara de Ahorro USD");
        int tipoDeCuenta = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return tipoDeCuenta;
    }
    public int tipoDeCuentaARS(){
        System.out.println("1.Caja de ahorro ARS");
        System.out.println("2.Cuenta Corriente");
        int tipoDeCuentaARS = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return tipoDeCuentaARS;
    }
    public String ingreseAlias(){
        String alias = generarEntrada("Ingrese alias de la cuenta del destinatario: ");
        return alias;
    }
    public double monto(){
        double monto = Double.parseDouble(generarEntrada("Ingrese monto: "));
        return monto;
    }
    public int comprarDolaresExitosa(double monto){
        System.out.println("Compraste " + monto + " USD");
        System.out.println("¿Desea imprimir el ticket");
        System.out.println("1.Si");
        System.out.println("2.No");
        int ticket = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return ticket;
    }
    public int extracionExitosa(double monto){
        System.out.println("Se extrajo " + monto + " ARS");
        System.out.println("¿Desea imprimir el ticket");
        System.out.println("1.Si");
        System.out.println("2.No");
        int ticket = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return ticket;
    }
    public int transferenciaExitosa (double monto){
        System.out.println("Se transfirio " + monto + " ARS");
        System.out.println("¿Que desea hacer?");
        System.out.println("1.Revertir transferencia");
        System.out.println("2.Imprimir el ticket");
        System.out.println("3.Salir");
        int queDeseaHacer = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return queDeseaHacer;
    }
    public int depositoExitoso(double monto){
        System.out.println("Se deposito " + monto + " ARS");
        System.out.println("¿Desea imprimir el ticket");
        System.out.println("1.Si");
        System.out.println("2.No");
        int ticket = Integer.parseInt(generarEntrada("¿Que desea hacer? "));
        return ticket;
    }
    public void despedida(){
        System.out.println("Gracias por usar el banco, que tenga buen dia.");
    }
}
