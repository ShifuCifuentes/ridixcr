
package org.rx.cr.dao;

import java.util.ArrayList;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public interface DAOGeneric<Tipo> 
{    
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public int registrar(Tipo bean);
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public int actualizarRegistro(Tipo bean);
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public int eliminarRegistro(Tipo bean);    
    /**
     *
     * @param referencia
     * @return (Lista objetos buscados | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public ArrayList<Tipo> buscarReferencia(String referencia);    
    /**
     *
     * @return (Lista objetos | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public ArrayList<Tipo> listar();
    /**
     *
     * @param id
     * @return (Objeto Buscado | NULL)
     */
    @RidixCr(author=RidixCr)
    public Tipo buscar(int id);     
}
