package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class GestionVehiculosTest {
    private GestionVehiculos gestionVehiculos;

    /**
     * Testeamos el constructor de la clase GestionVehiculos.
     */
    @BeforeEach
    void setup() {
        gestionVehiculos = new GestionVehiculos();
    }

    /**
     * Testeamos el método add de la clase GestionVehiculos.
     */
    @Test
    void testAddVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        assertTrue(gestionVehiculos.add(vehiculo));
        assertFalse(gestionVehiculos.add(vehiculo)); // No se puede añadir duplicado
    }

    /**
     * Testeamos el método getById de la clase GestionVehiculos.
     */
    @Test
    void testGetById() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertEquals(vehiculo, gestionVehiculos.getById(1));
        assertNull(gestionVehiculos.getById(2));
    }

    /**
     * Testeamos el método replace de la clase GestionVehiculos.
     */
    @Test
    void testReplaceVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        Vehiculo nuevoVehiculo = new Vehiculo(1, "Honda", "Alquilado", 60.0);
        assertTrue(gestionVehiculos.replace(nuevoVehiculo));
        assertEquals("Honda", gestionVehiculos.getById(1).getModelo());
    }

    /**
     * Testeamos el método remove de la clase GestionVehiculos.
     */
    @Test
    void testRemoveVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertTrue(gestionVehiculos.remove(vehiculo));
        assertFalse(gestionVehiculos.remove(vehiculo)); // Ya no existe
    }

    /**
     * Testeamos el método removeById de la clase GestionVehiculos.
     */
    @Test
    void testRemoveById() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertTrue(gestionVehiculos.remove(1));
        assertFalse(gestionVehiculos.remove(1)); // Ya no existe
    }
}