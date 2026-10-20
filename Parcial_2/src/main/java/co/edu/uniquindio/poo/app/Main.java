package co.edu.uniquindio.poo.app;

import co.edu.uniquindio.poo.model.*;

import javax.swing.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
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
        techRepair.getListaServicios().add(new ReperacionCorrectiva("S3", "Reparación correctiva", "Soluciona fallas", 35000, 45000));

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
                    registrarTecnico();
                    break;
                case 4:
                    registrarRepuesto();
                    break;
                case 5:
                    crearOrden();
                    break;
                case 6:
                    agregarDetalle();
                    break;
                case 7:
                    asignarTecnico();
                    break;
                case 8:
                    registrarRepuestosUtilizados();
                    break;
                case 9:
                    calcularValorDetalle();
                    break;
                case 10:
                    calcularValorOrden();
                    break;
                case 11:
                    actualizarEstadoDetalle();
                    break;
                case 12:
                    finalizarOrden();
                    break;
                case 13:
                    consultarOrdenesCliente();
                    break;
                case 14:
                    consultarTrabajosTecnico();
                    break;
                case 15:
                    consultarEquiposPendientes();
                    break;
                case 16:
                    JOptionPane.showMessageDialog(null, techRepair.generarReporteServicios());
                    break;
                case 17:
                    JOptionPane.showMessageDialog(null, techRepair.generarReporteTecnicos());
                    break;
                case 18:
                    consultarInventarioCritico();
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Adiós :D");
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


    static void registrarTecnico() {
        String codigo = JOptionPane.showInputDialog(null, "Código:");
        String nombre = JOptionPane.showInputDialog(null, "Nombre:");
        String documento = JOptionPane.showInputDialog(null, "Documento:");
        int especialidad = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Especialidad:\n" +
                        "1. Computador\n" +
                        "2. Móvil\n" +
                        "3. General"));
        int estado  = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Estado laboral:\n" +
                        "1. Activo\n" +
                        "2. Inactivo"));

        Especialidad esp = Especialidad.ESPECIALISTA_GENERAL;
        if (especialidad == 1) esp = Especialidad.ESPECIALISTA_COMPUTADOR;
        if (especialidad == 2) esp = Especialidad.ESPECIALISTA_MOVIL;
        EstadoLaboral est;
        if (estado==1){
            est = EstadoLaboral.ACTIVO;
        } else {
            est = EstadoLaboral.INACTIVO;
        }

        JOptionPane.showMessageDialog(null,
                techRepair.registrarTecnico(new Tecnico(codigo, nombre, documento, esp, est)));
    }

    static void registrarRepuesto() {
        String codigo = JOptionPane.showInputDialog(null, "Código:");
        String nombre = JOptionPane.showInputDialog(null, "Nombre:");
        String descripcion = JOptionPane.showInputDialog(null, "Descripción:");
        double precio = Double.parseDouble(JOptionPane.showInputDialog(null, "Precio unitario:"));
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad inicial:"));
        boolean compatible = JOptionPane.showConfirmDialog(null, "¿Es compatible?", "Pregunta",
                JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION;

        if (precio <= 0 || cantidad < 0) {
            JOptionPane.showMessageDialog(null, "Precio o cantidad inválidos");
        } else {
            JOptionPane.showMessageDialog(null, techRepair.registrarRepuesto(
                    new Repuesto(codigo, nombre, descripcion, precio, cantidad, compatible)));
        }
    }


    static void crearOrden() {
        Cliente cliente = buscarCliente();
        if (cliente == null) return;

        String codigo = JOptionPane.showInputDialog(null, "Código de la orden:");
        String observaciones = JOptionPane.showInputDialog(null, "Observaciones:");
        OrdenServicio orden = new OrdenServicio(codigo, LocalDate.now(), observaciones,
                EstadoOrden.ABIERTA, cliente, new ArrayList<>(), techRepair);

        if (techRepair.buscarOrdenServicio(codigo).isPresent()) {
            JOptionPane.showMessageDialog(null, "Orden ya existente");
        } else {
            cliente.getListaOrdenes().add(orden);
            JOptionPane.showMessageDialog(null, techRepair.registrarOrdenServicio(orden));
        }
    }


    static void agregarDetalle() {
        OrdenServicio orden = buscarOrden();
        if (orden == null) return;

        Optional<EquipoTecnologico> equipo = orden.getCliente()
                .buscarEquipo(JOptionPane.showInputDialog(null, "Código del equipo:"));
        if (equipo.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El cliente no tiene ese equipo");
            return;
        }

        String listaServicios = "Servicio: ";
        for (int i = 0; i < techRepair.getListaServicios().size(); i++) {
            listaServicios += (i + 1) + ". " + techRepair.getListaServicios().get(i).getNombre() + "\n";
        }
        int j = Integer.parseInt(JOptionPane.showInputDialog(null, listaServicios)) - 1;
        if (j < 0 || j >= techRepair.getListaServicios().size()) {
            JOptionPane.showMessageDialog(null, "Servicio inválido");
            return;
        }
        Servicio servicio = techRepair.getListaServicios().get(j);

        String codigo = JOptionPane.showInputDialog(null, "Código del detalle:");
        String falla = JOptionPane.showInputDialog(null, "Descripción de la falla:");
        short horas = 0;
        if (!(servicio instanceof Diagnostico)) {
            horas = Short.parseShort(JOptionPane.showInputDialog(null, "Horas de trabajo:"));
        }
        String observaciones = JOptionPane.showInputDialog(null, "Observaciones técnicas:");

        DetalleServicio detalle;
        if (servicio instanceof ReperacionCorrectiva) {
            detalle = new DetalleReparacion(codigo, falla, horas, observaciones, EstadoOrden.ABIERTA, 0,
                    equipo.get(), null, servicio, orden, new ArrayList<>());
        } else {
            detalle = new DetalleServicio(codigo, falla, horas, observaciones, EstadoOrden.ABIERTA, 0,
                    equipo.get(), null, servicio, orden);
        }
        JOptionPane.showMessageDialog(null, orden.agregarDetalle(detalle));
    }


    static void asignarTecnico() {
        DetalleServicio detalle = buscarDetalle();
        if (detalle == null) return;

        Optional<Tecnico> tecnico = techRepair.buscarTecnico(JOptionPane.showInputDialog(null, "Código del técnico: "));
        if (tecnico.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tecnico no existente");
        } else {
            JOptionPane.showMessageDialog(null, detalle.asignarTecnico(tecnico.get()));
        }
    }


    static void registrarRepuestosUtilizados() {
        DetalleServicio detalle = buscarDetalle();
        if (detalle == null) return;

        if (!(detalle instanceof DetalleReparacion)) {
            JOptionPane.showMessageDialog(null, "Solo las reparaciones correctivas usan repuestos");
            return;
        }
        Optional<Repuesto> repuesto = techRepair.buscarRepuesto(JOptionPane.showInputDialog(null, "Código del repuesto: "));
        if (repuesto.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Repuesto no existente");
            return;
        }
        int cantidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Cantidad: "));
        JOptionPane.showMessageDialog(null,
                ((DetalleReparacion) detalle).registrarRepuestoUtilizado(repuesto.get(), cantidad));
    }


    static void calcularValorDetalle() {
        DetalleServicio detalle = buscarDetalle();
        if (detalle == null) return;
        JOptionPane.showMessageDialog(null, "Valor del detalle: $" + detalle.calcularValor());
    }


    static void calcularValorOrden() {
        OrdenServicio orden = buscarOrden();
        if (orden == null) return;
        JOptionPane.showMessageDialog(null, "Valor total de la orden: $" + orden.calcularValorTotal());
    }


    static void actualizarEstadoDetalle() {
        DetalleServicio detalle = buscarDetalle();
        if (detalle == null) return;

        int op = Integer.parseInt(JOptionPane.showInputDialog(null,
                "Nuevo estado:\n" +
                        "1. Abierta\n" +
                        "2. En proceso\n" +
                        "3. Finalizada\n" +
                        "4. Entregada\n" +
                        ". Cancelada"));
        if (op < 1 || op > 5) {
            JOptionPane.showMessageDialog(null, "Estado inválido");
            return;
        }
        JOptionPane.showMessageDialog(null, detalle.actualizarEstado(EstadoOrden.values()[op - 1]));
    }

    // 12
    static void finalizarOrden() {
        OrdenServicio orden = buscarOrden();
        if (orden == null) return;

        if (orden.getListaDetalles().isEmpty()) {
            JOptionPane.showMessageDialog(null, "La orden no tiene detalles");
            return;
        }
        for (DetalleServicio d : orden.getListaDetalles()) {
            if (!d.estaFinalizado()) {
                JOptionPane.showMessageDialog(null, "El detalle " + d.getCodigo() + " aún no está finalizado");
                return;
            }
        }
        JOptionPane.showMessageDialog(null, orden.actualizarEstado(EstadoOrden.FINALIZADA));
    }

    // 13
    static void consultarOrdenesCliente() {
        ArrayList<OrdenServicio> ordenes = techRepair.consultarOrdenesDeCliente(
                JOptionPane.showInputDialog(null, "Documento del cliente:"));
        if (ordenes.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay órdenes para ese cliente");
            return;
        }
        String texto = "";
        for (OrdenServicio o : ordenes) {
            texto += "Orden " + o.getCodigo() + " | " + o.getEstado() + "\n";
            for (DetalleServicio d : o.getListaDetalles()) {
                texto += "   " + d.getCodigo() + " | " + d.getEquipo().getCodigo() + " (" + d.getEquipo().obtenerCategoria() + ")"
                        + " | " + d.getServicio().getNombre() + " | " + d.getEstado() + " | $" + d.calcularValor() + "\n";
            }
            texto += "   Total: $" + o.calcularValorTotal() + "\n\n";
        }
        JOptionPane.showMessageDialog(null, texto);
    }

    static void consultarTrabajosTecnico() {
        String codigo = JOptionPane.showInputDialog(null, "Código del técnico:");
        if (techRepair.buscarTecnico(codigo).isEmpty()) {
            JOptionPane.showMessageDialog(null, "Tecnico no existente");
            return;
        }
        HashMap<EstadoOrden, ArrayList<DetalleServicio>> trabajos = techRepair.consultarTrabajoDeTecnico(codigo);
        String texto = "";
        for (EstadoOrden estado : EstadoOrden.values()) {
            texto += estado + ":\n";
            for (DetalleServicio d : trabajos.get(estado)) {
                texto += "   " + d.getCodigo() + " | " + d.getServicio().getNombre() + " | " + d.getEquipo().getCodigo() + "\n";
            }
        }
        JOptionPane.showMessageDialog(null, texto);
    }


    static void consultarEquiposPendientes() {
        Cliente cliente = buscarCliente();
        if (cliente == null) return;

        ArrayList<EquipoTecnologico> equipos = techRepair.consultarEquiposPendientes(cliente);
        if (equipos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay equipos pendientes");
            return;
        }
        String msg = "Equipos pendientes:\n";
        for (EquipoTecnologico e : equipos) {
            msg += e.getCodigo() + " | " + e.obtenerCategoria() + " | " + e.getMarca() + " " + e.getModelo() + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }

    // 18
    static void consultarInventarioCritico() {
        ArrayList<Repuesto> criticos = techRepair.consultarInventarioCritico();
        if (criticos.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No hay repuestos críticos");
            return;
        }
        String msg   = "Inventario crítico:\n";
        for (Repuesto r : criticos) {
            msg += r.getCodigo() + " | " + r.getNombre() + " | disponibles: " + r.getCantidadDisponible() + "\n";
        }
        JOptionPane.showMessageDialog(null, msg);
    }


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


