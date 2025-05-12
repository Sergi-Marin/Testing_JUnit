package es.eug.campus;

import java.util.ArrayList;
import java.util.List;

public class GestionVehiculos {
    private final List<Vehiculo> vehiculos;

    public GestionVehiculos() {
        vehiculos = new ArrayList<>();
    }
/**
     * Devuelve la lista de vehículos.
     * @param posicion la posición del vehículo en la lista.
     * @return la lista de vehículos.
     */
    public Vehiculo get(int posicion) {
        if (posicion < 0 || posicion >= vehiculos.size()) {
            return null;
        }
        return vehiculos.get(posicion);
    }
    /**
     * Devuelve la lista de vehículos.
     * @param id el ID del vehículo a buscar.
     * @return la lista de vehículos.
     */
    public Vehiculo getById(int id) {
        return vehiculos.stream()
                .filter(vehiculo -> vehiculo.getId() == id)
                .findFirst()
                .orElse(null);
    }

/**
     * Devuelve la lista de vehículos.
 * @param vehiculo la oficina a añadir.
     * @return la lista de vehículos.
     */
    public boolean add(Vehiculo vehiculo) {
        if (getById(vehiculo.getId()) != null) {
            return false;
        }
        return vehiculos.add(vehiculo);
    }
/**
     * Devuelve la lista de vehículos.
     * @param vehiculo el nueva vehicluo que reemplazará a la existente..
     * @return la lista de vehículos.
     */
    public boolean replace(Vehiculo vehiculo) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId() == vehiculo.getId()) {
                vehiculos.set(i, vehiculo);
                return true;
            }
        }
        return false;
    }
/**
     * Devuelve la lista de vehículos.
     * @param vehiculo el vehículo a eliminar.
     * @return la lista de vehículos.
     */
    public boolean remove(Vehiculo vehiculo) {
        return vehiculos.remove(vehiculo);
    }

    public boolean remove(int id) {
        return vehiculos.removeIf(vehiculo -> vehiculo.getId() == id);
    }
}