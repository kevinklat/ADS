package com.aula4.aulafinal.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mensagem {
	
	@Id
	private Integer id;
	
	private String titulo;
	private String corpo;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getCorpo() {
		return corpo;
	}
	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}
}
