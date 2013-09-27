package org.rx.cr.db;

public class DBA {
    public static final int SQLSERVER=1,MYSQL=2,POSTGRESQL=3,ORACLE=4,DERBY=5,DB2=6;
    public static final int PORT_SQLSERVER=1433,PORT_MYSQL=3306,PORT_POSTGRESQL=5432,PORT_ORACLE=4,PORT_DERBY=5,PORT_DB2=6;
    private static int SELECTED;
    private static int PORT_SELECTED;
    
    public static void selectSQLSERVER(){
        SELECTED=SQLSERVER;
        PORT_SELECTED=PORT_SQLSERVER;
    }
    public static void selectMYSQL(){
        SELECTED=MYSQL;
        PORT_SELECTED=PORT_MYSQL;
    }
    public static void selectPOSTGRESQL(){
        SELECTED=POSTGRESQL;
        PORT_SELECTED=PORT_POSTGRESQL;
    }
    public static void selectORACLE(){
        SELECTED=ORACLE;
        PORT_SELECTED=PORT_ORACLE;
    }
    public static void selectDERBY(){
        SELECTED=DERBY;
        PORT_SELECTED=PORT_DERBY;
    }
    public static void selectDB2(){
        SELECTED=DB2;
        PORT_SELECTED=PORT_DB2;
    }
    public static int selectedDBA(){
        return SELECTED;
    }
    public static int portDB(){
        return PORT_SELECTED;
    }
    
}
