package co.edu.uniquindio.poo.model;

import java.time.LocalDate;

public class OrdenServicio {
    private final String codigo;
    private final LocalDate fechaCreacion;
    private final String observaciones;
    private EstadoOrden estado;
    private final Cliente cliente;

    private TechRepair ownedByTechRepair;

}
