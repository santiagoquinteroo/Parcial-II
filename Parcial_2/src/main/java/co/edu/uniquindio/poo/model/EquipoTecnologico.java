package co.edu.uniquindio.poo.model;

public abstract class EquipoTecnologico {


    private final String codigo;
    private final String numeroSerie;
    private final String marca;
    private final String modelo;
    private final short anoFabricacion;
    private String estadoFisico;

    private Cliente ownedByCliente;

    public EquipoTecnologico(String codigo, String numeroSerie, String marca, String modelo, short anoFabricacion, String estadoFisico) {
        this.codigo = codigo;
        this.numeroSerie = numeroSerie;
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.estadoFisico = estadoFisico;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public short getAnoFabricacion() {
        return anoFabricacion;
    }

    public String getEstadoFisico() {
        return estadoFisico;
    }

    public void setEstadoFisico(String estadoFisico) {
        this.estadoFisico = estadoFisico;
    }

   public boolean verificarIntervencionesPendientes(Cliente cliente){
        int contador = 0;
        for (OrdenServicio o : cliente.getListaOrdenes()){
            for (DetalleServicio d : o.getListaDetalles()){
                if (d.getEquipo().getCodigo().equalsIgnoreCase(codigo)){
                    contador++;
                }
            }
        }
        if (contador>0){
            return true;
        } else return false;
   }

   public abstract boolean validarAtributos();
   public boolean validarAtributosComunes(){
       if (!codigo.isEmpty()&&!numeroSerie.isEmpty()&&!marca.isEmpty()&&!modelo.isEmpty()&&anoFabricacion>0&&!estadoFisico.isEmpty()){
           return true;
       }else return false;
   }

    public abstract String obtenerCategoria();

}
