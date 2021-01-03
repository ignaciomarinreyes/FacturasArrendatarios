package model;

public class Contrato {

    private int idContrato = 0;
    private String dniArrendatario = null;
    private int idInmueble = 0;
    private int duracionContrato = 0;
    private double precio1Inmueble = 0;
    private double precio2Inmueble = 0;

    private String nombreCalle = null;
    private String numeroCalle = null;
    private String numeroInmueble = null;
    private String nombreArrendatario = null;
    private String appellidosArrendatario = null;

    public Contrato(int idContrato, String dniArrendatario, int idInmueble, int duracionContrato, double precio1, double precio2) {
        this.idContrato = idContrato;
        this.dniArrendatario = dniArrendatario;
        this.idInmueble = idInmueble;
        this.duracionContrato = duracionContrato;
        this.precio1Inmueble = precio1;
        this.precio2Inmueble = precio2;
    }

    public Contrato(int idContrato, String nombreArrendatario, String appellidosArrendatario, String nombreCalle, String numeroCalle, String numeroInmueble) {
        this.idContrato = idContrato;
        this.nombreArrendatario = nombreArrendatario;
        this.appellidosArrendatario = appellidosArrendatario;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.numeroInmueble = numeroInmueble;
    }

    public Contrato(String mensajeInicial) {
        this.dniArrendatario = mensajeInicial;
    }

    public int getDuracionContrato() {
        return duracionContrato;
    }

    public double getPrecio1Inmueble() {
        return precio1Inmueble;
    }

    public double getPrecio2Inmueble() {
        return precio2Inmueble;
    }

    public int getIdContrato() {
        return idContrato;
    }

    @Override
    public String toString() {
        if (idContrato != 0) {
            if(numeroInmueble != null){
                return nombreArrendatario + " " + appellidosArrendatario + " en " + nombreCalle + " " + numeroCalle + " " + numeroInmueble;
            } else {
                return nombreArrendatario + " " + appellidosArrendatario + " en " + nombreCalle + " " + numeroCalle;
            }
        } else {
            return dniArrendatario;
        }
    }
}
