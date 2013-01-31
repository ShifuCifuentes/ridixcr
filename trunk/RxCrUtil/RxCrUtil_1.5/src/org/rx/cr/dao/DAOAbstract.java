package org.rx.cr.dao;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;
/* 
 * 
 * Implementacion DAOAbstract 
 * 
 * @autor RidixCr
 * 
 */
public abstract class DAOAbstract<Tipo> implements DAOGeneric<Tipo>{    
    private Connection conection=null;
    private CallableStatement sprp=null;   
    private ResultSet rs=null;
    private ArrayList<Object> lista= new ArrayList<Object>();  
    private String sessionID=null;
    private String appContextPath=null;
    public static int TRANSACCION_FALLIDA=-1,TRANSACCION_EXITOSA=0;    
    //<editor-fold defaultstate="collapsed" desc="SET'S y GET'S">
    public void setParameterBinaryStream(int index,InputStream dat) throws SQLException{
      sprp.setBinaryStream(index,dat);      
    }
    public void setParameterBinaryStream(String ref,InputStream dat) throws SQLException{
      sprp.setBinaryStream(ref,dat);
    }    
    public void setParameterBinaryStream(int index,File file) throws SQLException{
      Object[] tmp = encodeFileBinaryBASE64_C(file); 
      InputStream is = (InputStream)tmp[0];
      int length = Integer.parseInt(tmp[1].toString());
      sprp.setBinaryStream(index,is,length);      
    }
    public void setParameterBinaryStream(String ref,File file) throws SQLException{
      Object[] tmp = encodeFileBinaryBASE64_C(file); 
      InputStream is = (InputStream)tmp[0];
      int length = Integer.parseInt(tmp[1].toString());
      sprp.setBinaryStream(ref,is,length);  
    }
    public void setParameterBinaryStream(int index,File file,String refnf) throws SQLException{       
        try {            
            File tmp = encodeFileBinaryBASE64(file, refnf).getAbsoluteFile();
            FileInputStream fis = new FileInputStream(tmp);
            sprp.setBinaryStream(index,fis,(int)tmp.length());  
        }catch (Exception ex) {} 
    }
    public void setParameterBinaryStream(String ref,File file,String refnf) throws SQLException{
      try {
            File tmp = encodeFileBinaryBASE64(file, refnf).getAbsoluteFile();
            FileInputStream fis = new FileInputStream(tmp);
            sprp.setBinaryStream(ref,fis,(int)tmp.length());  
        }catch (Exception ex) {} 
    }
    public void setParameterBinaryStream(int index,InputStream dat,long size) throws SQLException{
      sprp.setBinaryStream(index, dat, size);      
    }
    public void setParameterBinaryStream(String ref,InputStream dat,long size) throws SQLException{
      sprp.setBinaryStream(ref, dat, size);
    }
    
    public void setParameterBinaryStream(int index,InputStream dat,int size) throws SQLException{
      sprp.setBinaryStream(index, dat, size);
    }
    public void setParameterBinaryStream(String ref,InputStream dat,int size) throws SQLException{
      sprp.setBinaryStream(ref, dat, size);
    }
    
