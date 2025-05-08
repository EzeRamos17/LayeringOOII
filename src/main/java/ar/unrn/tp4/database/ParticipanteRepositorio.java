package ar.unrn.tp4.database;

import ar.unrn.tp4.model.Participante;

import java.sql.SQLException;

public interface ParticipanteRepositorio {
    void guardar(Participante participante) throws SQLException;
}
