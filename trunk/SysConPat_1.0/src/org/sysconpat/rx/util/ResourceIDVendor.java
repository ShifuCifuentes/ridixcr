
package org.sysconpat.rx.util;
import org.rx.cr.db.DBA;
import static org.rx.cr.util.Utilitarios.*;

public class ResourceIDVendor {
    public static String CLIENT_APP_ID="NTUzMjZDN0E2NDQ3NTY3NDU5NTM0MjZCNUE1MzQyNDQ2MjMyMzUzMDYzNkQzOTczNDk0NjQyNjg2NDQ4NEE3MDYyNTczOTc1NjE1NzQ2NzM0OTQzMzA2NzUxMzA1NjUzNTEzMTU2NTQ=";
    public static String VENDOR_ID="NTU2RDZDNkI2MTU4Njc2NzUxMzM0OTNE";
    public static String APP_ID="NTEzMDU2NTM1MTMxNTY1NA==";
    
     public static String HOST="NEQ1NDQ5MzM0QzZBNDE3NTRENDMzNDc4";
//    public static String HOST="NEQ1NDZCNzk0QzZBNDUzMjRGNDMzNDc4NEM2QTQ5Nzg0RDY3M0QzRA==";
    public static String PORT="NEU1NDUxN0E0RDY3M0QzRA==";
    public static String DB="NTkzMjM5NzU2NDQ4NEE3NjYyNDYzOTc3NTk1ODUyNzk2MTU3MzE3NjYyNkQ2QzY4NjI0MTNEM0Q=";
    public static String USER="NjMzMzZDN0E1OTMyMzk3NTYzNDc0NjMw";
    public static String PASSWORD="NjMzMzZDN0E1OTMyMzk3NTYzNDc0NjMwNEQ1NDQ5N0E=";
    public static String USER_ROOT="NjM0NzM5N0E2NDQ3NjQ3OTVBNTg0RDNE";
    //public static String PASSWORD_ROOT="NTkzMjU2Nzk1OTMzNTY3QTRENkE0MTc4NEQ3NzNEM0Q=";
    public static String PASSWORD_ROOT="NEQ1NDQ5N0E0RTQ0NTUzMjRFN0E2NzNE";
    public static String MAX_CLIENTS="NEQ1NDQxM0Q=";      
    static {
        DBA.selectPOSTGRESQL();
        CLIENT_APP_ID=_int_$(CLIENT_APP_ID);
        VENDOR_ID=_int_$(VENDOR_ID);
        APP_ID=_int_$(APP_ID);
        
        HOST=_int_$(HOST);
        PORT=_int_$(PORT);
        DB=_int_$(DB);
        USER=_int_$(USER);
        PASSWORD=_int_$(PASSWORD);
        USER_ROOT=_int_$(USER_ROOT);
        PASSWORD_ROOT=_int_$(PASSWORD_ROOT);
        MAX_CLIENTS=_int_$(MAX_CLIENTS);
    }
}
