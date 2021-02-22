/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.modelosContrato;

import auxiliar.Meses;
import auxiliar.NumeroEnTexto;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;

/**
 *
 * @author ignacio
 */
public class GeneradorPDFModeloContratoVivienda1 extends GeneradorPDFModeloContrato{

    public GeneradorPDFModeloContratoVivienda1(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato, int numeroModel) {
        super(arrendatario, inmueble, contrato, numeroModel);
        crearPDF();  
        abrirArchivo();
    }
    
    @Override
    protected void escribirPDF() {
        documento.open();
        LocalDate hoy = LocalDate.now();
        absText(inmueble.getLocalidad().toUpperCase(), 175.74792F, 629.62165F); 
        absText("1", 311.81083F, 629.62165F); 
        absText(Meses.getMes(hoy.getMonthValue()).toUpperCase(), 368.5037F, 629.62165F); 
        absText("" + hoy.getYear(), 496.88946F, 629.62165F);
        
        absText(arrendador.getNombre().toUpperCase() + " " + arrendador.getApellidos().toUpperCase(), 204.09436F, 538.58234F); 
        absText(arrendador.getNacionalidad().toUpperCase(), 184.25185F, 526.07841F); 
        absText(arrendador.getNombreCalle().toUpperCase() + ", " + arrendador.getNumeroCalle().toUpperCase(), 414.51943F, 526.07841F);
        absText(arrendador.getLocalidad().toUpperCase(), 170.07863F, 515.90519F);
        absText(arrendador.getMunicipio().toUpperCase(), 368.5037F, 515.90519F);
        absText(arrendador.getDni().toUpperCase(), 198.42507F, 503.56661F); 
        absText("- - - - -", 496.06268F, 503.56661F); 
        absText(arrendador.getEmail().toUpperCase(), 283.4643884F, 490.0626796F);
        
        absText(arrendatario.getNombre().toUpperCase() + " " + arrendatario.getApellidos().toUpperCase(), 212.5982913F, 372.6769243F); 
        absText(arrendatario.getNacionalidad().toUpperCase(), 184.2518524F, 358.5037049F); 
        absText(arrendatario.getNombreCalle().toUpperCase() + ", " + arrendatario.getNumeroCalle().toUpperCase(), 402.5194315F, 358.5037049F);
        absText(arrendatario.getNacionalidad().toUpperCase(), 170.078633F, 347.1651293F);
        absText(arrendatario.getMunicipio().toUpperCase(), 368.5037049F, 347.1651293F);
        absText(arrendatario.getDni().toUpperCase(), 198.4250719F, 334.8265538F);
        absText("- - - - -", 496.0626796F, 334.8265538F);
        
        absText(inmueble.getNumeroInmueble() != null ? inmueble.getNumeroInmueble().toUpperCase() + " ª": "", 425.1965826F, 41.70074098F);
        absText(inmueble.getLetraInmueble() != null ? inmueble.getLetraInmueble().toUpperCase(): "", 536.4091185F, 41.70074098F);
        absText(inmueble.getNombreCalle().toUpperCase(), 340.157266F, 30.36216544F);
        absText(inmueble.getNumeroCalle(), 311.8108272F, 15.85823379F);
        absText(inmueble.getLocalidad().toUpperCase(), 437.1965826F, 15.85823379F);
        absText("LAS PALMAS", 326.1965826F, 4.51965826F);
        documento.newPage();
        absText("" + contrato.getDuracionContrato(), 340.1965826F, 538.5823379F);
        
        double precioAnual = contrato.getPrecio1Inmueble() * 12;
        DecimalFormat df = new DecimalFormat("#.##");
        absText(NumeroEnTexto.convertirNumeroATextoDouble(precioAnual, true).toUpperCase(), 413.1965826F, 297.70074098F);
        absText(df.format(precioAnual), 184.1965826F, 283.70074098F);
        absText(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), true).toUpperCase(), 198.1965826F, 269.70074098F);
        absText(df.format(contrato.getPrecio1Inmueble()), 450.1965826F, 269.70074098F);
        
        documento.newPage();
        absText(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), true).toUpperCase(), 198.1965826F, 762.70074098F);
        absText(df.format(contrato.getPrecio1Inmueble()), 155.1965826F, 748.70074098F);
        
        absText("ARRENDATARIO", 198.1965826F, 468.70074098F);
        absText("ARRENDATARIO", 487.1965826F, 459.70074098F);
        
        documento.newPage();
        absText(" ", 113.1965826F, 606.70074098F);
        
        documento.newPage();
        absText("A) RECIBOS DE AGUA Y LUZ CORRESPONDEN AL ARRENDATARIO", 113.1965826F, 606.70074098F);
        absText("B) PISO COMPLETAMENTE AMUEBLADO", 113.1965826F, 594.70074098F);
        absText("C) LOS PAGOS SE EFECTUARAN EN EL BANCO SANTANDER", 113.1965826F, 582.36216544F);
        absText("     NUM. CUENTA 7900491751902290021318", 113.1965826F, 570.85823379F);
        absText("     DEL 1 AL 15 DE CADA MES", 113.1965826F, 558.85823379F);
        absText("TELF. CARIDAD: 609226895", 113.1965826F, 546.51965826F);
        
        documento.close();
    }  
}

