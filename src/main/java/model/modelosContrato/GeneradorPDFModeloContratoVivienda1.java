/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.modelosContrato;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfContentByte;
import java.text.DecimalFormat;
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
        
        absText("AGÜIMES", 175.74792F, 629.62165F); 
        absText("1", 311.81083F, 629.62165F); 
        absText("ENERO", 368.5037F, 629.62165F); 
        absText("2018", 481.88946F, 629.62165F);
        
        absText("CARIDAD REYES MOSEGUEZ", 204.09436F, 532.58234F); 
        absText("ESPAÑOLA", 184.25185F, 520.07841F); 
        absText("AVDA. POLIZON, 24", 402.51943F, 520.07841F);
        absText("ARINAGA", 170.07863F, 509.90519F);
        absText("AGÜIMES", 368.5037F, 509.90519F);
        absText("42883415F", 198.42507F, 498.56661F); 
        absText("- - - - -", 496.06268F, 498.56661F); 
        absText("CARIDADMOSEGUEZ@GMAIL.COM", 283.4643884F, 490.0626796F);
        
        absText("MARIA ISABEL MENA HERNANDEZ", 212.5982913F, 372.6769243F); 
        absText("ESPAÑOLA", 184.2518524F, 358.5037049F); 
        absText("C. JUAN DE CARDONA, 6", 402.5194315F, 358.5037049F);
        absText("ARINAGA", 170.078633F, 347.1651293F);
        absText("AGÜIMES", 368.5037049F, 347.1651293F);
        absText("42206869Y", 198.4250719F, 335.8265538F);
        absText("- - - - -", 496.0626796F, 335.8265538F);
        
        absText("1º", 425.1965826F, 53.70074098F);
        absText("A", 524.4091185F, 53.70074098F);
        absText("C. COLON", 340.157266F, 42.36216544F);
        absText("27", 311.8108272F, 33.85823379F);
        absText("AGÜIMES", 425.1965826F, 33.85823379F);
        absText("LAS PALMAS", 425.1965826F, 22.51965826F);
        //documento.newPage();
        //absText("hola", 2000, 40);
        documento.close();
    }  
}
