package ejercicio2.database;

import ejercicio2.model.Empleado;
import ejercicio2.model.EmpleadoRepository;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class FileEmpleadoRepository implements EmpleadoRepository {
    private final String rutaArchivo;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public FileEmpleadoRepository(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    @Override
    public List<Empleado> cargarEmpleados() throws IOException {
        List<Empleado> empleados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 4) {
                    String apellido = datos[0].trim();
                    String nombre = datos[1].trim();
                    LocalDate fechaNacimiento = LocalDate.parse(datos[2].trim(), formatter);
                    String email = datos[3].trim();

                    Empleado empleado = new Empleado(apellido, nombre, fechaNacimiento, email);
                    empleados.add(empleado);
                }
            }
        }
        return empleados;
    }
} 