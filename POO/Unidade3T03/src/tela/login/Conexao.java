package tela.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private static Connection con;
	private final static String URL = "jdbc:mysql://localhost:3306/producao";
	private final static String BASE = "producao";
	private final static String USUARIO = "root";
	private final static String SENHA = "";
	private final static String DRIVER = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() throws SQLException {
		System.out.println("Conectando com o banco de dados " + BASE);

		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
		} catch (ClassNotFoundException e) {
			System.err.println("Erro ao carregar o Driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Erro ao acessar a base " + BASE);
		}
		return con;
	}

	public static void main(String[] args) throws SQLException{
		Connection c = Conexao.getConnection();
		System.out.println("Conexao OK");
	}

}
