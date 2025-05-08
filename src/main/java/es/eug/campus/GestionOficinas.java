package es.eug.campus;

import java.util.HashMap;
import java.util.Map;

public class GestionOficinas {
    private Map<Integer, Oficina> oficinas;

    public GestionOficinas() {
        this.oficinas = new HashMap<>();
    }

    public boolean add(Oficina oficina) {
        if (oficinas.containsKey(oficina.getId())) {
            return false; // No se puede añadir una oficina con un ID duplicado
        }
        oficinas.put(oficina.getId(), oficina);
        return true;
    }

    public Oficina getById(int id) {
        return oficinas.get(id);
    }

    public boolean replace(Oficina nuevaOficina) {
        if (!oficinas.containsKey(nuevaOficina.getId())) {
            return false; // No se puede reemplazar si no existe la oficina
        }
        oficinas.put(nuevaOficina.getId(), nuevaOficina);
        return true;
    }

    public boolean remove(Oficina oficina) {
        return oficinas.remove(oficina.getId(), oficina);
    }

    public boolean remove(int id) {
        return oficinas.remove(id) != null;
    }
}