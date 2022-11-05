
package com.mycompany.cajeroautomatico;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivos { 
    FileReader archivo;
    BufferedReader lector;
    List <Tarjeta> tarjetas = new ArrayList <Tarjeta>();
    List<Cuenta>cuentas = new ArrayList<Cuenta>();
    List<Cliente>clientes = new ArrayList<Cliente>();

    public List<Movimiento> getMovimientos() {
        return movimientos;
    }

    public void setMovimientos(List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    List <Movimiento> movimientos = new ArrayList <Movimiento>();

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public List<Tarjeta> getTarjetas() {
        return tarjetas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setTarjetas(List<Tarjeta> tarjetas) {
        this.tarjetas = tarjetas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void leerTxtClientes ( ) {
        try{
            archivo = new FileReader ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Clientes.txt");
            if (archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                while((cadena = lector.readLine())!= null){
                    String [] lista =  cadena.split(",");
                    Cliente cliente = new Cliente (lista [0], lista[1]);
                    this.clientes.add(cliente);
                }
            }else{
                System.out.println("El archivo no esta listo para ser ledio...");
            }
        }catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
    }
    
    public void leerTxtCuenta () throws FileNotFoundException, IOException {
            try{
                archivo = new FileReader ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Cuentas.txt");
                if (archivo.ready()){
                    lector = new BufferedReader(archivo);
                    String cadena;
                    while((cadena = lector.readLine())!= null){
                        String [] lista =  cadena.split(",");
                         if (lista.length == 3) {
                            Cuenta cuentita = new Cuenta(Integer.parseInt(lista[0]), lista[1], Double.parseDouble(lista[2])){};
                            this.cuentas.add(cuentita);
                        }else {
                            Cuenta cuentita = new CC (Integer.parseInt(lista[0]), lista[1],Double.parseDouble(lista[2]),Double.parseDouble(lista[3])) {};
                            this.cuentas.add(cuentita);
                        }
                    }
                }else {
                    System.out.println("El arhivo no esta listo para ser leido");
                }
            }catch (Exception e){
                System.out.println("Error: " +e);
            }
            System.out.println();
    }
    
    public void leerTxtTarjetas () {
        try{
            archivo = new FileReader ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Tarjetas.txt");
            if (archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                while((cadena = lector.readLine())!= null){
                    String [] lista =  cadena.split(",");
                    Tarjeta tarjetita = new Tarjeta(lista[0], lista[1], lista[2]);
                    this.tarjetas.add(tarjetita);
                }
            }else{
                System.out.println("El archivo no esta listo para ser ledio...");
            }
        }catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
    }
    public void leerTxtMovimientos () {
        try{
            archivo = new FileReader ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Movimientos.txt");
            if (archivo.ready()){
                lector = new BufferedReader(archivo);
                String cadena;
                while((cadena = lector.readLine())!= null){
                    String [] lista =  cadena.split(",");
                    Movimiento movimiento = new Movimiento(LocalDate.parse(lista[0]),lista[1], lista[2], Double.parseDouble(lista[3]));
                    movimientos.add(movimiento);
                }
            }else{
                System.out.println("El archivo no esta listo para ser ledio...");
            }
        }catch (Exception e){
            System.out.println("Error: " +e.getMessage());
        }
    }

}
