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

    public Boolean estaActivo(){
        if (estadoLaboral.equals(EstadoLaboral.ACTIVO)){
            return true;
        }else return false;
    }

    public boolean estaAutorizadoPara(EquipoTecnologico equipo) {
        String categoria = equipo.obtenerCategoria();
        boolean autorizado = false;
        if (especialidad.equals(Especialidad.ESPECIALISTA_GENERAL)) {
            autorizado = true;
        } else if (especialidad.equals(Especialidad.ESPECIALISTA_COMPUTADOR)) {
            autorizado = categoria.equalsIgnoreCase("Portatil")
                    || categoria.equals("Computado de escritorio");
        } else if (especialidad.equals(Especialidad.ESPECIALISTA_MOVIL)) {
            autorizado = categoria.equals("Celular");
        }
        return autorizado;
    }

    public int contarIntervencionesFinalizadas(){
        int contador = 0;

        for(DetalleServicio d : detallesAsignados){
            if (d.estaFinalizado()){
                contador++;
            }
        }
        return  contador;
    }

    @Override
    public String toString() {
        return "Tecnico{" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", documento='" + documento + '\'' +
                ", especialidad=" + especialidad +
                ", estadoLaboral=" + estadoLaboral +
                ", detallesAsignados=" + detallesAsignados +
                '}';
    }
}
