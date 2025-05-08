package ejercicio3;

import ejercicio3.database.DatabaseConcursoRepository;
import ejercicio3.database.DatabaseInscriptoRepository;
import ejercicio3.model.ConcursoManager;
import ejercicio3.ui.RadioCompetition;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    new Main().start();
                } catch (Exception e) {
                    System.out.println(e);
                }
            }
        });
    }

    private void start() {
        // Configurar la conexión a la base de datos
        String url = "jdbc:mysql://localhost:3306/concursos_db";
        String user = "root";
        String password = "hernan123";

        // Configurar los repositorios
        DatabaseConcursoRepository concursoRepository = new DatabaseConcursoRepository(url, user, password);
        DatabaseInscriptoRepository inscriptoRepository = new DatabaseInscriptoRepository(url, user, password);

        // Crear el manager con los repositorios
        ConcursoManager manager = new ConcursoManager(concursoRepository, inscriptoRepository);

        // Iniciar la UI
        new RadioCompetition(manager);
    }
}
