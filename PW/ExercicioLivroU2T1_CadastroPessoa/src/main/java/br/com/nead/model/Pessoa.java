package br.com.nead.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String nome;
	private double salario;
	private String funcoes;
	private String email;
	private Date dataNascimento;
	private Sexo sexo;
	private String cargo;

	public Pessoa() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public String getFuncoes() {
		return funcoes;
	}

	public void setFuncoes(String funcoes) {
		this.funcoes = funcoes;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(id, other.id);
	}

	public enum Sexo {
		MASCULINO, FEMENINO, NEUTRO;
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", salario=" + salario + ", funcoes=" + funcoes + ", email="
				+ email + ", dataNascimento=" + dataNascimento + ", sexo=" + sexo + ", cargo=" + cargo + "]";
	}

}
