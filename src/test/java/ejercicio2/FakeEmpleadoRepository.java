package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.EmpleadoRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FakeEmpleadoRepository implements EmpleadoRepository {
    private final List<Empleado> empleados;

    public FakeEmpleadoRepository() {
        this.empleados = new ArrayList<>();
        // Agregar algunos empleados de prueba
        empleados.add(new Empleado("García", "Juan", LocalDate.of(1990, 5, 6), "juan.garcia@empresa.com"));
        empleados.add(new Empleado("Rodríguez", "María", LocalDate.of(1985, 5, 20), "maria.rodriguez@empresa.com"));
        empleados.add(new Empleado("López", "Carlos", LocalDate.of(1995, 5, 25), "carlos.lopez@empresa.com"));
    }

    @Override
    public List<Empleado> cargarEmpleados() {
        return new ArrayList<>(empleados);
    }

    // Métodos adicionales para pruebas
    public void limpiarEmpleados() {
        empleados.clear();
    }

    public void agregarEmpleadoQueCumpleHoy() {
        LocalDate hoy = LocalDate.now();
        empleados.add(new Empleado(
                "Cumpleañero",
                "Hoy",
                LocalDate.of(1990, hoy.getMonth(), hoy.getDayOfMonth()),
                "cumpleanero@empresa.com"
        ));
    }

    public void agregarEmpleadoQueNoCumpleHoy() {
        LocalDate hoy = LocalDate.now();
        LocalDate ayer = hoy.minusDays(1);
        empleados.add(new Empleado(
                "NoCumpleañero",
                "Ayer",
                LocalDate.of(1990, ayer.getMonth(), ayer.getDayOfMonth()),
                "nocumpleanero@empresa.com"
        ));
    }
} 