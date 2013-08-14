
package org.rx.cr.test;

import org.rx.cr.gui.JPanelUC;

public class TestUC extends JPanelUC{


    @Override
    public void _cargarCombos() {
        System.out.println("Cargar combos : Operacion "+getOPERACION());
    }

    @Override
    public void _agregaValidadoresControl() {
        System.out.println("Agregar Validadores");
    }

    @Override
    public boolean _isDatosValidosBE() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int _registrarBE() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int _guardarCambiosBE() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void _listarBEs() throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void _recuperarDatosBE() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void _deshabilitarControlesDatos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void _habilitarControlesDatos() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void _resetControls() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public static void main(String[] args) {
        TestUC tst = new TestUC();
        
    }
}
