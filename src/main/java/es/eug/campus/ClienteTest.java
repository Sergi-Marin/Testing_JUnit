package es.eug.campus;

import org.testng.annotations.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteTest {

    @Test
    public void testConstructor() {
        Cliente cliente = new Cliente(1, "Juan", "123456789", "12345678A");
        assertEquals(1, cliente.getId());
        assertEquals("Juan", cliente.getNombre());
        assertEquals("123456789", cliente.getTelefono());
        assertEquals("12345678A", cliente.getDni());
    }

    @Test
    public void testSettersAndGetters() {
        Cliente cliente = new Cliente(1, "Juan", "123456789", "12345678A");
        cliente.setNombre("Pedro");
        cliente.setTelefono("987654321");
        cliente.setDni("87654321B");

        assertEquals("Pedro", cliente.getNombre());
        assertEquals("987654321", cliente.getTelefono());
        assertEquals("87654321B", cliente.getDni());
    }
}