package es.eug.campus;

public class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String dni;

    // Constructor
    public Cliente(int id, String nombre, String telefono, String dni) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    // Métodos para persistir, actualizar y eliminar el cliente
    boolean persist () {
        return EntityManager.Persist(this);
    }

    boolean merge () {
        return EntityManager.Merge(this);
    }

    boolean remove () {
        return EntityManager.Remove(this);
    }

    static Cliente[] find (Cliente cliente) {
        return EntityManager.Find(cliente);
    }
}