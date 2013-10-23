package org.sysconpat.rx.da;

import java.sql.Connection;
import java.util.ArrayList;
import org.rx.cr.dao.DAOAbstract;
import org.sysconpat.rx.be.BEUbigeo;

public class DAOUbigeo extends DAOAbstract<BEUbigeo> {

    public DAOUbigeo(Connection conn) {
        setConnection(conn);
    }
    //<editor-fold defaultstate="collapsed" desc="Funciones No Utilizadas">
    @Override
    public int registrar(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int actualizarRegistro(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int eliminarRegistro(BEUbigeo bean) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEUbigeo> buscarReferencia(String referencia) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public ArrayList<BEUbigeo> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public BEUbigeo buscar(int id) throws Exception {
         try { 
            BEUbigeo bean = null;
            clear();
            setStoreProcedure("dbo.sp_sel_ubigeo"); 
            setParameterInt(id);
            commitc();
            while (existResult()) {
                bean = new BEUbigeo(); 
                bean.setId_ubigeo(getDataInt(1));
                bean.setNombre_region(getDataString(2));
                bean.setCodigo_region(getDataInt(3));
                bean.setNombre_provincia(getDataString(4));
                bean.setCodigo_provincia(getDataInt(5));
                bean.setNombre_distrito(getDataString(6));      
                bean.setCodigo_distrito(getDataInt(7));
            }   
            close();
            return bean;            
        } catch (Exception ex) {
            rollback(ex);
            return null;            
        }finally{
        }
    }
    //</editor-fold>    
    public ArrayList<BEUbigeo> listar_regiones() throws Exception {      
      try {             
            clear();
            setStoreProcedure("dbo.listar_regiones");
            commitc();
            while (existResult()){ 
              BEUbigeo bean = new BEUbigeo();              
              bean.setCodigo_region(getDataInt(1));
              bean.setNombre_region(getDataString(2));
              add(bean);
            }
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);
            return null;
        }finally{
        }       
    }    
    public ArrayList<BEUbigeo> listar_provincias_region(int cod_region) throws Exception{      
      try {             
            clear();
            setStoreProcedure("dbo.listar_provincias_region");            
            setParameterInt(cod_region);
            commitc();
            while (existResult()){ 
              BEUbigeo bean = new BEUbigeo();
              bean.setCodigo_provincia(getDataInt(1));
              bean.setNombre_provincia(getDataString(2));
              add(bean);
            }  
            close();
           return getLista();
        } catch (Exception ex) {
           rollback(ex);
           return null;
        }finally{
        }       
    }    
    public ArrayList<BEUbigeo> listar_distritos_provincia_region(int cod_region, int cod_provincia) throws Exception{      
      try {             
            clear();
            setStoreProcedure("dbo.listar_distritos_provincia_region");            
            setParameterInt(cod_region);
            setParameterInt(cod_provincia);
            commitc();
            while (existResult()){ 
              BEUbigeo bean = new BEUbigeo();              
              bean.setId_ubigeo(getDataInt(1));             
              bean.setCodigo_distrito(getDataInt(2));
              bean.setNombre_distrito(getDataString(3));
              add(bean);
            }  
            close();
            return getLista();
        } catch (Exception ex) {
            rollback(ex);           
            return null;
        }finally{
        }       
    }
    
}
