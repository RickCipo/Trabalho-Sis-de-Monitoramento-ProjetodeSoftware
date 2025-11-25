package dao;

import model.Drone;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DroneDAO {

    // Método para salvar um Drone no Banco de Dados SQL
    public void cadastrar(Drone drone) {
        String sql = "INSERT INTO drones (id, modelo, status) VALUES (?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            // 1. Abre a conexão
            conn = ConexaoFactory.getConexao();
            
            // 2. Prepara o SQL
            ps = conn.prepareStatement(sql);
            ps.setInt(1, drone.getId());
            ps.setString(2, drone.getModelo());
            ps.setString(3, drone.getStatus());

            // 3. Executa
            ps.execute();
            System.out.println("SUCESSO: Drone gravado no banco de dados MySQL!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar drone: " + e.getMessage());
        } finally {
            // 4. Fecha a conexão para não travar o banco
            try {
                if (ps != null) ps.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}