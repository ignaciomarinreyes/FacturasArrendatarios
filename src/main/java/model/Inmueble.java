package model;

public class Inmueble {

    private int idInmueble = 0;
    private String nombreCalle = null;
    private String numeroCalle = null;
    private String localidad = null;
    private String numeroInmueble = null;
    private String letraInmueble;
    private TipoInmueble tipoInmueble = null;   

    public Inmueble(int idInmueble, String nombreCalle, String numeroCalle, String localidad, String numeroInmueble, String letraInmueble, TipoInmueble tipoInmueble) {
        this.idInmueble = idInmueble;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.localidad = localidad;
        this.numeroInmueble = numeroInmueble;
        this.letraInmueble = letraInmueble;
        this.tipoInmueble = tipoInmueble;
    }

    public Inmueble(String nombreCalle) {
        this.nombreCalle = nombreCalle;
    }

    public int getIdInmueble() {
        return idInmueble;
    }

    public String getNombreCalle() {
        return nombreCalle;
    }

    public String getNumeroCalle() {
        return numeroCalle;
    }

    public String getLocalidad() {
        return localidad;
    }

    public String getNumeroInmueble() {
        return numeroInmueble;
    }

    public TipoInmueble getTipoInmueble() {
        return tipoInmueble;
    }
    
    public String getLetraInmueble() {
        return letraInmueble;
    }

    @Override
    public String toString() {
        if (numeroCalle == null) {
            return nombreCalle;
        } else if (numeroInmueble == null) {
            return nombreCalle + " " + numeroCalle + " " + tipoInmueble;
        } else {
            return nombreCalle + " " + numeroCalle + " " + numeroInmueble + " " + tipoInmueble;
        }
    }
}
