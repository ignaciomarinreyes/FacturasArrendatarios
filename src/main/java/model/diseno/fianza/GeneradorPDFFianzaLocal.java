package model.diseno.fianza;

import auxiliar.Meses;
import auxiliar.NumeroEnTexto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.awt.Font;
import java.text.DecimalFormat;
import java.time.LocalDate;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;

public class GeneradorPDFFianzaLocal extends GeneradorPDFFianza {

    private Document documento;
    private double precio;

    public GeneradorPDFFianzaLocal(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato) {
        super(arrendatario, inmueble, contrato);
    }

    @Override
    protected void escribirPDF(Document documento, int numeroMeses, LocalDate fechaFianza) {

        this.documento = documento;
        documento.open();
        this.precio = numeroMeses * contrato.getPrecio1Inmueble();
        try {
            rellenarTablaArrendador();
            this.documento.add(new Paragraph("\n\n\n\n\n\n\n\n\n\n"));
            rellenarContenido(fechaFianza, numeroMeses);
            this.documento.add(new Paragraph("\n\n\n\n\n\n"));
            rellenarTablaCentral();
            this.documento.add(new Paragraph("\n\n\n\n\n\n"));
            rellenarFirmaYFecha(fechaFianza);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        documento.close();
    }

    private void rellenarTablaArrendador() throws DocumentException {
        PdfPTable tablaArrendador = new PdfPTable(1);
        tablaArrendador.setWidthPercentage(31f);
        tablaArrendador.setHorizontalAlignment(Element.ALIGN_LEFT);
        PdfPCell cell1t = new PdfPCell(new Phrase("ARRENDADOR"));
        cell1t.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell1t.setPadding(5);
        PdfPCell cell2t = new PdfPCell(new Phrase(arrendador.getNombre() + " " + arrendador.getApellidos() + "\n"
                + arrendador.getNombreCalle() + " nº " + arrendador.getNumeroCalle() + "\n"
                + arrendador.getCodigoPostal() + " " + arrendador.getMunicipio() + "\n"
                + "NIF " + arrendador.getDni() + "\n"));
        cell2t.setPadding(5);
        tablaArrendador.addCell(cell1t);
        tablaArrendador.addCell(cell2t);
        documento.add(tablaArrendador);
    }

    private void rellenarContenido(LocalDate fechaFianza, int numeroMeses) throws DocumentException {
        NumeroEnTexto numero = new NumeroEnTexto();
        DecimalFormat decimal = new DecimalFormat("0.00");
        Paragraph contenido = new Paragraph();
        com.itextpdf.text.Font fuenteNegrita = new com.itextpdf.text.Font(com.itextpdf.text.Font.getFamily("ARIAL"), 12, com.itextpdf.text.Font.BOLD);//negrita
        com.itextpdf.text.Font fuenteNormal = new com.itextpdf.text.Font(com.itextpdf.text.Font.getFamily("ARIAL"), 12, com.itextpdf.text.Font.NORMAL);
        if (arrendatario.getApellidos() != null) { // es una persona física                    
            contenido.add(new Chunk("He recibido de ", fuenteNormal));
            contenido.add(new Chunk(arrendatario.getNombre(), fuenteNegrita));
            contenido.add(new Chunk(" ", fuenteNormal));
            contenido.add(new Chunk(arrendatario.getApellidos(), fuenteNegrita));
            contenido.add(new Chunk(" con NIF ", fuenteNormal));
            contenido.add(new Chunk(arrendatario.getDni(), fuenteNegrita));
            contenido.add(new Chunk(" la cantidad de ", fuenteNormal));
            contenido.add(new Chunk(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), false) + " euros ( " + decimal.format(contrato.getPrecio1Inmueble()) + " € )", fuenteNegrita));
            contenido.add(new Chunk(" en concepto de ", fuenteNormal));
            contenido.add(new Chunk("fianza ", fuenteNegrita));
            contenido.add(new Chunk("correspondiente a " + duracionFianza(numeroMeses), fuenteNormal));
            contenido.add(new Chunk(" del local de mi propiedad, situado en ", fuenteNormal));
            contenido.add(new Chunk(inmueble.getNombreCalle() + " nº " + inmueble.getNumeroCalle() , fuenteNegrita));
            contenido.add(new Chunk(" del término municipal de ", fuenteNormal));
            contenido.add(new Chunk(inmueble.getLocalidad(), fuenteNegrita));
            contenido.add(new Chunk(" correspondiente al mes de ", fuenteNormal));
            contenido.add(new Chunk(Meses.getMes(fechaFianza.getMonthValue()) + " de " + fechaFianza.getYear()  + ".", fuenteNegrita));
        } else { // es una persona jurídica
            contenido.add(new Chunk("He recibido de ", fuenteNormal));
            contenido.add(new Chunk(arrendatario.getNombre(), fuenteNegrita));
            contenido.add(new Chunk(" con NIF ", fuenteNormal));
            contenido.add(new Chunk(arrendatario.getDni(), fuenteNegrita));
            contenido.add(new Chunk(" la cantidad de ", fuenteNormal));
            contenido.add(new Chunk(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), false) + " euros ( " + decimal.format(contrato.getPrecio1Inmueble()) + " € )", fuenteNegrita));
            contenido.add(new Chunk(" en concepto de ", fuenteNormal));
             contenido.add(new Chunk("fianza ", fuenteNegrita));
            contenido.add(new Chunk("correspondiente a " + duracionFianza(numeroMeses), fuenteNormal));
            contenido.add(new Chunk("del local de mi propiedad, situado en ", fuenteNormal));
            contenido.add(new Chunk(inmueble.getNombreCalle() + " nº " + inmueble.getNumeroCalle(), fuenteNegrita));
            contenido.add(new Chunk(" del término municipal de ", fuenteNormal));
            contenido.add(new Chunk(inmueble.getLocalidad(), fuenteNegrita));
            contenido.add(new Chunk(" correspondiente al mes de ", fuenteNormal));
            contenido.add(new Chunk(Meses.getMes(fechaFianza.getMonthValue()) + " de " + fechaFianza.getYear()  + ".", fuenteNegrita));
        }
        contenido.setAlignment(Element.ALIGN_JUSTIFIED);
        documento.add(contenido);
    }

    private void rellenarTablaCentral() throws DocumentException {
        DecimalFormat decimal = new DecimalFormat("0.00");
        PdfPTable tablaCentral = new PdfPTable(2);
        tablaCentral.setWidthPercentage(65f);
        tablaCentral.setHorizontalAlignment(Element.ALIGN_CENTER);
        PdfPCell[] arrayCell = new PdfPCell[2];
        DecimalFormat format = new DecimalFormat("0.#");
        arrayCell[0] = new PdfPCell(new Phrase("Total"));
        arrayCell[1] = new PdfPCell(new Phrase(decimal.format(precio) + " €"));
        for (int i = 0; i < arrayCell.length; i++) {
            if (i % 2 == 0) {
                arrayCell[i].setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            } else {
                arrayCell[i].setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
            }
            arrayCell[i].setPadding(5);
            tablaCentral.addCell(arrayCell[i]);
        }
        documento.add(tablaCentral);
    }

    private void rellenarFirmaYFecha(LocalDate fechaFianza) throws DocumentException {
        Paragraph fechaYFirma = new Paragraph("En " + inmueble.getLocalidad() + " a 1 de " + Meses.getMes(fechaFianza.getMonthValue()) + " de " + fechaFianza.getYear() + "\nFirma");
        fechaYFirma.setAlignment(Element.ALIGN_CENTER);
        documento.add(fechaYFirma);
    }

    private String duracionFianza(int numeroMeses) {
        NumeroEnTexto numero = new NumeroEnTexto();
        if (numeroMeses > 1) {
            return NumeroEnTexto.convertirNumeroATextoEntero(numeroMeses, false) + " meses";
        } else {
            return "un mes";
        }
    }
}