
package org.rx.cr.generic;

import java.util.ArrayList;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public interface MVCGeneric<Tipo> 
{    
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long registrar(Tipo bean) throws Exception;
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long actualizarRegistro(Tipo bean) throws Exception;
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long eliminarRegistro(Tipo bean) throws Exception;    
    /**
     *
     * @param referencia
     * @return (Lista objetos buscados | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public ArrayList<Tipo> buscarReferencia(String referencia) throws Exception;    
    /**
     *
     * @return (Lista objetos | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public ArrayList<Tipo> listar() throws Exception;
    /**
     *
     * @param id
     * @return (Objeto Buscado | NULL)
     */
    @RidixCr(author=RidixCr)
    public Tipo buscar(long id) throws Exception;     
}
