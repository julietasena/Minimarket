package clasesDAO;

import Modelos.Comanda;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ComandaDAO extends DAO{
    public static void crearTablaComandaDAO() {
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE COMANDA" +
                    "(idComanda INTEGER auto_increment ," +
                    "IdPlato INTEGER, " +
                    "idCliente INTEGER," +

                    " PRIMARY KEY ( idComanda )," +
                    "FOREIGN KEY (idPlato) REFERENCES PLATO(idPlato))" ;
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosComandaDAO(Comanda comanda){
        //Paso 3: Ejecutar una consulta
        try {
            System.out.println("Insertando datos en la base de datos...");
            stmt = conn.createStatement();
            String sql = "insert into COMANDA" +
                    "(idPlato,idCliente) values ("+comanda.getIdPlato()+","+comanda.getidCliente()+")";
            stmt.executeUpdate(sql);
            System.out.println("Se insertaron los datos...");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void leerDatosComandaDAO(){
        //Paso 3: Ejecutar una consulta
        try {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "select * from COMANDA";
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
    public static int obtenerUltimoIdComanda() {
        int ultimoIdComanda = 0;
        try  {
            ResultSet rs;
            System.out.println("Leyendo datos desde la base de datos...");
            stmt = conn.createStatement();
            String sql = "SELECT MAX(idComanda) FROM COMANDA";
            rs = stmt.executeQuery(sql);

                if (rs.next()) {
                    ultimoIdComanda = rs.getInt(1);
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ultimoIdComanda;
    }
}
