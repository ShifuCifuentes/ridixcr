package org.rx.cr.jpedalprint;

import java.awt.Component;
import java.awt.print.PageFormat;
import java.awt.print.Paper;
import java.awt.print.PrinterJob;
import java.io.File;
import javax.swing.JOptionPane;
import org.jpedal.PdfDecoder;

public class JPedalPrint {
    private String[] args;
    public JPedalPrint(String[] args) {
        this.args=args;
    }
    
    public void printer(Component parent) {
        if (args.length>0) {
            File pdfFile = new File(args[1]);
            if (pdfFile.exists()) {
                if (args[0].toLowerCase().equals("-d")) {               
                    PdfDecoder pdf = null;
                    try {
                        //PrintService[] service = PrinterJob.lookupPrintServices();
                        PrinterJob printJob = PrinterJob.getPrinterJob();
                        //printJob.setPrintService(service[0]);
                        Paper paper = new Paper();
                        paper.setSize(595, 842);//A4
                        paper.setImageableArea(0,0,595,842);
                        PageFormat pf = printJob.defaultPage();
                        pf.setPaper(paper);

                        pdf = new PdfDecoder(true);
                        pdf.openPdfFile(pdfFile.getAbsolutePath());
                        pdf.setPageFormat(pf);

                        printJob.setPageable(pdf);        
                        boolean aceptar_impresion = printJob.printDialog();
                        if (aceptar_impresion) {
                        printJob.print();
                        }        
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        pdf.closePdfFile();
                    }                             
                }else if(args[0].toLowerCase().equals("-s")){
                    PdfDecoder pdf = null;
                    try {
                        //PrintService[] service = PrinterJob.lookupPrintServices();
                        PrinterJob printJob = PrinterJob.getPrinterJob();
                        //printJob.setPrintService(service[0]);
                        Paper paper = new Paper();
                        paper.setSize(595, 842);//A4
                        paper.setImageableArea(0,0,595,842);
                        PageFormat pf = printJob.defaultPage();
                        pf.setPaper(paper);
                        pdf = new PdfDecoder(true);
                        pdf.openPdfFile(pdfFile.getAbsolutePath());
                        pdf.setPageFormat(pf);
                        printJob.setPageable(pdf);        
                        printJob.print();       
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        pdf.closePdfFile();
                    }              
                }
            }else{
                JOptionPane.showMessageDialog(parent,"Ningun Archivo que Imprimir","Atencion",JOptionPane.ERROR_MESSAGE);            
            }            
        } else {
           JOptionPane.showMessageDialog(parent,"Ningun Archivo que Imprimir","Atencion",JOptionPane.ERROR_MESSAGE);            
        }  
    }
    
}
