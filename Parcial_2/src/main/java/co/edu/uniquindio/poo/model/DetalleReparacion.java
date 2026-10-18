package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class DetalleReparacion extends DetalleServicio{
    private ArrayList<RepuestoUtilizado>repuestosUtilizados;

    public DetalleReparacion(String codigo, String descripcionFalla, short horasTrabajo, String observacionesTecnicas, EstadoOrden estado, double valor,
                             EquipoTecnologico equipo, Tecnico tecnico, Servicio servicio, OrdenServicio ownedByOrdenServicio, ArrayList<RepuestoUtilizado> repuestosUtilizados) {
        super(codigo, descripcionFalla, horasTrabajo, observacionesTecnicas, estado, valor, equipo, tecnico, servicio, ownedByOrdenServicio);
        this.repuestosUtilizados = repuestosUtilizados;
    }

    public ArrayList<RepuestoUtilizado> getRepuestosUtilizados() {
        return repuestosUtilizados;
    }

    public void setRepuestosUtilizados(ArrayList<RepuestoUtilizado> repuestosUtilizados) {
        this.repuestosUtilizados = repuestosUtilizados;
    }
    public String registrarRepuestoUtilizado(Repuesto repuesto, int cantidad) {
        if (cantidad <= 0) {
            return "La cantidad debe ser mayor a cero";
        } else if (repuesto.verificarDisponibilidad(cantidad)==false) {
            return "No hay existencias suficientes";
        } else {
            repuesto.descontar(cantidad);
            repuestosUtilizados.add(new RepuestoUtilizado(cantidad, repuesto.getPrecioPorUnidad(), repuesto, this));
            return "Repuesto registrado con exito";
        }
    }
    public double calcularCostoRepuesto(){
        double costo = 0;
        for (RepuestoUtilizado r: repuestosUtilizados){
            costo += r.calcularSubtotal();
        }
        return costo;
    }

    @Override
    public double calcularValor() {
        double valor = super.calcularValor() + calcularCostoRepuesto();
        return valor;
    }

    @Override
    public String toString() {
        return "DetalleReparacion{" +
                "repuestosUtilizados=" + repuestosUtilizados +
                '}';
    }


}
