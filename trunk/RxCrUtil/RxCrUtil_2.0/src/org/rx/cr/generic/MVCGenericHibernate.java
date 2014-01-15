
package org.rx.cr.generic;

import java.util.List;
import org.RidixCr;
import static org.rx.cr.util.Utilitarios.*;

public interface MVCGenericHibernate<Tipo> 
{    
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long registrar(Tipo bean);
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long actualizarRegistro(Tipo bean);
    /**
     *
     * @param obj
     * @return ( 1(Correcto) | -1(Error))
     */
    @RidixCr(author=RidixCr)
    public long eliminarRegistro(Tipo bean);    
    /**
     *
     * @param referencia
     * @return (Lista objetos buscados | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public List<Tipo> buscarReferencia(String referencia);    
    /**
     *
     * @return (Lista objetos | Lista Vacia | NULL)
     */
    @RidixCr(author=RidixCr)
    public List<Tipo> listar();
    /**
     *
     * @param id
     * @return (Objeto Buscado | NULL)
     */
    @RidixCr(author=RidixCr)
    public Tipo buscar(long id);     
}
