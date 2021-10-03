package model.diseno.factura;

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
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Arrendatario;
import model.Configuracion;
import model.Contrato;
import model.Inmueble;
import model.Arrendador;
import org.apache.pdfbox.multipdf.PDFMergerUtility;
import static persistence.DataBase.selectArrendadorByIdArrendador;


public abstract class GeneradorPDFFactura {

    protected final Arrendatario arrendatario;
    protected final Inmueble inmueble;
    protected final Contrato contrato;
    protected Configuracion configuracion;
    protected Boolean prueba;
    protected Arrendador arrendador;

    public GeneradorPDFFactura(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato, Configuracion configuracion, Boolean version) {
        this.arrendatario = arrendatario;
        this.inmueble = inmueble;
        this.contrato = contrato;
        this.configuracion = configuracion;
        this.prueba = version;
        this.arrendador = selectArrendadorByIdArrendador(contrato.getIdArrendador());
    }

    public String crearPDF(int numeroFactura, LocalDate fechaFactura) {
        String rutaDocumento = System.getProperty("java.io.tmpdir") + "/" + "facturas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "/" + (prueba ? "prueba" : "normal") + "/" + fechaFactura.toString() + "_" + numeroFactura + ".pdf";
        Document documento = crearArchivo(rutaDocumento);
        escribirPDF(documento, numeroFactura, fechaFactura);
        return rutaDocumento;
    }

    public void crearCarpeta() {
        File directorio = new File(System.getProperty("java.io.tmpdir") + "/" + "facturas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "/" + (prueba ? "prueba" : "normal"));
        if (!directorio.exists()) {
            if (directorio.mkdirs()) {
                System.out.println("Directorio creado");
            } else {
                System.out.println("Error al crear directorio");
            }
        }
    }

    public void abrirCarpeta() {
        File directorio = new File(System.getProperty("java.io.tmpdir") + "/" + "facturas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "/" + (prueba ? "prueba" : "normal"));
        Desktop deskTop = Desktop.getDesktop();
        try {
            deskTop.open(directorio);
        } catch (IOException ex) {
            Logger.getLogger(GeneradorPDFFactura.class.getName()).log(Level.SEVERE, null, ex);
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

    protected abstract void escribirPDF(Document documento, int numeroFactura, LocalDate fechaFactura);
    
    public void fusionarPDF(String [] rutasDocumentos){
        try {
            Desktop deskTop = Desktop.getDesktop();
            String rutaArchivoTemporal = System.getProperty("java.io.tmpdir") + "/" + "union.pdf";
            PDFMergerUtility ut = new PDFMergerUtility();
            for (String rutaDocumento : rutasDocumentos) {
                ut.addSource(rutaDocumento);
            }
            ut.setDestinationFileName(rutaArchivoTemporal);
            ut.mergeDocuments();
            deskTop.open(new File(rutaArchivoTemporal));
        } catch (IOException ex) {
            ex.printStackTrace();
        }       
    }
    
    public void eliminarCarpeta() {
        File directorio = new File(System.getProperty("java.io.tmpdir") + "/" + "facturas/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "/" + (prueba ? "prueba" : "normal"));
        File[] ficheros = directorio.listFiles();
        for (File fichero : ficheros) {
            fichero.delete();
        }
        directorio.delete();
    }
}