package dao;

import model.Drone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

// Perceba o "implements ICrudDAO<Drone>"
public class DroneDAO implements ICrudDAO<Drone> {

    // O NOME AQUI TEM QUE SER "salvar" (antes era cadastrar)
    @Override
    public void salvar(Drone drone) {
        String sql = "INSERT INTO drones (id, modelo, status) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoFactory.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, drone.getId());
            ps.setString(2, drone.getModelo());
            ps.setString(3, drone.getStatus());

            ps.execute();
            System.out.println("SUCESSO: Drone gravado no banco de dados MySQL!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar drone: " + e.getMessage());
        } finally {
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}