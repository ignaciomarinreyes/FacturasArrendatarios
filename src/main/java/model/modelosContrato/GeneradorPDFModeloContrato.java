package model.modelosContrato;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import model.Arrendador;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.interactive.form.PDAcroForm;
import static persistence.DataBase.selectArrendadorByIdArrendador;

public abstract class GeneradorPDFModeloContrato {

    protected final Arrendatario arrendatario;
    protected final Inmueble inmueble;
    protected final Contrato contrato;
    protected Arrendador arrendador;
    protected int numeroModel;
    protected PDDocument modelPDF;
    protected PDAcroForm modelFormPDF;

    public GeneradorPDFModeloContrato(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato, int numeroModel) {
        this.arrendatario = arrendatario;
        this.inmueble = inmueble;
        this.contrato = contrato;
        this.numeroModel = numeroModel;
        this.arrendador = selectArrendadorByIdArrendador(contrato.getIdArrendador());
    }

    public void generatePopulatedPDF(String nameModelPDF) {
        try {
            loadModelPDF(nameModelPDF);
            populatePDF();
            savePopulatedPDF(nameModelPDF);
        } catch (IOException e) {
            e.printStackTrace();
        }
        openPDF();
    }

    private void loadModelPDF(String nombrePDF) throws IOException {
        modelPDF = PDDocument.load(new File("ModelosContratos/FormPDF/" + nombrePDF));
        modelFormPDF = modelPDF.getDocumentCatalog().getAcroForm();
    }

    private void savePopulatedPDF(String nameModelPDF) throws IOException {
        modelPDF.save(System.getProperty("java.io.tmpdir") + "/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "_" + contrato.getIdContrato() + "_" + numeroModel + ".pdf");
        modelPDF.close();
    }

    protected abstract void populatePDF() throws IOException;

    public void openPDF() {
        File archivo = new File(System.getProperty("java.io.tmpdir") + "/" + arrendatario.getDni() + "_" + inmueble.getIdInmueble() + "_" + contrato.getIdContrato() + "_" + numeroModel + ".pdf");
        Desktop deskTop = Desktop.getDesktop();
        try {
            deskTop.open(archivo);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
