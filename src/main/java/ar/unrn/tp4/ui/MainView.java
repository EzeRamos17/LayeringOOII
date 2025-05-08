package ar.unrn.tp4;

import ar.unrn.tp4.model.ParticipanteServicio;

import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class MainView extends JFrame {
    private JTextField nombre;
    private JTextField telefono;
    private JTextField region;
    private ParticipanteServicio participanteServicio;

    public MainView(ParticipanteServicio participanteServicio) {
        this.participanteServicio = participanteServicio;
        setupUIComponents();
    }

    private void setupUIComponents() {
        setTitle("Add Participant");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.nombre = new JTextField(10);
        this.telefono = new JTextField(10);
        this.region = new JTextField(10);
        this.nombre.setText("");
        this.telefono.setText("");
        this.region.setText("China");
        JPanel contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout());
        contentPane.add(new JLabel("Nombre: "));
        contentPane.add(nombre);
        contentPane.add(new JLabel("Telefono: "));
        contentPane.add(telefono);
        contentPane.add(new JLabel("Region: "));
        contentPane.add(region);
        JButton botonCargar = new JButton("Cargar");
        botonCargar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onBotonCargar();
            }
        });
        contentPane.add(botonCargar);
        setContentPane(contentPane);
        contentPane.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        pack();
        setVisible(true);

    }

    private void onBotonCargar(){
        try {
            participanteServicio.registrarParticipante(
                    nombre.getText(), telefono.getText(), region.getText()
            );
            JOptionPane.showMessageDialog(this, "Participante registrado con exito");
            dispose();
        } catch (IllegalArgumentException ex){
            JOptionPane.showMessageDialog(this, ex.getMessage());
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(this, "Error al guardar en la base de datos");
        }
    }
}
