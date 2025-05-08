package ejercicio2.database;

import jakarta.mail.*;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailService {
    private final String username;
    private final String password;
    private final Properties props;

    public EmailService(String username, String password) {
        this.username = username;
        this.password = password;
        
        props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "sandbox.smtp.mailtrap.io");
        props.put("mail.smtp.port", "2525");
    }

    public void enviarFelicitacionCumpleanos(String destinatario, String nombre) throws MessagingException {
        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("rrhh@empresa.com")); // Email de origen ficticio
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinatario));
        message.setSubject("¡Feliz Cumpleaños!");

        String contenido = String.format(
            "Estimado/a %s,\n\n" +
            "En este día tan especial, queremos desearte un muy feliz cumpleaños.\n" +
            "Que este nuevo año de vida esté lleno de alegrías y éxitos.\n\n" +
            "¡Feliz Cumpleaños!\n\n" +
            "Saludos cordiales,\n" +
            "El equipo de RRHH",
            nombre
        );

        message.setText(contenido);
        Transport.send(message);
    }
} 