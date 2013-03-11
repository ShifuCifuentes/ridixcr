package org.rx.cr.dao;
import org.rx.cr.generic.MVCGeneric;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.RidixCr;
import org.rx.cr.generic.BeanAbstractUtil;
import org.rx.cr.util.Utilitarios;
import static org.rx.cr.util.Utilitarios.*;
/* 
 * 
 * Implementacion DAOAbstract 
 * 
 * @autor RidixCr
 * 
 */
public abstract class DAOAbstract<Tipo> implements MVCGeneric<Tipo>{    
    private boolean isfirst=true;
    private String str_pro="";
    private Connection conection=null;
    private CallableStatement sprp=null;   
    private ResultSet rs=null;
    private ArrayList<Object> lista= new ArrayList<Object>();  
    private BeanAbstractUtil bean_parameter=null;
    private ArrayList<BeanAbstractUtil> list_parameter = new ArrayList<BeanAbstractUtil>();
    private String sessionID=null;
    private String appContextPath=null;
    public static int TRANSACCION_FALLIDA=-1,TRANSACCION_EXITOSA=0;    
    //<editor-fold defaultstate="collapsed" desc="SET'S y GET'S">
    private void pre_format_str_pro(){
        if (isfirst) {
            this.str_pro+="?";
            isfirst=false;
        } else {
            this.str_pro+=",?";
        }
    }    
    public void setParameterBinaryStream(File file) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(file);
      bean_parameter.setSize((int)file.length());
      list_parameter.add(bean_parameter);   
    }       
    public void setParameterBinaryStream(InputStream dat,long size) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize((int)size);
      list_parameter.add(bean_parameter);    
    }   
    public void setParameterBinaryStream(InputStream dat,int size) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(size);
      list_parameter.add(bean_parameter);
    }
    public void setParameterString(String dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }    
    public void setParameterInt(int dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }
    public void setParameterDouble(double dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }
    public void setParameterDate(Date dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }
    public void setParameterBoolean(boolean dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }
    public void setParameterBytes(byte[] dat) throws SQLException{
      pre_format_str_pro();
      bean_parameter = new BeanAbstractUtil();
      bean_parameter.setData(dat);
      bean_parameter.setSize(0);
      list_parameter.add(bean_parameter);
    }
    public Blob getDataBlob(int index) throws SQLException{
      return rs.getBlob(index);
    }
    public InputStream getDataBinaryStream(int index) throws SQLException{
     return rs.getBinaryStream(index);
    }  
    public File getDataBinaryStream(int index,String ref) throws SQLException{
        if (getDataBytesStream(index)!=null) {
          try {                    
             return Utilitarios.decodeFileBASE64Binary(getDataBytesStream(index),ref);
          } catch (IOException ex) {
              Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex);
              return null;
          } 
        }
        throw null;
    }
    public byte[] getDataBytesStream(int index) throws SQLException{
      return rs.getBytes(index);
    }
    public String getDataString(int index) throws SQLException{
      return rs.getString(index);
    }
    public int getDataInt(int index) throws SQLException{
      return rs.getInt(index);
    }
    public double getDataDouble(int index) throws SQLException{
      return rs.getDouble(index);
    }
    public Date getDataDate(int index) throws SQLException{
      return rs.getDate(index);
    }
    public boolean getDataBoolean(int index) throws SQLException{
      return rs.getBoolean(index);
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
        this.str_pro=strpc+"(";
        //sprp = conection.prepareCall("{call "+strpc+"}");       
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
        this.str_pro+=")";        
        sprp = conection.prepareCall("{call "+this.str_pro+"}");
        mk_str_parameter();
        Object tmp;
        commitTransaction();   
        while (existResult()) {             
            tmp = getDataObject(1);
            close();
            return !tmp.toString().equals("")?tmp:TRANSACCION_EXITOSA;
        }
        close();
        return TRANSACCION_EXITOSA;
    }
    public Object commit(String msg) throws Exception{
        this.str_pro+=")";
        sprp = conection.prepareCall("{call "+this.str_pro+"}"); 
        mk_str_parameter();
        Object tmp;
        commitTransaction();   
        while (existResult()) { 
            tmp = getDataObject(1);
            close();
            JOptionPane.showMessageDialog(null,msg,"Atencion",JOptionPane.INFORMATION_MESSAGE);
            return !tmp.toString().equals("")?tmp:TRANSACCION_EXITOSA;
        }
        close();
        JOptionPane.showMessageDialog(null,msg,"Atencion",JOptionPane.INFORMATION_MESSAGE);
        return TRANSACCION_EXITOSA;
    }
    public int commitc() throws Exception{
        this.str_pro+=")";
        sprp = conection.prepareCall("{call "+this.str_pro+"}");
        mk_str_parameter();
        commitTransaction();  
        return TRANSACCION_EXITOSA;
    }
    public int commitc(String msg) throws Exception{
        this.str_pro+=")";
        sprp = conection.prepareCall("{call "+this.str_pro+"}");
        mk_str_parameter();
        commitTransaction();  
        JOptionPane.showMessageDialog(null,msg,"Atencion",JOptionPane.INFORMATION_MESSAGE);
        return TRANSACCION_EXITOSA;
    }
    public int rollback(Exception ex){
        try{
            Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex);
            rollbackTransaction();
            close();
        } catch (Exception ex1) {
           //Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex1);
        } 
        close();
       return TRANSACCION_FALLIDA;
    }
    public int rollback(Exception ex,String msg){
        try{
            Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex);
            rollbackTransaction();
            close();
        } catch (Exception ex1) {
           Logger.getLogger(DAOAbstract.class.getName()).log(Level.SEVERE, null, ex1);
        } 
        close();
       JOptionPane.showMessageDialog(null,msg,"Error",JOptionPane.INFORMATION_MESSAGE);
       return TRANSACCION_FALLIDA;
    }
    public void close(){
        conectionClose();
        list_parameter.clear();
    }
    private void mk_str_parameter() throws SQLException {
        for (int i = 0; i < list_parameter.size(); i++) {
            bean_parameter = list_parameter.get(i);
            if (bean_parameter.getData() instanceof Integer) {                
                Integer tmp = (Integer) bean_parameter.getData();
                sprp.setInt((i+1),tmp);
            }else if(bean_parameter.getData() instanceof Double){
                Double tmp = (Double) bean_parameter.getData();
                sprp.setDouble((i+1),tmp);
            }else if(bean_parameter.getData() instanceof Float){
                Float tmp = (Float) bean_parameter.getData();
                sprp.setFloat((i+1),tmp);
            }else if(bean_parameter.getData() instanceof Boolean){
                Boolean tmp = (Boolean) bean_parameter.getData();
                sprp.setBoolean((i+1),tmp);
            }else if(bean_parameter.getData() instanceof Date){
                Date tmp = (Date) bean_parameter.getData();
                sprp.setDate((i+1),tmp);
            }else if(bean_parameter.getData() instanceof String){
                String tmp = (String) bean_parameter.getData();
                sprp.setString((i+1),tmp);
            }else if(bean_parameter.getData() instanceof File){
                File file = (File) bean_parameter.getData();                
                Object[] tmp = encodeFileBinaryBASE64_C(file); 
                InputStream is = (InputStream)tmp[0];
                int length = Integer.parseInt(tmp[1].toString());
                sprp.setBinaryStream((i+1),is,length);                
            }else if(bean_parameter.getData() instanceof InputStream){
                InputStream dat = (InputStream) bean_parameter.getData();
                sprp.setBinaryStream((i+1),dat,bean_parameter.getSize());
            }else if(bean_parameter.getData() instanceof Byte){
                byte[] dat = (byte[]) bean_parameter.getData();                
                sprp.setBytes((i+1),dat);
            }            
        }
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
        throw new UnsupportedOperationException("Implementar si se requiere!");
    }

    
}
