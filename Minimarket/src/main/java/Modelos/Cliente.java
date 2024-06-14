package Modelos;

public class Cliente extends Persona {
    private int  idCliente;
    private int cantidadDeCompras;

    public int getCantidadDeCompras() {
        return cantidadDeCompras;
    }

    public void setCantidadDeCompras(int cantidadDeCompras) {
        this.cantidadDeCompras = cantidadDeCompras;
    }

    public Cliente(String nombre, String apellido, int edad, int dni, int cantidadDeCompras) {
        super(nombre, apellido, edad, dni);
        this.cantidadDeCompras= cantidadDeCompras;


    }

    public Cliente() {
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }
}
