
package org.rx.cr.report;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyVetoException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import org.rx.cr.util.Utilitarios;

public class ReportGeneric {
    
    JPanel jp = new JPanel();
    private String reportParent;

    private Connection connection;

    public ReportGeneric(Connection connection) {
        this.connection = connection;
    }

    public JPanel mkReport(String nomRef) throws JRException{
        try {
            JasperReport jasperReport = (JasperReport) JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef + ".jasper"));                                              
            connection.close();
            return new JRViewer(JasperFillManager.fillReport(jasperReport,new HashMap(), connection));
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public JPanel mkReport(String nomRef,Map prmt) throws JRException{
        try {
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef+".jasper"));                   
            connection.close();
            return new JRViewer(JasperFillManager.fillReport(jasperReport, prmt,connection));
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    public JInternalFrame mkReportToInternalFrame(String report_name,String[] keys,Object[] values,String frame_title){
        JInternalFrame reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name, keys, values); 
            reportFrame= new JInternalFrame();            
            //reportFrame.setFrameIcon(im);
            reportFrame.setClosable(true);
            reportFrame.setIconifiable(true);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.addComponentListener(new ComponentListener() {
                @Override
                public void componentResized(ComponentEvent e) {}
                @Override
                public void componentMoved(ComponentEvent e) {}
                @Override
                public void componentShown(ComponentEvent e) {
                    try {
                        JInternalFrame tmp = (JInternalFrame)e.getComponent();
                        tmp.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                @Override
                public void componentHidden(ComponentEvent e) {}
            });
            
        }catch (Exception ex) {
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportFrame;
    }
    public JFrame mkReportToFrame(String report_name,String[] keys,Object[] values,String frame_title){
        JFrame reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name, keys, values); 
            reportFrame= new JFrame();   
            reportFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.setSize(800,600);
            reportFrame.addComponentListener(new ComponentAdapter(){                
                @Override
                public void componentShown(ComponentEvent e) {
                    JFrame tmp = (JFrame)e.getComponent();
                    Utilitarios.maximizar(tmp);
                }
            });
            reportFrame.addWindowListener(new WindowAdapter() {               
                @Override
                public void windowClosing(WindowEvent e) {
                    JFrame tmp = (JFrame)e.getComponent();
                    tmp.dispose();
                } 
            });
            
        }catch (Exception ex) {
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportFrame;
    }
    public JPanel mkReport(String nomRef,String[] keys,Object[] values) throws JRException, Exception{
        try {
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef+".jasper"));
            Map paramet = new HashMap();
              if (keys.length == values.length && keys!=null && values!=null) {
                  for (int i = 0; i < values.length; i++) {
                     paramet.put(keys[i],values[i]);
                  }
              } else {
                connection.close();
                throw new Exception("Parametros Invalidos(Llaves y Valores cantidades diferentes) o Nulos");
              }      
            connection.close();
            return new JRViewer(JasperFillManager.fillReport(jasperReport,paramet,connection));
        } catch (SQLException ex) {
            try {
                connection.close();
            } catch (SQLException ex1) {
                Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex1);
                return null;
            }
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String getReportParent() {
        return reportParent;
    }

    public void setReportParent(String reportParent) {
        this.reportParent = reportParent;
    }
}
