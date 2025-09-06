package br.com.mb;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.dao.ClienteDAO;
import br.com.entity.Cliente;
import br.com.jdbc.ConexaoBD;

@Named
@SessionScoped
public class ClienteMB implements Serializable {
	private static final long serialVersionUID = 1L;
	
	Connection connection;
	private ClienteDAO clienteDao;
	private Cliente cliente = new Cliente();
	private List<Cliente> listaClientes = new ArrayList<Cliente>();
	
	public ClienteMB() {
		System.out.println("Construtor Cliente..............");
		
		/*
		 * como Managed Bean possui SessionScopped (dura toda sess�o do usu�rio) n�o � necess�rio
		 * 		abrir e fechar uma conex�o com o banco para cada opera��o
		 * Desta forma, se abre uma �nica vez e quando o objeto MB for destru�do, a conex�o � fechada
		 * 
		 */
		connection = ConexaoBD.getConnection(); 
		clienteDao = new ClienteDAO(connection);
	}

	@PreDestroy
	public void destrutorClienteMB() {
		System.out.println("Destruindo objeto ClienteMB..............");
		
		if (connection != null) {
			try {
				connection.close();
				
			} catch (SQLException e) {e.printStackTrace();}
			connection = null;
		}
	}
	

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public List<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}
	
	

	public String listarClientesCadastrados() {
		try {
			if (connection != null) {				
				listaClientes = this.clienteDao.listarClientes();
				
			} else {
				FacesMessage mensagem = new FacesMessage("Erro", "N�o conectado no banco de dados!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			FacesMessage mensagem = new FacesMessage("Erro", "Erro ocorrido: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);			
			
		}
				
		return "listar";
	}
	
	public String gravarCadastro() {
		try {
			if (connection != null) {
				connection.setAutoCommit(false);	// inicia transa��o no banco de dados
								
				if (this.cliente.getCodigo() == 0) {
					this.clienteDao.inserir(this.cliente);
				} else {
					this.clienteDao.alterar(this.cliente);
				}
				
				connection.commit(); // efetua transa��o no banco de dados
				
				this.cliente = new Cliente();
				
			} else {
				FacesMessage mensagem = new FacesMessage("Erro", "N�o conectado no banco de dados!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
			}
			
			this.cliente = new Cliente();
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			FacesMessage mensagem = new FacesMessage("Erro", "Erro ocorrido: " + e.getMessage());
			FacesContext.getCurrentInstance().addMessage(null, mensagem);			
			
		} finally {
			try {
				connection.setAutoCommit(true);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return "cadastrar";
	}

	public String alterarCliente() {
		System.out.println("Codigo do cliente selecionado: " + cliente.getCodigo());
		return "cadastrar";
	}

	public void excluirCliente() {
		try {
			if (connection != null) {
				
				this.clienteDao.excluir(this.cliente);
				
				this.cliente = new Cliente();
			
				listarClientesCadastrados();
				
			} else {
				FacesMessage mensagem = new FacesMessage("Erro", "N�o conectado no banco de dados!");
				FacesContext.getCurrentInstance().addMessage(null, mensagem);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}	
	
}
