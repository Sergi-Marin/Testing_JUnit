package es.eug.campus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OficinaTest {

    /**
     * Comprueba qué ocurre si el constructor de la clase Oficina lanza una excepción
     */
    @Test
    public void testConstructorIdNegativo() {
        assertThrows(IllegalArgumentException.class, () -> new Oficina(-1, "Calle Falsa 123", "Madrid", "123456789"));
    }

    /**
     * Comprueba qué ocurre si creo un objeto Oficina con un id negativo
     */
    @Test
    public void testConstructorDireccionVacia() {
        assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "", "Madrid", "123456789"));
    }

    /**
     * Comprueba qué ocurre si creo un objeto Oficina con una dirección nula
     */
    @Test
    public void testConstructorCiudadNula() {
        assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Calle Falsa 123", null, "123456789"));
    }

    /**
     * Comprueba qué ocurre si el constructor de la clase Oficina lanza una excepción
     */
    @Test
    public void testConstructorTelefonoNulo() {
        assertThrows(IllegalArgumentException.class, () -> new Oficina(1, "Calle Falsa 123", "Madrid", null));
    }
}