package org.sysconpat.rx.gui.principal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.SwingConstants;
import org.pushingpixels.flamingo.api.common.*;
import org.pushingpixels.flamingo.api.common.popup.*;
import org.pushingpixels.flamingo.api.ribbon.*;
import org.pushingpixels.flamingo.api.ribbon.resize.*;
import org.rx.cr.conf.Config;
import org.rx.cr.gui.DesktopPanel;
import org.rx.cr.report.ReportGeneric;
import org.rx.cr.util.Utilitarios;
import static org.rx.cr.util.Utilitarios.*;
import org.rx.cr.util.gui.*;
import org.rx.cr.util.ribbon.UtilitariosRibbon;
import static org.rx.cr.util.ribbon.UtilitariosRibbon.*;
import org.sysconpat.rx.SysConPat;
import org.sysconpat.rx.be.*;
import org.sysconpat.rx.gui.ayuda.*;
import org.sysconpat.rx.gui.baja_bienes.*;
import org.sysconpat.rx.gui.bienes_activos.*;
import org.sysconpat.rx.gui.catalogo.*;
import org.sysconpat.rx.gui.contabilidad.*;
import org.sysconpat.rx.gui.locales.*;
import org.sysconpat.rx.gui.reportes.*;
import org.sysconpat.rx.gui.seguridad.*;
import org.sysconpat.rx.util.ResourceIDVendor;

public class Principal  extends JRibbonFrame{    
    static {
        JFrame.setDefaultLookAndFeelDecorated(true);
        JDialog.setDefaultLookAndFeelDecorated(true);        
    }
    
    private Config config;
        
    private RibbonApplicationMenuEntryPrimary menu_backup=null;
    private RibbonApplicationMenuEntrySecondary menu_backup_items[]=null;
    
    private RibbonApplicationMenuEntryPrimary menu_session=null;
    private RibbonApplicationMenuEntrySecondary menu_session_items[]=null;
       
    //public ConfigAdmin configAdmin;   
       
    private RibbonTask locales=null;
    private RibbonTask bienes_activos=null;
    private RibbonTask baja_bienes=null;
    private RibbonTask reportes=null;
    private RibbonTask contabilidad=null;
    private RibbonTask catalogo=null;
    private RibbonTask servicios=null;
    private RibbonTask seguridad=null;
    private RibbonTask ayuda=null;
      
    private DesktopPanel escritorio=null;
    
    private ArrayList<BEContenedor> modulos_cargados= null;
    
    public JIF_AdministrarLocalesEntidad adminLocal = null;
    public JIF_AdministrarAreasEntidad adminAreas = null;
    public JIF_AdministrarOficinasEntidad adminOficina = null;
    public JIF_AdministrarPersonalEntidad adminPersonal = null;
    public JIF_AdministrarBienes adminBienes = null;
    public JIF_TrasladarBienes traslBienes = null;
    public JIF_RegistrarUsuario regUsuario= null;
    public JIF_MantenerUsuario adminUsuario= null;
    public JIF_AdministrarBajaBienes adminBajaBienes = null;
    public JIF_GenerarReporteAsignacionBienesPatrimoniales genRepAsBp = null;    
    public JIF_GenerarReporteFormatoDatosBienes genRepFormDatBp = null;
    public JIF_GenerarReporteOtrosBP genRepOtrosBp = null;
    public JIF_GenerarReporteBienesPatrimonialesLocal genRepBpLoc=null;
    public JIF_GenerarReportePersonalLocal genRepPersLoc=null;
    public JIF_ConsultarCatalogo consCat=null;
    public JIF_ConsultarCatalogoDetallado consCatDet=null;
    private JIF_ActualizarCatalogo actuCat=null;
    private JIF_Depreciacion dep=null;
    private JIF_DepreciacionAnual depAnu=null;
    private JIF_DepreciacionIndividual depIndiv=null;
    
    private VisorPDF manualVisor=null;
    private JD_About about = null;
    private JD_Contacto contact = null;
    
    private BackupCreator bc = null;
    private BackupRestore br = null;
        
    public Principal() throws Exception {
        initComponent();   
    }

    private void initComponent() throws Exception {
        initWindow();
        initRibbonBar(); 
    }
    @SysConPat(author=RidixCr)
    private void initWindow() {
        setTitle(ResourceIDVendor.CLIENT_APP_ID);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setIconoVentana(this,"/org/sysconpat/rx/resource/SysRent.png");  
        setApplicationIcon(UtilitariosRibbon.getResizableIconFromResource("/org/sysconpat/rx/resource/SysRent.png"));
        setMinimumSize(new Dimension(800,600));   
        adaptarForma(this,15,15);
        addComponentListener(new ComponentListener() {
            //<editor-fold defaultstate="collapsed" desc="ComponentListener">           
            @Override
            public void componentResized(ComponentEvent e) {//Alternativa : ComponentAdapter
                formComponentResised(e);
            }
            @Override
            public void componentMoved(ComponentEvent e) {}
            @Override
            public void componentShown(ComponentEvent e) {}
            @Override
            public void componentHidden(ComponentEvent e) {}
            //</editor-fold>            
        });
        addWindowListener(new WindowListener() {//Alternativa : WindowAdapter
            //<editor-fold defaultstate="collapsed" desc="WindowListener">           
            @Override
            public void windowOpened(WindowEvent e) {}
            @Override
            public void windowClosing(WindowEvent e) {
                salir();
            }
            @Override
            public void windowClosed(WindowEvent e) {}
            @Override
            public void windowIconified(WindowEvent e) {}
            @Override
            public void windowDeiconified(WindowEvent e) {}
            @Override
            public void windowActivated(WindowEvent e) {}
            @Override
            public void windowDeactivated(WindowEvent e) {}  
            //</editor-fold>
        });
    }
    private void formComponentResised(ComponentEvent e) {
        centreaVentana(this);
    }
    public void salir(){     
       int op =  JOptionPane.showConfirmDialog(this,"Esta seguro que desea salir del sistema.","Atencion",JOptionPane.YES_NO_OPTION);        
       if (op==JOptionPane.YES_OPTION) {
            System.exit(0);
       } 
    }
    
