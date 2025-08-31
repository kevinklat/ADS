package br.com.mb;

import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("inicioMB")
@RequestScoped
public class InicioMB implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public InicioMB() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void executar() {
		System.out.println("Valor do campo da tela " + this.nome);
	}
	
	

}
