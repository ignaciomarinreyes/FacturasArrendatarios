package model;

import java.time.LocalDate;

public class RegistroFactura {

    private int idRegistroFactura;
    private int numeroFactura;
    private LocalDate fechaFactura;
    private boolean cobrado;
    private boolean agua;
    private boolean luz;

    public RegistroFactura(int idRegistroFactura, int numeroFactura, LocalDate fechaFactura, boolean cobrado, boolean agua, boolean luz) {
        this.idRegistroFactura = idRegistroFactura;
        this.numeroFactura = numeroFactura;
        this.fechaFactura = fechaFactura;
        this.cobrado = cobrado;
        this.agua = agua;
        this.luz = luz;
    }

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDate getFechaFactura() {
        return fechaFactura;
    }

    public int getIdRegistroFactura() {
        return idRegistroFactura;
    }

    public boolean isCobrado() {
        return cobrado;
    }

    public boolean isAgua() {
        return agua;
    }

    public boolean isLuz() {
        return luz;
    }

    public void setIdRegistroFactura(int idRegistroFactura) {
        this.idRegistroFactura = idRegistroFactura;
    }

    public void setNumeroFactura(int numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public void setFechaFactura(LocalDate fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

}