package co.edu.uniquindio.poo.model;

import java.time.LocalDate;
import java.util.ArrayList;

public class OrdenServicio {
    private final String codigo;
    private final LocalDate fechaCreacion;
    private final String observaciones;
    private EstadoOrden estado;
    private final Cliente cliente;
    private ArrayList<DetalleServicio>listaDetalles=new ArrayList<>();

    private TechRepair ownedByTechRepair;

    public OrdenServicio(String codigo, LocalDate fechaCreacion, String observaciones, EstadoOrden estado,
                         Cliente cliente, ArrayList<DetalleServicio> listaDetalles, TechRepair ownedByTechRepair) {
        this.codigo = codigo;
        this.fechaCreacion = fechaCreacion;
        this.observaciones = observaciones;
        this.estado = estado;
        this.cliente = cliente;
        this.listaDetalles = listaDetalles;
        this.ownedByTechRepair = ownedByTechRepair;
    }

    public String getCodigo() {
        return codigo;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<DetalleServicio> getListaDetalles() {
        return listaDetalles;
    }

    public void setListaDetalles(ArrayList<DetalleServicio> listaDetalles) {
        this.listaDetalles = listaDetalles;
    }

    public TechRepair getOwnedByTechRepair() {
        return ownedByTechRepair;
    }

    public void setOwnedByTechRepair(TechRepair ownedByTechRepair) {
        this.ownedByTechRepair = ownedByTechRepair;
    }
}