    public Config getConfig() {
        return config;
    }
    public void setConfig(Config config) throws Exception {
        this.config = config;
        initContent();
    }
    public ArrayList<BEContenedor> getModulos_cargados() {
        return modulos_cargados;
    }
    public void setModulos_cargados(ArrayList<BEContenedor> modulos_cargados) {
        this.modulos_cargados = modulos_cargados;
        configuraInterfazSegunRoles();
    }
    public void setLoguin(JF_Loguin jFLoguin) {
        
    }
    public void configuraInterfazSegunRoles(){
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
        if (modulos_cargados.size()>0) {
            getRibbon().removeAllTasks(); 
            for (BEContenedor modulo : modulos_cargados) {
                if (modulo.getNombre().equals("Locales")) {
                    getRibbon().addTask(locales);
                }else if(modulo.getNombre().equals("Bienes Activos")){
                    getRibbon().addTask(bienes_activos);
                }else if(modulo.getNombre().equals("Baja de Bienes")){
                    getRibbon().addTask(baja_bienes);
                }else if(modulo.getNombre().equals("Reportes")){
                    getRibbon().addTask(reportes);
                }else if(modulo.getNombre().equals("Contabilidad")){
                    getRibbon().addTask(contabilidad);
                }else if(modulo.getNombre().equals("Catalogo")){
                    getRibbon().addTask(catalogo);
                }else if(modulo.getNombre().equals("Servicios")){
                    getRibbon().addTask(servicios);
                }else if(modulo.getNombre().equals("Seguridad")){
                    getRibbon().addTask(seguridad);
                }else if(modulo.getNombre().equals("Ayuda")){
                    getRibbon().addTask(ayuda);
                }                
            }    
        }else{
            getRibbon().removeAllTasks();    
        }   
       // menu_backup.setEnabled(false); 
        menu_session.setEnabled(false);
      //</editor-fold>
    } 
    private void initRibbonBar() {
        //<editor-fold defaultstate="collapsed" desc="initRibbonBar">      
        //<editor-fold defaultstate="collapsed" desc="Tool Tip">      
        RichTooltip dtt = new RichTooltip(ResourceIDVendor.APP_ID,"Menu de opciones basicas para el funcionamiento de todo el sistema "+ResourceIDVendor.APP_ID+" (Fuente de datos, manejo de accesos y cierre del sistema).");
                    dtt.addFooterSection("Click en el boton para mayor detalle.");
                    dtt.setMainImage(getIconFromResource("/org/sysconpat/rx/resource/MenuToolstipIcon_min.png").getImage());                    
                    dtt.setFooterImage(getIconFromResource("/org/sysconpat/rx/resource/help-browser.png").getImage());
        getRibbon().setApplicationMenuRichTooltip(dtt);
        getRibbon().setApplicationMenuKeyTip("S");
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Menu de Aplicacion">        
         RibbonApplicationMenu apm = new RibbonApplicationMenu();
         
         menu_backup = new RibbonApplicationMenuEntryPrimary(getResizableIconFromResource("/org/sysconpat/rx/resource/database_min.png"),"Backup "+ResourceIDVendor.APP_ID,new ActionListener() {
                        @Override public void actionPerformed(ActionEvent e) {}
                    },JCommandButton.CommandButtonKind.POPUP_ONLY);                    
                    menu_backup_items = new RibbonApplicationMenuEntrySecondary[2];                    
                    menu_backup_items[0]  = new RibbonApplicationMenuEntrySecondary(getResizableIconFromResource("/org/sysconpat/rx/resource/backup_min.png"),"Crear Copia de Seguridad",new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            backUpCraetor();
                        }
                    }, JCommandButton.CommandButtonKind.ACTION_ONLY);   
                    menu_backup_items[1] = new RibbonApplicationMenuEntrySecondary(getResizableIconFromResource("/org/sysconpat/rx/resource/backup_restore_min.png"),"Restaura Copia de Seguridad",new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            backUpRestorer();                          
                        }
                    }, JCommandButton.CommandButtonKind.ACTION_ONLY);  
         menu_backup.addSecondaryMenuGroup("Backup "+ResourceIDVendor.APP_ID,menu_backup_items);                    
         apm.addMenuEntry(menu_backup);    
         menu_session = new RibbonApplicationMenuEntryPrimary(getResizableIconFromResource("/org/sysconpat/rx/resource/key_min.png"),"Session "+ResourceIDVendor.APP_ID,new ActionListener() {
                        @Override public void actionPerformed(ActionEvent e) {}
                    },JCommandButton.CommandButtonKind.POPUP_ONLY);                    
                    menu_session_items = new RibbonApplicationMenuEntrySecondary[2];                    
                    menu_session_items[0] = new RibbonApplicationMenuEntrySecondary(getResizableIconFromResource("/org/sysconpat/rx/resource/login_min.png"),"Iniciar Sesion",new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            //jFLoguin.setVisible(true);
                        }
                    }, JCommandButton.CommandButtonKind.ACTION_ONLY);                    
                    menu_session_items[1]  = new RibbonApplicationMenuEntrySecondary(getResizableIconFromResource("/org/sysconpat/rx/resource/login_out_min.png"),"Cerrar Session",new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
//                            configuraInterfazDefecto();
//                            configuraIniciarSession();       
                              System.exit(0);
                        }
                    }, JCommandButton.CommandButtonKind.ACTION_ONLY);                       
         menu_session.addSecondaryMenuGroup("Session "+ResourceIDVendor.APP_ID,menu_session_items);                    
         apm.addMenuEntry(menu_session);  
         
         apm.addMenuEntry(new RibbonApplicationMenuEntryPrimary(getResizableIconFromResource("/org/sysconpat/rx/resource/About_min.png"),"About",new ActionListener() {
                @Override
                    public void actionPerformed(ActionEvent e) {
                          about.setVisible(true);
                    }
                }, JCommandButton.CommandButtonKind.ACTION_ONLY));
         
         
         apm.addFooterEntry(new RibbonApplicationMenuEntryFooter(getResizableIconFromResource("/org/sysconpat/rx/resource/exit_min.png"),"Salir",new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            salir();
                        }
                    }));
         getRibbon().setApplicationMenu(apm);                  
         //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Task Bar">
        JCommandButton button1_tsk = new JCommandButton("Contactos",getResizableIconFromResource("/org/sysconpat/rx/resource/contacts_min.png"));
        button1_tsk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               contact.setVisible(true);
            }
        });
        //getRibbon().addTaskbarComponent(button1_tsk);  
                
        getRibbon().addTaskbarComponent(new JSeparator(SwingConstants.VERTICAL)); 
        
        JCommandButton button2_tsk = new JCommandButton("About",getResizableIconFromResource("/org/sysconpat/rx/resource/About_min.png"));
        button2_tsk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              about.setVisible(true);
            }
        });
        getRibbon().addTaskbarComponent(button2_tsk);                       
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="TAB'S">
        //<editor-fold defaultstate="collapsed" desc="Primer TAB">
        JRibbonBand primer_tab_band[] = new JRibbonBand[1];   
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb1 = new JRibbonBand("Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/Urbano.png"));
        
        JCommandButton button1_tb1 = new JCommandButton("Administrar Locales",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarPedioUrbano.png"));
        button1_tb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminLocal);
            }
        });
        button1_tb1.setOpaque(true);
        button1_tb1.setBackground(Color.YELLOW);
        JCommandButton button2_tb1 = new JCommandButton("Administrar Areas",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarPedioUrbano.png"));
        button2_tb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminAreas);
            }
        });
        button2_tb1.setOpaque(true);
        button2_tb1.setBackground(Color.YELLOW);
        JCommandButton button3_tb1 = new JCommandButton("Administrar Oficinas",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarPedioRural.png"));
        button3_tb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminOficina);
            }
        });
        button3_tb1.setOpaque(true);
        button3_tb1.setBackground(Color.YELLOW);
        JCommandButton button4_tb1 = new JCommandButton("Administrar Personal",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarUsuario.png"));
        button4_tb1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminPersonal);
            }
        });
        button4_tb1.setOpaque(true);
        button4_tb1.setBackground(Color.YELLOW);
        primera_banda_tb1.addCommandButton(button1_tb1,RibbonElementPriority.TOP);
        primera_banda_tb1.addCommandButton(button2_tb1,RibbonElementPriority.TOP);
        primera_banda_tb1.addCommandButton(button3_tb1,RibbonElementPriority.TOP);
        primera_banda_tb1.addCommandButton(button4_tb1,RibbonElementPriority.TOP);
        
        primera_banda_tb1.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb1.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb1.getControlPanel())));
        primera_banda_tb1.setOpaque(true);
        primera_banda_tb1.setBackground(Color.YELLOW);
        primer_tab_band[0]=primera_banda_tb1;
        //</editor-fold> 
        this.locales = new RibbonTask("Locales",primer_tab_band);
        //</editor-fold>   
        //<editor-fold defaultstate="collapsed" desc="Segundo TAB">
        JRibbonBand segundo_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb2 = new JRibbonBand("Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/LicenciaFuncionamiento.png"));
        
        JCommandButton button1_tb2 = new JCommandButton("Administracion de Bienes",getResizableIconFromResource("/org/sysconpat/rx/resource/RegistrarLicenciaFuncionamiento.png"));       
        button1_tb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminBienes);
            }
        });         
        button1_tb2.setOpaque(true);
        button1_tb2.setBackground(new Color(1,132,205));
        button1_tb2.setForeground(Color.WHITE);
        JCommandButton button2_tb2 = new JCommandButton("Traslado de Bienes",getResizableIconFromResource("/org/sysconpat/rx/resource/RegistrarLicenciaFuncionamiento.png"));       
        button2_tb2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(traslBienes);
            }
        }); 
        button2_tb2.setOpaque(true);
        button2_tb2.setBackground(new Color(1,132,205));
        button2_tb2.setForeground(Color.WHITE);
        primera_banda_tb2.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb2.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb2.getControlPanel())));
        
        primera_banda_tb2.addCommandButton(button1_tb2,RibbonElementPriority.TOP);
        primera_banda_tb2.addCommandButton(button2_tb2,RibbonElementPriority.TOP);
        primera_banda_tb2.setOpaque(true);
        primera_banda_tb2.setBackground(new Color(1,132,205));
        segundo_tab_band[0]=primera_banda_tb2;
        //</editor-fold>        
        this.bienes_activos = new RibbonTask("Bienes Activos",segundo_tab_band);          
        //</editor-fold>       
        //<editor-fold defaultstate="collapsed" desc="Tercer TAB">        
        JRibbonBand tercer_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb3 = new JRibbonBand("Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/Tributo.png"));
                
        JCommandButton button1_tb3 = new JCommandButton("Administrar Bajas",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
        button1_tb3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(adminBajaBienes);
            }
        });
        button1_tb3.setOpaque(true);
        button1_tb3.setBackground(new Color(160,120,46));
        button1_tb3.setForeground(Color.WHITE);
        primera_banda_tb3.addCommandButton(button1_tb3,RibbonElementPriority.TOP);  
        
        primera_banda_tb3.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb3.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb3.getControlPanel())));
        primera_banda_tb3.setOpaque(true);
        primera_banda_tb3.setBackground(new Color(160,120,46));
        tercer_tab_band[0]=primera_banda_tb3;
        //</editor-fold>
        this.baja_bienes = new RibbonTask("Baja de Bienes",tercer_tab_band);  
        //</editor-fold> 
        //<editor-fold defaultstate="collapsed" desc="Cuarto TAB">
        JRibbonBand sexto_tab_band[] = new JRibbonBand[2];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb6 = new JRibbonBand("Bienes",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoCaja.png"));
        JRibbonBand segunda_banda_tb6 = new JRibbonBand("Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoCaja.png"));
         
        JCommandButton button1_tb6 = new JCommandButton("Formato de Asignacion Bs",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoAdministrativo.png"));
        button1_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(genRepAsBp);
            }
        });
        button1_tb6.setOpaque(true);
        button1_tb6.setBackground(new Color(240,117,2));
        button1_tb6.setForeground(Color.WHITE);
        JCommandButton button2_tb6 = new JCommandButton("Formato de Datos Bs",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button2_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              insertarInternalFrames(genRepFormDatBp);
            }
        });         
        button2_tb6.setOpaque(true);
        button2_tb6.setBackground(new Color(240,117,2));
        button2_tb6.setForeground(Color.WHITE);
        JCommandButton button3_tb6 = new JCommandButton("Bienes Activos",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button3_tb6.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);
        button3_tb6.setPopupCallback(new PopupPanelCallback() {
        @Override
        public JPopupPanel getPopupPanel(JCommandButton commandButton) {
        return new PopUpMenu(PopUpMenu.BIENES_ACTIVOS);
        }
        });
        button3_tb6.setOpaque(true);
        button3_tb6.setBackground(new Color(240,117,2));
        button3_tb6.setForeground(Color.WHITE);
        JCommandButton button4_tb6 = new JCommandButton("Formato de Bs",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button4_tb6.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);
        button4_tb6.setPopupCallback(new PopupPanelCallback() {
        @Override
        public JPopupPanel getPopupPanel(JCommandButton commandButton) {
        return new PopUpMenu(PopUpMenu.FORMATO_BIENES);
        }
        });
        button4_tb6.setOpaque(true);
        button4_tb6.setBackground(new Color(240,117,2));
        button4_tb6.setForeground(Color.WHITE);
        JCommandButton button5_tb6 = new JCommandButton("Bienes por Local",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button5_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              insertarInternalFrames(genRepBpLoc);
            }
        }); 
        button5_tb6.setOpaque(true);
        button5_tb6.setBackground(new Color(240,117,2));
        button5_tb6.setForeground(Color.WHITE);
        JCommandButton button6_tb6 = new JCommandButton("Bienes Dados de Baja",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button6_tb6.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);
        button6_tb6.setPopupCallback(new PopupPanelCallback() {
        @Override
        public JPopupPanel getPopupPanel(JCommandButton commandButton) {
        return new PopUpMenu(PopUpMenu.BIENES_DADOS_BAJA);
        }
        });
        button6_tb6.setOpaque(true);
        button6_tb6.setBackground(new Color(240,117,2));
        button6_tb6.setForeground(Color.WHITE);
        JCommandButton button7_tb6 = new JCommandButton("Locales de la Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button7_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              generarReporteLocalesEntidad();
            }
        }); 
        button7_tb6.setOpaque(true);
        button7_tb6.setBackground(new Color(240,117,2));
        button7_tb6.setForeground(Color.WHITE);
        JCommandButton button8_tb6 = new JCommandButton("Areas de la Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button8_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              generarReporteAreasEntidad();
            }

            
        }); 
        button8_tb6.setOpaque(true);
        button8_tb6.setBackground(new Color(240,117,2));
        button8_tb6.setForeground(Color.WHITE);
        JCommandButton button9_tb6 = new JCommandButton("Personal de la Entidad",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button9_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              insertarInternalFrames(genRepPersLoc);
            }
        }); 
        button9_tb6.setOpaque(true);
        button9_tb6.setBackground(new Color(240,117,2));
        button9_tb6.setForeground(Color.WHITE);
        JCommandButton button10_tb6 = new JCommandButton("Estadisticas",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button10_tb6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              
            }
        }); 
        button10_tb6.setOpaque(true);
        button10_tb6.setBackground(new Color(240,117,2)); 
        button10_tb6.setForeground(Color.WHITE);
        primera_banda_tb6.addCommandButton(button1_tb6,RibbonElementPriority.TOP);
        primera_banda_tb6.addCommandButton(button2_tb6,RibbonElementPriority.TOP);      
        primera_banda_tb6.addCommandButton(button3_tb6,RibbonElementPriority.TOP);      
        primera_banda_tb6.addCommandButton(button4_tb6,RibbonElementPriority.TOP);      
        primera_banda_tb6.addCommandButton(button5_tb6,RibbonElementPriority.TOP);      
        primera_banda_tb6.addCommandButton(button6_tb6,RibbonElementPriority.TOP);
        
        segunda_banda_tb6.addCommandButton(button7_tb6,RibbonElementPriority.TOP);      
        segunda_banda_tb6.addCommandButton(button8_tb6,RibbonElementPriority.TOP);      
        segunda_banda_tb6.addCommandButton(button9_tb6,RibbonElementPriority.TOP);      
        //segunda_banda_tb6.addCommandButton(button10_tb6,RibbonElementPriority.TOP);      
        
        primera_banda_tb6.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb6.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb6.getControlPanel())));
        segunda_banda_tb6.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(segunda_banda_tb6.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(segunda_banda_tb6.getControlPanel())));
        primera_banda_tb6.setOpaque(true);
        primera_banda_tb6.setBackground(new Color(240,117,2));
        sexto_tab_band[0]=primera_banda_tb6;
        segunda_banda_tb6.setOpaque(true);
        segunda_banda_tb6.setBackground(new Color(240,117,2));
        sexto_tab_band[1]=segunda_banda_tb6;
        //</editor-fold>
        this.reportes = new RibbonTask("Reportes",sexto_tab_band); 
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Quinto TAB">
        JRibbonBand septimo_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb7 = new JRibbonBand("Contabilidad",getResizableIconFromResource("/org/sysconpat/rx/resource/Configuracion.png"));
        
        JCommandButton button1_tb7 = new JCommandButton("Depreciacion",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button1_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              insertarInternalFrames(dep);
            }
        });
        button1_tb7.setOpaque(true);
        button1_tb7.setBackground(new Color(124,188,25));
        button1_tb7.setForeground(Color.WHITE);
        JCommandButton button2_tb7 = new JCommandButton("Depreciacion Anual",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button2_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              insertarInternalFrames(depAnu);
            }
        });
        button2_tb7.setOpaque(true);
        button2_tb7.setBackground(new Color(124,188,25));     
        button2_tb7.setForeground(Color.WHITE);
        JCommandButton button3_tb7 = new JCommandButton("Depreciacion Individual",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button3_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(depIndiv);
            }
        });
        button3_tb7.setOpaque(true);
        button3_tb7.setBackground(new Color(124,188,25)); 
        button3_tb7.setForeground(Color.WHITE);
        JCommandButton button4_tb7 = new JCommandButton("Resumen Depreciacion",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button4_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
                generarReporteResumenDepreciacion();
            }
        });
        button4_tb7.setOpaque(true);
        button4_tb7.setBackground(new Color(124,188,25)); 
        button4_tb7.setForeground(Color.WHITE);
        JCommandButton button5_tb7 = new JCommandButton("Resumen Contable",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button5_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                generarReporteResumenContable();
            }
        });
        button5_tb7.setOpaque(true);
        button5_tb7.setBackground(new Color(124,188,25)); 
        button5_tb7.setForeground(Color.WHITE);
        JCommandButton button6_tb7 = new JCommandButton("Vehiculos",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button6_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                generarInventarioVehicular();
            }
        });
        button6_tb7.setOpaque(true);
        button6_tb7.setBackground(new Color(124,188,25));
        button6_tb7.setForeground(Color.WHITE);
        JCommandButton button7_tb7 = new JCommandButton("Activo Fijo",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button7_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                generarReporteFormatoBsAF();
            }
        });
        button7_tb7.setOpaque(true);
        button7_tb7.setBackground(new Color(124,188,25)); 
        button7_tb7.setForeground(Color.WHITE);
        JCommandButton button8_tb7 = new JCommandButton("Cuentas de Orden",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button8_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                generarReporteFormatoBsCO();
            }
        });
        button8_tb7.setOpaque(true);
        button8_tb7.setBackground(new Color(124,188,25)); 
        button8_tb7.setForeground(Color.WHITE);
        JCommandButton button9_tb7 = new JCommandButton("Consolidacion",getResizableIconFromResource("/org/sysconpat/rx/resource/PagoTributario.png"));
        button9_tb7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                generarReporteConciliacion();
            }
        });
        button9_tb7.setOpaque(true);
        button9_tb7.setBackground(new Color(124,188,25)); 
        button9_tb7.setForeground(Color.WHITE);
        primera_banda_tb7.addCommandButton(button1_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button2_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button3_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button4_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button5_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button6_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button7_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button8_tb7,RibbonElementPriority.TOP);
        primera_banda_tb7.addCommandButton(button9_tb7,RibbonElementPriority.TOP);
        
        primera_banda_tb7.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb7.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb7.getControlPanel())));
        primera_banda_tb7.setOpaque(true);
        primera_banda_tb7.setBackground(new Color(124,188,25)); 
        septimo_tab_band[0]=primera_banda_tb7;
        //</editor-fold>        
        this.contabilidad = new RibbonTask("Contabilidad",septimo_tab_band);          
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Sexto TAB">
        JRibbonBand report_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tbr = new JRibbonBand("Catalogo",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        
        JCommandButton button1_tbr = new JCommandButton("Consulta de Catalogo",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        button1_tbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(consCat);             
            }
        });
        button1_tbr.setOpaque(true);
        button1_tbr.setBackground(new Color(67,59,143)); 
        button1_tbr.setForeground(Color.WHITE);
        JCommandButton button3_tbr = new JCommandButton("Consulta de Catalogo Detallado",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        button3_tbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(consCatDet);             
            }
        });
        button3_tbr.setOpaque(true);
        button3_tbr.setBackground(new Color(67,59,143)); 
        button3_tbr.setForeground(Color.WHITE);
