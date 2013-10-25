package org.rx.cr.dao;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.rx.cr.generic.MVCGenericHibernate;
import org.rx.cr.util.HibernateUtil;

public abstract class DAAbstractHibernate<Tipo> implements MVCGenericHibernate<Tipo>{
    private Transaction transaction;
    private Session sesion;
    private Tipo dataObject;
    public static int TRANSACCION_FALLIDA=-1,TRANSACCION_EXITOSA=0;    
    private List<Tipo> list = new LinkedList<Tipo>();

    public DAAbstractHibernate() {
        sesion = HibernateUtil.getSessionFactory().openSession();
    }
    
    private Transaction getTransaction() {
        return transaction;
    }

    private void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    protected Session getSesion() {
        return sesion;
    }

    protected void setSesion(Session sesion) {
        this.sesion = sesion;
    }
    private void initTransaction(){
        sesion = HibernateUtil.getSessionFactory().openSession();
        setTransaction(sesion.beginTransaction());
    }
    protected long save(){
        Long rs=null;
        try { 	 
            initTransaction();
            rs = (Long)sesion.save(getDataObject()); 
            commit();
        }catch(HibernateException he) { 
            he.printStackTrace();
            rollback();
            close();
        }finally { 
            close();
        }  
        return rs;
    }
    protected int update(){
        try { 	         
            initTransaction();
            sesion.update(getDataObject()); 
            commit();
            return TRANSACCION_EXITOSA;
        }catch(HibernateException he) { 
            he.printStackTrace();
            rollback();
            close();
            return TRANSACCION_FALLIDA;
        }finally { 
            close();
        }  
    }
    protected int delete(){
        try { 	         
            initTransaction();
            sesion.delete(getDataObject()); 
            commit();
            return TRANSACCION_EXITOSA;
        }catch(HibernateException he) { 
            he.printStackTrace();
            rollback();
            close();
            return TRANSACCION_FALLIDA;
        }finally { 
            close();
        }  
    }
    protected List<Tipo> getList(String tabName){
        try { 	         
            initTransaction();  
            list.addAll((List<Tipo>)sesion.createQuery("from "+tabName).list());
            return list;
        }finally { 
            close();
        }  
    }
    protected Tipo getObject(int id){
        try { 	         
            initTransaction();            
            return (Tipo)sesion.get(Object.class,id); 
        }finally { 
            close();
        }  
    }
    private void commit(){
        getTransaction().commit(); 
    }
    private void rollback(){
        getTransaction().rollback();
    }
    private void close(){
        sesion.close();
    }
    
    private Tipo getDataObject() {
        return dataObject;
    }

    protected void setDataObject(Tipo dataObject) {
        this.dataObject = dataObject;
    }

}
