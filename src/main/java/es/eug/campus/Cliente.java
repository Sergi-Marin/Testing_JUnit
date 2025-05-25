package es.eug.campus;

/**
 * Clase que representa un cliente.
 */
public final class Cliente {
    private int id;
    private String nombre;
    private String telefono;
    private String dni;

    public Cliente(int id, String nombre, String telefono, String dni) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede ser nulo o vacío");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío");
        }
        if (dni == null || dni.isEmpty()) {
            throw new IllegalArgumentException("El DNI no puede ser nulo o vacío");
        }
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.dni = dni;
    }

    // Getters y setters
    public int getId() {
        return id;
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
}