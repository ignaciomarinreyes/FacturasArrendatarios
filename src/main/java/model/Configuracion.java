package model;

public class Configuracion {

    private float irpf;
    private float igic;

    public Configuracion(float irpf, float igic) {
        this.irpf = irpf;
        this.igic = igic;
    }

    public float getIrpf() {
        return irpf;
    }

    public float getIgic() {
        return igic;
    }

}