//        JCommandButton button4_tbr = new JCommandButton("Buscar Clasificadores",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
//        button4_tbr.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                            
//            }
//        });
        JCommandButton button5_tbr = new JCommandButton("Actualizar Catalogo",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        button5_tbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               insertarInternalFrames(actuCat);             
            }
        });
        button5_tbr.setOpaque(true);
        button5_tbr.setBackground(new Color(67,59,143)); 
        button5_tbr.setForeground(Color.WHITE);
        JCommandButton button6_tbr = new JCommandButton("Etiquetado Manual",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        button6_tbr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                            
            }
        });
        button6_tbr.setOpaque(true);
        button6_tbr.setBackground(new Color(67,59,143)); 
        button6_tbr.setForeground(Color.WHITE);
        primera_banda_tbr.addCommandButton(button1_tbr,RibbonElementPriority.TOP);
        //primera_banda_tbr.addCommandButton(button2_tbr,RibbonElementPriority.TOP);
        primera_banda_tbr.addCommandButton(button3_tbr,RibbonElementPriority.TOP);
        //primera_banda_tbr.addCommandButton(button4_tbr,RibbonElementPriority.TOP);
        primera_banda_tbr.addCommandButton(button5_tbr,RibbonElementPriority.TOP);
        //primera_banda_tbr.addCommandButton(button6_tbr,RibbonElementPriority.TOP);
        
        primera_banda_tbr.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tbr.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tbr.getControlPanel())));
        primera_banda_tbr.setOpaque(true);
        primera_banda_tbr.setBackground(new Color(67,59,143)); 
        report_tab_band[0]=primera_banda_tbr;
        //</editor-fold>        
        this.catalogo = new RibbonTask("Catalogo",report_tab_band);          
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Septimo TAB">
        JRibbonBand sept_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tbsept = new JRibbonBand("Base de Datos",getResizableIconFromResource("/org/sysconpat/rx/resource/RealizarOrdenPagoDT.png"));
        
        JCommandButton button1_tbsept = new JCommandButton("Crear Backup BD",getResizableIconFromResource("/org/sysconpat/rx/resource/backup_min.png"));
        button1_tbsept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               backUpCraetor();                
            }
        });        
        button1_tbsept.setOpaque(true);
        button1_tbsept.setBackground(new Color(101,91,143));
        button1_tbsept.setForeground(Color.WHITE);
        JCommandButton button2_tbsept = new JCommandButton("Restaurar Backup BD",getResizableIconFromResource("/org/sysconpat/rx/resource/backup_restore_min.png"));
        button2_tbsept.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backUpRestorer();                
            }
        });       
        button2_tbsept.setOpaque(true);
        button2_tbsept.setBackground(new Color(101,91,143));
        button2_tbsept.setForeground(Color.WHITE);
        primera_banda_tbsept.addCommandButton(button1_tbsept,RibbonElementPriority.TOP);
        primera_banda_tbsept.addCommandButton(button2_tbsept,RibbonElementPriority.TOP);
        
        primera_banda_tbsept.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tbsept.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tbsept.getControlPanel())));
        primera_banda_tbsept.setOpaque(true);
        primera_banda_tbsept.setBackground(new Color(101,91,143));
        sept_tab_band[0]=primera_banda_tbsept;
        //</editor-fold>        
        this.servicios = new RibbonTask("Servicios",sept_tab_band);          
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Octabo TAB">
        JRibbonBand octavo_tab_band[] = new JRibbonBand[1];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb8 = new JRibbonBand("Usuario",getResizableIconFromResource("/org/sysconpat/rx/resource/Seguridad.png"));
        
        JCommandButton button1_tb8 = new JCommandButton("Registrar",getResizableIconFromResource("/org/sysconpat/rx/resource/RegistrarUsuario.png"));
        button1_tb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              escritorio.insertarInternalFrame(regUsuario);
            }
        });
        JCommandButton button2_tb8 = new JCommandButton("Mantener",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarUsuario.png"));
        button2_tb8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               escritorio.insertarInternalFrame(adminUsuario);
            }
        }); 
        primera_banda_tb8.addCommandButton(button1_tb8,RibbonElementPriority.TOP);
        primera_banda_tb8.addCommandButton(button2_tb8,RibbonElementPriority.TOP);
        
        primera_banda_tb8.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb8.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb8.getControlPanel())));
        
        octavo_tab_band[0]=primera_banda_tb8;
        //</editor-fold>
        this.seguridad = new RibbonTask("Seguridad",octavo_tab_band);                   
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Noveno TAB">
        JRibbonBand noveno_tab_band[] = new JRibbonBand[2];
        //<editor-fold defaultstate="collapsed" desc="Primera Banda">
        JRibbonBand primera_banda_tb9 = new JRibbonBand("Ayuda "+ResourceIDVendor.APP_ID,getResizableIconFromResource("/org/sysconpat/rx/resource/About_min.png"));
        
        JCommandButton button1_tb9 = new JCommandButton("Manual",getResizableIconFromResource("/org/sysconpat/rx/resource/help_min.png"));
        button1_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               manualVisor.visualizarManual();
            }
        });       
        JCommandButton button2_tb9 = new JCommandButton("Contactos",getResizableIconFromResource("/org/sysconpat/rx/resource/contacts_min.png"));
        button2_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               contact.setVisible(true);
            }
        });
        JCommandButton button3_tb9 = new JCommandButton("About",getResizableIconFromResource("/org/sysconpat/rx/resource/About_min.png"));
        button3_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               about.setVisible(true);
            }
        });    
        
        primera_banda_tb9.addCommandButton(button1_tb9,RibbonElementPriority.TOP);
        //primera_banda_tb9.addCommandButton(button2_tb9,RibbonElementPriority.TOP);
        primera_banda_tb9.addCommandButton(button3_tb9,RibbonElementPriority.TOP);
        
        primera_banda_tb9.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(primera_banda_tb9.getControlPanel()),                            
                            new CoreRibbonResizePolicies.Mirror(primera_banda_tb9.getControlPanel()),                            
                            new IconRibbonBandResizePolicy(primera_banda_tb9.getControlPanel())));
        
        noveno_tab_band[0]=primera_banda_tb9;
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Segunda Banda">
        JRibbonBand segunda_banda_tb9 = new JRibbonBand("Utilidades",getResizableIconFromResource("/org/sysconpat/rx/resource/Utilidades.png"));
        
        JCommandButton button4_tb9 = new JCommandButton("Bloc de Notas",getResizableIconFromResource("/org/sysconpat/rx/resource/txt.png"));
        button4_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ejecutarNotepad();
            }
        });
        JCommandButton button5_tb9 = new JCommandButton("WordPad",getResizableIconFromResource("/org/sysconpat/rx/resource/wordpad.png"));
        button5_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarWordPad();
            }
         });
        JCommandButton button6_tb9 = new JCommandButton("Calculadora",getResizableIconFromResource("/org/sysconpat/rx/resource/calc.png"));
        button6_tb9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ejecutarCalc();
            }
        });
        JCommandButton button7_tb9 = new JCommandButton("Microsoft Office",getResizableIconFromResource("/org/sysconpat/rx/resource/office2010.png"));
        button7_tb9.setCommandButtonKind(JCommandButton.CommandButtonKind.ACTION_AND_POPUP_MAIN_ACTION);
        
        RichTooltip mainRichTooltip = new RichTooltip();
        mainRichTooltip.setTitle("Microsoft Office");
        mainRichTooltip.addDescriptionSection("Suite Office Basico");
        button7_tb9.setActionRichTooltip(mainRichTooltip);
        button7_tb9.setPopupKeyTip("O");
        
         button7_tb9.setPopupCallback(new PopupPanelCallback() {
        @Override
        public JPopupPanel getPopupPanel(JCommandButton commandButton) {
        return new PopUpMenu(PopUpMenu.MSOFFICE);
        }
        });
                       
        segunda_banda_tb9.addCommandButton(button4_tb9,RibbonElementPriority.TOP);
        segunda_banda_tb9.addCommandButton(button5_tb9,RibbonElementPriority.TOP);
        segunda_banda_tb9.addCommandButton(button6_tb9,RibbonElementPriority.TOP);
        segunda_banda_tb9.addCommandButton(button7_tb9,RibbonElementPriority.TOP);
        
        segunda_banda_tb9.setResizePolicies((List) Arrays.asList(
                            new CoreRibbonResizePolicies.None(segunda_banda_tb9.getControlPanel()),                            
                            new CoreRibbonResizePolicies.Mirror(segunda_banda_tb9.getControlPanel()), 
                            new CoreRibbonResizePolicies.Mid2Low(segunda_banda_tb9.getControlPanel()),
                            new IconRibbonBandResizePolicy(segunda_banda_tb9.getControlPanel())));
        
        noveno_tab_band[1]=segunda_banda_tb9;
        //</editor-fold>
        this.ayuda = new RibbonTask("Ayuda",noveno_tab_band);                  
        //</editor-fold>
        //</editor-fold>
        //<editor-fold defaultstate="collapsed" desc="Ayuda">
        getRibbon().configureHelp(getResizableIconFromResource("/org/sysconpat/rx/resource/help-browser.png"),new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                 manualVisor.visualizarManual();
            }
        });
        //</editor-fold>
        //</editor-fold>  
    }
    private void backUpCraetor(){
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
       if(bc!=null){
           bc.validaCreacionBackUp();
       }else{
           bc = new BackupCreator(Principal.this,getConfig());                   
            Utilitarios.centreaVentana(bc);
            Utilitarios.setIconoVentana(bc,"/org/sysconpat/rx/resource/SysRent_Min.png");  
            bc.validaCreacionBackUp();
       }
       //</editor-fold>
    }
    private void backUpRestorer() {
        //<editor-fold defaultstate="collapsed" desc="Cuerpo">
       if(br!=null){
           br.validaRestauracionBackUp();
       }else{                  
            br = new BackupRestore(Principal.this,getConfig());
            Utilitarios.centreaVentana(br);
            Utilitarios.setIconoVentana(br,"/org/sysconpat/rx/resource/SysRent_Min.png");
            br.validaRestauracionBackUp();
       }   
        //</editor-fold>  
    }
    //<editor-fold defaultstate="collapsed" desc="Genracion de Reportes">
    public void generarReporteGeneralBA() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales","Bienes Patrimoniales Resumen");        
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }
    public void generarReporteDetalladoBA() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_detallado","Bienes Patrimoniales Detallado");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }
    public void generarReporteFormatoBsAF() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_activo_fijo","Bienes Patrimoniales Activo Fijo");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsCO() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_cuentas_orden","Bienes Patrimoniales Cuentas de Orden");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsEnTransito() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_entransito","Bienes Patrimoniales en Transito");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteFormatoBsInvGeneral() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_detallado","Bienes Patrimoniales Inventario General");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteBienesPatrimonialesBaja() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_dados_baja","Bienes Patrimoniales dados de Baja");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteBienesPatrimonialesBajaDetallado() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("bienes_patrimoniales_dados_baja_detallado","Bienes Patrimoniales dados de Baja Detallado");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    public void generarReporteLocalesEntidad() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("locales_entidad","Locales de la Entidad");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);         
    }    
    private void generarReporteAreasEntidad() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("areas_entidad","Areas de la Entidad");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteResumenDepreciacion() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("resumen_depreciacion","Resumen de Depreciacion");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteResumenContable() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("resumen_contable","Resumen Contable");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);   
    }    
    private void generarInventarioVehicular() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("reporte_vehiculos","Inventario Vehicular");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);   
    }    
    private void generarReporteConciliacion() {
        ReportGeneric report = new ReportGeneric(getConfig());
        report.setReportParent("/org/sysconpat/rx/report/");
        JInternalFrame reportFrame;        
        reportFrame = report.mkReportToInternalFrame("reporte_consolidacion","Conciliacion");  
        Utilitarios.setIconoVentana(reportFrame,"/org/sysconpat/rx/resource/SysRent_Min.png");
        insertarInternalFrames(reportFrame);   
    }    
    //</editor-fold>
    private class PopUpMenu extends JCommandPopupMenu {
        public static final int MSOFFICE=1,
                                BIENES_ACTIVOS=2,
                                FORMATO_BIENES=3,
                                BIENES_DADOS_BAJA=4,
                                LISTADO_BIENES=5;
        public PopUpMenu(int op) {
            initPopUpMenu(op);
        }        
        private void initPopUpMenu(int op){
            //<editor-fold defaultstate="collapsed" desc="initPopUpMenu"> 
            if (op==MSOFFICE) {
                        JCommandMenuButton menuButton1 = new JCommandMenuButton("Microsoft Word",getResizableIconFromResource("/org/sysconpat/rx/resource/MSWord.png"));
                        menuButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ejecutarMSWord();                    
                            }
                        });
                        addMenuButton(menuButton1);
                        JCommandMenuButton menuButton2 = new JCommandMenuButton("Microsoft Excel",getResizableIconFromResource("/org/sysconpat/rx/resource/MSExcel.png"));
                        menuButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ejecutarMSExcel();                    
                            }
                        });
                         addMenuButton(menuButton2);
                        JCommandMenuButton menuButton3 = new JCommandMenuButton("Microsoft PowerPoint",getResizableIconFromResource("/org/sysconpat/rx/resource/MSPowerPoint.png"));
                        menuButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                ejecutarMSPowerPoint();                    
                            }
                        });
                         addMenuButton(menuButton3);
            } else if(op==BIENES_ACTIVOS){
                        JCommandMenuButton menuButton1 = new JCommandMenuButton("General",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
                        menuButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteGeneralBA();
                            }
                        });
                        addMenuButton(menuButton1);
                        JCommandMenuButton menuButton2 = new JCommandMenuButton("Detallado",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
                        menuButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteDetalladoBA();
                            }
                        });
                         addMenuButton(menuButton2);                
                        JCommandMenuButton menuButton3 = new JCommandMenuButton("Otros Reportes",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
                        menuButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                insertarInternalFrames(genRepOtrosBp);
                            }
                        });
                         addMenuButton(menuButton3);                
            } else if(op==BIENES_DADOS_BAJA){
                        JCommandMenuButton menuButton1 = new JCommandMenuButton("General",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
                        menuButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteBienesPatrimonialesBaja();
                            }
                        });
                        addMenuButton(menuButton1);
                        JCommandMenuButton menuButton2 = new JCommandMenuButton("Detallado",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
                        menuButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteBienesPatrimonialesBajaDetallado();
                            }
                        });
                         addMenuButton(menuButton2);                
