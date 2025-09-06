package br.com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConexaoBD {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection("jdbc:mysql:///uniasselvi", "root", "root");
			
			if (conn == null) {
				System.out.println("N�o conectado!!!!!!!!!!!!!");
			}
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return conn;
	}
	
}