package co.edu.uniquindio.poo.model;

public class MantenimientoPreventivo extends Servicio{
    private final double tarifaPortatil;
    private final double tarifaCelular;
    private final double tarifaEscritorio;

    public MantenimientoPreventivo(String codigo, String nombre, String descripcion, double tarifaBase,
                                   double tarifaPortatil, double tarifaCelular, double tarifaEscritorio) {
        super(codigo, nombre, descripcion, tarifaBase);
        this.tarifaPortatil = tarifaPortatil;
        this.tarifaCelular = tarifaCelular;
        this.tarifaEscritorio = tarifaEscritorio;
    }

    public double getTarifaPortatil() {
        return tarifaPortatil;
    }

    public double getTarifaTelefono() {
        return tarifaCelular;
    }

    public double getTarifaEscritorio() {
        return tarifaEscritorio;
    }


    @Override
    public double calcularCostoFinal(DetalleServicio detalleServicio) {
        if (detalleServicio.getEquipo().obtenerCategoria().equalsIgnoreCase("Portatil")){
            return detalleServicio.getHorasTrabajo() * tarifaPortatil;
        }
        if (detalleServicio.getEquipo().obtenerCategoria().equalsIgnoreCase("Celular")){
            return detalleServicio.getHorasTrabajo() * tarifaCelular;
        }else return detalleServicio.getHorasTrabajo() * tarifaEscritorio;
    }

    @Override
    public String toString() {
        return "MantenimientoPreventivo{" +
                "tarifaPortatil=" + tarifaPortatil +
                ", tarifaCelular=" + tarifaCelular +
                ", tarifaEscritorio=" + tarifaEscritorio +
                '}';
    }
}

