package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{
    private final double tarifaPortatil;
    private final double tarifaTelefono;
    private final double tarifaEscritorio;

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, double tarifaBase,
                                   double tarifaPortatil, double tarifaTelefono, double tarifaEscritorio) {
        super(codigo, nombre, descripcion, tarifaBase);
        this.tarifaPortatil = tarifaPortatil;
        this.tarifaTelefono = tarifaTelefono;
        this.tarifaEscritorio = tarifaEscritorio;
    }

    public double getTarifaPortatil() {
        return tarifaPortatil;
    }

    public double getTarifaTelefono() {
        return tarifaTelefono;
    }

    public double getTarifaEscritorio() {
        return tarifaEscritorio;
    }
}
