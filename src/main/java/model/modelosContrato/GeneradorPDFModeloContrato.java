
package model.modelosContrato;

import static com.itextpdf.text.Annotation.FILE;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import model.Arrendador;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import static persistence.DataBase.selectArrendadorByIdArrendador;


public abstract class GeneradorPDFModeloContrato {
    protected final Arrendatario arrendatario;
    protected final Inmueble inmueble;
    protected final Contrato contrato;
    protected Arrendador arrendador;
    protected com.itextpdf.text.Document documento;
    protected int numeroModel;
    protected PdfWriter pdfWriter;

    public GeneradorPDFModeloContrato(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato, int numeroModel) {
        this.arrendatario = arrendatario;
        this.inmueble = inmueble;
        this.contrato = contrato;
        this.numeroModel = numeroModel;
        this.arrendador = selectArrendadorByIdArrendador(contrato.getIdArrendador());
    }

    public void crearPDF() {
        String rutaDocumento = System.getProperty("java.io.tmpdir") + "/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "_" + contrato.getIdContrato() + "_" + numeroModel + ".pdf";
        crearArchivo(rutaDocumento);
        escribirPDF();
    }

    private void crearArchivo(String nombrePDF) {
        documento = new com.itextpdf.text.Document(PageSize.A4);
        FileOutputStream ficheroPDF = null;
        try {
            ficheroPDF = new FileOutputStream(nombrePDF);
            pdfWriter = PdfWriter.getInstance(documento, ficheroPDF);
        } catch (FileNotFoundException | DocumentException ex) {
            ex.printStackTrace();
        }
    }
    
    public void abrirArchivo() {
        File archivo = new File(System.getProperty("java.io.tmpdir") + "/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "_" + contrato.getIdContrato() + "_" + numeroModel + ".pdf");
        Desktop deskTop = Desktop.getDesktop();
        try {
            deskTop.open(archivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    protected abstract void escribirPDF();
    
    // Unidad de medida del moveText(x,y), la x e y están en pt. 1 pt = 0,0352778 cm. pt (puntos)
    // el sistema de cordenadas la coordenada 0, 0 está en la esquina inferior izquierda de la hoja
    protected void absText(String text, float x, float y) {
    try {
      PdfContentByte cb = pdfWriter.getDirectContent();
      BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA, BaseFont.CP1252, BaseFont.NOT_EMBEDDED);
      cb.saveState();
      cb.beginText();
      cb.moveText(x, y);
      cb.setFontAndSize(bf, 12);
      cb.showText(text);
      cb.endText();
      cb.restoreState();
    } catch (DocumentException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  
}
