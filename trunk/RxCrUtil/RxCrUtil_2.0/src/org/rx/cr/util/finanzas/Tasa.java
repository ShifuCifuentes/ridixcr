package org.rx.cr.util.finanzas;

public class Tasa {
    public static  final int DIARIO=1,
                            QINCENAL=15*DIARIO,
                            MENSUAL=2*QINCENAL,
                            BIMESTRAL=2*MENSUAL,
                            TRIMESTRAL=3*MENSUAL,
                            CUATRIMESTRAL=4*MENSUAL,
                            SEMESTRAL=6*MENSUAL,
                            ANUAL=12*MENSUAL;
    public static int _n(int op) {
        switch(op){
            case DIARIO:return DIARIO;
            case QINCENAL:return QINCENAL;
            case MENSUAL:return MENSUAL;
            case BIMESTRAL:return BIMESTRAL;
            case TRIMESTRAL:return TRIMESTRAL;
            case CUATRIMESTRAL:return CUATRIMESTRAL;
            case SEMESTRAL:return SEMESTRAL;
            case ANUAL:return ANUAL;
            default: return 0;
        }
    }
    private static double _f(int opie,int ope) {
        return (double)_n(ope)/(double)_n(opie);
    }
    private static double _H(int ope,int ops) {
        return (double)_n(ope)/(double)_n(ops);
    }
    private static double n_mn(int opie,int ope,int ns,int ops) {
        return (double)ns*_f(opie,ope)/(double)_H(ope,ops);
    }
    private static double n_my(int opie,int ns,int ops) {
        return (double)_f(opie,ops)/(double)ns*_H(opie,opie);
    }
    public static double _i_my(double i,int ope,int ns,int ops) {
        return Math.pow((1.0+i),n_my(ope,ns,ops))-1.0;
    }       
    public static double _i_mn(double i,int opie,int ope,int ns,int ops) {
        return Math.pow((1.0+i),n_mn(opie,ope,ns,ops))-1.0;
    }       
//    public static double _i(double i,int opie,int ope,int ns,int ops) {
//        if (ops>ope) {
//            return _i_my(i, ope, ns, ops);
//        }else{
//            return _i_mn(i, ope, ope, ns, ops);
//        }        
//    }       
    public static double _i(double i,int ope,int ns,int ops) {
        if (ops>ope) {
            return _i_my(i, ope, ns, ops);
        }else{
            return _i_mn(i, ope, ope, ns, ops);
        }        
    } 
//    public static void main(String[] args) {
//        System.out.println(100*_i(0.10,SEMESTRAL,1,TRIMESTRAL)); 
//    }
}
