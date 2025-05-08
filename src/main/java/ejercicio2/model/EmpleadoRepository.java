package ejercicio2.model;

import java.util.List;

public interface EmpleadoRepository {
    List<Empleado> cargarEmpleados() throws Exception;
} 