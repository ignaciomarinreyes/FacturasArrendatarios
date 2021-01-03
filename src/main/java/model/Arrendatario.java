package model;

public class Arrendatario {

    private String dni = null;
    private String nombre;
    private String apellidos = null;

    public Arrendatario(String dni, String nombre, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellidos = apellidos;
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
