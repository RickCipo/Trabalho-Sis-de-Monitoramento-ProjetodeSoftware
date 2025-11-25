package dao;

import model.DadosColetados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DadosColetadosDAO {

    public void salvar(DadosColetados dados) {
        // SQL para inserir os dados (temperatura, umidade, etc)
        String sql = "INSERT INTO dados_coletados (missao_id, temperatura, umidade, imagem_url) VALUES (?, ?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoFactory.getConexao();
            ps = conn.prepareStatement(sql);
            
            // Preenchendo os ? com os dados do objeto
            ps.setInt(1, dados.getId()); // Aqui estamos usando o ID da missão como link
            ps.setFloat(2, dados.getTemperatura());
            ps.setFloat(3, dados.getUmidade());
            ps.setString(4, dados.getImagemUrl());

            ps.execute();
            System.out.println("SUCESSO: Dados da missão " + dados.getId() + " salvos no MySQL!");

        } catch (SQLException e) {
            System.out.println("Erro ao salvar dados coletados: " + e.getMessage());
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