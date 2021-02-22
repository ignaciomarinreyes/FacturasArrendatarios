package model;

public class Arrendador {
    private int idArrendador;
    private String nombre;
    private String apellidos;
    private String nacionalidad;
    private String nombreCalle;
    private String numeroCalle;
    private String localidad;
    private String municipio;
    private String dni;
    private String email;
    private String codigoPostal;

    public Arrendador(int idArrendador, String nombre, String apellidos, String nacionalidad, String nombreCalle, String numeroCalle, String localidad, String municipio, String dni, String email, String codigoPostal) {
        this.idArrendador = idArrendador;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nacionalidad = nacionalidad;
        this.nombreCalle = nombreCalle;
        this.numeroCalle = numeroCalle;
        this.localidad = localidad;
        this.municipio = municipio;
        this.dni = dni;
        this.email = email;
        this.codigoPostal = codigoPostal;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
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

    public String getDni() {
        return dni;
    }

    public String getEmail() {
        return email;
    }

    public String getCodigoPostal() {
        return codigoPostal;
    }    
    
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }

    public int getIdArrendador() {
        return idArrendador;
    }
  
    
}
