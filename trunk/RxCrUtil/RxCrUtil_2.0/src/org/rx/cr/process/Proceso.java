package org.rx.cr.process;

import java.awt.Frame;
import javax.swing.JFrame;

public final class Proceso implements Runnable{
        public static final long _1MILISEGUNDO=1,
                                 _2MILISEGUNDOS=2*_1MILISEGUNDO,
                                 _3MILISEGUNDOS=3*_1MILISEGUNDO,
                                 _4MILISEGUNDOS=4*_1MILISEGUNDO,
                                 _5MILISEGUNDOS=5*_1MILISEGUNDO,
                                 _6MILISEGUNDOS=6*_1MILISEGUNDO,
                                 _7MILISEGUNDOS=7*_1MILISEGUNDO,
                                 _8MILISEGUNDOS=8*_1MILISEGUNDO,
                                 _9MILISEGUNDOS=9*_1MILISEGUNDO,
                                 _10MILISEGUNDOS=10*_1MILISEGUNDO,
                                 _100MILISEGUNDOS=100*_1MILISEGUNDO,
                                 _1000MILISEGUNDOS=1000*_1MILISEGUNDO;
        public static final long _1SEGUNDO=_1000MILISEGUNDOS,
                                 _2SEGUNDOS=2*_1SEGUNDO,
                                 _3SEGUNDOS=3*_1SEGUNDO,
                                 _4SEGUNDOS=4*_1SEGUNDO,
                                 _5SEGUNDOS=5*_1SEGUNDO,
                                 _6SEGUNDOS=6*_1SEGUNDO,
                                 _7SEGUNDOS=7*_1SEGUNDO,
                                 _8SEGUNDOS=8*_1SEGUNDO,
                                 _9SEGUNDOS=9*_1SEGUNDO,
                                 _10SEGUNDOS=10*_1SEGUNDO,
                                 _60SEGUNDOS=60*_1SEGUNDO;
        public static final long _1MINUTO=_60SEGUNDOS,
                                 _2MINUTOS=2*_1MINUTO,
                                 _3MINUTOS=3*_1MINUTO,
                                 _4MINUTOS=4*_1MINUTO,
                                 _5MINUTOS=5*_1MINUTO,
                                 _6MINUTOS=6*_1MINUTO,
                                 _7MINUTOS=7*_1MINUTO,
                                 _8MINUTOS=8*_1MINUTO,
                                 _9MINUTOS=9*_1MINUTO,                                 
                                 _10MINUTOS=10*_1MINUTO,
                                 _60MINUTOS=60*_1MINUTO;
        public static final long _1HORA=_60MINUTOS,
                                 _2HORAS=2*_1HORA,
                                 _3HORAS=3*_1HORA,
                                 _4HORAS=4*_1HORA,
                                 _5HORAS=5*_1HORA,
                                 _6HORAS=6*_1HORA,
                                 _7HORAS=7*_1HORA,
                                 _8HORAS=8*_1HORA,
                                 _9HORAS=9*_1HORA,
                                 _10HORAS=10*_1HORA,
                                 _24HORAS=24*_1HORA;        
        private Evento evento=null;
        private Thread hilo = null;        
        private boolean estadoProceso=false;
        private int nroEjecuciones=0,contador=0;
        private long pausaEjecucion=0;
        private Object object;
        
        //<editor-fold defaultstate="collapsed" desc="GUI PROCESS MONITOR">
        private JD_Process monitor;
        //</editor-fold>        
        
        public Proceso(long delayMillis,Evento evt,JFrame parent) {
            setPausaEjecucion(delayMillis);
            this.evento = evt;    
            monitor = new JD_Process(parent);
            detener();
                       
        }    
        public Proceso(long delayMillis,JFrame parent) {
            this(delayMillis,null,parent);
        }    

        public Proceso(JFrame parent) {
            this(_10MILISEGUNDOS,parent);
        }
        
        public void setEvento(Evento evt){
            this.evento = evt; 
        }
        public void iniciar(){
            estadoProceso=true;
            this.hilo = new Thread(this); 
            hilo.start();
            contador=0;
            monitor.setVisible(true);
        }
        public void detener(){
            estadoProceso=false;
            if (hilo!=null && hilo.isAlive()) {
                hilo.stop();
            }          
            contador=0;            
        }
        public int getContador(){
            return contador;
        }
        public void pausar(long s){
            try {Thread.sleep(s);} catch (InterruptedException ex) {}
        }
        private void ejecutarEvento(long s){
            if (evento!=null) {
                evento._Accion();
            }            
            incrementaContador();            
            pausar(s);
            
        }
        private void incrementaContador(){
            contador++;
            monitor.setValue(contador);
        }
        public int getNroEjecuciones() {
            return nroEjecuciones;
        }

        public void setNroEjecuciones(int nroEjecuciones) {
            this.nroEjecuciones = nroEjecuciones;
            monitor.setMaxValue(nroEjecuciones);
        }
        public long getPausaEjecucion() {
            return pausaEjecucion;
        }

        public void setPausaEjecucion(long duracionEjecucion) {
            this.pausaEjecucion = duracionEjecucion;
        }
        
        @Override
        public void run() {
            while (estadoProceso && hilo.isAlive() && contador<getNroEjecuciones()) {       
                ejecutarEvento(getPausaEjecucion());                
            }
            if (isProcesoCompleto()) { 
                if (evento!=null) {
                    monitor.setVisible(false);
                    monitor.dispose();
                    evento._PostAccion();
                }                
                detener();
            }
        }
    private boolean isProcesoCompleto(){
        return contador==getNroEjecuciones();
    }
    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }
}
