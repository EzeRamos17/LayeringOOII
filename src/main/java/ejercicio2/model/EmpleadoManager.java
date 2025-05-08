package ejercicio2.model;

import java.time.LocalDate;
import java.util.List;

public class EmpleadoManager {
    private final EmpleadoRepository repository;
    private List<Empleado> empleados;

    public EmpleadoManager(EmpleadoRepository repository) {
        this.repository = repository;
        this.empleados = List.of(); // Inicializar con lista vacía
    }

    public void cargarEmpleados() throws Exception {
        this.empleados = repository.cargarEmpleados();
    }

    public List<Empleado> EmpleadosQueCumplenAniosHoy() {
        LocalDate hoy = LocalDate.now();
        return empleados.stream()
                .filter(empleado -> {
                    LocalDate fechaNac = empleado.FechaNacimiento();
                    return fechaNac.getDayOfMonth() == hoy.getDayOfMonth()
                            && fechaNac.getMonth() == hoy.getMonth();
                })
                .toList();
    }
} 