package es.eug.campus;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class VehiculoTest {
    /**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    public void testConstructorIdNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(-1, "Corolla", "Nuevo", 15000.0);
        });
    }
/**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    public void testConstructorModeloNulo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, null, "Nuevo", 15000.0);
        });
    }
/**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    public void testConstructorEstadoVacio() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, "Corolla", "", 15000.0);
        });
    }
/**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    public void testConstructorPrecioNegativo() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Vehiculo(1, "Corolla", "Nuevo", -15000.0);
        });
    }
}