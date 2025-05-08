package es.eug.campus;

public class Vehiculo {
    private int id;
    private String modelo;
    private String estado;
    private double precio; // Precio total del vehículo
    private double precioPorDia; // Precio por día (nueva propiedad)

    public Vehiculo(int id, String modelo, String estado, double precio) {
        if (id < 0) {
            throw new IllegalArgumentException("El ID no puede ser negativo");
        }
        if (modelo == null) {
            throw new IllegalArgumentException("El modelo no puede ser nulo");
        }
        if (estado == null || estado.isEmpty()) {
            throw new IllegalArgumentException("El estado no puede ser nulo o vacío");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }
        this.id = id;
        this.modelo = modelo;
        this.estado = estado;
        this.precio = precio;
        this.precioPorDia = calcularPrecioPorDia(); // Inicializar el precio por día
    }

    // Método para calcular el precio por día (puedes personalizar la lógica)
    private double calcularPrecioPorDia() {
        return this.precio / 30; // Ejemplo: dividir el precio total entre 30 días
    }

    // Nuevo método getPrecioPorDia()
    public double getPrecioPorDia() {
        return this.precioPorDia;
    }

    // Getters y setters existentes
    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public String getEstado() {
        return estado;
    }

    public double getPrecio() {
        return precio;
    }
}