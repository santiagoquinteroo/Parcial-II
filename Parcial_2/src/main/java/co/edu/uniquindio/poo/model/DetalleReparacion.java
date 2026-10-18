package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

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
}
