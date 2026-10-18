package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.Optional;

public class Cliente {
    private final String documento;
    private final String nombre;
    private final String telefono;
    private final String direccion;

    private final ArrayList<EquipoTecnologico>listaEquipos=new ArrayList<>();
    private final ArrayList<OrdenServicio>listaOrdenes=new ArrayList<>();

    private TechRepair ownedByTechRepair;

    public Cliente(String documento, String nombre, String telefono, String direccion, TechRepair ownedByTechRepair) {
        this.documento = documento;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.ownedByTechRepair = ownedByTechRepair;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public ArrayList<EquipoTecnologico> getListaEquipos() {
        return listaEquipos;
    }

    public ArrayList<OrdenServicio> getListaOrdenes() {
        return listaOrdenes;
    }

    public boolean validarDatos (){
        return !documento.isEmpty() && !nombre.isEmpty() && !telefono.isEmpty() && !direccion.isEmpty();
    }
    public String registrarEquipo(EquipoTecnologico equipo) {
        Optional<EquipoTecnologico> encontrado = buscarEquipo(equipo.getCodigo());
        if (!equipo.validarAtributos()) {
            return "Los datos del equipo no son validos";
        } else if (encontrado.isPresent()) {
            return "El equipo ya existe";
        } else {
            listaEquipos.add(equipo);
            return "Registrado con exito";
        }
    }

    public Optional<EquipoTecnologico> buscarEquipo(String codigoRegistro) {
        return listaEquipos.stream().filter(e -> e.getCodigo().equalsIgnoreCase(codigoRegistro)).findFirst();
    }


}
