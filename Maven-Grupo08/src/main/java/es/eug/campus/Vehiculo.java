package es.eug.campus;

public class Vehiculo {
    private int id;
    private String modelo;
    private String estado;
    private double precioPorDia;

    // Constructor
    public Vehiculo(int id, String modelo, String estado, double precioPorDia) {
        this.id = id;
        this.modelo = modelo;
        this.estado = estado;
        this.precioPorDia = precioPorDia;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public double getPrecioPorDia() {
        return precioPorDia;
    }

    public void setPrecioPorDia(double precioPorDia) {
        this.precioPorDia = precioPorDia;
    }

    // Métodos para persistir, actualizar y eliminar el vehículo
    boolean persist() {
        return EntityManager.Persist(this);
    }

    boolean merge() {
        return EntityManager.Merge(this);
    }

    boolean remove() {
        return EntityManager.Remove(this);
    }

    Vehiculo[] find() {
        return EntityManager.Find(this);
    }
}
