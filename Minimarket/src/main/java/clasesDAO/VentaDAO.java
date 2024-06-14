package clasesDAO;

import Modelos.Venta;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VentaDAO extends DAO{
    public static void crearTablaVentaDAO() {
        //Paso 3: Ejecutar una consulta nombre, String apellido, int edad, int dni, int idCliente
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE VENTA" +
                    "(idVenta INTEGER auto_increment, " +
                    " idCliente INTEGER, " +
                    "idProducto INTEGER," +
                    "idComanda INTEGER,"+
                    " fechaVenta DATE, " +
                    "monto DOUBLE, "+

                    " PRIMARY KEY ( idVenta )," +
                    "FOREIGN KEY (idProducto) REFERENCES PRODUCTO(idProducto)," +
                    "FOREIGN KEY (idCliente) REFERENCES CLIENTE(idCliente)," +
                    "FOREIGN KEY (idComanda) REFERENCES COMANDA(idComanda))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosVentaDAO(Venta venta){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into VENTA" +
                    "(fechaVenta, idCliente, monto,idProducto, idComanda) values ('"+venta.getFecha()+"',"+venta.getId_cliente()+","+venta.getMonto()+","+venta.getIdProducto()+","+null+")";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void guardarDatosVentaComandaDAO(Venta venta){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into VENTA" +
                    "(fechaVenta, idCliente, monto,idProducto, idComanda) values ('"+venta.getFecha()+"',"+venta.getId_cliente()+","+venta.getMonto()+","+null+","+venta.getIdComanda()+")";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosVentasDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "select * from VENTA";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Dato leido: " + rs.getString(2));
            }
            System.out.println("Se leyeron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void hacerVentaProducto(int idProducto) {

        ProductoDAO.modificarStock(idProducto, -1);

    }
    public static double obtenerVentasDiarias(Date fecha) {
        double totalVentas = 0;
        try {
            String sql = "SELECT SUM(monto) FROM VENTA WHERE fechaVenta = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setDate(1, fecha);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        totalVentas = resultSet.getDouble(1);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Error al obtener ventas diarias: " + e.getMessage(), e);
        }
        return totalVentas;
    }
    public static double obtenerVentasMensuales(int mes, int anio) {
        double totalVentas = 0;
        try{
            String sql = "SELECT SUM(monto) FROM VENTA WHERE MONTH(fechaVenta) = ? AND YEAR(fechaVenta) = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, mes);
                statement.setInt(2, anio);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        totalVentas = resultSet.getDouble(1);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return totalVentas;
    }
    public static double calcularVentas(){
        double totalVentas = 0;
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select SUM(monto) from VENTA";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {               // Position the cursor                 3
                totalVentas= rs.getDouble(1);
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return totalVentas;
    }


}
