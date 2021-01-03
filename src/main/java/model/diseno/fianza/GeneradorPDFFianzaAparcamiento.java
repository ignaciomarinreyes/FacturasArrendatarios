package model.diseno.fianza;

import auxiliar.Meses;
import auxiliar.NumeroEnTexto;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import java.awt.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import java.text.DecimalFormat;
import java.time.LocalDate;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;

public class GeneradorPDFFianzaAparcamiento extends GeneradorPDFFianza {

    private Document documento;
    private double precio;

    public GeneradorPDFFianzaAparcamiento(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato) {
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
        PdfPCell cell2t = new PdfPCell(new Phrase("Caridad Reyes Moséguez\n"
                + "Avda.Polizón nº 24\n"
                + "35118 Agüimes\n"
                + "NIF 42883415F\n"));
        cell2t.setPadding(5);
        tablaArrendador.addCell(cell1t);
        tablaArrendador.addCell(cell2t);
        documento.add(tablaArrendador);
    }

    private void rellenarContenido(LocalDate fechaFianza, int numeroMeses) throws DocumentException {
        NumeroEnTexto numero = new NumeroEnTexto();
        Paragraph contenido = null;
        DecimalFormat decimal = new DecimalFormat("0.00");
        if (arrendatario.getApellidos() != null) { // es una persona física
            contenido = new Paragraph("He recibido de " + arrendatario.getNombre() + " " + arrendatario.getApellidos() + " con NIF " + arrendatario.getDni() + " la "
                    + "cantidad de " + NumeroEnTexto.convertirNumeroATextoDouble(precio, false) + " euros ( " + decimal.format(precio) + " € ) en concepto de fianza correspondiente a " + duracionFianza(numeroMeses) + " del aparcamiento de mi propiedad, situado "
                    + "en " + inmueble.getNombreCalle() + " nº " + inmueble.getNumeroCalle() + ", del término municipal de " + inmueble.getLocalidad() + " correspondiente al mes de " + Meses.getMes(fechaFianza.getMonthValue()) + " de "
                    + fechaFianza.getYear() + ".", FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK));
        } else { // es una persona jurídica
            contenido = new Paragraph("He recibido de " + arrendatario.getNombre() + " con NIF " + arrendatario.getDni() + " la "
                    + "cantidad de " + NumeroEnTexto.convertirNumeroATextoDouble(precio, false) + " euros ( " + decimal.format(precio) + " € ) en concepto de fianza correspondiente a " + duracionFianza(numeroMeses) + " del aparcamiento de mi propiedad, situado "
                    + "en " + inmueble.getNombreCalle() + " nº " + inmueble.getNumeroCalle() + ", del término municipal de " + inmueble.getLocalidad() + " correspondiente al mes de " + Meses.getMes(fechaFianza.getMonthValue()) + " de "
                    + fechaFianza.getYear() + ".", FontFactory.getFont("arial", 12, Font.PLAIN, BaseColor.BLACK));
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