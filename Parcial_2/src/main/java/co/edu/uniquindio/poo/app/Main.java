package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static TechRepair techRepair = new TechRepair("TechRepair", "Ciudad", new ArrayList<>(),
            new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>());

    static void main() {

        techRepair.getListaServicios().add(new Diagnostico("S1", "Diagnostico", "Identifica fallas", 35000, 35000));
        techRepair.getListaServicios().add(new MantenimientoPreventivo("S2", "Mantenimiento preventivo",
                "Limpieza, revisión y optimización de dispositivos", 35000, 60000, 40000, 70000));
        techRepair.getListaServicios().add(new ReperacionCorrectiva("S3", "Reparación", "Soluciona fallas", 35000, 45000));

        int opcion;
        do {
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                    "----- MENÚ ----- \n" +
                            "1. Registrar cliente\n" +
                            "2. Registrar equipo\n" +
                            "3. Registrar técnico\n" +
                            "4. Registrar repuesto\n" +
                            "5. Crear orden de servicio\n" +
                            "6. Agregar detalle a una orden\n" +
                            "7. Asignar técnico\n" +
                            "8. Registrar repuestos utilizados\n" +
                            "9. Calcular valor de un detalle\n" +
                            "10. Calcular valor total de la orden\n" +
                            "11. Actualizar estado de un detalle\n" +
                            "12. Finalizar una orden\n" +
                            "13. Consultar órdenes de un cliente\n" +
                            "14. Consultar trabajos de un técnico\n" +
                            "15. Consultar equipos pendientes\n" +
                            "16. Generar reporte de servicios\n" +
                            "17. Generar reporte de técnicos\n" +
                            "18. Consultar inventario crítico\n" +
                            "0. Salir"));

            switch (opcion) {
                case 1:
                    registrarCliente();
                    break;
                case 2:
                    registrarEquipo();
                    break;
                case 3:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opción invalida");
            }


        } while (opcion != 0);

    }

    static void registrarCliente() {
        String documento = JOptionPane.showInputDialog(null, "Documento: ");
        String nombre = JOptionPane.showInputDialog(null, "Nombre: ");
        String telefono = JOptionPane.showInputDialog(null, "Teléfono: ");
        String direccion = JOptionPane.showInputDialog(null, "Dirección: ");
        Cliente cliente = new Cliente(documento, nombre, telefono, direccion, techRepair);

        if (!cliente.validarDatos()) {
            JOptionPane.showMessageDialog(null, "Los datos no son validos");
        } else {
            JOptionPane.showMessageDialog(null, techRepair.registrarCliente(cliente));
        }
    }
    static void registrarEquipo(){
        Cliente encontrado = buscarCliente();
        if (encontrado == null) {
            JOptionPane.showMessageDialog(null,"Error cliente no encontrado");
        }
        int tipo = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese el tipo de equipo: \n" +
                "1. Portatil \n"+
                "2. Computador de escritorio \n"+
                "3. Celular"));
        String codigo = JOptionPane.showInputDialog(null, "Código: ");
        String numeroSerie = JOptionPane.showInputDialog(null, "Número de serie: ");
        String marca = JOptionPane.showInputDialog(null, "Marca: ");
        String modelo = JOptionPane.showInputDialog(null, "Modelo: ");
        short anoFabricacion = Short.parseShort(JOptionPane.showInputDialog(null, "Año de fabricación: "));
        String estadoFisico = JOptionPane.showInputDialog(null, "Estado físico: ");

        if (tipo == 1){
            short tamanoPantallaPulgadas = Short.parseShort(JOptionPane.showInputDialog(null, "Tamaño de pantalla (en pulgadas): "));
            short memoriaRAM = Short.parseShort(JOptionPane.showInputDialog(null, "Memoria RAM: "));
            short almacenamientoGB = Short.parseShort(JOptionPane.showInputDialog(null, "Almacenamiento (en GB)"));
            boolean bateriaExtraible = JOptionPane.showConfirmDialog(null, "¿La batería es extraíble?", "Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            EquipoTecnologico equipo = new ComputadorPortatil(codigo, numeroSerie, marca, modelo, anoFabricacion, estadoFisico,
                                                        tamanoPantallaPulgadas, memoriaRAM, almacenamientoGB, bateriaExtraible);
        } else if (tipo == 2){
            String procesador = JOptionPane.showInputDialog(null, "Procesador: ");
            short memoriaRAM = Short.parseShort(JOptionPane.showInputDialog(null, "Memoria RAM: "));
            short almacenamientoGB = Short.parseShort(JOptionPane.showInputDialog(null, "Almacenamiento (en GB)"));
            boolean tarjetaGraficaDelicada = JOptionPane.showConfirmDialog(null, "La tarjeta gráfica es delicada?", "Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            EquipoTecnologico equipo = new ComputadorEscritorio(codigo,numeroSerie, marca, modelo, anoFabricacion, estadoFisico, procesador, almacenamientoGB, memoriaRAM, tarjetaGraficaDelicada);

        } else {
            String sistemaOperativo = JOptionPane.showInputDialog(null, "Sistema operativo: ");
            short almacenamientoGB = Short.parseShort(JOptionPane.showInputDialog(null, "Almacenamiento (en GB): "));
            short capacidadBateriaMah = Short.parseShort(JOptionPane.showInputDialog(null, "Capacidad de batería (en Mah): "));
            boolean compatible5G = JOptionPane.showConfirmDialog(null, "El celular es compatible con 5G?", "Pregunta", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

            EquipoTecnologico equipo = new TelefonoInteligente(codigo, numeroSerie, marca, modelo, anoFabricacion, estadoFisico, sistemaOperativo, almacenamientoGB, capacidadBateriaMah, compatible5G);
        }
    }





    //--------------------------------------
    static Cliente buscarCliente() {
        Optional<Cliente> cliente = techRepair.buscarCliente(JOptionPane.showInputDialog(null, "Documento del cliente:"));
        if (cliente.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cliente no existente");
            return null;
        }
        return cliente.get();
    }

    static OrdenServicio buscarOrden() {
        Optional<OrdenServicio> orden = techRepair.buscarOrdenServicio(JOptionPane.showInputDialog(null, "Código de la orden:"));
        if (orden.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Orden no existente");
            return null;
        }
        return orden.get();
    }

    static DetalleServicio buscarDetalle() {
        OrdenServicio orden = buscarOrden();
        if (orden == null) return null;
        Optional<DetalleServicio> detalle = orden.buscarDetalle(JOptionPane.showInputDialog(null, "Código del detalle:"));
        if (detalle.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Detalle no existente");
            return null;
        }
        return detalle.get();
    }


}


