package clasesDAO;

import Modelos.Pago;

import java.sql.ResultSet;

public class PagoDAO extends DAO {
    public static void crearTablaPagoDAO() {
        //Paso 3: Ejecutar una consulta id_Pago, int id_proveedor, Date fecha_pago, double monto
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE PAGO ("+
            "idPago INT PRIMARY KEY auto_increment,"+
            "idProveedor INT,"+
            "fechaPago DATE,"+
            "monto DOUBLE,"+
            "FOREIGN KEY (idProveedor) REFERENCES PROVEEDOR(idProveedor))";

            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosPagoDAO(Pago pago){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into PAGO" +
                    "(idProveedor, fechaPago, monto) values ("+pago.getId_proveedor()+",'"+pago.getFecha_pago()+"',"+pago.getMonto()+")";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static void guardarDatosPagoCuentaDAO(Pago pago){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into PAGO" +
                    "(idProveedor, fechaPago, monto) values ("+null+",'"+pago.getFecha_pago()+"',"+pago.getMonto()+")";
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
            String sql = "select * from PAGO";
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
    public static double calcularPagos(){
        double totalVentas = 0;
        try {
            ResultSet rs;

            stmt = conn.createStatement();
            String sql = "select SUM(monto) from PAGO";
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
