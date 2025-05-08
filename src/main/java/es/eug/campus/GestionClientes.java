package es.eug.campus;

import java.util.ArrayList;
import java.util.List;

public class GestionClientes {
    private final List<Cliente> clientes = new ArrayList<>();

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public boolean eliminarCliente(int id) {
        return clientes.removeIf(cliente -> cliente.getId() == id);
    }

    public Cliente buscarClientePorId(int id) {
        return clientes.stream()
                .filter(cliente -> cliente.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<Cliente> obtenerTodosLosClientes() {
        return new ArrayList<>(clientes);
    }
}