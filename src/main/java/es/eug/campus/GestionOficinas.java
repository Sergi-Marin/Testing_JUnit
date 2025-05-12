package es.eug.campus;

import java.util.HashMap;
import java.util.Map;

public class GestionOficinas {
    private final Map<Integer, Oficina> oficinas;

    public GestionOficinas() {
        this.oficinas = new HashMap<>();
    }

    /**
     * Añade una oficina a la lista de oficinas.
     * @param oficina la oficina a añadir.
     * @return true si se ha añadido correctamente, false si ya existe una oficina con el mismo ID.
     */
    public boolean add(Oficina oficina) {
        if (oficinas.containsKey(oficina.getId())) {
            return false; // No se puede añadir una oficina con un ID duplicado
        }
        oficinas.put(oficina.getId(), oficina);
        return true;
    }

    /**
     * Devuelve la oficina con el ID especificado.
     * @param id el ID de la oficina a buscar.
     * @return la oficina con el ID especificado, o null si no existe.
     */
    public Oficina getById(int id) {
        return oficinas.get(id);
    }

    /**
     * Reemplaza una oficina existente por una nueva oficina.
     * @param nuevaOficina la nueva oficina que reemplazará a la existente.
     * @return true si se ha reemplazado correctamente, false si no existe la oficina a reemplazar.
     */
    public boolean replace(Oficina nuevaOficina) {
        if (!oficinas.containsKey(nuevaOficina.getId())) {
            return false; // No se puede reemplazar si no existe la oficina
        }
        oficinas.put(nuevaOficina.getId(), nuevaOficina);
        return true;
    }

    /**
     * Elimina una oficina de la lista.
     * @param oficina la oficina a eliminar.
     * @return true si se ha eliminado correctamente, false si no existe la oficina.
     */
    public boolean remove(Oficina oficina) {
        return oficinas.remove(oficina.getId(), oficina);
    }

    /**
     * Elimina una oficina de la lista por su ID.
     * @param id el ID de la oficina a eliminar.
     * @return true si se ha eliminado correctamente, false si no existe la oficina.
     */
    public boolean remove(int id) {
        return oficinas.remove(id) != null;
    }
}