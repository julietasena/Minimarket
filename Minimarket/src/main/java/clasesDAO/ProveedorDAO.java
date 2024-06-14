package clasesDAO;

import Modelos.Proveedor;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProveedorDAO extends DAO{
    public static void crearTablaProveedorDAO() {
        //Paso 3: Ejecutar una consulta
        //int idProveedor, String razonSocial, int cuil, double deuda
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE PROVEEDOR" +
                    "(idProveedor INTEGER auto_increment, " +
                    " razonSocial VARCHAR(255), " +
                    "  cuil INTEGER, " +
                    " deuda DOUBLE, "+
                    " PRIMARY KEY ( idProveedor ))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosProvedorDAO(Proveedor proveedor){
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "insert into PROVEEDOR" +
                    "(razonSocial, cuil, deuda) values ('"+proveedor.getRazonSocial()+"',"+proveedor.getCuil()+","+proveedor.getDeuda()+")";
            stmt.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosProveedorDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select * from PROVEEDOR";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Provedor: [" +rs.getInt(1)+"] "+ rs.getString(2)+" Deuda: "+rs.getDouble(4));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }
    public static void modificarDeuda(int idProveedor, double pago) {
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            // Obtener el stock actual del producto
            String sqlSelect = "SELECT deuda FROM PROVEEDOR WHERE idProveedor = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idProveedor);
            rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                double deudaActual = rs.getDouble("deuda");
                double nuevaDeuda = deudaActual - pago;

                // Actualizar el stock del producto
                String sqlUpdate = "UPDATE PROVEEDOR SET deuda = ? WHERE idProveedor = ?";
                pstmtUpdate = conn.prepareStatement(sqlUpdate);
                pstmtUpdate.setDouble(1, nuevaDeuda);
                pstmtUpdate.setInt(2, idProveedor);
                pstmtUpdate.executeUpdate();

                System.out.println("Deuda modificada");
                leerDatosProveedorDAO(); // Asegúrate de que este método esté definido en la clase
            } else {
                System.out.println("Proveedor no encontrado con id: " + idProveedor);
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la deuda: " + e.getMessage());
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
}
