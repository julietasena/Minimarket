package org.example;

import Modelos.*;
import clasesDAO.*;

import java.util.Scanner;

public class Metodos {
    public static void eliminarTablas() {
        try {
            System.out.println("Eliminando tabla en la base de datos...");
            DAO.stmt = DAO.conn.createStatement();
            String sql = "DROP TABLE IF EXISTS CLIENTE, COMANDA ,EMPLEADO ,PAGO ,PRODUCTO ,PROVEEDOR, PLATO, VENTAPRODUCTO,VENTACOMANDA ,COMANDAPLATO ,VENTA, SERVICIO;";
            DAO.stmt.executeUpdate(sql);
            System.out.println("Se eliminaron las tablas");
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
    public static void crearTablas() {
        System.out.println("Creando tablas..");
        ClienteDAO.crearTablaClienteDAO();
        ServicioDAO.crearTablaServicioDAO();

        PlatoDAO.crearTablaPlatoDAO();
        EmpleadoDAO.crearTablaEmpleadoDAO();
        ComandaDAO.crearTablaComandaDAO();
        ComandaPlatoDAO.crearTablaComandaPlatoDAO();
        ProductoDAO.crearTablaProductoDAO();
        ProveedorDAO.crearTablaProveedorDAO();

        VentaDAO.crearTablaVentaDAO();
        VentaComandaDAO.crearTablaVentaComandaDAO();
        VentaProductoDAO.crearTablaVentaProductoDAO();

        PagoDAO.crearTablaPagoDAO();
        System.out.println("Tablas creadas");
    }
    public static void agregarProductos() {
        System.out.println("agregando productos ");
        ProductoDAO.guardarDatosProductoDAO(new Producto("Coca cola", 2200.00, 15));
        ProductoDAO.guardarDatosProductoDAO(new Producto("Galletas", 1000.15, 50));
        ProductoDAO.guardarDatosProductoDAO(new Producto("papas fritas", 1300.00, 15));
        ProductoDAO.guardarDatosProductoDAO(new Producto("Cigarrillo", 1200.00, 56));
        ProductoDAO.guardarDatosProductoDAO(new Producto("Cerveza", 1500.00, 30));
        System.out.println("datos agregados");
    }
    public static void agregarClientes(){
        System.out.println("Agregando Clientes: ");
        ClienteDAO.guardarDatosCienteDAO(new Cliente("Jose","Rodriguez",51,4564646,4));
        ClienteDAO.guardarDatosCienteDAO(new Cliente("Luis","Gimenez",30,5466464,2));
        ClienteDAO.guardarDatosCienteDAO(new Cliente("Jorge","Gonzalez",42,45646,7));
        ClienteDAO.guardarDatosCienteDAO(new Cliente("Gastón","Sisterna",61,43646,8));
        ClienteDAO.guardarDatosCienteDAO(new Cliente("Luciano","Reggio",21,4564646,9));
        System.out.println("Clientes Agregados");
    }
    public static void agregarProvedores(){
        System.out.println("Agregando provedores");
        ProveedorDAO.guardarDatosProvedorDAO(new Proveedor("Bimbo",1561651,250000));
        ProveedorDAO.guardarDatosProvedorDAO(new Proveedor("Malboro",65465,30000));
        ProveedorDAO.guardarDatosProvedorDAO(new Proveedor("Oreo",489469,22600));
        ProveedorDAO.guardarDatosProvedorDAO(new Proveedor("Quilmes",545646,85200));
        ProveedorDAO.guardarDatosProvedorDAO(new Proveedor("Polvoron",155461,54200));
        System.out.println("Provedores agregados");


    }
    public static void agregarPlatos(){
        System.out.println("Agregando Platos");
        PlatoDAO.guardarDatosPlatoDAO(new Plato("Hamburguesa", 5000, 5));
        PlatoDAO.guardarDatosPlatoDAO(new Plato("Pancho", 3000,10));
        PlatoDAO.guardarDatosPlatoDAO(new Plato("Papas fritas", 2000, 20));
        PlatoDAO.guardarDatosPlatoDAO(new Plato("Lomo", 7500, 40));
        System.out.println("platos agregados");
    }
    public static void agregarEmpleados(){
        EmpleadoDAO.guardarDatosEmpleadoDAO(new Empleado("Juan","Salas",22, 546465,java.sql.Date.valueOf("2022-11-20"),50000));
        EmpleadoDAO.guardarDatosEmpleadoDAO(new Empleado("Pepe","Honguito",25, 564655,java.sql.Date.valueOf("2022-05-14"),50000));
        EmpleadoDAO.guardarDatosEmpleadoDAO(new Empleado("Juan","Salas",22, 546465,java.sql.Date.valueOf("2015-10-04"),75000));
    }
    public static void agregarServicios(){
        ServicioDAO.guardarDatosServicioDAO(new Servicio("Luz",5000));
        ServicioDAO.guardarDatosServicioDAO(new Servicio("Gas",10000));
        ServicioDAO.guardarDatosServicioDAO(new Servicio("Agua",400));
        ServicioDAO.guardarDatosServicioDAO(new Servicio("Municipalidad",2000));

    }
  public static void metodoParaCaso2() {
        String opcion = "";
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("""
                    Seleccionó la opcion 2 (Ingreso de mercadería)
                    a) ingresar un nuevo producto
                    b) rellenar producto existente
                    Ingrese la opción que desee.""");
            opcion = sc.nextLine().toLowerCase().trim();
            if(opcion.equals("a") && opcion.equals("b"))
                System.out.println("La opción no existe intentelo de nuevo");
        } while (opcion.equals("a") && opcion.equals("b"));
        if(opcion.equals("a")){
            System.out.print("Ingrese el nombre del producto: ");
           String nombre=sc.nextLine();
           sc.nextLine();
            System.out.print("Ingrese el precio del producto: ");
            double precio= sc.nextDouble();
            System.out.print("Ingrese el stock del producto: ");
            int stock = sc.nextInt();
             ProductoDAO.guardarDatosProductoDAO(new Producto(nombre,precio,stock));
             ProductoDAO.leerDatosProductoDAO();
        } else if (opcion.equals("b")) {
            ProductoDAO.leerDatosProductoDAO();
            System.out.println("Ingrese el numero del indice del producto: ");
            int indice= sc.nextInt();
            System.out.println("Ingrese la cantidad a agregar del producto: ");
            int stock = sc.nextInt();
            ProductoDAO.modificarStock(indice,stock);
        }
    }
    public static void metodoParaCaso1(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agregue los siguientes datos de la venta:");
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
        System.out.println("Agregue al cliente: ");
        ClienteDAO.leerDatosCLienteDAO();
        System.out.print("Seleccione el id del cliente: ");int idCLiente= sc.nextInt();
        System.out.println("Productos");
        ProductoDAO.leerDatosProductoDAO();
        System.out.print("Seleccione el id del Producto vendido: ");int idProcucto = sc.nextInt();
        System.out.print("Cantidad vendida: ");int stock =sc.nextInt();
        ProductoDAO.modificarStock(idProcucto,-stock);
        ProductoDAO.calcularMonto(idProcucto,stock);
        VentaDAO.guardarDatosVentaDAO(new Venta(idCLiente,fecha,ProductoDAO.calcularMonto(idProcucto,stock),idProcucto));
       // ClienteDAO.agregarCompra(idCLiente);
    }
    public static void metodoParaCaso3(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Agregue los siguientes datos de la venta:");
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
        System.out.println("Agregue al Proveedor: ");
        ProveedorDAO.leerDatosProveedorDAO();
        System.out.print("Seleccione el id del Provedor  que le va a pagar: ");int idProveedor= sc.nextInt();
        System.out.print("Monto a pagar: ");double monto = sc.nextDouble();
        PagoDAO.guardarDatosPagoDAO(new Pago(idProveedor,fecha,monto));
        ProveedorDAO.modificarDeuda(idProveedor, monto);
    }
    public static void metodoParaCaso4(){
        Scanner sc = new Scanner(System.in);
        String subopcion="";
        do{
            System.out.println("""
                        Seleccione una subopción:
                a- Diaria
                b- Mensual""");
            subopcion = sc.nextLine().toLowerCase().trim();
            if(subopcion.equals("a")){
                // buscamos los datos de las ventas diarias y las mostramos por pantalla
                // implemantamos con la clase date y le pedimos a la base que nos coincida conel día  ingresado
               metodoParaCaso4A();
                break;
            }else if (subopcion.equals("b")){
                // buscamos los datos de las ventas diarias y las mostramos por pantalla
                // implemantamos con la clase date y le pedimos a la base que nos traiga lo que nos coincida con el
                //mes ingresado
                metodoParaCaso4B();
                break;
            }else{
                System.out.println("La opcion no existe vuelvela a ingresar.");
            }
        }while (!subopcion.equals("a")&&subopcion.equals("b"));
    }
    public static void metodoParaCaso4A(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Eligio ver las ventas diarias");
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        String fechaStr = sc.nextLine();
        java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
        System.out.println("Las ventas diarias fueron de: "+VentaDAO.obtenerVentasDiarias(fecha));

    }
    public static void metodoParaCaso4B(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Eligio ver las ventas mensuales");
        System.out.print("Ingrese la fecha: ");
        System.out.print("Mes: ");int mes= sc.nextInt();
        System.out.print("Año: ");int anio= sc.nextInt();
        System.out.println("Las ventas mensuales fueron de: "+VentaDAO.obtenerVentasMensuales(mes,anio));
    }
    public static void metodoParaCaso5(){
        System.out.println("El balance es de: ");
        double total= VentaDAO.calcularVentas()-PagoDAO.calcularPagos();
        if(total<0){
            System.out.println("El negocio va perdidas de: "+ total);
            System.out.println("El negocio tiene 0 ganacias");
        }else if(total>0){
            System.out.println("El negocio se encuentra con ganancias de: "+ total);
            System.out.println("No tiene perdidas");
        }else{
            System.out.println("El negocio no tiene ganancias ni perdidas");
        }

    }
    public static void metodoParaCaso6(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Carga de comanda(Seleccione el plato pedido)");
        PlatoDAO.leerDatosPlatoDAO();
        System.out.print("Número Plato: ");int idplato= sc.nextInt();


        System.out.println("Agregue al cliente: ");
        ClienteDAO.leerDatosCLienteDAO();
        System.out.print("Seleccione el id del cliente: ");int idCLiente= sc.nextInt();
        System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
        sc.nextLine();
        String fechaStr = sc.nextLine();

        ComandaDAO.guardarDatosComandaDAO(new Comanda(idplato,idCLiente));
        VentaDAO.guardarDatosVentaComandaDAO(new Venta(idCLiente,ComandaDAO.obtenerUltimoIdComanda(),java.sql.Date.valueOf(fechaStr),PlatoDAO.obtenerPrecioPlato(idplato)));
        PlatoDAO.sumarVentas(idplato);
    }
    public static void metodoParaCaso7(){
        Scanner sc = new Scanner(System.in);
        String subopcion="";
        do{
            System.out.println("""
                        Seleccione una subopción:
                a- Pagar sueldo a Empleado
                b- Pagar Servicios""");
            subopcion = sc.nextLine().toLowerCase().trim();
            if(subopcion.equals("a")){
                EmpleadoDAO.leerDatosCLienteDAO();
                System.out.print("ingrese el numero del Empleado: "); int idEmpleado= sc.nextInt();
                System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
                sc.nextLine();
                String fechaStr = sc.nextLine();
                java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                PagoDAO.guardarDatosPagoCuentaDAO(new Pago(fecha,EmpleadoDAO.obtenerSueldo(idEmpleado)));
                System.out.println("Sueldo pagado");
                break;
            }else if (subopcion.equals("b")){
                ServicioDAO.leerDatosServicioDAO();
                System.out.print("Ingrese el numero de sevicio: "); int idServicio= sc.nextInt();
                System.out.print("Ingrese la fecha (yyyy-mm-dd): ");
                sc.nextLine();
                String fechaStr = sc.nextLine();
                java.sql.Date fecha = java.sql.Date.valueOf(fechaStr);
                PagoDAO.guardarDatosPagoCuentaDAO(new Pago(fecha,ServicioDAO.obtenerPrecioServicio(idServicio)));
                break;
            }else{
                System.out.println("La opcion no existe vuelvela a ingresar.");
            }
        }while (!subopcion.equals("a")&&subopcion.equals("b"));

    }
    public static void metodoParaCaso8(){
        PlatoDAO.mostrarEstadisticaPlatos();
    }



}
