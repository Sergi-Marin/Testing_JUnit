package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class OficinaTest {

    /**
     * Testeamos el constructor de la clase Oficina.
     */
    @Test
    void testConstructorValoresValidos() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        assertEquals(1, oficina.getId());
        assertEquals("Madrid", oficina.getCiudad());
        assertEquals("Calle Mayor", oficina.getDireccion());
        assertEquals("123456789", oficina.getTelefono());
    }

    /**
     * Testeamos el constructor de la clase Oficina con valores inválidos.
     */
    @Test
    void testConstructorIdNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(-1, "Madrid", "Calle Mayor", "123456789"));
        assertEquals("El ID no puede ser negativo.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Oficina con valores inválidos.
     */
    @Test
    void testConstructorCiudadNula() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, null, "Calle Mayor", "123456789"));
        assertEquals("La ciudad no puede ser nula o vacía.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Oficina con valores inválidos.
     */
    @Test
    void testConstructorDireccionVacia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Madrid", "", "123456789"));
        assertEquals("La dirección no puede ser nula o vacía.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Oficina con valores inválidos.
     */
    @Test
    void testConstructorTelefonoNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Madrid", "Calle Mayor", null));
        assertEquals("El teléfono no puede ser nulo o vacío.", exception.getMessage());
    }
}