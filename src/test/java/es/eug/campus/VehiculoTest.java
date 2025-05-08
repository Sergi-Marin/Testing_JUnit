package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class VehiculoTest {

    /**
     * Testeamos el constructor de la clase Vehiculo.
     */
    @Test
    void testConstructorValoresValidos() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        assertEquals(1, vehiculo.getId());
        assertEquals("Toyota", vehiculo.getModelo());
        assertEquals("Disponible", vehiculo.getEstado());
        assertEquals(50.0, vehiculo.getPrecioPorDia());
    }

    /**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    void testConstructorIdNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Vehiculo(-1, "Toyota", "Disponible", 50.0));
        assertEquals("El ID no puede ser negativo.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    void testConstructorModeloNulo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Vehiculo(1, null, "Disponible", 50.0));
        assertEquals("El modelo no puede ser nulo o vacío.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    void testConstructorEstadoVacio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Vehiculo(1, "Toyota", "", 50.0));
        assertEquals("El estado no puede ser nulo o vacío.", exception.getMessage());
    }

    /**
     * Testeamos el constructor de la clase Vehiculo con valores inválidos.
     */
    @Test
    void testConstructorPrecioNegativo() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Vehiculo(1, "Toyota", "Disponible", -10.0));
        assertEquals("El precio por día no puede ser negativo.", exception.getMessage());
    }
}