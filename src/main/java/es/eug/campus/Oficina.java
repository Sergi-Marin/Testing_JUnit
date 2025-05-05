package es.eug.campus;

public class Oficina {
    private int id;
    private String ciudad;
    private String direccion;
    private String telefono;

    public Oficina(int id, String ciudad, String direccion, String telefono) {
        this.id = id;
        this.ciudad = ciudad;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    public Oficina() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDireccion() {
        return direccion;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Métodos para persistir, actualizar y eliminar la oficina

    boolean persist () {
        return EntityManager.Persist(this);
    }

    boolean merge () {
        return EntityManager.Merge(this);
    }

    boolean remove () {
        return EntityManager.Remove(this);
    }

    Oficina[] find () {
        return EntityManager.Find(this);
    }
}
