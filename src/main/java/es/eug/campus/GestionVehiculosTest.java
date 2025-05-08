package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class GestionVehiculosTest {
    private GestionVehiculos gestionVehiculos;

    @BeforeEach
    void setup() {
        gestionVehiculos = new GestionVehiculos();
    }

    @Test
    void testAddVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        assertTrue(gestionVehiculos.add(vehiculo));
        assertFalse(gestionVehiculos.add(vehiculo)); // No se puede añadir duplicado
    }

    @Test
    void testGetById() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertEquals(vehiculo, gestionVehiculos.getById(1));
        assertNull(gestionVehiculos.getById(2));
    }

    @Test
    void testReplaceVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        Vehiculo nuevoVehiculo = new Vehiculo(1, "Honda", "Alquilado", 60.0);
        assertTrue(gestionVehiculos.replace(nuevoVehiculo));
        assertEquals("Honda", gestionVehiculos.getById(1).getModelo());
    }

    @Test
    void testRemoveVehiculo() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertTrue(gestionVehiculos.remove(vehiculo));
        assertFalse(gestionVehiculos.remove(vehiculo)); // Ya no existe
    }

    @Test
    void testRemoveById() {
        Vehiculo vehiculo = new Vehiculo(1, "Toyota", "Disponible", 50.0);
        gestionVehiculos.add(vehiculo);
        assertTrue(gestionVehiculos.remove(1));
        assertFalse(gestionVehiculos.remove(1)); // Ya no existe
    }
}