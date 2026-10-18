package co.edu.uniquindio.poo.model;

public class ReperacionCorrectiva extends Servicio{
    private final double tarifaManoObra;

    public ReperacionCorrectiva(String codigo, String nombre, String descripcion, double tarifaBase, double tarifaManoObra) {
        super(codigo, nombre, descripcion, tarifaBase);
        this.tarifaManoObra = tarifaManoObra;
    }

    public double getTarifaManoObra() {
        return tarifaManoObra;
    }


    @Override
    public double calcularCostoFinal(DetalleServicio detalleServicio) {
        return detalleServicio.getHorasTrabajo()*tarifaManoObra;
    }
}
