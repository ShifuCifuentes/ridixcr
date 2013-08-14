package org.rx.cr.generic;

public interface GenericFunctionUC{
    public static final int _NUEVO=1,_MODIFICAR=2,_DESCONOCIDO=-1;     
    public void _cargarCombos() throws Exception;
    public void _agregaValidadoresControl();
    public boolean _isDatosValidosBE();    
    public int _registrarBE() throws Exception;
    public int _guardarCambiosBE() throws Exception;   
    public void _listarBEs() throws Exception;
    public void _recuperarDatosBE() throws Exception;
    public void _deshabilitarControlesDatos();
    public void _habilitarControlesDatos();
    public void _resetControls();
}
