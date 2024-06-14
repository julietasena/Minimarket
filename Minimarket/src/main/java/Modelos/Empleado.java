package Modelos;

import java.util.Date;

public class Empleado extends Persona {
    private int idEmpleado;
    private Date fechaIngreso;

    private double sueldo;

    public Empleado(String nombre, String apellido, int edad, int dni, Date fechaIngreso, double sueldo) {
        super(nombre, apellido, edad, dni);

        this.fechaIngreso = fechaIngreso;

        this.sueldo = sueldo;

    }



    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public Empleado() {

    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }
}
