package ejercicio2;

import ejercicio2.model.Empleado;
import ejercicio2.model.EmpleadoManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class EmpleadoServiceConFakeTest {

    private FakeEmpleadoRepository repository;
    private EmpleadoManager service;

    @BeforeEach
    void setUp() {
        repository = new FakeEmpleadoRepository();
        service = new EmpleadoManager(repository);
    }

    @Test
    void empleadoQueCumpleHoy() throws Exception {
        repository.limpiarEmpleados();
        repository.agregarEmpleadoQueCumpleHoy();
        service.cargarEmpleados();

        List<Empleado> cumpleaneros = service.EmpleadosQueCumplenAniosHoy();

        assertEquals(1, cumpleaneros.size());
        assertEquals("Cumpleañero", cumpleaneros.get(0).Apellido());
        assertEquals("Hoy", cumpleaneros.get(0).Nombre());
    }

    @Test
    void empleadoQueNoCumpleHoy() throws Exception {
        repository.limpiarEmpleados();
        repository.agregarEmpleadoQueNoCumpleHoy();
        service.cargarEmpleados();

        List<Empleado> cumpleaneros = service.EmpleadosQueCumplenAniosHoy();

        assertTrue(cumpleaneros.isEmpty());
    }

    @Test
    void variosEmpleadosCumplenHoy() throws Exception {
        repository.limpiarEmpleados();
        repository.agregarEmpleadoQueCumpleHoy();
        repository.agregarEmpleadoQueNoCumpleHoy();
        repository.agregarEmpleadoQueCumpleHoy(); // Agregamos otro que cumple hoy
        service.cargarEmpleados();

        List<Empleado> cumpleaneros = service.EmpleadosQueCumplenAniosHoy();

        assertEquals(2, cumpleaneros.size());
        assertTrue(cumpleaneros.stream().allMatch(e -> e.Apellido().equals("Cumpleañero")));
    }
} 