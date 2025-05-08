package ejercicio2.model;

import java.time.LocalDate;

public class Empleado {
    private String apellido;
    private String nombre;
    private LocalDate fechaNacimiento;
    private String email;


    public Empleado(String apellido, String nombre, LocalDate fechaNacimiento, String email) {
        this.apellido = apellido;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.email = email;
    }

    public String Apellido() {
        return apellido;
    }

    public String Nombre() {
        return nombre;
    }

    public LocalDate FechaNacimiento() {
        return fechaNacimiento;
    }

    public String Email() {
        return email;
    }
}
