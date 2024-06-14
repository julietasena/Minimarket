package clasesDAO;

import Modelos.Empleado;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO extends DAO{
    public static void crearTablaEmpleadoDAO() {
        //Paso 3: Ejecutar una consulta
        //idEmpleado,String nombre, String apellido, int edad, int dni, Date fechaIngreso, int diaPago, double sueldo
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE EMPLEADO" +
                    "(idEmpleado INTEGER auto_increment, " +
                    " nombre VARCHAR(255), " +
                    " apellido VARCHAR(255), " +
                    "edad INTEGER, "+
                    "dni INTEGER, "+
                    "fechaIngreso DATE, " +
                    "sueldo DOUBLE, "+
                    " PRIMARY KEY ( idEmpleado ))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
    public static void guardarDatosEmpleadoDAO(Empleado empleado){
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "insert into EMPLEADO" +
                    "(nombre, apellido, edad, dni,fechaIngreso, sueldo) values ('"+empleado.getNombre()+"','"+empleado.getApellido()+"',"+empleado.getEdad()+","+empleado.getDni()+",'"+empleado.getFechaIngreso()+"',"+empleado.getSueldo()+")";
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
            String sql = "select * from Empleado";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {               // Position the cursor                 3
                System.out.println("Empleado: ["+rs.getInt(1)+"] " + rs.getString(2)+" "+ rs.getNString(3)+" Sueldo: "+ rs.getDouble(7));
            }

        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
    public static double obtenerSueldo(int idEmpleado) {
        double sueldo = 0;
        try {
            String sql = "SELECT sueldo FROM EMPLEADO WHERE idEmpleado = ?";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setInt(1, idEmpleado);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        sueldo = resultSet.getDouble("sueldo");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sueldo;
    }
}