    public void setParameterString(int index,String dat) throws SQLException{
      sprp.setString(index, dat);
    }
    public void setParameterString(String ref,String dat) throws SQLException{
      sprp.setString(ref, dat);
    }
    public void setParameterInt(int index,int dat) throws SQLException{
      sprp.setInt(index, dat);
    }
    public void setParameterInt(String ref,int dat) throws SQLException{
      sprp.setInt(ref, dat);
    }
    public void setParameterDouble(int index,double dat) throws SQLException{
      sprp.setDouble(index, dat);
    }
    public void setParameterDouble(String ref,double dat) throws SQLException{
      sprp.setDouble(ref, dat);
    }
    public void setParameterDate(int index,Date dat) throws SQLException{
      sprp.setDate(index, dat);
    }
    public void setParameterDate(String ref,Date dat) throws SQLException{
      sprp.setDate(ref, dat);
    }
    public void setParameterBoolean(int index,boolean dat) throws SQLException{
      sprp.setBoolean(index, dat);
    }
    public void setParameterBoolean(String ref,boolean dat) throws SQLException{
      sprp.setBoolean(ref, dat);
    }  
    public void setParameterBytes(int index,byte[] dat) throws SQLException{
      sprp.setBytes(index,dat);
    }
    public void setParameterBytes(String ref,byte[] dat) throws SQLException{
      sprp.setBytes(ref,dat);
    }
    public Blob getDataBlob(int index) throws SQLException{
      return rs.getBlob(index);
    }
    public Blob getDataBlob(String ref) throws SQLException{      
        return rs.getBlob(ref);
    }
    public InputStream getDataBinaryStream(int index) throws SQLException{
     return rs.getBinaryStream(index);
    }
    public InputStream getDataBinaryStream(String ref) throws SQLException{
     return rs.getBinaryStream(ref);
    }        
    public byte[] getDataBytesStream(int index) throws SQLException{
      return rs.getBytes(index);
    }
    public byte[] getDataBytesStream(String ref) throws SQLException{
      return rs.getBytes(ref);
    }
    public String getDataString(int index) throws SQLException{
      return rs.getString(index);
    }
    public String getDataString(String ref) throws SQLException{
      return rs.getString(ref);
    }
    public int getDataInt(int index) throws SQLException{
      return rs.getInt(index);
    }
    public int getDataInt(String ref) throws SQLException{
      return rs.getInt(ref);
    }
    public double getDataDouble(int index) throws SQLException{
      return rs.getDouble(index);
    }
    public double getDataDouble(String ref) throws SQLException{
      return rs.getDouble(ref);
    }
    public Date getDataDate(int index) throws SQLException{
      return rs.getDate(index);
    }
    public Date getDataDate(String ref) throws SQLException{
      return rs.getDate(ref);
    }
    public boolean getDataBoolean(int index) throws SQLException{
      return rs.getBoolean(index);
    }
    public boolean getDataBoolean(String ref) throws SQLException{
      return rs.getBoolean(ref);
    }
    public Object getDataObject(String ref) throws SQLException{
        return rs.getObject(ref);
    }
    public Object getDataObject(int index) throws SQLException{
        return rs.getObject(index);
    }
    //</editor-fold>   
    //<editor-fold defaultstate="collapsed" desc="Method's Control"> 
    //<editor-fold defaultstate="collapsed" desc="FORMA DE USO">
    /*
     *  == USO EN DAO'S ==
     * 
     try {             
            setStoreProcedure("<NombreSquema>.<NombreProcedimiento/Funcion>(?,?,?,...,?)"); 
            setParameter<dataType>(1,<data>);    
            ...
            setParameter<dataType>(n,<data>); 
            commit();          
        } catch (SQLException ex) {
            rollback(ex);
        }finally{
            close();
        }
     *
     * =====================
     */
    //</editor-fold>  
    @RidixCr(author=RidixCr)
    public void setStoreProcedure(String strpc) throws SQLException{     
        conection.setAutoCommit(false);
        sprp = conection.prepareCall("{call "+strpc+"}");       
    }
    //<editor-fold defaultstate="collapsed" desc="FORMA DE USO">  
    /*
     *  == USO EN DAO'S ==
     * 
     try {             
            setStoreProcedure("<NombreSquema>.<NombreProcedimiento/Funcion>",<Nro de Parametros>); 
            setParameter<dataType>(1,<data>);    
            ...
            setParameter<dataType>(n,<data>); 
            commit();          
        } catch (SQLException ex) {
            rollback(ex);
        }finally{
            close();
        }
     *
     * =====================
     */
    //</editor-fold>
    @RidixCr(author=RidixCr)
    public void setStoreProcedure(String strpc,int nro_prm) throws SQLException{     
        conection.setAutoCommit(false);
        strpc+="(";
         for (int i = 1; i <= nro_prm; i++) {
             if (i<nro_prm) {
               strpc+="?,";  
             } else {
               strpc+="?";
             }
         }
        strpc+=")";
        sprp = conection.prepareCall("{call "+strpc+"}");       
    }    
    public void setConnection(Connection conn){
        this.conection=conn;
    }    
    private void commitTransaction() throws SQLException{
        sprp.execute();
        rs = sprp.getResultSet();
        conection.commit();
    }
    private void rollbackTransaction() throws SQLException{
        conection.rollback();
    }
    private void conectionClose(){
        try {
            conection.close();
            sprp.close();
            rs.close();
        } catch (Exception ex) {
            Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex);
        }
    }     
    private ResultSet getResultSet(){
        return rs;
    }
    public boolean existResult() throws Exception{
        return getResultSet().next();
    }    
    public CallableStatement getCallableStatement(){
        return sprp;
    }
    public ArrayList getLista() {
        return lista;
    }
    public void setLista(ArrayList<Object> lista) {
        this.lista = lista;
    }    
    public void add(Object obj){
        this.lista.add(obj);
    }
    public void clear(){
        this.lista.clear();
    }
    public String getSessionID() {
        return sessionID;
    }
    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }
    public String getAppContextPath() {
        return appContextPath;
    }
    public void setAppContextPath(String appContextPath) {
        this.appContextPath = appContextPath;
    }
    /**
     * @see commit()
     * @return (ID_Registro| TRANSACCION_EXITOSA | TRANSACCION_FALLIDA)
     */
    public Object commit() throws Exception{
        Object tmp;
        commitTransaction();   
        while (existResult()) { 
            tmp = getDataObject(1);
            close();
            return tmp;
        }
        close();
        return TRANSACCION_EXITOSA;
    }
    public int commitc() throws Exception{
        commitTransaction();  
        return TRANSACCION_EXITOSA;
    }
    public int rollback(Exception ex){
        try{
            Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex);
            rollbackTransaction();
            close();
        } catch (Exception ex1) {
           Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex1);
        } 
        close();
       return TRANSACCION_FALLIDA;
    }
    public void close(){
        conectionClose();
    }
    //</editor-fold>
    /* ESTAS FUNCIONES SON PARA USO ESPECIFICO SI NO LOS DESCEA IGNORELOS*/
    /**
     *
     * @param user
     * @param password
     * @return (Usuario autenticado | NULL)
     */
    @RidixCr(author=RidixCr)
    @Deprecated
    public Tipo autenticarUsuario(String user,String password){
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
