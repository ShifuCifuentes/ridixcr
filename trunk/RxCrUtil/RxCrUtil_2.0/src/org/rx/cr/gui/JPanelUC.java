package org.rx.cr.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import org.rx.cr.generic.GenericFunctionUC;
import org.rx.cr.gui.table.AbstractTableModel;

public abstract class JPanelUC extends JPanel implements GenericFunctionUC{  
    public int _OPERACION;
    private String departamento,provincia,distrito;
//    private AbstractTableModel<Class> model = null;
//    private JTable t_lista=null;

    public JPanelUC() {
        _OPERACION=_DESCONOCIDO;
        //_init();
    }
    public void _setDefaultUbigeo(String departamento,String provincia,String distrito){
        this.departamento=departamento;
        this.provincia=provincia;
        this.distrito=distrito;
    }
    protected void _setModelTable(JTable t_lista,AbstractTableModel model){
//        this.t_lista=t_lista;
//        this.model = model;
        t_lista.setModel(model);
    }
    public void _addSearchEventsButton(final JButton b_buscar){
        b_buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    _listarBEs();
                } catch (Exception ex) {
                    Logger.getLogger(JPanelUC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    public void _addRestoreDataEventsTable(final JTable t_lista){
        t_lista.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    _recuperarDatosBE();
                } catch (Exception ex) {
                    Logger.getLogger(JPanelUC.class.getName()).log(Level.SEVERE, null, ex);
                }
            }            
        });
    }
    public void _addRequestFocusEventsShownWindow(final JTextField t_referencia){
        addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentShown(java.awt.event.ComponentEvent evt) {
                t_referencia.requestFocus();
            }
        });
    }
    public void _addOperationEventsButtons(final JButton b_nuevo,final JButton b_modificar,final JButton b_guardar,final JButton b_cancelar){
        b_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _OPERACION=_NUEVO;
                b_nuevo.setEnabled(false);
                b_guardar.setEnabled(true);
                _habilitarControlesDatos();
                _resetControls();
            }
        });
        b_modificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _OPERACION=_MODIFICAR;
                b_modificar.setEnabled(false);
                b_guardar.setEnabled(true);
                _habilitarControlesDatos();
            }
        });
        b_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(_isDatosValidosBE()){
                        _guardarCambiosOperacion();
                        b_nuevo.setEnabled(true);                        
                        b_modificar.setEnabled(false);                        
                        b_guardar.setEnabled(false);
                    }            
                } catch (Exception ex) {
                    Logger.getLogger(JPanelUC.class.getName()).log(Level.SEVERE, null,ex);
                }
            }
        });
        b_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b_modificar.setEnabled(false);
                b_nuevo.setEnabled(true);
                b_guardar.setEnabled(false);
                _resetControls();
                _deshabilitarControlesDatos();
                _OPERACION=_DESCONOCIDO;
            }
        });
    }
    public void _addOperationEventsButtons(final JButton b_nuevo,final JButton b_guardar,final JButton b_cancelar){
        b_nuevo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                _OPERACION=_NUEVO;
                b_nuevo.setEnabled(false);
                b_guardar.setEnabled(true);
                _habilitarControlesDatos();
            }
        });
        b_guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(_isDatosValidosBE()){
                        int rsp = _guardarCambiosOperacion();
                        if(rsp>=0){            
                            _resetControls();
                            _deshabilitarControlesDatos();
                            _OPERACION=_DESCONOCIDO;
                            _listarBEs();
                            b_nuevo.setEnabled(true);                        
                            b_guardar.setEnabled(false);
                            JOptionPane.showMessageDialog(JPanelUC.this,"Operacion exitosa.", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(JPanelUC.this,"Error operacion fallida.", "Error", JOptionPane.ERROR_MESSAGE);
                        }                        
                    }            
                } catch (Exception ex) {
                    Logger.getLogger(JPanelUC.class.getName()).log(Level.SEVERE, null,ex);
                }
            }
        });
        b_cancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b_nuevo.setEnabled(true);
                b_guardar.setEnabled(false);
                _resetControls();
                _deshabilitarControlesDatos();
                _OPERACION=_DESCONOCIDO;
            }
        });
    }
    public int _guardarCambiosOperacion() throws Exception{
        switch(getOPERACION()){
            case _NUEVO: 
                return _registrarBE();
            case _MODIFICAR: 
                return _guardarCambiosBE();
            default: return _DESCONOCIDO;
        }
    }

    public void _init() {
        try {
            _cargarCombos();
            _agregaValidadoresControl();
        } catch (Exception ex) {
            Logger.getLogger(JPanelUC.class.getName()).log(Level.SEVERE, null, ex);
        }
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentShown(ComponentEvent e) {
               _resetControls();
               _deshabilitarControlesDatos();
            }
            
        });
    }

    public int getOPERACION() {
        return _OPERACION;
    }

    public String getDepartamento() {
        return departamento;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getDistrito() {
        return distrito;
    }
}
