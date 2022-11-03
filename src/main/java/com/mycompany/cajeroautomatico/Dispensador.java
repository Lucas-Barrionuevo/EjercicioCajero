package com.mycompany.cajeroautomatico;
public class Dispensador {
    private int billetes100, billetes500, billetes1000;
    private int entregaDeBilletes1000 ,entregaDeBilletes500, entregaDeBilletes100 ;

    public Dispensador() {
        this.billetes100 = 500;
        this.billetes500 = 500;
        this.billetes1000 = 500;
        this.entregaDeBilletes100 = 0;
        this.entregaDeBilletes500 = 0;
        this.entregaDeBilletes1000 = 0;
    }
    
    public void entregaDeBilletes (int monto){
        if (monto >=1000){
             monto = entregaBilletes1000(monto);
        }
        if (monto >=500){
             monto = entregaBilletes500(monto);
        }
        if (monto>=100){
             monto= entregaBilletes100(monto);
        }
        System.out.println("Se entregaron: " + this.entregaDeBilletes1000 + " billetes de 1000");
        System.out.println("Se entregaron: " + this.entregaDeBilletes500 + " billetes de 500");
        System.out.println("Se entregaron: " + this.entregaDeBilletes100 + " billetes de 100");
    }
    private int entregaBilletes1000 (int monto){
        this.entregaDeBilletes1000 = (int) (monto/1000);
        this.billetes1000 = this.billetes1000 - this.entregaDeBilletes1000;
        monto = monto - (1000*(int)(monto/1000));
        return monto;
    }
    private int entregaBilletes500 (int monto){
        this.entregaDeBilletes500 = (int) (monto/500);
        this.billetes500 = this.billetes500 - this.entregaDeBilletes500;
        monto = monto - (500*(int)(monto/500));
        return monto;
    }
    private int entregaBilletes100 (int monto){
        this.entregaDeBilletes100 = (int) (monto/100);
        this.billetes100 = this.billetes100 - this.entregaDeBilletes100;
        monto = monto - (100*(int)(monto/100));
        return monto;
    }


}

