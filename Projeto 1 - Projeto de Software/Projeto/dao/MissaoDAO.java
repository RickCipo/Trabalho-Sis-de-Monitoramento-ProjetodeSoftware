package dao;

import model.MissaoVoo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Timestamp; // Importante para data e hora
import java.sql.SQLException;

public class MissaoDAO {
    
    public void salvar(MissaoVoo missao) {
        // SQL insere as chaves estrangeiras (drone_id, area_id)
        String sql = "INSERT INTO missoes (id, data_hora, status, drone_id, area_id) VALUES (?, ?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoFactory.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, missao.getId());
            // Converte Data do Java para Data do SQL
            ps.setTimestamp(2, new Timestamp(missao.getDataHora().getTime()));
            ps.setString(3, missao.getStatus());
            ps.setInt(4, missao.getDrone().getId());
            ps.setInt(5, missao.getArea().getId());
            
            ps.execute();
            System.out.println("SUCESSO: Missão " + missao.getId() + " registrada no MySQL!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar missão: " + e.getMessage());
        } finally {
            try { if(ps!=null) ps.close(); if(conn!=null) conn.close(); } catch(Exception e){}
        }
    }
}