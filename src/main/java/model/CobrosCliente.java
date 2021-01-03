package model;

public class CobrosCliente {
    private String dni;
    private String nombre;
    private String apellidos;
    private double cobrado;

    public CobrosCliente(String dni, String nombre, String apellidos, double cobrado) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.cobrado = cobrado;
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

    public double getCobrado() {
        return cobrado;
    }
    
}
