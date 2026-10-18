package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class TechRepair {
    private final String nombre;
    private final String ciudad;

    private ArrayList<Cliente>listaClientes=new ArrayList<>();
    private ArrayList<Tecnico>listaTecnicos=new ArrayList<>();
    private ArrayList<OrdenServicio>listaOrdenes=new ArrayList<>();
    private ArrayList<Servicio>listaServicios=new ArrayList<>();
    private ArrayList<Repuesto>listaRepuestos=new ArrayList<>();

    public TechRepair(String nombre, String ciudad, ArrayList<Cliente> listaClientes, ArrayList<Tecnico> listaTecnicos,
                      ArrayList<OrdenServicio> listaOrdenes, ArrayList<Servicio> listaServicios, ArrayList<Repuesto> listaRepuestos) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.listaClientes = listaClientes;
        this.listaTecnicos = listaTecnicos;
        this.listaOrdenes = listaOrdenes;
        this.listaServicios = listaServicios;
        this.listaRepuestos = listaRepuestos;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(ArrayList<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }

    public ArrayList<Tecnico> getListaTecnicos() {
        return listaTecnicos;
    }

    public void setListaTecnicos(ArrayList<Tecnico> listaTecnicos) {
        this.listaTecnicos = listaTecnicos;
    }

    public ArrayList<OrdenServicio> getListaOrdenes() {
        return listaOrdenes;
    }

    public void setListaOrdenes(ArrayList<OrdenServicio> listaOrdenes) {
        this.listaOrdenes = listaOrdenes;
    }

    public ArrayList<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(ArrayList<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public ArrayList<Repuesto> getListaRepuestos() {
        return listaRepuestos;
    }

    public void setListaRepuestos(ArrayList<Repuesto> listaRepuestos) {
        this.listaRepuestos = listaRepuestos;
    }

    public String registrarCliente(Cliente cliente){
        Optional<Cliente>encontrado=buscarCliente(cliente.getDocumento());
        if (encontrado.isEmpty()){
            listaClientes.add(cliente);
            return "Cliente registrado con éxito";
        }else return "Cliente ya existente";
    }
    public String eliminarCliente(Cliente cliente){
        Optional<Cliente>encontrado=buscarCliente((cliente.getDocumento()));
        if (encontrado.isPresent()){
            listaClientes.remove(cliente);
            return "Cliente eliminado con éxito";
        }else return "Cliente no existente";
    }
    public Optional<Cliente>buscarCliente(String documento){
        return listaClientes.stream().filter(c -> c.getDocumento().equalsIgnoreCase(documento)).findFirst();
    }

    public String registrarTecnico(Tecnico tecnico){
        Optional<Tecnico>encontrado=buscarTecnico(tecnico.getCodigo());
        if (encontrado.isEmpty()){
            listaTecnicos.add(tecnico);
            return "Tecnico registrado con éxito";
        }else return "Tecnico ya existente";
    }

    public String eliminarTecnico(Tecnico tecnico){
        Optional<Tecnico>encontrado=buscarTecnico(tecnico.getCodigo());
        if (encontrado.isPresent()){
            listaTecnicos.remove(tecnico);
            return "Tecnico eliminado con éxito";
        }else return "Tecnico no existente";
    }
    public Optional<Tecnico>buscarTecnico(String codigo){
        return listaTecnicos.stream().filter(t -> t.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }
    public String registrarRepuesto(Repuesto repuesto){
        Optional<Repuesto>encontrado=buscarRepuesto(repuesto.getCodigo());
        if (encontrado.isEmpty()){
            listaRepuestos.add(repuesto);
            return "Repuesto registrado con éxito";
        }else return "Repuesto ya existente";
    }

    public String eliminarRepuesto(Repuesto repuesto){
        Optional<Repuesto>encontrado=buscarRepuesto(repuesto.getCodigo());
        if (encontrado.isPresent()){
            listaRepuestos.remove(repuesto);
            return "Repuesto eliminado con éxito";
        }else return "Repuesto no existente";
    }
    public Optional<Repuesto>buscarRepuesto(String codigo){
        return listaRepuestos.stream().filter(r -> r.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    public String registrarOrdenServicio(OrdenServicio ordenServicio){
        Optional<OrdenServicio>encontrado=buscarOrdenServicio(ordenServicio.getCodigo());
        if (encontrado.isEmpty()){
            listaOrdenes.add(ordenServicio);
            return "Orden registrado con éxito";
        }else return "Orden ya existente";
    }

    public String eliminarOrdenServicio(OrdenServicio ordenServicio){
        Optional<OrdenServicio>encontrado=buscarOrdenServicio(ordenServicio.getCodigo());
        if (encontrado.isPresent()){
            listaOrdenes.remove(ordenServicio);
            return "Orden eliminada con éxito";
        }else return "Orden no existente";
    }
    public Optional<OrdenServicio>buscarOrdenServicio(String codigo){
        return listaOrdenes.stream().filter(o -> o.getCodigo().equalsIgnoreCase(codigo)).findFirst();
    }

    public ArrayList<OrdenServicio>consultarOrdenesDeCliente(String documento){
        ArrayList<OrdenServicio>ordenes=new ArrayList<>();
        for (OrdenServicio o : listaOrdenes){
            if (o.getCliente().getDocumento().equalsIgnoreCase(documento)){
                ordenes.add(o);
            }
        }
        return ordenes;
    }
    public HashMap<EstadoOrden, ArrayList<DetalleServicio>>consultarTrabajoDeTecnico(String codigo){
        HashMap<EstadoOrden, ArrayList<DetalleServicio>>trabajosTecnicos=new HashMap<>();
        for (EstadoOrden estado : EstadoOrden.values()){
            trabajosTecnicos.put(estado, new ArrayList<>());
        }
        Optional<Tecnico>tecnico=buscarTecnico(codigo);
        if (tecnico.isPresent()){
            for (DetalleServicio d : tecnico.get().getDetallesAsignados()){
                trabajosTecnicos.get(d.getEstado()).add(d);
            }
        }
        return trabajosTecnicos;
    }

    public ArrayList<EquipoTecnologico> consultarEquiposPendientes(Cliente cliente){
        ArrayList<EquipoTecnologico> equipos = new ArrayList<>();
        for (Cliente c : listaClientes){
            for (EquipoTecnologico e : c.getListaEquipos()){
                if (e.verificarIntervencionesPendientes(cliente)){
                equipos.add(e);
                }
            }
        }
        return equipos;
    }

    public String generarReporteServicios(){
        double totalEscritorios = 0;
        double totalPortatiles = 0;
        double totalCelulares = 0;
        int reparaciones = 0;
        int mantenimientos = 0;
        int diagnosticos = 0;

        for (OrdenServicio o : listaOrdenes){
            for (DetalleServicio d : o.getListaDetalles()){
                if (d.estaFinalizado()){
                    Servicio servicio = d.getServicio();
                    if (servicio instanceof Diagnostico) {
                        diagnosticos++;
                    } else if (servicio instanceof MantenimientoPreventivo) {
                        mantenimientos++;
                    } else if (servicio instanceof ReperacionCorrectiva) {
                        reparaciones++;
                    }

                    String categoria = d.getEquipo().obtenerCategoria();
                    double valor = d.calcularValor();
                    if (categoria.equalsIgnoreCase("Portatil")) {
                        totalPortatiles += valor;
                    } else if (categoria.equalsIgnoreCase("Escritorio")) {
                        totalEscritorios += valor;
                    } else if (categoria.equalsIgnoreCase("Celular")) {
                        totalCelulares += valor;
                    }
                }
            }
        }
        return "Servicios finalizados por tipo:\n" +
                "  Diagnostico: " + diagnosticos + "\n" +
                "  Mantenimiento preventivo: " + mantenimientos + "\n" +
                "  Reparacion correctiva: " + reparaciones + "\n" +
                "Total facturado por categoria de equipo:\n" +
                "  Portatiles: " + totalPortatiles + "\n" +
                "  Escritorio: " + totalEscritorios + "\n" +
                "  Celulares: " + totalCelulares + "\n";
    }

    public String generarReporteTecnicos() {
        String reporte = "Reporte de tecnicos:\n";
        for (Tecnico tecnico : listaTecnicos) {
            double valorServicios = 0;
            for (DetalleServicio d : tecnico.getDetallesAsignados()) {
                if (d.estaFinalizado()) {
                    valorServicios += d.calcularValor();
                }
            }
            reporte += tecnico.getNombre() + ": " + tecnico.contarIntervencionesFinalizadas()
                    + " intervenciones finalizadas, valor de los servicios " + valorServicios + "\n";
        }
        return reporte;
    }
    public ArrayList<Repuesto> consultarInventarioCritico() {
        ArrayList<Repuesto> criticos = new ArrayList<>();
        for (Repuesto repuesto : listaRepuestos) {
            if (repuesto.verificarCritico()) {
                criticos.add(repuesto);
            }
        }
        return criticos;
    }

    
}
