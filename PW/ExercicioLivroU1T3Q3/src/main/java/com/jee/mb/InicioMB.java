package com.jee.mb;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named("InicioMB")
@SessionScoped
public class InicioMB implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uname;
	private String password;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String validarDadosUsuario() {
		System.out.println("Validando dados do Usuario...");

		if (uname.equals("admin") && password.equals("admin")) {
			return "acessoInterno";
		} else {
			return "failure";
		}

	}

}
