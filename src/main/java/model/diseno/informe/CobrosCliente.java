package model.diseno.informe;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import persistence.DataBase;

public class CobrosCliente {

    public CobrosCliente(LocalDate fechaInicio, LocalDate fechaFin) {
        crearPDF(fechaInicio, fechaFin);
    }

    public void crearPDF(LocalDate fechaInicio, LocalDate fechaFin) {
        Document documento = crearArchivo(System.getProperty("java.io.tmpdir") + "/cobros.pdf");
        escribirPDF(documento, fechaInicio, fechaFin);
        abrirArchivo();
    }

    private com.itextpdf.text.Document crearArchivo(String nombrePDF) {
        com.itextpdf.text.Document documento = new com.itextpdf.text.Document(PageSize.A4);
        FileOutputStream ficheroPDF = null;
        try {
            ficheroPDF = new FileOutputStream(nombrePDF);
            PdfWriter.getInstance(documento, ficheroPDF);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace();
        }
        return documento;
    }

    private void escribirPDF(Document documento, LocalDate fechaInicio, LocalDate fechaFin) {
        documento.open();
        try {
            rellenarFechas(documento, fechaInicio, fechaFin);
            documento.add(new Paragraph("\n\n\n"));
            rellenarTablaCentral(documento, fechaInicio, fechaFin);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
        documento.close();
    }

    public void abrirArchivo() {
        File archivo = new File(System.getProperty("java.io.tmpdir") + "/cobros.pdf");
        Desktop deskTop = Desktop.getDesktop();
        try {
            deskTop.open(archivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void rellenarTablaCentral(Document documento, LocalDate fechaInicio, LocalDate fechaFin) throws DocumentException {
        PdfPTable tablaCobrosClientes = new PdfPTable(4);
        tablaCobrosClientes.setHorizontalAlignment(Element.ALIGN_LEFT);
        anadirCelda(new PdfPCell(new Phrase("DNI")), tablaCobrosClientes);
        anadirCelda(new PdfPCell(new Phrase("Nombre")), tablaCobrosClientes);
        anadirCelda(new PdfPCell(new Phrase("Apellidos")), tablaCobrosClientes);
        anadirCelda(new PdfPCell(new Phrase("Cobrado")), tablaCobrosClientes);
        ArrayList<model.CobrosCliente> cobrosClientes = DataBase.selectSumCobrosCadaCliente(fechaInicio, fechaFin);
        for (model.CobrosCliente cobrosCliente : cobrosClientes) {
            anadirCelda(new PdfPCell(new Phrase(cobrosCliente.getDni())), tablaCobrosClientes);
            anadirCelda(new PdfPCell(new Phrase(cobrosCliente.getNombre())), tablaCobrosClientes);
            anadirCelda(new PdfPCell(new Phrase(cobrosCliente.getApellidos())), tablaCobrosClientes);
            anadirCelda(new PdfPCell(new Phrase(String.valueOf(cobrosCliente.getCobrado()))), tablaCobrosClientes);
        }
        tablaCobrosClientes.setWidths(new float[]{8f, 8f, 8f, 8f});
        documento.add(tablaCobrosClientes);
    }

    private void rellenarFechas(Document documento, LocalDate fechaInicio, LocalDate fechaFin) throws DocumentException {
        documento.add(new Paragraph("Inicio: " + fechaInicio));
        documento.add(new Paragraph("Fin: " + fechaFin));
    }

    private void anadirCelda(PdfPCell cell1t, PdfPTable tablaCobrosClientes) {
        cell1t.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
        cell1t.setPadding(5);
        tablaCobrosClientes.addCell(cell1t);
    }

}