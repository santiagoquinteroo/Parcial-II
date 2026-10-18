package co.edu.uniquindio.poo.model;

public class Repuesto {
    private final String codigo;
    private final String nombre;
    private final String descripcion;
    private final double precioPorUnidad;
    private int cantidadDisponible;
    private boolean compatibilidad;

    public Repuesto(String codigo, String nombre, String descripcion, double precioPorUnidad, int cantidadDisponible, boolean compatibilidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precioPorUnidad = precioPorUnidad;
        this.cantidadDisponible = cantidadDisponible;
        this.compatibilidad = compatibilidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public int getCantidadDisponible() {
        return cantidadDisponible;
    }

    public void setCantidadDisponible(int cantidadDisponible) {
        this.cantidadDisponible = cantidadDisponible;
    }

    public boolean isCompatibilidad() {
        return compatibilidad;
    }

    public void setCompatibilidad(boolean compatibilidad) {
        this.compatibilidad = compatibilidad;
    }
}
