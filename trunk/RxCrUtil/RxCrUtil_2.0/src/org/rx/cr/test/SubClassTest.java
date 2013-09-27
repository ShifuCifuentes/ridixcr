
package org.rx.cr.test;

import static org.rx.cr.util.ResourceMetadataDB.*;

public class SubClassTest {

    public SubClassTest() {
        
    }
    
    public void testStatic(){
        System.out.println(RSC_DATA_BASE);
        System.out.println(RSC_USER);
        System.out.println(RSC_PASSWORD);
        System.out.println(RSC_USER_ROOT);
        System.out.println(RSC_PASSWORD_ROOT);
        System.out.println(RSC_BACKUP_FILE);
    }
}
