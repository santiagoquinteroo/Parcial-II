package co.edu.uniquindio.poo.model;

public class ComputadorEscritorio extends EquipoTecnologico{
    private final String tipoProcesador;
    private short memoriaRAM;
    private short capacidadAlmacenamientoGB;
    private boolean tarjetaGraficaDelicada;

    public ComputadorEscritorio(String codigo, String numeroSerie, String marca, String modelo, short anoFabricacion, String estadoFisico,
                                String tipoProcesador, short memoriaRAM, short capacidadAlmacenamientoGB, boolean tarjetaGraficaDelicada) {
        super(codigo, numeroSerie, marca, modelo, anoFabricacion, estadoFisico);
        this.tipoProcesador = tipoProcesador;
        this.memoriaRAM = memoriaRAM;
        this.capacidadAlmacenamientoGB = capacidadAlmacenamientoGB;
        this.tarjetaGraficaDelicada = tarjetaGraficaDelicada;
    }

    public String getTipoProcesador() {
        return tipoProcesador;
    }

    public short getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(short memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public short getCapacidadAlmacenamientoGB() {
        return capacidadAlmacenamientoGB;
    }

    public void setCapacidadAlmacenamientoGB(short capacidadAlmacenamientoGB) {
        this.capacidadAlmacenamientoGB = capacidadAlmacenamientoGB;
    }

    public boolean isTarjetaGraficaDelicada() {
        return tarjetaGraficaDelicada;
    }

    public void setTarjetaGraficaDelicada(boolean tarjetaGraficaDelicada) {
        this.tarjetaGraficaDelicada = tarjetaGraficaDelicada;
    }

    @Override
    public boolean validarAtributos() {
        return validarAtributosComunes() && !tipoProcesador.isEmpty() && memoriaRAM > 0 && capacidadAlmacenamientoGB > 0 ;
    }

    @Override
    public String obtenerCategoria() {
        return "Escritorio" ;
    }

    @Override
    public String toString() {
        return "ComputadorEscritorio{" +
                "tipoProcesador='" + tipoProcesador + '\'' +
                ", memoriaRAM=" + memoriaRAM +
                ", capacidadAlmacenamientoGB=" + capacidadAlmacenamientoGB +
                ", tarjetaGraficaDelicada=" + tarjetaGraficaDelicada +
                '}';
    }
}
