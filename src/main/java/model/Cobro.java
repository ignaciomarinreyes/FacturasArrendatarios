package model;

import java.time.LocalDate;

public class Cobro {

    private int idCobro;
    private LocalDate fechaCobro;
    private double importe;

    public Cobro(int idCobro, LocalDate fechaCobro, double importe) {
        this.idCobro = idCobro;
        this.fechaCobro = fechaCobro;
        this.importe = importe;
    }

    public int getIdCobro() {
        return idCobro;
    }

    public LocalDate getFechaCobro() {
        return fechaCobro;
    }

    public double getImporte() {
        return importe;
    }

}