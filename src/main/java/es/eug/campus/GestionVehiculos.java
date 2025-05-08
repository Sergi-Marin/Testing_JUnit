package es.eug.campus;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculos {
    private final List<Vehiculo> vehiculos;

    public GestionVehiculos() {
        vehiculos = new ArrayList<>();
    }

    public Vehiculo get(int posicion) {
        if (posicion < 0 || posicion >= vehiculos.size()) {
            return null;
        }
        return vehiculos.get(posicion);
    }

    public Vehiculo getById(int id) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public boolean add(Vehiculo vehiculo) {
        if (getById(vehiculo.getId()) != null) {
            return false;
        }
        return vehiculos.add(vehiculo);
    }

    public boolean replace(Vehiculo vehiculo) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId() == vehiculo.getId()) {
                vehiculos.set(i, vehiculo);
                return true;
            }
        }
        return false;
    }

    public boolean remove(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }

    public boolean remove(int id) {
        return vehiculos.removeIf(vehiculo -> vehiculo.getId() == id);
    }
}