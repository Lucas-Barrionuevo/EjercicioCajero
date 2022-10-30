
package com.mycompany.cajeroautomatico;

import java.time.LocalDateTime;
import java.util.Date;

public interface Movimientos  {
   private LocalDateTime fechaHora;
   private String concepto;
   private double importe;
   private Movimientos ultimos [];


    public void ingresarDinero(){
    }
    public void transferencias(){
    }
}
