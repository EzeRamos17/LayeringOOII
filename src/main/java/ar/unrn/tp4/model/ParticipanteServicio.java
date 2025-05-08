package ar.unrn.tp4.model;

import ar.unrn.tp4.database.ParticipanteRepositorio;

import java.sql.SQLException;

public class ParticipanteServicio {
    private ParticipanteRepositorio repositorio;

    public ParticipanteServicio(ParticipanteRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void registrarParticipante(String nombre, String telefono, String region) throws SQLException {
        Participante participante = new Participante(nombre, telefono, region);
        repositorio.guardar(participante);
    }
}
