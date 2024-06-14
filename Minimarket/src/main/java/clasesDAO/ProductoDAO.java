package clasesDAO;

import Modelos.Producto;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO extends DAO {
    public static void crearTablaProductoDAO() {
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE PRODUCTO " +
                    "(idProducto INTEGER auto_increment, " +
                    " nombre_producto VARCHAR(255), " +
                    " precio_producto DOUBLE PRECISION, " +
                    "stock INTEGER, " +
                    " PRIMARY KEY ( idProducto ))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }

    public static void guardarDatosProductoDAO(Producto producto) {
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "insert into PRODUCTO" +
                    "( nombre_producto, precio_producto,stock) values ('" + producto.getNombre_producto() + "'," + producto.getPrecio_producto() + "," + producto.getStockProducto() + ")";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosProductoDAO() {
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "select * from PRODUCTO";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3pre
                System.out.println("Producto [" + rs.getInt(1) + "] " + rs.getString(2) + " Precio:$" + rs.getDouble(3) + " Stock:" + rs.getInt(4));
            }
            System.out.println("Se leyeron los datos...");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void modificarStock(int idProducto, int cantidadASumar) {
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            // Obtener el stock actual del producto
            String sqlSelect = "SELECT stock FROM PRODUCTO WHERE idProducto = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idProducto);
            rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                int stockActual = rs.getInt("stock");
                int nuevoStock = stockActual + cantidadASumar;

                // Actualizar el stock del producto
                String sqlUpdate = "UPDATE PRODUCTO SET stock = ? WHERE idProducto = ?";
                pstmtUpdate = conn.prepareStatement(sqlUpdate);
                pstmtUpdate.setInt(1, nuevoStock);
                pstmtUpdate.setInt(2, idProducto);
                pstmtUpdate.executeUpdate();

                System.out.println("Stock modificado");
                leerDatosProductoDAO(); // Asegúrate de que este método esté definido en la clase
            } else {
                System.out.println("Producto no encontrado con id: " + idProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar el stock: " + e.getMessage());
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
                if (pstmtUpdate != null) pstmtUpdate.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
    }
    public static double calcularMonto(int idProducto, int stock) {
        double monto = 0;
        PreparedStatement pstmtSelect = null;
        ResultSet rs = null;

        try {
            // Obtener el stock y precio actual del producto
            String sqlSelect = "SELECT stock, precio_producto FROM PRODUCTO WHERE idProducto = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idProducto);
            rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                int precio = rs.getInt("precio_producto");
                monto = precio * stock;
            } else {
                throw new RuntimeException("Producto no encontrado con ID: " + idProducto);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al calcular el monto: " + e.getMessage(), e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return monto;
    }

    public static double calcularMonto1(int idProducto, int stock){
        double monto=0;
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            // Obtener el stock actual del producto
            String sqlSelect = "SELECT stock FROM PRODUCTO WHERE idProducto = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idProducto);
            rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                monto = rs.getInt("precio")* stock;
            } else {
                System.out.println("Producto no encontrado con id: " + idProducto);
            }
        } catch (SQLException e) {
            System.out.println("Error al calcular el monto: " + e.getMessage());
        } finally {
            // Cerrar los recursos
            try {
                if (rs != null) rs.close();
                if (pstmtSelect != null) pstmtSelect.close();
                if (pstmtUpdate != null) pstmtUpdate.close();
            } catch (SQLException e) {
                System.out.println("Error al cerrar recursos: " + e.getMessage());
            }
        }
        return monto;
    }
}
