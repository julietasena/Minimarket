package Modelos;

public class Plato {
    private String nombre_plato;
    private double precio_plato;
    private int caantidadVentas;
    private int idPlato;

    public int getCaantidadVentas() {
        return caantidadVentas;
    }

    public void setCaantidadVentas(int caantidadVentas) {
        this.caantidadVentas = caantidadVentas;
    }

    public Plato(String nombre_plato, double precio_plato, int caantidadVentas) {
        this.nombre_plato = nombre_plato;
        this.precio_plato = precio_plato;
        this.caantidadVentas = caantidadVentas;
        ;
    }

    public int getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(int idPlato) {
        this.idPlato = idPlato;
    }

    public Plato() {
    }

    public String getNombre_plato() {
        return nombre_plato;
    }

    public void setNombre_plato(String nombre_plato) {
        this.nombre_plato = nombre_plato;
    }

    public double getPrecio_plato() {
        return precio_plato;
    }

    public void setPrecio_plato(double precio_plato) {
        this.precio_plato = precio_plato;
    }
}
