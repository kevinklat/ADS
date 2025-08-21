package com.projetojee;

import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class FormularioMB implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private String nome;
	
	public FormularioMB() {
		System.out.println("Criando uma instancia de ExemploMB");
		}
	
	public void setNome(String nome) {
		System.out.println("SetNome " + nome);
		this.nome = nome;
	}
	public String getNome() {
		System.out.println("GetNome " + nome);
		return nome;
	}
	public void executar() {
		System.out.println("Invocando metodo executar() ...");
		System.out.println("Nome digitado " + nome);
	}
	
}
