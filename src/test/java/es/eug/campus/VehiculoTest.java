package es.eug.campus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehiculoTest {

    @Test
    public void testConstructorIdNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(-1, "Corolla", "Nuevo", 15000.0);
        });
    }

    @Test
    public void testConstructorModeloNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, null, "Nuevo", 15000.0);
        });
    }

    @Test
    public void testConstructorEstadoVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, "Corolla", "", 15000.0);
        });
    }

    @Test
    public void testConstructorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, "Corolla", "Nuevo", -15000.0);
        });
    }
}