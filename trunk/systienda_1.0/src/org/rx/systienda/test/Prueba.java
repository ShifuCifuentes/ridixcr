
package org.rx.systienda.test;

import java.util.ArrayList;


public class Prueba {
    public static void main(String []arg){
        /*System.out.println("skinner najarro");
        System.err.println("error mostrando nombre"); */
        
        //BEmpleado empleado1=new BEmpleado();
        /*
        System.out.println(empleado1.toString());
        
        empleado1.setCodigo_empleado(1);
        empleado1.setNombres("skinner");
        empleado1.setAp_paterno("najarro");
        empleado1.setAp_maternno("cardenas");
        empleado1.setDireccion("jr. girasoeles");
        empleado1.setCorreo("skin_9@hotmai.com");
        empleado1.setTelefono("966149687"); 
     
        System.out.println(empleado1.toString());*/
        /////////////////////////////////////////////////
        /*
        try{
        System.out.println(empleado1.dias_semana[9]);
        }catch(Exception ex){
            System.out.println(ex.toString());
        }*/
        //////////////////////////////////////////////
        /*System.out.println(empleado1.dias_semanax[0]);
        empleado1.dias_semanax[0]="linus";        
        System.out.println(empleado1.dias_semanax[0]);*/
        //////////////////////////////////////////////
        /*for (int i = 0; i < empleado1.dias_semana.length; i++) {
            String dia = empleado1.dias_semana[i];
            System.out.print(dia+",");
        }*/
        ///////////////////////////////////////
        /*
        int k=0;
        while (k<empleado1.dias_semana.length) {            
            String dia = empleado1.dias_semana[k];
            System.out.print(dia+",");
            k++;
        }*/
        /////////////////////////////////////////
        /*
        int k=0;
        do{
         String dia = empleado1.dias_semana[k];
         System.out.print(dia+",");   
         k++;
        }while(k<empleado1.dias_semana.length);        * 
        */
        ///////////////////////////////////////
        /*int n1=4,n2=6,n3=8;
        if (n1>n3) {
            System.out.println("verdad");
        }else{
            System.out.println("falso");
        }*/
        ////////////////////////////////////////
        /*int n2=3;
        switch(n2){
            case 2: System.out.println("dos");  break;
            case 8: System.out.println("ocho");  break;
            case 4: System.out.println("cuatro");  break;
            case 7: System.out.println("siete");  break;
            default: System.out.println("no existe"); break;
        }*/
        
        ///////////////////////////////////////////////
        /*ArrayList<BCuenta> lista=new ArrayList<BCuenta>();
        BCuenta cuenta1;
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(1);
        cuenta1.setCodigo_cuenta(1);
        cuenta1.setNombre_cuenta("skinner");        
        cuenta1.setRol("Administrador");        
        lista.add(cuenta1);
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(8);
        cuenta1.setCodigo_cuenta(2);
        cuenta1.setNombre_cuenta("pavel");        
        cuenta1.setRol("server");
        lista.add(cuenta1);
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(13);
        cuenta1.setCodigo_cuenta(3);
        cuenta1.setNombre_cuenta("Mart");        
        cuenta1.setRol("Mart1");
        lista.add(cuenta1);
        
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i).toString());             
        }*/
        ///////////////////////////////////////////
        /*ArrayList lista=new ArrayList();
        BCuenta cuenta1;
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(1);
        cuenta1.setCodigo_cuenta(1);
        cuenta1.setNombre_cuenta("skinner");        
        cuenta1.setRol("Administrador");        
        lista.add(cuenta1);
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(8);
        cuenta1.setCodigo_cuenta(2);
        cuenta1.setNombre_cuenta("pavel");        
        cuenta1.setRol("server");
        lista.add(cuenta1);
        
        cuenta1=new BCuenta();
        cuenta1.setCodigo_empleado(13);
        cuenta1.setCodigo_cuenta(3);
        cuenta1.setNombre_cuenta("Mart");        
        cuenta1.setRol("Mart1");
        lista.add(cuenta1);
        
        for (int i = 0; i < lista.size(); i++) {
            BCuenta tem =(BCuenta)lista.get(i);
            System.out.println(tem.toString());             
        }**/
        /////////////////////////////////////
        String str1="5";
        String str2="mentira";
        int n1=0;  
        float n2=0;
        double n3=0;
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        
        n1=Integer.parseInt(str1);
        n2=Float.parseFloat(str1);
        n3=Double.parseDouble(str1);
        System.out.println(n1);
        System.out.println(n2);
        System.out.println(n3);
        //////////////////////////
        char ch='A';
        char ch2='0';
        
        System.out.println((int)ch);
        System.out.println((int)ch2);
        
        
        
    }
}
