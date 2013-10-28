package org.sysconpat.rx.ds;

import java.sql.Connection;
import org.rx.cr.conf.Config;
import org.rx.cr.db.DBA;
import org.rx.cr.ds.DSConeccion;
import static org.rx.cr.util.Utilitarios.*;

public class DSUtil {   
    public static String HOST="NEQ1NDQ5MzM0QzZBNDE3NTRENDMzNDc4";
    public static String PORT="NEU1NDUxN0E0RDY3M0QzRA==";
    public static String DB="NTkzMjM5NzU2NDQ4NEE3NjYyNDYzOTc3NTk1ODUyNzk2MTU3MzE3NjYyNkQ2QzY4NjI0MTNEM0Q=";
    public static String USER="NjMzMzZDN0E1OTMyMzk3NTYzNDc0NjMw";
    public static String PASSWORD="NjMzMzZDN0E1OTMyMzk3NTYzNDc0NjMwNEQ1NDQ5N0E=";
    public static String USER_ROOT="NjM0NzM5N0E2NDQ3NjQ3OTVBNTg0RDNE";
    public static String PASSWORD_ROOT="NTkzMjU2Nzk1OTMzNTY3QTRENkE0MTc4NEQ3NzNEM0Q=";
    static {
        DBA.selectPOSTGRESQL();
        HOST=_int_$(HOST);
        PORT=_int_$(PORT);
        DB=_int_$(DB);
        USER=_int_$(USER);
        PASSWORD=_int_$(PASSWORD);
        USER_ROOT=_int_$(USER_ROOT);
        PASSWORD_ROOT=_int_$(PASSWORD_ROOT);
    }
    public static DSConeccion _DSConneccion(Config conf){
        return new DSConeccion(conf);
    }
    public static DSConeccion _DSConneccion(){
        return new DSConeccion(HOST,PORT,DB,USER,PASSWORD);
    }
    public static Connection _Conneccion(){
        return _DSConneccion().getConeccion();
    }
    
}