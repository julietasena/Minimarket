package Modelos;

public class Proveedor {
    private int idProveedor;
    private String RazonSocial;
    private int cuil;
    private double deuda;

    public Proveedor( String razonSocial, int cuil, double deuda) {

        RazonSocial = razonSocial;
        this.cuil = cuil;
        this.deuda = deuda;
    }

    public double getDeuda() {
        return deuda;
    }

    public void setDeuda(double deuda) {
        this.deuda = deuda;
    }

    public Proveedor() {
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getRazonSocial() {
        return RazonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        RazonSocial = razonSocial;
    }

    public int getCuil() {
        return cuil;
    }

    public void setCuil(int cuil) {
        this.cuil = cuil;
    }
}
