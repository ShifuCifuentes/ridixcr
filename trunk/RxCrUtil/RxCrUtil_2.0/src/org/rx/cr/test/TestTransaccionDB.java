package org.rx.cr.test;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TestTransaccionDB {

    public static void main(String[] args) throws Exception {
        Class.forName("*.package.Driver").newInstance();
        Connection conn = DriverManager
                          .getConnection("jdbc:DBA://host:port/DB","user","pass");    
                   conn.setAutoCommit(false);
        CallableStatement cst = conn.prepareCall("{call scheme.procedure(?,...,?)}");  
                          cst.setInt(1,0);
                   conn.commit();
        ResultSet rs = cst.getResultSet();
        while (rs.next()) {
            Object object = rs.getInt(1);            
        }        
    }
}
