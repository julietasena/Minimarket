package Modelos;

import java.util.Date;

public class Pago {
    private int id_Pago;
    private  int id_proveedor;
    private Date fecha_pago;
    private double monto;

    public Pago(Date fecha_pago, double monto) {
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public Pago(int id_proveedor, Date fecha_pago, double monto) {

        this.id_proveedor = id_proveedor;
        this.fecha_pago = fecha_pago;
        this.monto = monto;
    }

    public Pago() {
    }

    public int getId_Pago() {
        return id_Pago;
    }

    public void setId_Pago(int id_Pago) {
        this.id_Pago = id_Pago;
    }

    public int getId_proveedor() {
        return id_proveedor;
    }

    public void setId_proveedor(int id_proveedor) {
        this.id_proveedor = id_proveedor;
    }

    public Date getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(Date fecha_pago) {
        this.fecha_pago = fecha_pago;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
}
