package model;

public class Arrendatario {

    private String dni = null;
    private String nombre;
    private String apellidos = null;
    private String nacionalidad;
    private String nombreCalle;
    private String numeroCalle;
    private String localidad;
    private String municipio;

    public Arrendatario(String dni, String nombre, String apellidos, String nacionalidad, String nombreCalle, String numeroCalle, String localidad, String municipio) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.localidad = localidad;
        this.municipio = municipio;
    }

    public String getNacionalidad() {
        return nacionalidad;
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

    public String getMunicipio() {
        return municipio;
    }

    public Arrendatario(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    @Override
    public String toString() {
        if (dni == null) {
            return nombre;
        } else if (apellidos == null) {
            return dni + " " + nombre;
        } else {
            return dni + " " + nombre + " " + apellidos;
        }
    }
}
