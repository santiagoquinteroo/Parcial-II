package co.edu.uniquindio.poo.model;

public class TelefonoInteligente extends EquipoTecnologico{
    private final String sistemaOperativo;
    private final short almacenamientoGB;
    private final short capacidadBateriaMah;
    private final boolean compatible5G;

    public TelefonoInteligente(String codigo, String numeroSerie, String marca, String modelo, short anoFabricacion, String estadoFisico,
                               String sistemaOperativo, short almacenamientoGB, short capacidadBateriaMah, boolean compatible5G) {
        super(codigo, numeroSerie, marca, modelo, anoFabricacion, estadoFisico);
        this.sistemaOperativo = sistemaOperativo;
        this.almacenamientoGB = almacenamientoGB;
        this.capacidadBateriaMah = capacidadBateriaMah;
        this.compatible5G = compatible5G;
    }

    public String getSistemaOperativo() {
        return sistemaOperativo;
    }

    public short getAlmacenamientoGB() {
        return almacenamientoGB;
    }

    public short getCapacidadBateriaMah() {
        return capacidadBateriaMah;
    }

    public boolean isCompatible5G() {
        return compatible5G;
    }

    @Override
    public boolean validarAtributos() {
        if (validarAtributosComunes() && !sistemaOperativo.isEmpty() && almacenamientoGB > 0 && capacidadBateriaMah > 0){
            return true;
        } else return false;
    }

    @Override
    public String obtenerCategoria() {
        return "Celular";
    }

    @Override
    public String toString() {
        return "TelefonoInteligente{" +
                "sistemaOperativo='" + sistemaOperativo + '\'' +
                ", almacenamientoGB=" + almacenamientoGB +
                ", capacidadBateriaMah=" + capacidadBateriaMah +
                ", compatible5G=" + compatible5G +
                '}';
    }
}
