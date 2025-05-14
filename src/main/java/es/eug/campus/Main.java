package es.eug.campus;
import java.util.Scanner;

/**
 * Clase principal que gestiona la aplicación de gestión de vehículos.
 */
public class Main {
    public static void main(String[] args) {
        EntityManager bbdd = new EntityManager();
        boolean conexionExitosa = bbdd.init();

        if (conexionExitosa) {
            System.out.println("Conexión a la base de datos establecida correctamente.");
        } else {
            System.out.println("Error: No se pudo conectar a la base de datos.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Gestionar Clientes");
            System.out.println("2. Gestionar Vehículos");
            System.out.println("3. Gestionar Oficinas");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    menuClientes(scanner);
                    break;
                case 2:
                    menuVehiculos(scanner);
                    break;
                case 3:
                    menuOficinas(scanner);
                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtalo de nuevo.");
            }
        } while (opcion != 0);

        bbdd.unLoad();
        scanner.close();
    }

    private static void menuClientes(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú Clientes ---");
            System.out.println("1. Añadir Cliente");
            System.out.println("2. Actualizar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Buscar Cliente");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Nombre: ");
                    String nombre = scanner.next();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.next();
                    System.out.print("DNI: ");
                    String dni = scanner.next();
                    Cliente nuevoCliente = new Cliente(0, nombre, telefono, dni);
                    if (EntityManager.Persist(nuevoCliente)) {
                        System.out.println("Cliente añadido correctamente.");
                    } else {
                        System.out.println("Error al añadir el cliente.");
                    }
                    break;
                case 2:
                    System.out.print("ID del Cliente a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo Nombre: ");
                    String nuevoNombre = scanner.next();
                    System.out.print("Nuevo Teléfono: ");
                    String nuevoTelefono = scanner.next();
                    System.out.print("Nuevo DNI: ");
                    String nuevoDni = scanner.next();
                    Cliente clienteActualizar = new Cliente(idActualizar, nuevoNombre, nuevoTelefono, nuevoDni);
                    if (EntityManager.Merge(clienteActualizar)) {
                        System.out.println("Cliente actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar el cliente.");
                    }
                    break;
                case 3:
                    System.out.print("ID del Cliente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    Cliente clienteEliminar = new Cliente(idEliminar, null, null, null);
                    if (EntityManager.Remove(clienteEliminar)) {
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("Error al eliminar el cliente.");
                    }
                    break;
                case 4:
                    System.out.print("Nombre (opcional): ");
                    String buscarNombre = scanner.next();
                    System.out.print("Teléfono (opcional): ");
                    String buscarTelefono = scanner.next();
                    System.out.print("DNI (opcional): ");
                    String buscarDni = scanner.next();
                    Cliente clienteBuscar = new Cliente(0, buscarNombre, buscarTelefono, buscarDni);
                    Cliente[] resultados = EntityManager.Find(clienteBuscar);
                    if (resultados != null && resultados.length > 0) {
                        System.out.println("Clientes encontrados:");
                        for (Cliente c : resultados) {
                            System.out.println(c.getId() + " - " + c.getNombre() + " - " + c.getTelefono() + " - " + c.getDni());
                        }
                    } else {
                        System.out.println("No se encontraron clientes.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void menuVehiculos(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú Vehículos ---");
            System.out.println("1. Añadir Vehículo");
            System.out.println("2. Actualizar Vehículo");
            System.out.println("3. Eliminar Vehículo");
            System.out.println("4. Buscar Vehículo");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Modelo: ");
                    String modelo = scanner.next();
                    System.out.print("Estado: ");
                    String estado = scanner.next();
                    System.out.print("Precio por día: ");
                    double precioPorDia = scanner.nextDouble();
                    Vehiculo nuevoVehiculo = new Vehiculo(0, modelo, estado, precioPorDia);
                    if (EntityManager.Persist(nuevoVehiculo)) {
                        System.out.println("Vehículo añadido correctamente.");
                    } else {
                        System.out.println("Error al añadir el vehículo.");
                    }
                    break;
                case 2:
                    System.out.print("ID del Vehículo a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nuevo Modelo: ");
                    String nuevoModelo = scanner.next();
                    System.out.print("Nuevo Estado: ");
                    String nuevoEstado = scanner.next();
                    System.out.print("Nuevo Precio por día: ");
                    double nuevoPrecioPorDia = scanner.nextDouble();
                    Vehiculo vehiculoActualizar = new Vehiculo(idActualizar, nuevoModelo, nuevoEstado, nuevoPrecioPorDia);
                    if (EntityManager.Merge(vehiculoActualizar)) {
                        System.out.println("Vehículo actualizado correctamente.");
                    } else {
                        System.out.println("Error al actualizar el vehículo.");
                    }
                    break;
                case 3:
                    System.out.print("ID del Vehículo a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    Vehiculo vehiculoEliminar = new Vehiculo(idEliminar, null, null, 0);
                    if (EntityManager.Remove(vehiculoEliminar)) {
                        System.out.println("Vehículo eliminado correctamente.");
                    } else {
                        System.out.println("Error al eliminar el vehículo.");
                    }
                    break;
                case 4:
                    System.out.print("Modelo (opcional): ");
                    String buscarModelo = scanner.next();
                    System.out.print("Estado (opcional): ");
                    String buscarEstado = scanner.next();
                    System.out.print("Precio por día (opcional): ");
                    double buscarPrecioPorDia = scanner.nextDouble();
                    Vehiculo vehiculoBuscar = new Vehiculo(0, buscarModelo, buscarEstado, buscarPrecioPorDia);
                    Vehiculo[] resultados = EntityManager.Find(vehiculoBuscar);
                    if (resultados != null && resultados.length > 0) {
                        System.out.println("Vehículos encontrados:");
                        for (Vehiculo v : resultados) {
                            System.out.println(v.getId() + " - " + v.getModelo() + " - " + v.getEstado() + " - " + v.getPrecioPorDia());
                        }
                    } else {
                        System.out.println("No se encontraron vehículos.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    private static void menuOficinas(Scanner scanner) {
        int opcion;
        do {
            System.out.println("\n--- Menú Oficinas ---");
            System.out.println("1. Añadir Oficina");
            System.out.println("2. Actualizar Oficina");
            System.out.println("3. Eliminar Oficina");
            System.out.println("4. Buscar Oficina");
            System.out.println("0. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ciudad: ");
                    String ciudad = scanner.next();
                    System.out.print("Dirección: ");
                    String direccion = scanner.next();
                    System.out.print("Teléfono: ");
                    String telefono = scanner.next();
                    Oficina nuevaOficina = new Oficina(0, ciudad, direccion, telefono);
                    if (EntityManager.Persist(nuevaOficina)) {
                        System.out.println("Oficina añadida correctamente.");
                    } else {
                        System.out.println("Error al añadir la oficina.");
                    }
                    break;
                case 2:
                    System.out.print("ID de la Oficina a actualizar: ");
                    int idActualizar = scanner.nextInt();
                    System.out.print("Nueva Ciudad: ");
                    String nuevaCiudad = scanner.next();
                    System.out.print("Nueva Dirección: ");
                    String nuevaDireccion = scanner.next();
                    System.out.print("Nuevo Teléfono: ");
                    String nuevoTelefono = scanner.next();
                    Oficina oficinaActualizar = new Oficina(idActualizar, nuevaCiudad, nuevaDireccion, nuevoTelefono);
                    if (EntityManager.Merge(oficinaActualizar)) {
                        System.out.println("Oficina actualizada correctamente.");
                    } else {
                        System.out.println("Error al actualizar la oficina.");
                    }
                    break;
                case 3:
                    System.out.print("ID de la Oficina a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    Oficina oficinaEliminar = new Oficina(idEliminar, null, null, null);
                    if (EntityManager.Remove(oficinaEliminar)) {
                        System.out.println("Oficina eliminada correctamente.");
                    } else {
                        System.out.println("Error al eliminar la oficina.");
                    }
                    break;
                case 4:
                    System.out.print("Ciudad (opcional): ");
                    String buscarCiudad = scanner.next();
                    System.out.print("Dirección (opcional): ");
                    String buscarDireccion = scanner.next();
                    System.out.print("Teléfono (opcional): ");
                    String buscarTelefono = scanner.next();
                    Oficina oficinaBuscar = new Oficina(0, buscarCiudad, buscarDireccion, buscarTelefono);
                    Oficina[] resultados = EntityManager.Find(oficinaBuscar);
                    if (resultados != null && resultados.length > 0) {
                        System.out.println("Oficinas encontradas:");
                        for (Oficina o : resultados) {
                            System.out.println(o.getId() + " - " + o.getCiudad() + " - " + o.getDireccion() + " - " + o.getTelefono());
                        }
                    } else {
                        System.out.println("No se encontraron oficinas.");
                    }
                    break;
                case 0:
                    System.out.println("Volviendo al Menú Principal...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }
}