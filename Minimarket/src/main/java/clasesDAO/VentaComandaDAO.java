package clasesDAO;

import java.sql.ResultSet;

public class VentaComandaDAO extends DAO{
    public static void crearTablaVentaComandaDAO() {
        //Paso 3: Ejecutar una consulta nombre, String apellido, int edad, int dni, int idCliente
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE VENTACOMANDA" +
                    "(idComanda INTEGER , " +
                    " idVenta INTEGER, " +
                    "PRIMARY KEY ( idComanda,idVenta)," +
                    "FOREIGN KEY (idComanda) REFERENCES COMANDA(idComanda)," +
                    "FOREIGN KEY (idVenta) REFERENCES VENTA(idVenta))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosCienteDAO(String nombre, String apellido, int edad, int dni, int idCliente){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into CLIENTE" +
                    "(idCliente, nombre, apellido, edad, dni) values ("+idCliente+",'"+nombre+"','"+apellido+"',"+edad+","+dni+")";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosCLienteDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "select * from CLIENTE";
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
}
