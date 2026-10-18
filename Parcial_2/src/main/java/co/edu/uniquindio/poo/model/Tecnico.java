package co.edu.uniquindio.poo.model;

import java.util.ArrayList;

public class Tecnico {
    private final String codigo;
    private final String nombre;
    private final String documento;
    private final Especialidad especialidad;
    private final EstadoLaboral estadoLaboral;
    private final ArrayList<DetalleServicio>detallesAsignados=new ArrayList<>();

    public Tecnico(String codigo, String nombre, String documento, Especialidad especialidad, EstadoLaboral estadoLaboral) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.documento = documento;
        this.especialidad = especialidad;
        this.estadoLaboral = estadoLaboral;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDocumento() {
        return documento;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public EstadoLaboral getEstadoLaboral() {
        return estadoLaboral;
    }

    public ArrayList<DetalleServicio> getDetallesAsignados() {
        return detallesAsignados;
    }
}
