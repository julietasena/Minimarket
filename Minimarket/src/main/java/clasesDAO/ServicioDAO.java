package clasesDAO;

import Modelos.Plato;
import Modelos.Servicio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ServicioDAO extends DAO{
    public static void crearTablaServicioDAO() {
        //Paso 3: Ejecutar una consulta
        try {
            stmt = conn.createStatement();
            String sql = "CREATE TABLE  SERVICIO" +
                    "(idServicio INTEGER auto_increment, " +
                    " nombreServicio VARCHAR(255), " +
                    " precioServicio DOUBLE, " +
                    " PRIMARY KEY ( idServicio ))"
                    ;
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public static void guardarDatosServicioDAO(Servicio servicio){
        //Paso 3: Ejecutar una consulta
        try {
            stmt = conn.createStatement();
            String sql = "insert into SERVICIO" +
                    "(nombreServicio, precioServicio) values ('"+servicio.getNombreServicio()+"',"+servicio.getPrecioServicio()+")";
            stmt.executeUpdate(sql);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }

    }

    public static void leerDatosServicioDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select * from SERVICIO";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("SERVICIO: [" +rs.getInt(1)+"] "+ rs.getString(2)+" Pago: "+ rs.getDouble(3));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static double obtenerPrecioServicio(int idServicio) {
        double precioServicio = 0;
        try {
            String sql = "SELECT precioServicio FROM SERVICIO WHERE idServicio = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, idServicio);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        precioServicio = resultSet.getDouble("precioServicio");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return precioServicio;
    }
}
