
package com.mycompany.cajeroautomatico;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Cliente {
    private Integer cuit;
    private String alias;
    private List <Cuenta> misCuentas;
    private List <Tarjeta> misTarjetas;
    private List <Cliente> clientes;
    private List<Cuenta>cuentas;
    private List <Tarjeta> tarjetas;
    private List <Movimiento> misMovimientos;

    public Cliente(Integer cuit, String alias) {
        this.cuit = cuit;
        this.alias = alias;
        this.misCuentas = new ArrayList<Cuenta>();
        this.misTarjetas = new ArrayList<Tarjeta>();
        this.clientes =  new ArrayList<Cliente>();
        this.cuentas = new ArrayList<Cuenta>();
        this.tarjetas = new ArrayList<Tarjeta>();
        this.misMovimientos = new ArrayList<Movimiento>();
        
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

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public Integer getCuit() {
        return cuit;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public void setMisCuentas(List<Cuenta> misCuentas) {
        this.misCuentas = misCuentas;
    }

    public void setCuit(Integer cuit) {
        this.cuit = cuit;
    }
    

    public List validacion(int numeroDeTarjeta, int pin){
        LectorDeArchivos lector = new LectorDeArchivos ();
        this.clientes = lector.leerTxtClientes("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Clientes.txt");
        this.cuentas = lector.leerTxtCuenta("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Cuentas.txt");
        this.tarjetas = lector.leerTxtTarjetas("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Tarjetas.txt");
        int cuitNecesitado = 0 ;
        String aliasNecesitado = null;
        for(Tarjeta tarjetas : this.tarjetas){
             if (numeroDeTarjeta == tarjetas.getNumeroDeTarjeta()){
                 if (pin == tarjetas.getPin()){
                     cuitNecesitado = tarjetas.getCuit();
                 }
             }
             for(Cliente clientes: this.clientes){
                if (cuitNecesitado == clientes.getCuit()){
                    misTarjetas.add(tarjetas);
                    this.setAlias(clientes.getAlias());
                    this.setCuit(clientes.getCuit());
                    break;
                }
            }
        }
        for(Cuenta cuentas : this.cuentas){
            if(this.alias == cuentas.getAlias()){
                this.misCuentas.add(cuentas);
            }
                   
        }
        return this.misCuentas;
    }
    public void consultarMovimientos(String alias ){
        LectorDeArchivos lector = new LectorDeArchivos();
        this.misMovimientos = lector.leerTxtMovimientos("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Movimientos.txt");
        for(Movimiento movimiento: this.misMovimientos){
            if (movimiento.getHacia() ==alias){
                System.out.println(movimiento.getFecha()+","+movimiento.getConcepto()+","+movimiento.getHacia()+","+movimiento.getImporte());
            }
        }
    }
}
