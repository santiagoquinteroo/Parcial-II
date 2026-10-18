package co.edu.uniquindio.poo.model;

public class Diagnostico extends Servicio{
    private final double costoFijo;

    public Diagnostico(String codigo, String nombre, String descripcion, double tarifaBase, double costoFijo) {
        super(codigo, nombre, descripcion, tarifaBase);
        this.costoFijo = costoFijo;
    }

    public double getCostoFijo() {
        return costoFijo;
    }
}
