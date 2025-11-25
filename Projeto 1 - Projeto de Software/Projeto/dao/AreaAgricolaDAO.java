package dao;

import model.AreaAgricola;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AreaAgricolaDAO {
    
    public void salvar(AreaAgricola area) {
        String sql = "INSERT INTO areas_agricolas (id, localizacao, tipo_cultivo, tamanho) VALUES (?, ?, ?, ?)";
        
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConexaoFactory.getConexao();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, area.getId());
            ps.setString(2, area.getLocalizacao());
            ps.setString(3, area.getTipoCultivo());
            ps.setFloat(4, area.getTamanho());
            
            ps.execute();
            System.out.println("SUCESSO: Área '" + area.getLocalizacao() + "' salva no MySQL!");
        } catch (SQLException e) {
            System.out.println("Erro ao salvar área: " + e.getMessage());
        } finally {
            try { if(ps!=null) ps.close(); if(conn!=null) conn.close(); } catch(Exception e){}
        }
    }
}