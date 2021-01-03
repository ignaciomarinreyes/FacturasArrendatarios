package model.diseno.factoria;

import model.Arrendatario;
import model.Configuracion;
import model.Contrato;
import model.Inmueble;
import model.diseno.factura.GeneradorPDFFactura;
import model.diseno.factura.GeneradorPDFFacturaAparcamientoNormal;
import model.diseno.factura.GeneradorPDFFacturaAparcamientoPrueba;
import model.diseno.factura.GeneradorPDFFacturaLocalNormal;
import model.diseno.factura.GeneradorPDFFacturaLocalPrueba;
import model.diseno.factura.GeneradorPDFFacturaViviendaNormal;
import model.diseno.factura.GeneradorPDFFacturaViviendaPrueba;

public class FactoriaFactura {

    private Boolean prueba;
    private Configuracion configuracion;

    public FactoriaFactura(Boolean version, Configuracion configuracion) {
        this.prueba = version;
        this.configuracion = configuracion;
    }

    public GeneradorPDFFactura metodoFactoria(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato) {
        if (!prueba) {
            switch (inmueble.getTipoInmueble()) {
                case VIVIENDA:
                    return new GeneradorPDFFacturaViviendaNormal(arrendatario, inmueble, contrato, configuracion, prueba);
                case APARCAMIENTO:
                    return new GeneradorPDFFacturaAparcamientoNormal(arrendatario, inmueble, contrato, configuracion, prueba);
                case LOCAL:
                    return new GeneradorPDFFacturaLocalNormal(arrendatario, inmueble, contrato, configuracion, prueba);
                default:
                    return null;
            }
        } else {
            switch (inmueble.getTipoInmueble()) {
                case VIVIENDA:
                    return new GeneradorPDFFacturaViviendaPrueba(arrendatario, inmueble, contrato, configuracion, prueba);
                case APARCAMIENTO:
                    return new GeneradorPDFFacturaAparcamientoPrueba(arrendatario, inmueble, contrato, configuracion, prueba);
                case LOCAL:
                    return new GeneradorPDFFacturaLocalPrueba(arrendatario, inmueble, contrato, configuracion, prueba);
                default:
                    return null;
            }
        }
    }

    public void setVersion(Boolean version) {
        this.prueba = version;
    }

}
