package Modelos;

import java.util.Date;

public class Venta {
    private int idVentas;
    private int id_cliente;
    private int idProducto;
    private int idComanda;

    public Venta(int id_cliente, int idComanda, Date fecha, double monto) {
        this.id_cliente = id_cliente;
        this.idComanda = idComanda;
        this.fecha = fecha;
        this.monto = monto;
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    private Date fecha;
    private double monto;

    public Venta( int id_cliente, Date fecha, double monto, int idProducto) {

        this.id_cliente = id_cliente;
        this.fecha = fecha;
        this.monto = monto;
        this.idProducto= idProducto;
    }

    public Venta() {
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdVentas() {
        return idVentas;
    }

    public void setIdVentas(int idVentas) {
        this.idVentas = idVentas;
    }


    public int getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

}
