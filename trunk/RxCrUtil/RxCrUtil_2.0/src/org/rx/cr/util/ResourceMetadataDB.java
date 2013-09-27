
package org.rx.cr.util;
import java.io.File;
import static org.rx.cr.util.Utilitarios.*;

public class ResourceMetadataDB{
    public static String RSC_DATA_BASE="";
    public static String RSC_USER="";
    public static String RSC_PASSWORD="";
    public static String RSC_USER_ROOT="";
    public static String RSC_PASSWORD_ROOT="";
    public static String RSC_BACKUP_FILE="";
        
    public static void setMetaDataDB(String[] meta_data){
        RSC_DATA_BASE=_int_$(meta_data[0]);
        RSC_USER=_int_$(meta_data[1]);
        RSC_PASSWORD=_int_$(meta_data[2]);
        RSC_USER_ROOT=_int_$(meta_data[3]);
        RSC_PASSWORD_ROOT=_int_$(meta_data[4]);
        RSC_BACKUP_FILE=_int_$(meta_data[5]);
    }
    public static void main(String[] args) {        
        ResourceMetadataDB.setMetaDataDB(new String[]{
            "NjM2RDU2Nzc2MjMzNEEzMDVBNTc0RTdBNjE2NzNEM0Q=",
            "NjM2RDM5NzY2NDQxM0QzRA==",
            "NEQ1NDQ5N0E0RTQ0NTUzMjRFN0E2NzNE",
            "NjM2RDM5NzY2NDQxM0QzRA==",
            "NEQ1NDQ5N0E0RTQ0NTUzMjRFN0E2NzNE",
            "NUE0NzQ5NzY1QTQ3NEE2NjVBNTc3MDZDNjI1ODQyNzM2Mjc5MzU3QTYzNTc3NzNE"
        });
        System.out.println(RSC_DATA_BASE);
        System.out.println(RSC_USER);
        System.out.println(RSC_PASSWORD);
        System.out.println(RSC_USER_ROOT);
        System.out.println(RSC_PASSWORD_ROOT);
        System.out.println(RSC_BACKUP_FILE);
//        System.out.println(encodeRx("db/db_ejemplo.sql"));  
//        System.out.println(encodeRx("db/db_ejemplo.backup"));  
        File bf = new File(Utilitarios.getCurentPath()+File.separator+RSC_BACKUP_FILE);
        System.out.println(bf.getAbsolutePath());
        System.out.println(bf.exists()?"Existe":"No Existe");
    }
}
