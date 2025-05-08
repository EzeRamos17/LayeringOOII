package ar.unrn.tp4.database;

import ar.unrn.tp4.model.Participante;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ParticipanteRepositorioJdbc implements ParticipanteRepositorio{
    private Connection dbConn;

    public ParticipanteRepositorioJdbc(Connection dbConn) {
        this.dbConn = dbConn;
    }

    @Override
    public void guardar(Participante participante) throws SQLException {
        PreparedStatement st = dbConn
                .prepareStatement("insert into participantes(nombre, telefono, region) values(?, ?, ?)");
        try {
            st.setString(1, participante.nombre());
            st.setString(2, participante.telefono());
            st.setString(3, participante.region());
            st.executeUpdate();
        } finally {
            st.close();
        }
    }
}
