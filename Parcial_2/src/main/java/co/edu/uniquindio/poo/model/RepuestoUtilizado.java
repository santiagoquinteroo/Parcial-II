package co.edu.uniquindio.poo.model;

public class RepuestoUtilizado {
    private final int cantidad;
    private final double precioPorUnidad;
    private final Repuesto repuesto;

    private DetalleReparacion ownedByDetalleReparacion;

    public RepuestoUtilizado(int cantidad, double precioPorUnidad, Repuesto repuesto, DetalleReparacion ownedByDetalleReparacion) {
        this.cantidad = cantidad;
        this.precioPorUnidad = precioPorUnidad;
        this.repuesto = repuesto;
        this.ownedByDetalleReparacion = ownedByDetalleReparacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecioPorUnidad() {
        return precioPorUnidad;
    }

    public Repuesto getRepuesto() {
        return repuesto;
    }

    public DetalleReparacion getOwnedByDetalleReparacion() {
        return ownedByDetalleReparacion;
    }

    public void setOwnedByDetalleReparacion(DetalleReparacion ownedByDetalleReparacion) {
        this.ownedByDetalleReparacion = ownedByDetalleReparacion;
    }

    public double calcularSubtotal(){
        return precioPorUnidad*cantidad;

    }
}
