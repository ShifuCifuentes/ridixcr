package org.sysconpat.rx.bl;

import java.sql.Date;
import java.util.ArrayList;
import org.rx.cr.bl.BLAbstract;
import org.rx.cr.conf.Config;
import org.sysconpat.rx.be.BEBienPatrimonial;
import org.sysconpat.rx.da.DABienPatrimonial;
import static org.sysconpat.rx.ds.DSUtil._DSConneccion;

public class BLBienPatrimonial extends BLAbstract<BEBienPatrimonial>{
    
    private DABienPatrimonial dao = null;
    
    public BLBienPatrimonial(Config conf) {
        setConfig(conf);
    }

    public BLBienPatrimonial() {
        setDSConeccion(_DSConneccion());
    }
    
    
    @Override
    public int registrar(BEBienPatrimonial bean) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.registrar(bean);
    }

    @Override
    public int actualizarRegistro(BEBienPatrimonial bean) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.actualizarRegistro(bean);
    }

    @Override
    public int eliminarRegistro(BEBienPatrimonial bean) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.eliminarRegistro(bean);
    }

    @Override
    public ArrayList<BEBienPatrimonial> buscarReferencia(String referencia) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.buscarReferencia(referencia);
    }
    public ArrayList<BEBienPatrimonial> buscarReferencia(int id_personal) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.buscarReferencia(id_personal);
    }

    @Override
    public ArrayList<BEBienPatrimonial> listar() throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.listar();
    }

    @Override
    public BEBienPatrimonial buscar(int id) throws Exception {
        dao = new DABienPatrimonial(getConeccion());
        return dao.buscar(id);
    }
    public int generar_deprecion_general(Date fecha_calculo) throws Exception{
        dao = new DABienPatrimonial(getConeccion());
        return dao.generar_deprecion_general(fecha_calculo);
    }
    public int generar_deprecion_general_anual(int anio_calculo) throws Exception{
        dao = new DABienPatrimonial(getConeccion());
        return dao.generar_deprecion_general_anual(anio_calculo);
    }
    public int generar_deprecion_general_individual(Date fecha_calculo,int id_bien_patrimonial) throws Exception{
        dao = new DABienPatrimonial(getConeccion());
        return dao.generar_deprecion_general_individual(fecha_calculo,id_bien_patrimonial);
    }
    public int generar_depreciacion_general_individual_anual(Date fecha_calculo,int id_bien_patrimonial) throws Exception{
        dao = new DABienPatrimonial(getConeccion());
        return dao.generar_depreciacion_general_individual_anual(fecha_calculo, id_bien_patrimonial);
    }
}
