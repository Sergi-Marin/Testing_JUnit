package es.eug.campus;

/**
 * Clase que representa un cliente.
 */
public class Oficina {
    private int id;
    private String direccion;
    private String ciudad;
    private String telefono;

    public Oficina(int id, String direccion, String ciudad, String telefono) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        if (direccion == null || direccion.isEmpty()) {
            throw new IllegalArgumentException("La dirección no puede ser nula o vacía");
        }
        if (ciudad == null || ciudad.isEmpty()) {
            throw new IllegalArgumentException("La ciudad no puede ser nula o vacía");
        }
        if (telefono == null || telefono.isEmpty()) {
            throw new IllegalArgumentException("El teléfono no puede ser nulo o vacío");
        }
        this.id = id;
        this.direccion = direccion;
        this.ciudad = ciudad;
        this.telefono = telefono;
    }

    // Getters y setters
    public int getId() {
        return id;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}