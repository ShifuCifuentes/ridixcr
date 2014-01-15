package org.rx.cr.util.finanzas;

import java.util.Date;
import static org.rx.cr.util.Utilitarios.*;
import static org.rx.cr.util.finanzas.Tasa.*;

public class CuotaAmortizacion {
    //<editor-fold defaultstate="collapsed" desc="Funciones Utiles">  
    private static int diasAnio() {     
         Date f = new Date(); 
        int tmp = f.getYear()+1900;
        int DIAS_MES[] = {31,tmp%4!=0?28:29,31,30,31,30,31,31,30,31,30,31};  
        tmp=0;
        for (int i = 0; i < 12; i++) {
            tmp+=DIAS_MES[i];          
        }
        return tmp;
    }        
    private static int diasTranscurridosMes(int m,double a) {  
        int DIAS_MES[] = {31,a%4.0!=0?28:29,31,30,31,30,31,31,30,31,30,31}; 
        int td=0;
        for (int i = 0; i < m; i++) {
            td+=DIAS_MES[i];         
        }
        return td;
    }    
    private static int nro_meses(int op){
        switch(op){
            case DIARIO:return DIARIO/30;
            case QINCENAL:return QINCENAL/30;
            case MENSUAL:return MENSUAL/30;
            case BIMESTRAL:return BIMESTRAL/30;
            case TRIMESTRAL:return TRIMESTRAL/30;
            case CUATRIMESTRAL:return CUATRIMESTRAL/30;
            case SEMESTRAL:return SEMESTRAL/30;
            case ANUAL:return ANUAL/30;
            default:return 0;
        }
    }
    public static String formatDateString(Date f){
        return (numberFormat(f.getDate(),"##")+"/"+numberFormat(f.getMonth()+1,"##")+"/"+(f.getYear()+1900));
    }
    public static Date mkDate(String f){
        int d,m,y;
        d=Integer.parseInt(f.substring(0,f.indexOf("/")));
        f=f.substring(f.indexOf("/")+1,f.length());
        m=Integer.parseInt(f.substring(0,f.indexOf("/")))-1;
        f=f.substring(f.indexOf("/")+1,f.length());
        y=Integer.parseInt(f);
        return new Date(y-1900,m,d);
    }    
    private static int diasTranscurridosFecha(Date f) {
        int dia = f.getDate();        
        int mes = f.getMonth();
        int year = f.getYear()+1900;
        int DIAS_MES[] = {31,year%4!=0?28:29,31,30,31,30,31,31, 30,31,30,31};  
        int td=0;
        for (int i = 0; i <mes; i++) {
            td+=DIAS_MES[i];  
        }
        return td+dia;
    }    
    private static int mesPago(int a,int dtt){
        int DIAS_MES[] = {31,a%4!=0?28:29,31,30,31,30,31,31,30,31,30,31};  
        int sd=0;
        int ms=-1,i=0;
        while (dtt>sd) {            
            sd+=DIAS_MES[i]; 
            ms=i;
            i++;            
        }        
        return ms;
    }
    public static Date fechaAmortizacion(Date f,int op){       
        int a=f.getYear()+1900,        
            ndp=_n(op),
            dtf=diasTranscurridosFecha(f),
            dtf_p=(dtf+ndp),
            ap,       
            mp, 
            dp,        
            dias_anio=diasAnio();
        if (dtf_p>dias_anio) {                 
            dtf_p =(dtf_p-dias_anio);
            ap=a+1;
            mp=mesPago(ap,dtf_p);              
            dp=dtf_p-diasTranscurridosMes(mp,ap);            
        }else{ 
            ap=a;
            mp=mesPago(ap,dtf_p);  
            dp=dtf_p-diasTranscurridosMes(mp,ap);
        }        
        return new Date(ap-1900,mp,dp);
    }    
    public static int unidadMedidaTiempo(String op){
        switch(op){
            case "DIARIO":return DIARIO;
            case "QINCENAL":return QINCENAL;
            case "MENSUAL":return MENSUAL;
            case "BIMESTRAL":return BIMESTRAL;
            case "TRIMESTRAL":return TRIMESTRAL;
            case "CUATRIMESTRAL":return CUATRIMESTRAL;
            case "SEMESTRAL":return SEMESTRAL;
            case "ANUAL":return ANUAL;
            default:return 0;
        }
    }
    public static int diferenciaFecha(Date f1,Date f2){
        return diasTranscurridosFecha(f2)-diasTranscurridosFecha(f1);
    }
    //</editor-fold>   
}
