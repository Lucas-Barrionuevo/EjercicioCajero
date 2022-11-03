
package com.mycompany.cajeroautomatico;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LectorDeArchivos { 
    List<Cuenta>cuentas = new ArrayList<Cuenta>();

    public List<Cuenta> getCuentas() {
        return cuentas;
    }
    
    public List leerTxtClientes (String direccion ) {
        List <Cliente> clientes = new ArrayList<Cliente>();
        try{
            BufferedReader bf = new BufferedReader (new FileReader(direccion));
            String temp="";
            String bfRead;
            while ((bfRead = bf.readLine()) != null){ //hace el ciclo hasta que el archivo esta vacio
                temp = bfRead; //guarda el texto del archivo 
                String [] lista =  temp.split(",");
                Cliente clientito = new Cliente(Integer.parseInt(lista[0]), lista[1]);
                clientes.add (clientito);
            }

        }catch (Exception e){
            System.out.println("No se encontro archivo");
        }
        return clientes;
    }
    
        public List leerTxtCuenta (String direccion ) {
        try{
            BufferedReader bf = new BufferedReader (new FileReader(direccion));
            String temp="";
            String bfRead;
            while ((bfRead = bf.readLine()) != null){ //hace el ciclo hasta que el archivo esta vacio
                temp = bfRead; //guarda el texto del archivo 
                String [] lista =  temp.split(",");
                if (lista.length == 3) {
                    Cuenta cuentita = new Cuenta(Integer.parseInt(lista[0]), lista[1],Double.parseDouble(lista[2])) {};
                    cuentas.add(cuentita);
                }else {
                    Cuenta cuentita = new CC (Integer.parseInt(lista[0]), lista[1],Double.parseDouble(lista[2]),Double.parseDouble(lista[3])) {};
                    cuentas.add(cuentita);
                }
            }

        }catch (Exception e){
            System.out.println("No se encontro archivo");
        }
        return cuentas;
    }
    
    public List leerTxtTarjetas (String direccion ) {
        List <Tarjeta> tarjetas = new ArrayList <Tarjeta>();
        try{
            BufferedReader bf = new BufferedReader (new FileReader(direccion));
            String temp="";
            String bfRead;
            while ((bfRead = bf.readLine()) != null){ //hace el ciclo hasta que el archivo esta vacio
                temp = bfRead; //guarda el texto del archivo 
                String [] lista =  temp.split(",");
                Tarjeta tarjetita = new Tarjeta(Integer.parseInt(lista[0]), Integer.parseInt(lista[1]), Integer.parseInt(lista[2]));
                tarjetas.add(tarjetita);
            }

        }catch (Exception e){
            System.out.println("No se encontro archivo");
        }
        return tarjetas;
    }
    public List leerTxtMovimientos (String direccion ) {
        List <Movimiento> movimientos = new ArrayList <Movimiento>();
        try{
            BufferedReader bf = new BufferedReader (new FileReader(direccion));
            String temp="";
            String bfRead;
            while ((bfRead = bf.readLine()) != null){ //hace el ciclo hasta que el archivo esta vacio
                temp = bfRead; //guarda el texto del archivo 
                String [] lista =  temp.split(",");
                Movimiento movimiento = new Movimiento(lista[0],lista[1], lista[2], Double.parseDouble(lista[3]));
                movimientos.add(movimiento);
            }

        }catch (Exception e){
            System.out.println("No se encontro archivo");
        }
        return movimientos;
    }

}
