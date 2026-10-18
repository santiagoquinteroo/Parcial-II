package co.edu.uniquindio.poo.model;

import java.util.ArrayList;
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
            return "Cliente registrado con exito";
        }
    }
    public Optional<Cliente>buscarCliente(String documento){
        return listaClientes.stream().filter(c -> c.getDocumento(documento)).findFirst();
    }
}
