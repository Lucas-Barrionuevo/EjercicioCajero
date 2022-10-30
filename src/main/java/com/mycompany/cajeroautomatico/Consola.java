
package com.mycompany.cajeroautomatico;

import java.util.Scanner;

public class Consola {
    private Scanner entradaDeTeclado;
 
    public Consola (){
        this.entradaDeTeclado = new Scanner (System.in);
    }
    
    public String generarEntrada(String mensaje){
            System.out.println(mensaje);
            return this.entradaDeTeclado.nextLine();
        }
}
