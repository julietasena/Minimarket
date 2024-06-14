package clasesDAO;

public class ComandaPlatoDAO extends DAO{
    public static void crearTablaComandaPlatoDAO() {
        //Paso 3: Ejecutar una consulta
        try {

            stmt = conn.createStatement();
            String sql = "CREATE TABLE COMANDAPLATO" +
                    "(idComanda INTEGER , " +
                    " idPlato INTEGER, " +
                    "PRIMARY KEY ( idComanda,idPlato)," +
                    "FOREIGN KEY (idComanda) REFERENCES COMANDA(idComanda)," +
                    "FOREIGN KEY (idPlato) REFERENCES PLATO(idPlato))";
            stmt.executeUpdate(sql);

        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
