package es.eug.campus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class GestionClientesTest {

    @Test
    public void testAgregarCliente() {
        GestionClientes gestion = new GestionClientes();
        Cliente cliente = new Cliente(1, "Juan", "123456789", "12345678A");
        gestion.agregarCliente(cliente);

        List<Cliente> clientes = gestion.obtenerTodosLosClientes();
        assertEquals(1, clientes.size());
        assertEquals(cliente, clientes.get(0));
    }

    @Test
    public void testEliminarCliente() {
        GestionClientes gestion = new GestionClientes();
        Cliente cliente = new Cliente(1, "Juan", "123456789", "12345678A");
        gestion.agregarCliente(cliente);

        assertTrue(gestion.eliminarCliente(1));
        assertTrue(gestion.obtenerTodosLosClientes().isEmpty());
    }

    @Test
    public void testBuscarClientePorId() {
        GestionClientes gestion = new GestionClientes();
        Cliente cliente = new Cliente(1, "Juan", "123456789", "12345678A");
        gestion.agregarCliente(cliente);

        Cliente encontrado = gestion.buscarClientePorId(1);
        assertNotNull(encontrado);
        assertEquals(cliente, encontrado);
    }
}