package es.eug.campus;

import java.util.ArrayList;
import java.util.List;

public class GestionClientes {
    private final List<Cliente> clientes = new ArrayList<>();

    /**
     * Añade un cliente a la lista de clientes.
     * @param cliente el cliente a añadir.
     */
    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }
    /**
     * Reemplaza un cliente existente por uno nuevo.
     * @param id el nuevo cliente que reemplazará al existente.
     * @return true si se ha reemplazado correctamente, false si no existe el cliente a reemplazar.
     */
    public boolean eliminarCliente(int id) {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }
    /**
     * Busca un cliente por su ID.
     * @param id el ID del cliente a buscar.
     * @return el cliente con el ID especificado, o null si no existe.
     */
    public Cliente buscarClientePorId(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }
    /**
     * Busca un cliente por su DNI.
     * @return el cliente con el DNI especificado, o null si no existe.
     */
    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }
}