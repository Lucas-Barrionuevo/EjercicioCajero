
package com.mycompany.cajeroautomatico;
public class Clientes {
    private Integer cuit;
    private String alias;

    public Clientes(Integer cuit, String alias) {
        this.cuit = cuit;
        this.alias = alias;
    }

    public Integer getCuit() {
        return cuit;
    }

    public String getAlias() {
        return alias;
    }
    
    
}
