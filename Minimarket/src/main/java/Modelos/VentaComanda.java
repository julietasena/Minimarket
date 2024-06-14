package Modelos;

public class VentaComanda {
    private int idComanda;
    private int idVenta;

    public VentaComanda(int idComanda, int idVenta) {
        this.idComanda = idComanda;
        this.idVenta = idVenta;
    }

    public VentaComanda() {
    }

    public int getIdComanda() {
        return idComanda;
    }

    public void setIdComanda(int idComanda) {
        this.idComanda = idComanda;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }
}
