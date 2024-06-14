package clasesDAO;

import java.sql.Connection;
import java.sql.Statement;

public  abstract class DAO {
    public static final String JDBC_DRIVER = "org.h2.Driver";
    //static final String DB_URL = "jdbc:h2:~/testdb";
    //static final String DB_URL = "jdbc:h2:~/h2/testdb";
    //static final String DB_URL = "jdbc:h2:mem:test";
    //static final String DB_URL = "jdbc:h2:tcp://localhost/~/h2/test";

    public static final String DB_URL = "jdbc:h2:tcp://localhost/~/test";

    //  Credenciales
    public static final String USER = "sa";
    public static final String PASS = "";

    public static Connection conn = null;
    public static Statement stmt = null;


}
