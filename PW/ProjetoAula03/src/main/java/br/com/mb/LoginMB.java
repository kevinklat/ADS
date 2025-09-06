package br.com.mb;

import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.dao.UsuarioDAO;
import br.com.entity.Usuario;
import br.com.jdbc.ConexaoBD;

@Named
@SessionScoped
public class LoginMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Usuario usuario = new Usuario();
	
	public LoginMB() {
		System.out.println("Construtor..............");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	public String validarUsuario() {
		Connection conn = ConexaoBD.getConnection();
		String retorno = "";
		try {
			if (conn != null) {
				UsuarioDAO usuarioDAO = new UsuarioDAO(conn);
			
				this.usuario = usuarioDAO.consultar(this.usuario.getCodigo(), this.usuario.getSenha());
			
				if (this.usuario != null) { // usu�rio e senha v�lidos
					retorno = "acesso_interno";
					
				} else {
					this.usuario = new Usuario();
					FacesMessage mensagem = new FacesMessage("Erro", "Usuário ou senha inválido!");
					FacesContext.getCurrentInstance().addMessage(null, mensagem);
					retorno = "login";
				}
				
			} else {
				FacesMessage mensagem = new FacesMessage("Erro", "Não conectado no banco de dados!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				retorno = "login";
	
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				try {
					conn.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		return retorno;
	}
	
	public void logout(){
		FacesContext context = FacesContext.getCurrentInstance();
		context.getExternalContext().invalidateSession();
		try {
			context.getExternalContext().redirect("login.xhtml");
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}

	
	public String voltarPaginaInicial(){
		return "acesso_interno";
	}	
	
	public String cadastrar() {
		return "cadastrar";
	}
}

