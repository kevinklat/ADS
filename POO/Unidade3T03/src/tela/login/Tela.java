package tela.login;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Tela extends JFrame{

	private JPanel contentPane;
	private JTextField tfNome;
	private JTextField tfEmail;

	static Connection con;
	static PreparedStatement ps;
	static ResultSet rs;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					con = Conexao.getConnection();
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}

			}
		});

	}

	public Tela() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100,100,450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5,5,5,5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNweLabel = new JLabel("Nome");
		lblNweLabel.setBounds(47,64,68,14);
		contentPane.add(lblNweLabel);

		JLabel lblNweLabel_1 = new JLabel("Email");
		lblNweLabel_1.setBounds(47,101,49,14);
		contentPane.add(lblNweLabel_1);

		tfNome = new JTextField();
		tfNome.setBounds(125,61,96,20);
		contentPane.add(tfNome);
		tfNome.setColumns(10);

		tfEmail = new JTextField();
		tfEmail.setBounds(125,108,96,20);
		contentPane.add(tfEmail);


		JButton btnLogar = new JButton("Logar");
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroUsuario cad = new CadastroUsuario();
				cad.setNome(tfNome.getText());
				cad.setEmail(tfEmail.getText());

				String sql = "select * from contato where nome = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1,cad.getNome());

					rs = ps.executeQuery();

					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Usuario encontrado");
					} else {
						JOptionPane.showMessageDialog(null, "Usuario não encontrado");
					}

					tfNome.setText("");
					tfEmail.setText("");
					tfNome.requestFocus();

				} catch (SQLException e1) {
					e1.printStackTrace();
				}



			}
		});
		btnLogar.setBounds(48,189,89,23);
		contentPane.add(btnLogar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				CadastroUsuario cad = new CadastroUsuario();
				cad.setNome(tfNome.getText());
				cad.setEmail(tfEmail.getText());

				String sql = "insert into contato (nome,email) values (?,?)";
				//INSERT INTO `contato` (`codigo`, `nome`, `email`, `sexo`, `mensagem`) VALUES ('', NULL, NULL, NULL, NULL)

				try {
					ps = con.prepareStatement(sql);
					ps.setString(1,cad.getNome());
					ps.setString(2, cad.getEmail());

					ps.execute();
					ps.close();

					JOptionPane.showMessageDialog(null, "Dados cadastrados");

					tfNome.setText("");
					tfEmail.setText("");
					tfNome.requestFocus();



				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		btnCadastrar.setBounds(188,189,89,23);
		contentPane.add(btnCadastrar);



	}

}
