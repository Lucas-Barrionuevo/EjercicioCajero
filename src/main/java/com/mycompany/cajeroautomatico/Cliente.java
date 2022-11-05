
package com.mycompany.cajeroautomatico;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.io.*;
public class Cliente {
    private String cuit;
    private String alias;
    private List <Cuenta> misCuentas = new ArrayList <Cuenta>();
    private List <Tarjeta> misTarjetas = new ArrayList <Tarjeta>();
    private List <Cliente> clientes;
    private List<Cuenta>cuentas;
    private List <Tarjeta> tarjetas;
    private List <Movimiento> misMovimientos;

    public Cliente(String cuit, String alias) {
        this.cuit = cuit;
        this.alias = alias;
        
    }

    public Cliente() {
    }

    public List<Cuenta> getMisCuentas() {
        return misCuentas;
    }

    public List<Tarjeta> getMisTarjetas() {
        return misTarjetas;
    }

    public String getAlias() {
        return alias;
    }
    public String getCuit() {
        return cuit;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setMisCuentas(List<Cuenta> misCuentas) {
        this.misCuentas = misCuentas;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }
    

    public void validacion(String numeroDeTarjeta, String pin) throws IOException  {
        LectorDeArchivos lector = new LectorDeArchivos ();
        lector.leerTxtClientes();
        lector.leerTxtCuenta();
        lector.leerTxtTarjetas();
        String cuitNecesitado = null;
        String aliasNecesitado ;
        for(Tarjeta tarjetas : lector.getTarjetas()){
             if (tarjetas.getNumeroDeTarjeta().equals(numeroDeTarjeta)){
                 if (tarjetas.getPin().equals(pin)){
                    cuitNecesitado = tarjetas.getCuit();
                    this.misTarjetas.add(tarjetas);
                 }else{
                     System.out.println("Numero de pin incorrecto");
                 }
             }else{
                 System.out.println("Numero de tarjeta incorrecto");
             }
        }
        for(Cliente clientes: lector.getClientes()){
           if (cuitNecesitado.equals(clientes.getCuit())){
               this.alias = clientes.getAlias();
               this.cuit = clientes.getCuit();
           }
        }
        for(Cuenta cuentas : lector.getCuentas()){
            if(this.alias.equals(cuentas.getAlias())){
                this.misCuentas.add(cuentas);
            }
        }
    }
    public void consultarMovimientos(String alias ){
        LectorDeArchivos lector = new LectorDeArchivos();
        lector.leerTxtMovimientos();
        for(Movimiento movimiento: lector.getMovimientos()){
            if (movimiento.getHacia().equals(alias)){
                System.out.println(movimiento.getFecha()+","+movimiento.getConcepto()+","+movimiento.getHacia()+","+movimiento.getImporte());
            }
        }
    }
}
