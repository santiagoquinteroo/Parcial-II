package co.edu.uniquindio.poo.model;

public class ComputadorPortatil extends EquipoTecnologico{
    private final short tamanoPantallaPulgadas;
    private short memoriaRAM;
    private short capacidadAlmacenamiento;
    private boolean bateriaExtraible;

    public ComputadorPortatil(String codigo, String numeroSerie, String marca, String modelo, short anoFabricacion, String estadoFisico,
                              short tamanoPantallaPulgadas, short memoriaRAM, short capacidadAlmacenamiento, boolean bateriaExtraible) {
        super(codigo, numeroSerie, marca, modelo, anoFabricacion, estadoFisico);
        this.tamanoPantallaPulgadas = tamanoPantallaPulgadas;
        this.memoriaRAM = memoriaRAM;
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
        this.bateriaExtraible = bateriaExtraible;
    }

    public short getTamanoPantallaPulgadas() {
        return tamanoPantallaPulgadas;
    }

    public short getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(short memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public short getCapacidadAlmacenamiento() {
        return capacidadAlmacenamiento;
    }

    public void setCapacidadAlmacenamiento(short capacidadAlmacenamiento) {
        this.capacidadAlmacenamiento = capacidadAlmacenamiento;
    }

    public boolean isBateriaExtraible() {
        return bateriaExtraible;
    }

    public void setBateriaExtraible(boolean bateriaExtraible) {
        this.bateriaExtraible = bateriaExtraible;
    }

    @Override
    public boolean validarAtributos() {
        return validarAtributosComunes() && tamanoPantallaPulgadas > 0 && memoriaRAM > 0 && capacidadAlmacenamiento > 0;
    }

    @Override
    public String obtenerCategoria() {
        return "Portátil";
    }

    @Override
    public String toString() {
        return "ComputadorPortatil{" +
                "tamanoPantallaPulgadas=" + tamanoPantallaPulgadas +
                ", memoriaRAM=" + memoriaRAM +
                ", capacidadAlmacenamiento=" + capacidadAlmacenamiento +
                ", bateriaExtraible=" + bateriaExtraible +
                '}';
    }
}
