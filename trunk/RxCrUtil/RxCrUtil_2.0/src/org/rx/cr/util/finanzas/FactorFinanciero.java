package org.rx.cr.util.finanzas;

public class FactorFinanciero {
    public static double _FSC(double i,int n){
        return Math.pow((1+i),n);
    }
    public static double _FCS(double i,int n){
        return (Math.pow((1+i),n)-1)/i;
    }    
    public static double _FRC(double i,int n){
        return (i*Math.pow((1+i),n))/(Math.pow((1+i),n)-1);
    }
    public static double _FSA(double i,int n){
        return Math.pow((1+i),-n);
    }
    public static double _FDFA(double i,int n){
        return i/(Math.pow((1+i),n)-1);
    }
    public static double _FAS(double i,int n){
        return (Math.pow((1+i),n)-1)/(i*Math.pow((1+i),n));
    }
}