//                        JCommandMenuButton menuButton3 = new JCommandMenuButton("Consolidado",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
//                        menuButton2.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//
//                            }
//                        });
//                         addMenuButton(menuButton3);                
//                        JCommandMenuButton menuButton4 = new JCommandMenuButton("Otros Reportes",getResizableIconFromResource("/org/sysconpat/rx/resource/FraccionarDeudaTributaria.png"));
//                        menuButton2.addActionListener(new ActionListener() {
//                            @Override
//                            public void actionPerformed(ActionEvent e) {
//
//                            }
//                        });
//                         addMenuButton(menuButton4);                
            } else if(op==FORMATO_BIENES){
                        JCommandMenuButton menuButton1 = new JCommandMenuButton("Activos Fijos",getResizableIconFromResource("/org/sysconpat/rx/resource/RegistrarClienteAgua.png"));
                        menuButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteFormatoBsAF();
                            }
                        });
                        addMenuButton(menuButton1);
                        JCommandMenuButton menuButton2 = new JCommandMenuButton("Cuentas de Orden",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarClienteAgua.png"));
                        menuButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteFormatoBsCO();
                            }
                        });
                         addMenuButton(menuButton2);                
                        JCommandMenuButton menuButton3 = new JCommandMenuButton("Bienes en Transito",getResizableIconFromResource("/org/sysconpat/rx/resource/ImprimirReciboAguaCliente.png"));
                        menuButton3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteFormatoBsEnTransito();
                            }
                        });
                         addMenuButton(menuButton3);  
                        JCommandMenuButton menuButton4 = new JCommandMenuButton("Inventario General",getResizableIconFromResource("/org/sysconpat/rx/resource/ImprimirReciboAguaCliente.png"));
                        menuButton4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                generarReporteFormatoBsInvGeneral();
                            }
                        });
                         addMenuButton(menuButton4);  
            }else if(op==LISTADO_BIENES){
                        JCommandMenuButton menuButton1 = new JCommandMenuButton("Ordenados por Denominacion",getResizableIconFromResource("/org/sysconpat/rx/resource/RegistrarClienteAgua.png"));
                        menuButton1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            }
                        });
                        addMenuButton(menuButton1);
                        JCommandMenuButton menuButton2 = new JCommandMenuButton("Ordenados por Codigo",getResizableIconFromResource("/org/sysconpat/rx/resource/ModificarClienteAgua.png"));
                        menuButton2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                            }
                        });                          
            }                  
            //</editor-fold>
        }
    }
    
    private void initContent() throws Exception {
        //<editor-fold defaultstate="collapsed" desc="initContent">
        escritorio = new DesktopPanel();
        escritorio.quitaPanelesInfo();
        escritorio.setImageApp("/org/sysconpat/rx/resource/APP_Icon.png");
        escritorio.setAppName(ResourceIDVendor.APP_ID);
        getContentPane().add(escritorio);
        pack();
        Utilitarios.maximizar(this);
        //<editor-fold defaultstate="collapsed" desc="Internal Frames">                
            adminLocal = new JIF_AdministrarLocalesEntidad(this);
            Utilitarios.setIconoVentana(adminLocal,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminAreas = new JIF_AdministrarAreasEntidad(this);
            Utilitarios.setIconoVentana(adminAreas,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminOficina = new JIF_AdministrarOficinasEntidad(this);
            Utilitarios.setIconoVentana(adminOficina,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminPersonal = new JIF_AdministrarPersonalEntidad(this);
            Utilitarios.setIconoVentana(adminPersonal,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminBienes = new JIF_AdministrarBienes(this);
            Utilitarios.setIconoVentana(adminBienes,"/org/sysconpat/rx/resource/SysRent_Min.png");
            traslBienes = new JIF_TrasladarBienes(this);
            Utilitarios.setIconoVentana(traslBienes,"/org/sysconpat/rx/resource/SysRent_Min.png");
            regUsuario = new JIF_RegistrarUsuario(this);
            Utilitarios.setIconoVentana(regUsuario,"/org/sysconpat/rx/resource/SysRent_Min.png");
            adminUsuario = new JIF_MantenerUsuario(this);
            Utilitarios.setIconoVentana(adminUsuario,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            adminBajaBienes = new JIF_AdministrarBajaBienes(this);
            Utilitarios.setIconoVentana(adminBajaBienes,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            about = new JD_About(this);
            Utilitarios.setIconoVentana(about,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            contact = new JD_Contacto(this);
            Utilitarios.setIconoVentana(contact,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepAsBp = new JIF_GenerarReporteAsignacionBienesPatrimoniales(this);
            Utilitarios.setIconoVentana(genRepAsBp,"/org/sysconpat/rx/resource/SysRent_Min.png");             
            genRepFormDatBp = new JIF_GenerarReporteFormatoDatosBienes(this);
            Utilitarios.setIconoVentana(genRepFormDatBp,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepOtrosBp = new JIF_GenerarReporteOtrosBP(this);
            Utilitarios.setIconoVentana(genRepOtrosBp,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepBpLoc = new JIF_GenerarReporteBienesPatrimonialesLocal(this);
            Utilitarios.setIconoVentana(genRepBpLoc,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            genRepPersLoc = new JIF_GenerarReportePersonalLocal(this);
            Utilitarios.setIconoVentana(genRepPersLoc,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            consCat = new JIF_ConsultarCatalogo(this);
            Utilitarios.setIconoVentana(consCat,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            consCatDet = new JIF_ConsultarCatalogoDetallado(this);
            Utilitarios.setIconoVentana(consCatDet,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            actuCat = new JIF_ActualizarCatalogo(this);
            Utilitarios.setIconoVentana(actuCat,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            dep = new JIF_Depreciacion(this);
            Utilitarios.setIconoVentana(dep,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            depAnu = new JIF_DepreciacionAnual(this);
            Utilitarios.setIconoVentana(depAnu,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            depIndiv = new JIF_DepreciacionIndividual(this);
            Utilitarios.setIconoVentana(depIndiv,"/org/sysconpat/rx/resource/SysRent_Min.png"); 
            manualVisor = new VisorPDF();
            manualVisor.setManual_name("Manual.pdf");
            Utilitarios.setIconoVentana(manualVisor,"/org/sysconpat/rx/resource/SysRent_Min.png");            
        //</editor-fold>    
        setVisible(true); 
        //</editor-fold>
    }
    
    public void insertarInternalFrames(JInternalFrame jif){
       escritorio.insertarInternalFrame(jif);       
    }
}
