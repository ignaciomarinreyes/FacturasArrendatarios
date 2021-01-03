package model.diseno.factoria;

import model.Arrendatario;
import model.Contrato;
import model.Inmueble;
import model.diseno.fianza.GeneradorPDFFianza;
import model.diseno.fianza.GeneradorPDFFianzaAparcamiento;
import model.diseno.fianza.GeneradorPDFFianzaLocal;
import model.diseno.fianza.GeneradorPDFFianzaVivienda;

public class FactoriaFianza {

    public GeneradorPDFFianza metodoFactoria(Arrendatario arrendatario, Inmueble inmueble, Contrato contrato) {
        switch (inmueble.getTipoInmueble()) {
            case VIVIENDA:
                return new GeneradorPDFFianzaVivienda(arrendatario, inmueble, contrato);
            case APARCAMIENTO:
                return new GeneradorPDFFianzaAparcamiento(arrendatario, inmueble, contrato);
            case LOCAL:
                return new GeneradorPDFFianzaLocal(arrendatario, inmueble, contrato);
            default:
                return null;
        }
    }
}