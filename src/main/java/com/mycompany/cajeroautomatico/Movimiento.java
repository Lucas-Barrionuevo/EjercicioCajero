
package com.mycompany.cajeroautomatico;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class Movimiento {
   private String fecha;
   private FileWriter archivo;
   private PrintWriter escritor;
   private String hacia;
   private double importe;
   private String concepto;
   
    public Movimiento() {
        this.archivo = null;
        this.escritor=null;
    }

    public Movimiento(String fecha,String concepto, String hacia, double importe) {
        this.fecha = fecha;
        this.hacia = hacia;
        this.importe = importe;
        this.concepto = concepto;
    }
 
    public Movimiento( String hacia, double importe, String concepto) {
        this.hacia = hacia;
        this.importe = importe;
        this.concepto = concepto;
    }

    public String getFecha() {
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
        LocalTime fecha= LocalTime.now();
        try {
            this.archivo = new FileWriter ("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Ticket.txt");
            this.escritor = new PrintWriter(this.archivo);
            
            this.escritor.println(fecha + ", "+concepto + ", hacia"+ hacia + ", "+ importe);     
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }finally{
            this.archivo.close();
        }
    }
    public void guardarMovimientos(Cuenta desde,Cuenta hacia, double importe, String concept) throws IOException{
        LocalTime fecha= LocalTime.now();
        try {
            this.escritor = new PrintWriter("C:\\Users\\lbarr\\OneDrive\\Escritorio\\Textos de Programa\\Movimientos.txt");
            
            this.escritor.println(fecha + ","+concepto +","+hacia.getAlias() + ","+ importe);     
        }catch(Exception e){
            System.out.println("Error " + e.getMessage());
        }
    }
}
