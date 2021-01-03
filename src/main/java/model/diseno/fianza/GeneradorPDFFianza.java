package model.diseno.fianza;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;

public abstract class GeneradorPDFFianza {

    protected final Arrendatario arrendatario;
    protected final Inmueble inmueble;
    protected final Contrato contrato;

    public GeneradorPDFFianza(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato) {
        this.arrendatario = arrendatario;
        this.inmueble = inmueble;
        this.contrato = contrato;
    }

    public void crearPDF(int numeroMeses, LocalDate fechaFianza) {
        Document documento = crearArchivo(System.getProperty("java.io.tmpdir") + "/" + "fianzas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + ".pdf");
        escribirPDF(documento, numeroMeses, fechaFianza);
    }

    public void crearCarpeta() {
        File directorio = new File(System.getProperty("java.io.tmpdir") + "/" + "fianzas/");
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public void abrirArchivo() {
        File archivo = new File(System.getProperty("java.io.tmpdir") + "/" + "fianzas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + ".pdf");
        Desktop deskTop = Desktop.getDesktop();
        try {
            deskTop.open(archivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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

    protected abstract void escribirPDF(Document documento, int numeroMeses, LocalDate fechaFianza);
}
