package co.edu.uniquindio.poo.model;

public class DetalleServicio {
    private final String codigo;
    private final String descripcionFalla;
    private short horasTrabajo;
    private String observacionesTecnicas;
    private EstadoOrden estado;
    private final double valor;
    private final EquipoTecnologico equipo;
    private final Tecnico tecnico;
    private final Servicio servicio;

    private OrdenServicio ownedByOrdenServicio;


    public DetalleServicio(String codigo, String descripcionFalla, short horasTrabajo, String observacionesTecnicas, EstadoOrden estado,
                           double valor, EquipoTecnologico equipo, Tecnico tecnico, Servicio servicio, OrdenServicio ownedByOrdenServicio) {
        this.codigo = codigo;
        this.descripcionFalla = descripcionFalla;
        this.horasTrabajo = horasTrabajo;
        this.observacionesTecnicas = observacionesTecnicas;
        this.estado = estado;
        this.valor = valor;
        this.equipo = equipo;
        this.tecnico = tecnico;
        this.servicio = servicio;
        this.ownedByOrdenServicio = ownedByOrdenServicio;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcionFalla() {
        return descripcionFalla;
    }

    public short getHorasTrabajo() {
        return horasTrabajo;
    }

    public void setHorasTrabajo(short horasTrabajo) {
        this.horasTrabajo = horasTrabajo;
    }

    public String getObservacionesTecnicas() {
        return observacionesTecnicas;
    }

    public void setObservacionesTecnicas(String observacionesTecnicas) {
        this.observacionesTecnicas = observacionesTecnicas;
    }

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public double getValor() {
        return valor;
    }

    public EquipoTecnologico getEquipo() {
        return equipo;
    }

    public Tecnico getTecnico() {
        return tecnico;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public OrdenServicio getOwnedByOrdenServicio() {
        return ownedByOrdenServicio;
    }

    public void setOwnedByOrdenServicio(OrdenServicio ownedByOrdenServicio) {
        this.ownedByOrdenServicio = ownedByOrdenServicio;
    }
}
