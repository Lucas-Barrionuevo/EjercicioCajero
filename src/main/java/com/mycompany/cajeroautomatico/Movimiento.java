
package com.mycompany.cajeroautomatico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Movimiento {
   private FileWriter archivo;
   private PrintWriter escritor;
   private String hacia;
   private double importe;
   private String concepto;
   private LocalDate fecha;
   
    public Movimiento() {
        this.archivo = null;
        this.escritor=null;
    }

    public Movimiento(LocalDate fecha, String concepto, String hacia, double importe) {
        this.hacia = hacia;
        this.importe = importe;
        this.concepto = concepto;
        this.fecha = null;
    }
 
    public Movimiento( String hacia, double importe, String concepto) {
        this.hacia = hacia;
        this.importe = importe;
        this.concepto = concepto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public FileWriter getArchivo() {
        return archivo;
    }

    public PrintWriter getEscritor() {
        return escritor;
    }

    public String getHacia() {
        return hacia;
    }

    public double getImporte() {
        return importe;
    }

    public String getConcepto() {
        return concepto;
    }

    public void imprimirTicket( String hacia, double importe, String concepto) throws IOException{
        this.fecha= LocalDate.now();
        try {
            this.archivo = new FileWriter ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Ticket.txt");
            this.escritor = new PrintWriter(this.archivo);
            
            this.escritor.println(fecha + ", "+concepto + ", hacia "+ hacia + ", "+ importe);     
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }finally{
            this.archivo.close();
        }
    }
    public void guardarMovimientos(String hacia, double importe, String concept) throws IOException{
        this.fecha= LocalDate.now();
        try {
            this.escritor = new PrintWriter("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Movimientos.txt");
            
            this.escritor.println(fecha + ","+concepto +","+hacia + ","+ importe);     
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
