package clasesDAO;

import Modelos.Cliente;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteDAO extends DAO{
    public static void crearTablaClienteDAO() {
        //Paso 3: Ejecutar una consulta nombre, String apellido, int edad, int dni, int idCliente
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE CLIENTE" +
                    "(idCliente INTEGER auto_increment, " +
                    " nombre VARCHAR(255), " +
                    " apellido VARCHAR(255), " +
                    "edad INTEGER, "+
                    "dni INTEGER," +
                    "cantidadDeCompras INTEGER, "+
                    " PRIMARY KEY ( idCliente ))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosCienteDAO(Cliente cliente){
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "insert into CLIENTE" +
                    "( nombre, apellido, edad, dni,cantidadDeCompras) values ('"+ cliente.getNombre()+"','"+cliente.getApellido()+"',"+cliente.getEdad()+","+cliente.getDni()+","+cliente.getCantidadDeCompras()+")";
            stmt.executeUpdate(sql);

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosCLienteDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select * from CLIENTE";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Cliente: [" + rs.getInt(1)+"] "+ rs.getString(2)+" "+ rs.getString(3));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void eliminarDatosCLienteDAO(int id){


    }
    public static void agregarCompra(int idCliente){
        PreparedStatement pstmtSelect = null;
        PreparedStatement pstmtUpdate = null;
        ResultSet rs = null;

        try {
            // Obtener el stock actual del producto
            String sqlSelect = "SELECT cantidadDeCompras FROM CLIENTE WHERE idCliente = ?";
            pstmtSelect = conn.prepareStatement(sqlSelect);
            pstmtSelect.setInt(1, idCliente);
            rs = pstmtSelect.executeQuery();

            if (rs.next()) {
                int compras = rs.getInt("cantidadDeCompras");
                int nuevoCompra = compras + 1;

                // Actualizar el stock del producto
                String sqlUpdate = "UPDATE PRODUCTO SET cantidadDeCompras = ? WHERE idCliente = ?";
                pstmtUpdate = conn.prepareStatement(sqlUpdate);
                pstmtUpdate.setInt(1, nuevoCompra);
                pstmtUpdate.setInt(2, idCliente);
                pstmtUpdate.executeUpdate();


            } else {
                System.out.println("Cliente no encontrado con id: " + idCliente);
            }
        } catch (SQLException e) {
            System.out.println("Error al modificar la compras: " + e.getMessage());
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
