package org.rx.cr.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static Connection connection;
    private static Statement statement;
     public static final ThreadLocal session = new ThreadLocal();
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static Session currentSession() throws HibernateException {
        Session s = (Session) session.get();
        // Open a new Session, if this thread has none yet
        if (s == null) {
            s = sessionFactory.openSession();
            // Store it in the ThreadLocal variable
            session.set(s);
        }
        return s;
    }
    
    public static void closeSession() throws HibernateException {
        Session s = (Session) session.get();
        if (s != null)
            s.close();
        session.set(null);
    }
    private static void createStatement() {
        try {            
            statement = getConnection().createStatement();
        } catch (Exception e) {
            e.printStackTrace();            
        }
    }
    public static void setup(String sql) {
        try {
            createStatement();
            statement.executeUpdate(sql);
            close();
        } catch (Exception e) {
            e.printStackTrace();
            close();
        }
    }
    // Drop table if exists
    public static void droptable(String sql) {
        try {
            createStatement();
            statement.executeUpdate(sql);
            close();
        } catch (Exception e) {
            e.printStackTrace();       
            close();
        }
    }
    
    public static void checkData(String sql) {
        String[] starray = sql.split(" ");
        try {
            createStatement();
            ResultSet r = statement.executeQuery(sql);
            HibernateUtil.outputResultSet(r);
            close();
        } catch (Exception e) {
            e.printStackTrace();
            close();
        }
    }
    
    public static void outputResultSet(ResultSet rs) throws Exception{
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        ResultSetMetaData metadata = rs.getMetaData();
        
        int numcols = metadata.getColumnCount();
        String[] labels = new String[numcols];
        int[] colwidths = new int[numcols];
        int[] colpos = new int[numcols];
        int linewidth;
        
        linewidth = 1;
        for (int i = 0; i < numcols; i++) {
            colpos[i] = linewidth;
            labels[i] = metadata.getColumnLabel(i + 1); // get its label
            int size = metadata.getColumnDisplaySize(i + 1);
            if (size > 30 || size == -1)
                size = 30;
            int labelsize = labels[i].length();
            if (labelsize > size)
                size = labelsize;
            colwidths[i] = size + 1; // save the column the size
            linewidth += colwidths[i] + 2; // increment total size
        }
        
        StringBuffer divider = new StringBuffer(linewidth);
        StringBuffer blankline = new StringBuffer(linewidth);
        for (int i = 0; i < linewidth; i++) {
            divider.insert(i, '-');
            blankline.insert(i, " ");
        }
        // Put special marks in the divider line at the column positions
        for (int i = 0; i < numcols; i++)
            divider.setCharAt(colpos[i] - 1, '+');
        divider.setCharAt(linewidth - 1, '+');
        
        // Begin the table output with a divider line
        
        // The next line of the table contains the column labels.
        // Begin with a blank line, and put the column names and column
        // divider characters "|" into it. overwrite() is defined below.
        StringBuffer line = new StringBuffer(blankline.toString());
        line.setCharAt(0, '|');
        for (int i = 0; i < numcols; i++) {
            int pos = colpos[i] + 1 + (colwidths[i] - labels[i].length()) / 2;
            overwrite(line, pos, labels[i]);
            overwrite(line, colpos[i] + colwidths[i], " |");
        }
                
        while (rs.next()) {
            line = new StringBuffer(blankline.toString());
            line.setCharAt(0, '|');
            for (int i = 0; i < numcols; i++) {
                Object value = rs.getObject(i + 1);
                if (value != null){
                    overwrite(line, colpos[i] + 1, value.toString().trim());
                    overwrite(line, colpos[i] + colwidths[i], " |");
                }
            }           
        }        
        //</editor-fold>
    }
    private static void close(){
        try {getConnection().close();statement.close();} catch (SQLException ex) {}
    }
    public static void overwrite(StringBuffer b, int pos, String s) {
        int len = s.length();
        for (int i = 0; i < len; i++)
            b.setCharAt(pos + i, s.charAt(i));
    }

    public static Connection getConnection() {
        return connection;
    }

    public static void setConnection(Connection aConnection) {
        connection = aConnection;
    }
}
