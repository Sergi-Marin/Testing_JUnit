package es.eug.campus;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EntityManager {
    private static Connection conn;

    public boolean init() {
        try {
            Properties p = loadPropertiesFile();
            if (p == null) return false;

            String strConn = (String) p.get("db.string_connection");
            System.out.println(strConn);
            conn = DriverManager.getConnection(strConn);
            return true;
        } catch (SQLException e) {
            showError(e);
            unLoad();
            return false;
        }
    }

    public void showError(SQLException e) {
        System.out.println("Mensaje de error: " + e.getMessage());
        System.out.println("SQLState: " + e.getSQLState());
        System.out.println("VendorError: " + e.getErrorCode());
    }

    public void unLoad() {
        try {
            if (conn != null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private Properties loadPropertiesFile() {
        Properties p = new Properties();
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("config.properties");
            p.load(resourceAsStream);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return p;
    }

    // --- Métodos para Vehiculo ---
    public static boolean Persist(Vehiculo vehiculo) {
        String sql = "INSERT INTO vehiculos (modelo, estado, precio_por_dia) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getModelo());
            pstmt.setString(2, vehiculo.getEstado());
            pstmt.setDouble(3, vehiculo.getPrecioPorDia());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Merge(Vehiculo vehiculo) {
        String sql = "UPDATE vehiculos SET modelo = ?, estado = ?, precio_por_dia = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getModelo());
            pstmt.setString(2, vehiculo.getEstado());
            pstmt.setDouble(3, vehiculo.getPrecioPorDia());
            pstmt.setInt(4, vehiculo.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Remove(Vehiculo vehiculo) {
        String sql = "DELETE FROM vehiculos WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, vehiculo.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Vehiculo[] Find(Vehiculo vehiculo) {
        String sql = "SELECT * FROM vehiculos WHERE modelo = ? OR estado = ? OR precio_por_dia = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, vehiculo.getModelo());
            pstmt.setString(2, vehiculo.getEstado());
            pstmt.setDouble(3, vehiculo.getPrecioPorDia());
            ResultSet rs = pstmt.executeQuery();
            List<Vehiculo> vehiculos = new ArrayList<>();
            while (rs.next()) {
                Vehiculo v = new Vehiculo(
                        rs.getInt("id"),
                        rs.getString("modelo"),
                        rs.getString("estado"),
                        rs.getDouble("precio_por_dia")
                );
                vehiculos.add(v);
            }
            return vehiculos.toArray(new Vehiculo[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    // --- Métodos para Cliente ---
    public static boolean Persist(Cliente cliente) {
        String sql = "INSERT INTO clientes (nombre, telefono, dni) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getDni());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Merge(Cliente cliente) {
        String sql = "UPDATE clientes SET nombre = ?, telefono = ?, dni = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getDni());
            pstmt.setInt(4, cliente.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Remove(Cliente cliente) {
        String sql = "DELETE FROM clientes WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, cliente.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Cliente[] Find(Cliente cliente) {
        String sql = "SELECT * FROM clientes WHERE nombre = ? OR telefono = ? OR dni = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombre());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getDni());
            ResultSet rs = pstmt.executeQuery();
            List<Cliente> clientes = new ArrayList<>();
            while (rs.next()) {
                Cliente c = new Cliente(rs.getInt("id"), rs.getString("nombre"), rs.getString("telefono"), rs.getString("dni"));
                clientes.add(c);
            }
            // Cliente[0] se utiliza para especificar el tipo de array que deseamos obtener
            return clientes.toArray(new Cliente[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    // --- Métodos para Oficina ---
    public static boolean Persist(Oficina oficina) {
        String sql = "INSERT INTO oficinas (ciudad, direccion, telefono) VALUES (?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, oficina.getCiudad());
            pstmt.setString(2, oficina.getDireccion());
            pstmt.setString(3, oficina.getTelefono());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Merge(Oficina oficina) {
        String sql = "UPDATE oficinas SET ciudad = ?, direccion = ?, telefono = ? WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, oficina.getCiudad());
            pstmt.setString(2, oficina.getDireccion());
            pstmt.setString(3, oficina.getTelefono());
            pstmt.setInt(4, oficina.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean Remove(Oficina oficina) {
        String sql = "DELETE FROM oficinas WHERE id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, oficina.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Oficina[] Find(Oficina oficina) {
        String sql = "SELECT * FROM oficinas WHERE ciudad = ? OR direccion = ? OR telefono = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, oficina.getCiudad());
            pstmt.setString(2, oficina.getDireccion());
            pstmt.setString(3, oficina.getTelefono());
            ResultSet rs = pstmt.executeQuery();
            List<Oficina> oficinas = new ArrayList<>();
            while (rs.next()) {
                Oficina o = new Oficina(
                        rs.getInt("id"),
                        rs.getString("ciudad"),
                        rs.getString("direccion"),
                        rs.getString("telefono")
                );
                oficinas.add(o);
            }
            return oficinas.toArray(new Oficina[0]);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}