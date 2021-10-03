package model.modelosContrato;

import auxiliar.Meses;
import auxiliar.NumeroEnTexto;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;
import model.Arrendatario;
import model.Contrato;
import model.Inmueble;

public class GeneradorPDFModeloContratoVivienda1 extends GeneradorPDFModeloContrato {

    public GeneradorPDFModeloContratoVivienda1(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato, int numeroModel) {
        super(arrendatario, inmueble, contrato, numeroModel);
        generatePopulatedPDF("ContratoVivienda1.pdf");
    }

    @Override
    protected void populatePDF() throws IOException {
        LocalDate hoy = LocalDate.now();
        this.modelFormPDF.getField("atPlace").setValue(inmueble.getLocalidad().toUpperCase());
        this.modelFormPDF.getField("toDay").setValue("1");
        this.modelFormPDF.getField("ofMonth").setValue(Meses.getMes(hoy.getMonthValue()).toUpperCase());
        this.modelFormPDF.getField("ofYear").setValue(String.valueOf(hoy.getYear()));
        this.modelFormPDF.getField("lessorName").setValue(arrendador.getNombre().toUpperCase() + " " + arrendador.getApellidos().toUpperCase());
        this.modelFormPDF.getField("lessorNationality").setValue(arrendador.getNacionalidad().toUpperCase());
        this.modelFormPDF.getField("lessorAddress").setValue(arrendador.getNombreCalle().toUpperCase() + ", " + arrendador.getNumeroCalle().toUpperCase());
        this.modelFormPDF.getField("lessorLocality").setValue(arrendador.getLocalidad().toUpperCase());
        this.modelFormPDF.getField("lessorNIF").setValue(arrendador.getDni().toUpperCase());
        this.modelFormPDF.getField("lesseeName").setValue(arrendatario.getNombre().toUpperCase() + " " + arrendatario.getApellidos().toUpperCase());
        this.modelFormPDF.getField("lesseeNationality").setValue(arrendatario.getNacionalidad().toUpperCase());
        this.modelFormPDF.getField("lesseeAddress").setValue(arrendatario.getNombreCalle().toUpperCase() + ", " + arrendatario.getNumeroCalle().toUpperCase());
        this.modelFormPDF.getField("lesseeNIF").setValue(arrendatario.getDni().toUpperCase());
        this.modelFormPDF.getField("lesseeLocality").setValue(arrendatario.getLocalidad().toUpperCase());
        this.modelFormPDF.getField("floorApartment").setValue(inmueble.getNumeroInmueble() != null ? inmueble.getNumeroInmueble().toUpperCase() + " ª" : "");
        this.modelFormPDF.getField("letterApartment").setValue(inmueble.getLetraInmueble() != null ? inmueble.getLetraInmueble().toUpperCase() : "");
        this.modelFormPDF.getField("streetApartment").setValue(inmueble.getNombreCalle().toUpperCase());
        this.modelFormPDF.getField("numberApartment").setValue(inmueble.getNumeroCalle());
        this.modelFormPDF.getField("localityApartment").setValue(inmueble.getLocalidad().toUpperCase());
        this.modelFormPDF.getField("provinceApartment").setValue("LAS PALMAS");
        this.modelFormPDF.getField("durationRentNumber").setValue(String.valueOf(contrato.getDuracionContrato()));
        double precioAnual = contrato.getPrecio1Inmueble() * 12;
        DecimalFormat df = new DecimalFormat("#.##");
        this.modelFormPDF.getField("annualRentLetter").setValue(NumeroEnTexto.convertirNumeroATextoDouble(precioAnual, true).toUpperCase());
        this.modelFormPDF.getField("annualRentNumber").setValue(df.format(precioAnual));
        this.modelFormPDF.getField("monthlyRentLetter").setValue(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), true).toUpperCase());
        this.modelFormPDF.getField("monthlyRentNumber").setValue(df.format(contrato.getPrecio1Inmueble()));
        this.modelFormPDF.getField("guaranteeLetter").setValue(NumeroEnTexto.convertirNumeroATextoDouble(contrato.getPrecio1Inmueble(), true).toUpperCase());
        this.modelFormPDF.getField("guaranteeNumber").setValue(df.format(contrato.getPrecio1Inmueble()));
        this.modelFormPDF.getField("expensesWho1").setValue("ARRENDATARIO");
        this.modelFormPDF.getField("expensesWho2").setValue("ARRENDATARIO");
        this.modelFormPDF.getField("other").setValue(
             "A) RECIBOS DE AGUA Y LUZ CORRESPONDEN AL ARRENDATARIO\n" +
             "B) PISO COMPLETAMENTE AMUEBLADO\n" +
             "C) LOS PAGOS SE EFECTUARAN EN EL BANCO SANTANDER\n" +
             "     NUM. CUENTA 7900491751902290021318\n" +
             "     DEL 1 AL 15 DE CADA MES\n" +
             "TELF. CARIDAD: 609226895"
        );
    }
}