/*
@Override
    protected void escribirPDF() {
        documento.open();
        
        absText("AGÜIMES", 175.74792F, 629.62165F); 
        absText("1", 311.81083F, 629.62165F); 
        absText("ENERO", 368.5037F, 629.62165F); 
        absText("2018", 496.88946F, 629.62165F);
        
        absText("CARIDAD REYES MOSEGUEZ", 204.09436F, 538.58234F); 
        absText("ESPAÑOLA", 184.25185F, 526.07841F); 
        absText("AVDA. POLIZON, 24", 414.51943F, 526.07841F);
        absText("ARINAGA", 170.07863F, 515.90519F);
        absText("AGÜIMES", 368.5037F, 515.90519F);
        absText("42883415F", 198.42507F, 503.56661F); 
        absText("- - - - -", 496.06268F, 503.56661F); 
        absText("CARIDADMOSEGUEZ@GMAIL.COM", 283.4643884F, 490.0626796F);
        
        absText("MARIA ISABEL MENA HERNANDEZ", 212.5982913F, 372.6769243F); 
        absText("ESPAÑOLA", 184.2518524F, 358.5037049F); 
        absText("C. JUAN DE CARDONA, 6", 402.5194315F, 358.5037049F);
        absText("ARINAGA", 170.078633F, 347.1651293F);
        absText("AGÜIMES", 368.5037049F, 347.1651293F);
        absText("42206869Y", 198.4250719F, 334.8265538F);
        absText("- - - - -", 496.0626796F, 334.8265538F);
        
        absText("1º", 425.1965826F, 41.70074098F);
        absText("A", 536.4091185F, 41.70074098F);
        absText("C. COLON", 340.157266F, 30.36216544F);
        absText("27", 311.8108272F, 15.85823379F);
        absText("AGÜIMES", 437.1965826F, 15.85823379F);
        absText("LAS PALMAS", 326.1965826F, 4.51965826F);
        documento.newPage();
        absText("1", 340.1965826F, 538.5823379F);
        
        absText("Seis mil seiscientos", 413.1965826F, 297.70074098F);
        absText("6600", 184.1965826F, 283.70074098F);
        absText("Quinientos cincuenta", 198.1965826F, 269.70074098F);
        absText("550", 450.1965826F, 269.70074098F);
        
        documento.newPage();
        absText("Quinientos cincuenta", 198.1965826F, 762.70074098F);
        absText("550", 155.1965826F, 748.70074098F);
        
        absText("ARRENDATARIO", 198.1965826F, 468.70074098F);
        absText("ARRENDATARIO", 487.1965826F, 459.70074098F);
        
        documento.newPage();
        absText(" ", 113.1965826F, 606.70074098F);
        
        documento.newPage();
        absText("A) RECIBOS DE AGUA Y LUZ CORRESPONDEN AL ARRENDATARIO", 113.1965826F, 606.70074098F);
        absText("B) PISO COMPLETAMENTE AMUEBLADO", 113.1965826F, 594.70074098F);
        absText("C) LOS PAGOS SE EFECTUARAN EN EL BANCO SANTANDER", 113.1965826F, 582.36216544F);
        absText("     NUM. CUENTA 7900491751902290021318", 113.1965826F, 570.85823379F);
        absText("     DEL 1 AL 15 DE CADA MES", 113.1965826F, 558.85823379F);
        absText("TELF. CARIDAD: 609226895", 113.1965826F, 546.51965826F);
        
        documento.close();
    }  
*/
