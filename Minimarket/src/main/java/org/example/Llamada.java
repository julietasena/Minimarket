package org.example;


import clasesDAO.PlatoDAO;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

import static clasesDAO.DAO.*;

public class Llamada {

    private static final Logger consoleLogger = LogManager.getLogger("ConsoleLogger");
    private static final Logger fileLogger = LogManager.getLogger("FileLogger");
    private static final Logger mail = LogManager.getLogger("mail");
    public static void main(String[] args) {

        try {
            // Paso 1: Registrar el driver jdbc
            Class.forName(JDBC_DRIVER);


            //Paso 2: Abrir una conexión
            System.out.println("Conectándose a la base de datos...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            //eliminamos las tablas en la base de datos para que al cargar no se sobreescriban en las que existen

            Metodos.eliminarTablas();
            Scanner sc = new Scanner(System.in);

            //creo todas las tablas a utilizar
          Metodos.crearTablas();
          //agrego datos a las diferentes tablas para poder trabajr con ellas
          Metodos.agregarProductos();
          Metodos.agregarClientes();
          Metodos.agregarProvedores();
          Metodos.agregarPlatos();
          Metodos.agregarEmpleados();
          Metodos.agregarServicios();

          //muestro lo que ofrece el minimarket
            System.out.println("Platos");
            PlatoDAO.leerDatosPlatoDAO();
            System.out.println("Productos");
            System.out.println();
            //ProductoDAO.leerDatosProductoDAO();

            int operacion=0;
            do {
                System.out.print("""
                 
                 ------MENÚ DE OPCIONES------
                
                1-Vender/Cobrar un producto
                2-Ingreso de mercadería
                3-Pago a proveedor
                4-Consulta de ventas
                        a- Diaria
                        b- Mensual
                5-Balance (mostrar ganancias y pérdidas)
                6-Solicitar una comanda a la cocina.
                7-Pagar cuenta
                8-Informacion estadística de platos más pedidos.
                9- Finalizar programa.
                INGRESE LA OPERACION QUE DESEA REALIZAR: """);
                operacion=sc.nextInt();
                switch (operacion){
                    case 1:
                        consoleLogger.info("Seleccionó la opcion 1 (Vender/Cobrar un producto)");
                        fileLogger.warn("Seleccionó la opcion 1 (Vender/Cobrar un producto)");

                        System.out.println("Seleccionó la opcion 1 (Vender/Cobrar un producto)");
                        Metodos.metodoParaCaso1();
                        //aparece logica de cargar ventas

                        break;
                    case 2:
                        consoleLogger.info("Seleccionó la opcion 2 (Ingreso de mercadería)");
                        fileLogger.warn("Seleccionó la opcion 2 (Ingreso de mercadería)");

                        System.out.println("Seleccionó la opcion 2 (Ingreso de mercadería)");
                        Metodos.metodoParaCaso2();
                        //agrega un producto
                        break;
                    case 3:
                        consoleLogger.info("Seleccionó la opcion 3 (Pago a proveedor)");
                        fileLogger.warn("Seleccionó la opcion 3 (Pago a proveedor)");
                        System.out.println("Seleccionó la opcion 3 (Pago a proveedor)");
                        //aparece deuda del provedor y agregamos el monto a pagar descontandolo de la base de datos

                        Metodos.metodoParaCaso3();
                        break;

                    case 4:
                        consoleLogger.info("Seleccionó la opcion 4 (Consulta de ventas)");
                        fileLogger.warn("Seleccionó la opcion 4 (Consulta de ventas)");

                        System.out.println("Seleccionó la opcion 4 (Consulta de ventas)");
                        //generamos 2 metodos donde te aparce el monto de lo vendido durante las ventas diarias o mensuales
                        Metodos.metodoParaCaso4();
                        break;
                    case 5:
                        consoleLogger.info("Seleccionó la opcion 5 (Balance (mostrar ganancias y pérdidas))");
                        fileLogger.warn("Seleccionó la opcion 5 (Balance (mostrar ganancias y pérdidas))");

                        System.out.println("Seleccionó la opcion 5 (Balance (mostrar ganancias y pérdidas))");

                        // dentro de la clase balance creamos metodos donde llama a los montos de la tabla gastos
                        // y ventas y hacemos un blance entre ambos para saber si tuvimos perdidas o gancias
                        Metodos.metodoParaCaso5();
                        break;
                    case 6:
                        consoleLogger.info("Seleccionó la opcion 6 (Solicitar una comanda a la cocina)");
                        fileLogger.warn("Seleccionó la opcion 6 (Solicitar una comanda a la cocina)");

                        System.out.println("Seleccionó la opcion 6 (Solicitar una comanda a la cocina)");
                        // agregamos un comanda en donde va directamente contabilizada a la parte de venta
                        Metodos.metodoParaCaso6();
                        break;

                    case 7:
                        consoleLogger.info("Seleccionó la opcion 7 (pagar cuenta)");
                        fileLogger.warn("Seleccionó la opcion 7 (pagar cuenta)");

                        System.out.println("Seleccionó la opcion 7 (pagar cuenta)");
                        // paagamos cuentas seguimos almacenando datos en la parte de pagos
                        Metodos.metodoParaCaso7();
                        break;
                    case 8:
                        consoleLogger.info("Seleccionó la opcion 8 (Informacion estadística de platos más pedidos)");
                        fileLogger.warn("Seleccionó la opcion 8 (Informacion estadística de platos más pedidos)");

                        System.out.println("Seleccionó la opcion 8 (Informacion estadística de platos más pedidos)");

                        //creamos un metodo con los platos almacenados en comanda donde nos encuentre la mayor coincidencia
                        //platos y sacamos la estadistica que nos interesa
                        Metodos.metodoParaCaso8();
                        break;
                    case 9:
                        consoleLogger.info("Seleccionó la opción 9: PROGRAMA FINALIZADO....");
                        fileLogger.warn("Seleccionó la opción 9: PROGRAMA FINALIZADO....");

                        System.out.println("Seleccionó la opción 9: PROGRAMA FINALIZADO....");
                        //mail.error("EL programa tuvo una ejecución exitosa");
                        break;
                    default:
                        System.out.println("la opción ingresada no corresponde a ninguna de las opciones que aparecen en el menú");
                }
            }while (operacion!=9);

     stmt.close();
        conn.close();


}catch(SQLException se){
        //administrar errores para JDBC
        se.printStackTrace();
            } catch(Exception e){
        //administrar errores para Class.forName
        e.printStackTrace();
            } finally{
                    try {
                    if (stmt != null) stmt.close();
                } catch (SQLException se2) {
        }
        try {
        if (conn != null) conn.close();
                } catch (SQLException se) {
        se.printStackTrace();
                }
                        }

                        System.out.println("Goodbye!");
        }
    }

