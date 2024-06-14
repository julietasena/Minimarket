package Modelos;

public class Comanda {
    private int idCliente;
    private int idPlato;
    

    private double monto;

    public Comanda() {}

    public Comanda(int idPlato, int idCliente) {
        this.idPlato = idPlato;

        this.idCliente = idCliente;
    }

    public int getidCliente() {
        return idCliente;
    }

    public void setidCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }




}
