package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class OficinaTest {

    @Test
    void testConstructorValoresValidos() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        assertEquals(1, oficina.getId());
        assertEquals("Madrid", oficina.getCiudad());
        assertEquals("Calle Mayor", oficina.getDireccion());
        assertEquals("123456789", oficina.getTelefono());
    }

    @Test
    void testConstructorIdNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(-1, "Madrid", "Calle Mayor", "123456789"));
        assertEquals("El ID no puede ser negativo.", exception.getMessage());
    }

    @Test
    void testConstructorCiudadNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, null, "Calle Mayor", "123456789"));
        assertEquals("La ciudad no puede ser nula o vacía.", exception.getMessage());
    }

    @Test
    void testConstructorDireccionVacia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Madrid", "", "123456789"));
        assertEquals("La dirección no puede ser nula o vacía.", exception.getMessage());
    }

    @Test
    void testConstructorTelefonoNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Madrid", "Calle Mayor", null));
        assertEquals("El teléfono no puede ser nulo o vacío.", exception.getMessage());
    }
}