package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.entity.Usuario;

public class UsuarioDAO {
	private Connection conn;

	public UsuarioDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Usuario consultar(int codigo, String senha) throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Usuario usuario = null;
		try{
			sql.append("SELECT * FROM USUARIO ");
			sql.append("WHERE CODIGO = ? ");
			sql.append("  AND SENHA = ? ");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, codigo);
			ps.setString(2, senha);
			rs = ps.executeQuery();
			if (rs.next()){
				usuario = new Usuario();
				usuario.setCodigo(rs.getInt("CODIGO"));
				usuario.setNome(rs.getString("NOME").trim());
				usuario.setSenha(rs.getString("SENHA").trim());
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("(consultar) - Erro: " + e.getMessage());
		}finally{
			try{ps.close();}catch(SQLException e){}
			if (rs != null){
				try{rs.close();}catch(SQLException e){}
			}
			ps = null;
			rs = null;
			sql = null;
		}
		return usuario;
	}
}
