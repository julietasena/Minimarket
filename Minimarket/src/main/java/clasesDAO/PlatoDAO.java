package clasesDAO;

import Modelos.Plato;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlatoDAO extends DAO{
    public static void crearTablaPlatoDAO() {
        //Paso 3: Ejecutar una consulta
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE  PLATO" +
                    "(idPlato INTEGER auto_increment, " +
                    " nombrePlato VARCHAR(255), " +
                    " precioPlato DOUBLE, " +
                    "cantidaVendida INTEGER," +
                    " PRIMARY KEY ( idPlato ))"
                    ;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void guardarDatosPlatoDAO(Plato plato){
        //Paso 3: Ejecutar una consulta
        try {
            stmt = conn.createStatement();
            String sql = "insert into PLATO" +
                    "(nombrePlato, precioPlato, cantidaVendida) values ('"+plato.getNombre_plato()+"',"+plato.getPrecio_plato()+","+plato.getCaantidadVentas()+")";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void leerDatosPlatoDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select * from PLATO";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Plato: [" +rs.getInt(1)+"] "+ rs.getString(2)+" Precio: "+ rs.getDouble(3));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static double obtenerPrecioPlato(int idPlato) {
        double precioPlato = 0;
        try {
            String sql = "SELECT precioPlato FROM PLATO WHERE idPlato = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, idPlato);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        precioPlato = resultSet.getDouble("precioPlato");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return precioPlato;
    }
    public static void sumarVentas(int idPlato) {
        try {
            String sqlSelect = "SELECT cantidaVendida FROM PLATO WHERE idPlato = ?";
            try (PreparedStatement pstmtSelect = conn.prepareStatement(sqlSelect)) {
                pstmtSelect.setInt(1, idPlato);
                try (ResultSet rs = pstmtSelect.executeQuery()) {
                    if (rs.next()) {
                        int stockActual = rs.getInt("cantidaVendida");
                        int nuevoStock = ++stockActual; // Incremento antes de asignar

                        String sqlUpdate = "UPDATE PLATO SET cantidaVendida = ? WHERE idPlato = ?";
                        try (PreparedStatement pstmtUpdate = conn.prepareStatement(sqlUpdate)) {
                            pstmtUpdate.setInt(1, nuevoStock);
                            pstmtUpdate.setInt(2, idPlato);
                            pstmtUpdate.executeUpdate();
                        }
                    } else {
                        System.out.println("Plato no encontrado con id: " + idPlato);
                    }
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la cantidad vendida: " + e.getMessage());
        }
    }
    public static int calcularTotalVentas(){
        int totalVentas = 0;
        try {
            ResultSet rs;
            stmt = conn.createStatement();
            String sql = "select  SUM(cantidaVendida) from PLATO";
            rs = stmt.executeQuery(sql);
            if(rs.next()) {               // Position the cursor                 3
                totalVentas= rs.getInt(1);
            }
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return totalVentas;
    }
    public static void mostrarEstadisticaPlatos(){
        try {
            ResultSet rs;
            System.out.println("Estadistica de Venta de Platos:");
            stmt = conn.createStatement();
            String sql = "select * from PLATO";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Plato: [" +rs.getInt(1)+"] "+ rs.getString(2)+" Porcentaje de Venta: "+ ((rs.getInt(4)*100)/calcularTotalVentas())+"%");
            }
            System.out.println("Se leyeron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }


}
