package br.com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.entity.Cliente;

public class ClienteDAO {
	private Connection conn;

	public ClienteDAO(Connection conn) {
		this.conn = conn;
	}
	
	public Cliente consultar(int codigo) throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		try{
			sql.append("SELECT * FROM CLIENTE ");
			sql.append("WHERE CODIGO = ? ");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, codigo);
			rs = ps.executeQuery();
			while (rs.next()){
				cliente = new Cliente();
				cliente.setCodigo(rs.getInt("CODIGO"));
				cliente.setNome(rs.getString("NOME").trim());
				cliente.setTelefone(rs.getString("TELEFONE"));
				cliente.setEmail(rs.getString("EMAIL"));
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("(listarClientes) - Erro: " + e.getMessage());
		}finally{
			try{ps.close();}catch(SQLException e){}
			if (rs != null){
				try{rs.close();}catch(SQLException e){}
			}
			ps = null;
			rs = null;
			sql = null;
		}
		return cliente;
	}
	
	public List<Cliente> listarClientes() throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		ResultSet rs = null;
		Cliente cliente = null;
		List<Cliente> lista = new ArrayList<Cliente>();
		try{
			sql.append("SELECT * FROM CLIENTE ");
			sql.append("ORDER BY CODIGO ");
			ps = conn.prepareStatement(sql.toString());
			rs = ps.executeQuery();
			while (rs.next()){
				cliente = new Cliente();
				cliente.setCodigo(rs.getInt("CODIGO"));
				cliente.setNome(rs.getString("NOME").trim());
				cliente.setTelefone(rs.getString("TELEFONE"));
				cliente.setEmail(rs.getString("EMAIL"));
				lista.add(cliente);
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("(listarClientes) - Erro: " + e.getMessage());
		}finally{
			try{ps.close();}catch(SQLException e){}
			if (rs != null){
				try{rs.close();}catch(SQLException e){}
			}
			ps = null;
			rs = null;
			sql = null;
		}
		return lista;
	}
	
	public void inserir(Cliente cliente) throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		try{
			int qtdeGravados = listarClientes().size();	//   <<<<-------
			qtdeGravados++;
			
			sql.delete(0, sql.length());
			sql.append("INSERT INTO CLIENTE (CODIGO, NOME, TELEFONE, EMAIL) ");
			sql.append("             VALUES (     ?,    ?,        ?,     ?) ");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, qtdeGravados);					
			ps.setString(2, cliente.getNome());
			ps.setString(3, cliente.getTelefone());				
			ps.setString(4, cliente.getEmail());
			ps.executeUpdate();
			
		}finally{
			try{ps.close();ps = null;}catch(SQLException e){}
			ps = null;
			sql = null;
		}
	}
	
	public void alterar(Cliente cliente) throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		try{
			sql.delete(0, sql.length());
			sql.append("UPDATE CLIENTE SET NOME = ?, TELEFONE = ?, EMAIL = ? ");
			sql.append("WHERE CODIGO = ? ");
			ps = conn.prepareStatement(sql.toString());
			ps.setString(1, cliente.getNome());
			ps.setString(2, cliente.getTelefone());				
			ps.setString(3, cliente.getEmail());
			ps.setInt(4, cliente.getCodigo());
			ps.executeUpdate();
			
		}finally{
			try{ps.close();ps = null;}catch(SQLException e){}
			ps = null;
			sql = null;
		}
	}
	
	public void excluir(Cliente cliente) throws SQLException{
		StringBuffer sql = new StringBuffer();
		PreparedStatement ps = null;
		try{
			sql.delete(0, sql.length());
			sql.append("DELETE FROM CLIENTE ");
			sql.append("WHERE CODIGO = ? ");
			ps = conn.prepareStatement(sql.toString());
			ps.setInt(1, cliente.getCodigo());
			ps.executeUpdate();
			
		}finally{
			try{ps.close();ps = null;}catch(SQLException e){}
			ps = null;
			sql = null;
		}
	}
	
}
