package es.eug.campus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class OficinaTest {

    @Test
    public void testConstructorIdNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Oficina(-1, "Calle Falsa 123", "Madrid", "123456789");
        });
    }

    @Test
    public void testConstructorDireccionVacia() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Oficina(1, "", "Madrid", "123456789");
        });
    }

    @Test
    public void testConstructorCiudadNula() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Oficina(1, "Calle Falsa 123", null, "123456789");
        });
    }

    @Test
    public void testConstructorTelefonoNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Oficina(1, "Calle Falsa 123", "Madrid", null);
        });
    }
}