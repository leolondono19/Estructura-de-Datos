

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import Productos.Producto;

public class GestionProductos {
    private HashMap<Integer, Producto> productos;
    private int nextId;
    public Connection connection;

    public GestionProductos(Connection connection) {
        this.connection = connection;
        productos = new HashMap<>();
        nextId = 1;
        cargarProductosDesdeBD();
    }

    public void agregarProducto(Producto producto) {
        productos.put(nextId, producto);
        guardarProductoEnBD(nextId, producto);
        nextId++;
    }

    public Producto obtenerProducto(int id) {
        return productos.get(id);
    }

    public void eliminarProducto(int id) {
        productos.remove(id);
        eliminarProductoDeBD(id);
    }

    public void mostrarTodosLosProductos() {
        for (Producto producto : productos.values()) {
            System.out.println(producto);
        }
    }

    private void guardarProductoEnBD(int id, Producto producto) {
        String sql = "INSERT INTO Productos (id, descripcion, precio, marca, modelo, stock, garantiaMeses) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.setString(2, producto.getDescripcion());
            pstmt.setFloat(3, producto.getPrecio());
            pstmt.setString(4, producto.getMarca());
            pstmt.setString(5, producto.getModelo());
            pstmt.setInt(6, producto.getStock());
            pstmt.setInt(7, producto.getGarantiaMeses());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void eliminarProductoDeBD(int id) {
        String sql = "DELETE FROM Productos WHERE id = ?";
        try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void cargarProductosDesdeBD() {
        String sql = "SELECT * FROM Productos";
        try (PreparedStatement pstmt = connection.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String descripcion = rs.getString("descripcion");
                float precio = rs.getFloat("precio");
                String marca = rs.getString("marca");
                String modelo = rs.getString("modelo");
                int stock = rs.getInt("stock");
                int garantiaMeses = rs.getInt("garantiaMeses");

                Producto producto = new Producto(descripcion, precio, marca, modelo, stock, garantiaMeses) {};
                productos.put(id, producto);
                if (id >= nextId) {
                    nextId = id + 1;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
