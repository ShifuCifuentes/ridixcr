
package org.sysconpat.rx.util;
import static org.rx.cr.util.Utilitarios.*;

public class ResourceIDVendor {
    public static String CLIENT_APP_ID="NTUzMjZDN0E2NDQ3NTY3NDU5NTM0MjZCNUE1MzQyNDQ2MjMyMzUzMDYzNkQzOTczNDk0NjQyNjg2NDQ4NEE3MDYyNTczOTc1NjE1NzQ2NzM0OTQzMzA2NzUxMzA1NjUzNTEzMTU2NTQ=";
    public static String VENDOR_ID="NTU2RDZDNkI2MTU4Njc2NzUxMzM0OTNE";
    public static String APP_ID="NTEzMDU2NTM1MTMxNTY1NA==";
    static {
        CLIENT_APP_ID=_int_$(CLIENT_APP_ID);
        VENDOR_ID=_int_$(VENDOR_ID);
        APP_ID=_int_$(APP_ID);
    }
    public static void main(String[] args) {
        System.out.println(APP_ID);
        System.out.println(CLIENT_APP_ID);
        //System.out.println(VENDOR_ID);
        System.out.println(encodeRx("CERCUS"));
        System.out.println(encodeRx("Sistema de Control Patrimonial - CERCUS"));
    }
}
