package ejercicio2;

import ejercicio2.database.EmailService;
import ejercicio2.database.FileEmpleadoRepository;
import ejercicio2.model.Empleado;
import ejercicio2.model.EmpleadoManager;
import ejercicio2.model.EmpleadoRepository;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            // Configurar el servicio de email con credenciales de Mailtrap
            EmailService emailService = new EmailService(
                    "tu_usuario",
                    "tu_contraseña"
            );

            // Configurar el repositorio y manager de empleados
            EmpleadoRepository repository = new FileEmpleadoRepository("empleados.txt");
            EmpleadoManager empleadoManager = new EmpleadoManager(repository);
            empleadoManager.cargarEmpleados();

            // Obtener empleados que cumplen años hoy
            List<Empleado> cumpleaneros = empleadoManager.EmpleadosQueCumplenAniosHoy();

            // Enviar felicitaciones
            for (Empleado empleado : cumpleaneros) {
                try {
                    emailService.enviarFelicitacionCumpleanos(
                            empleado.Email(),
                            empleado.Nombre() + " " + empleado.Apellido()
                    );
                    System.out.println("Felicitación enviada a: " + empleado.Nombre() + " " + empleado.Apellido());
                } catch (Exception e) {
                    System.err.println("Error al enviar email a " + empleado.Email() + ": " + e.getMessage());
                }
            }

        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}