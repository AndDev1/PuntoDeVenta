/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.puntodeventa.global.report.viewer;


import com.puntodeventa.global.Entity.Corte;
import com.puntodeventa.global.Entity.Usuario;
import com.puntodeventa.global.Util.LogHelper;
import com.puntodeventa.global.Util.ParamHelper;
import com.puntodeventa.global.printservice.printService;
import com.puntodeventa.global.report.DataSource.CorteDS;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author Nato
 */
public class printCorte {
    LogHelper objLog = new LogHelper("CorteDAO");
    static JasperReport Reporte;
    static JasperPrint impresion;
    static JasperViewer jviewer;
    static String pathImage = System.getProperty("user.dir") + "/src/images/";
    static Corte corteList;
    static CorteDS corteDS;
    
    public boolean printCorte(Corte corte, Usuario user) {
        CorteDS corteDS = new CorteDS();
        String pathImage = System.getProperty("user.dir") + "/src/images/";

        String id_folio = String.valueOf(corte.getId_folio());
        corte.getFecha();
        corte.getEfvoInicial();
        corte.getTotal_preciocompra();
        corte.getEfvoCaja();
        corte.getNumero_de_ventas();
        corte.getId_usuario();
        /*
         * @Params nombre del usuario
         * @@Params logo
         */
        String nameUser = user.getNombre();
        
        Map param = new HashMap();
        param.put("logo", pathImage + "splash1.jpg");
        param.put("usuario", nameUser);

        corteDS.addCompraList(corte);

        try {
            String archivo = System.getProperty("user.dir") + "/src/com/puntodeventa/global/report/File/Corte.jasper";
            Reporte = (JasperReport) JRLoader.loadObject(archivo);
            JasperPrint jasperPrint = (JasperPrint) JasperFillManager.fillReport(Reporte, param, corteDS);
            JRExporter exporter = new JRPdfExporter();
            exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
            exporter.setParameter(JRExporterParameter.OUTPUT_FILE, new java.io.File(ParamHelper.getParam("cashout.path.location").toString().replace("_folio_", id_folio)));
            exporter.exportReport();
            corteDS.cleanBean();
            System.out.println("Cut finished...");
            return true;
        } catch (JRException ex) {
            objLog.Log("while printing Corte. JRException:" + ex.getMessage());
            return false;
        }
    }    
    
}
