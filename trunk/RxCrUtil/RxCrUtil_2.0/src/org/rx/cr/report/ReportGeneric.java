
package org.rx.cr.report;

import java.awt.Frame;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JRViewer;
import org.rx.cr.conf.Config;
import org.rx.cr.db.DBA;
import org.rx.cr.ds.DSConeccion;
import org.rx.cr.util.Utilitarios;

public class ReportGeneric {    
    
    private String reportParent;
    private Connection connection;
    public ReportGeneric(Connection connection) {
        this.connection = connection;
    }
    public ReportGeneric(Config conf) {
        this.connection=(new DSConeccion(conf.getHost(),conf.getPort(),conf.getDb(),conf.getUser(),conf.getPassword())).getConeccion();
    }
    
    public JPanel mkReport(String nomRef){
        try {
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef + ".jasper"));               
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,(Map)new HashMap(), connection);                   
            connection.close();
            return new JRViewer(jasperPrint);
        } catch (Exception ex) {
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
    public JPanel mkReport(String nomRef,Map prmt){
        try {
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef + ".jasper"));               
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,prmt, connection);                   
            connection.close();
            return new JRViewer(jasperPrint);
        } catch (Exception ex) {
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
    public JInternalFrame mkReportToInternalFrame(String report_name,String frame_title){
        JInternalFrame reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name); 
            reportFrame= new JInternalFrame(); 
            Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setClosable(true);
            reportFrame.setResizable(true);
            reportFrame.setIconifiable(true);
            reportFrame.setMaximizable(true);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.addComponentListener(new ComponentAdapter() {                
                @Override
                public void componentShown(ComponentEvent e) {
                    try {
                        JInternalFrame tmp = (JInternalFrame)e.getComponent();
                        tmp.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
        }catch (Exception ex) {
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportFrame;
    }
    public JInternalFrame mkReportToInternalFrame(String report_name,String[] keys,Object[] values,String frame_title){
        JInternalFrame reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name, keys, values); 
            reportFrame= new JInternalFrame();                        
            Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setClosable(true);
            reportFrame.setIconifiable(true);
            reportFrame.setResizable(true);
            reportFrame.setMaximizable(true);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.addComponentListener(new ComponentAdapter() {                
                @Override
                public void componentShown(ComponentEvent e) {
                    try {
                        JInternalFrame tmp = (JInternalFrame)e.getComponent();
                        tmp.setMaximum(true);
                    } catch (PropertyVetoException ex) {
                        Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            
        }catch (Exception ex) {
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportFrame;
    }
    public JDialog mkReportToDialog(String report_name,String frame_title,Frame parent){                
        JPanel report_panel = mkReport(report_name); 
        JDialog reportFrame= new JDialog(parent, true); 
        Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);            
            reportFrame.setSize(800,600);             
            reportFrame.addComponentListener(new ComponentAdapter(){                
                @Override
                public void componentShown(ComponentEvent e) {
                    JDialog tmp = (JDialog)e.getComponent();
                    Utilitarios.maximizar(tmp);
                    tmp.setLocationRelativeTo(null);
                }
            });
            reportFrame.addWindowListener(new WindowAdapter() {               
                @Override
                public void windowClosing(WindowEvent e) {
                    JDialog tmp = (JDialog)e.getComponent();
                    tmp.dispose();
                } 
            });
        return reportFrame;
    }
    public JDialog mkReportToDialog(String report_name,String[] keys,Object[] values,String frame_title,Frame parent){
        JDialog reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name, keys, values); 
            reportFrame= new JDialog(parent, true); 
            Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.setSize(800,600);
            reportFrame.setModal(true);
            reportFrame.addComponentListener(new ComponentAdapter(){                
                @Override
                public void componentShown(ComponentEvent e) {
                    JDialog tmp = (JDialog)e.getComponent();
                    Utilitarios.maximizar(tmp);
                    tmp.setLocationRelativeTo(null);
                }
            });
            reportFrame.addWindowListener(new WindowAdapter() {               
                @Override
                public void windowClosing(WindowEvent e) {
                    JDialog tmp = (JDialog)e.getComponent();
                    tmp.dispose();
                } 
            });
            
        }catch (Exception ex) {
            Logger.getLogger(ReportGeneric.class.getName()).log(Level.SEVERE, null, ex);
        }
        return reportFrame;
    }
    public JFrame mkReportToFrame(String report_name,String frame_title){                
        JPanel report_panel = mkReport(report_name); 
        JFrame reportFrame= new JFrame();
            Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);            
            reportFrame.setSize(800,600);            
            reportFrame.addComponentListener(new ComponentAdapter(){                
                @Override
                public void componentShown(ComponentEvent e) {
                    JFrame tmp = (JFrame)e.getComponent();
                    Utilitarios.maximizar(tmp);
                    tmp.setLocationRelativeTo(null);
                }
            });
            reportFrame.addWindowListener(new WindowAdapter() {               
                @Override
                public void windowClosing(WindowEvent e) {
                    JFrame tmp = (JFrame)e.getComponent();
                    tmp.dispose();
                } 
            });
        return reportFrame;
    }
    public JFrame mkReportToFrame(String report_name,String[] keys,Object[] values,String frame_title){
        JFrame reportFrame=null;
        try {
            JPanel report_panel = mkReport(report_name, keys, values); 
            reportFrame= new JFrame(); 
            Utilitarios.setIconoVentana(reportFrame,"/org/rx/cr/resource/report.png");
            reportFrame.setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
            reportFrame.getContentPane().add(report_panel);
            reportFrame.setTitle(frame_title);
            reportFrame.setSize(800,600);
            reportFrame.addComponentListener(new ComponentAdapter(){                
                @Override
                public void componentShown(ComponentEvent e) {
                    JFrame tmp = (JFrame)e.getComponent();
                    Utilitarios.maximizar(tmp);
                    tmp.setLocationRelativeTo(null);
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
    public JPanel mkReport(String nomRef,String[] keys,Object[] values){
        try {
            JasperReport jasperReport = (JasperReport)JRLoader.loadObject(getClass().getResource(getReportParent()+nomRef + ".jasper"));               
            Map paramet = new HashMap();
              if (keys.length == values.length && keys!=null && values!=null) {
                  for (int i = 0; i < values.length; i++) {
                     paramet.put(keys[i],values[i]);
                  }
              } else {
                connection.close();
                throw new Exception("Parametros Invalidos(Llaves y Valores cantidades diferentes) o Nulos");
              }      
            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport,paramet, connection);                   
            connection.close();
            return new JRViewer(jasperPrint);
        } catch (Exception ex) {
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
