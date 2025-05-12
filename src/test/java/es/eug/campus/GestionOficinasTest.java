package es.eug.campus;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.*;

public class GestionOficinasTest {
    private GestionOficinas gestionOficinas;

    /**
     * Testeamos la clase GestionOficinas.
     */
    @BeforeEach
    void setup() {
        gestionOficinas = new GestionOficinas();
    }

    /**
     * Testeamos la función add de la clase GestionOficinas.
     */
    @Test
    void testAddOficina() {
        Oficina oficina = new Oficina(1, "Calle Mayor", "Madrid", "123456789");
        assertTrue(gestionOficinas.add(oficina));
        assertFalse(gestionOficinas.add(oficina)); // No se puede añadir duplicada
    }

    /**
     * Testeamos la función getById de la clase GestionOficinas.
     */
    @Test
    void testGetById() {
        Oficina oficina = new Oficina(1, "Calle Mayor", "Madrid", "123456789");
        gestionOficinas.add(oficina);
        assertEquals(oficina, gestionOficinas.getById(1));
        assertNull(gestionOficinas.getById(2));
    }

    /**
     * Testeamos la función replace de la clase GestionOficinas.
     */
    @Test
    void testReplaceOficina() {
        Oficina oficina = new Oficina(1, "Calle Mayor", "Madrid", "123456789");
        gestionOficinas.add(oficina);
        Oficina nuevaOficina = new Oficina(1, "Calle Gran Via", "Barcelona", "987654321");
        assertTrue(gestionOficinas.replace(nuevaOficina));
        assertEquals("Barcelona", gestionOficinas.getById(1).getCiudad());
    }

    /**
     * Testeamos la función remove de la clase GestionOficinas.
     */
    @Test
    void testRemoveOficina() {
        Oficina oficina = new Oficina(1, "Calle Mayor", "Madrid", "123456789");
        gestionOficinas.add(oficina);
        assertTrue(gestionOficinas.remove(oficina));
        assertFalse(gestionOficinas.remove(oficina));
    }

    /**
     * Testeamos la función removeById de la clase GestionOficinas.
     */
    @Test
    void testRemoveById() {
        Oficina oficina = new Oficina(1, "Calle Mayor", "Madrid", "123456789");
        gestionOficinas.add(oficina);
        assertTrue(gestionOficinas.remove(1));
        assertFalse(gestionOficinas.remove(1));
    }
}