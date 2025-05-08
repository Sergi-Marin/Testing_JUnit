package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class GestionOficinasTest {
    private GestionOficinas gestionOficinas;

    /**
     * Testeamos el constructor de la clase GestionOficinas.
     */
    @BeforeEach
    void setup() {
        gestionOficinas = new GestionOficinas();
    }

    /**
     * Testeamos el método add de la clase GestionOficinas.
     */
    @Test
    void testAddOficina() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        assertTrue(gestionOficinas.add(oficina));
        assertFalse(gestionOficinas.add(oficina)); // No se puede añadir duplicada
    }

    /**
     * Testeamos el método getById de la clase GestionOficinas.
     */
    @Test
    void testGetById() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        gestionOficinas.add(oficina);
        assertEquals(oficina, gestionOficinas.getById(1));
        assertNull(gestionOficinas.getById(2));
    }

    /**
     * Testeamos el método replace de la clase GestionOficinas.
     */
    @Test
    void testReplaceOficina() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        gestionOficinas.add(oficina);
        Oficina nuevaOficina = new Oficina(1, "Barcelona", "Calle Gran Via", "987654321");
        assertTrue(gestionOficinas.replace(nuevaOficina));
        assertEquals("Barcelona", gestionOficinas.getById(1).getCiudad());
    }

    /**
     * Testeamos el método remove de la clase GestionOficinas.
     */
    @Test
    void testRemoveOficina() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        gestionOficinas.add(oficina);
        assertTrue(gestionOficinas.remove(oficina));
        assertFalse(gestionOficinas.remove(oficina)); // Ya no existe
    }

    /**
     * Testeamos el método removeById de la clase GestionOficinas.
     */
    @Test
    void testRemoveById() {
        Oficina oficina = new Oficina(1, "Madrid", "Calle Mayor", "123456789");
        gestionOficinas.add(oficina);
        assertTrue(gestionOficinas.remove(1));
        assertFalse(gestionOficinas.remove(1)); // Ya no existe
    }
}