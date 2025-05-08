package es.eug.campus;

import java.util.ArrayList;
import java.util.List;

public class GestionOficinas {
    private final List<Oficina> oficinas;

    public GestionOficinas() {
        oficinas = new ArrayList<>();
    }

    public Oficina get(int posicion) {
        if (posicion < 0 || posicion >= oficinas.size()) {
            return null;
        }
        return oficinas.get(posicion);
    }

    public Oficina getById(int id) {
        return oficinas.stream()
                .filter(oficina -> oficina.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean add(Oficina oficina) {
        if (getById(oficina.getId()) != null) {
            return false;
        }
        return oficinas.add(oficina);
    }

    public boolean replace(Oficina oficina) {
        for (int i = 0; i < oficinas.size(); i++) {
            if (oficinas.get(i).getId() == oficina.getId()) {
                oficinas.set(i, oficina);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Oficina oficina) {
        return oficinas.remove(oficina);
    }

    public boolean remove(int id) {
        return oficinas.removeIf(oficina -> oficina.getId() == id);
    }
}