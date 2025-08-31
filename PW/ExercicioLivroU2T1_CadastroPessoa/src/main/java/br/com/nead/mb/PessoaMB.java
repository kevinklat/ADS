package br.com.nead.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.inject.Named;

import br.com.nead.model.Pessoa;
import br.com.nead.model.Pessoa.Sexo;

@Named
@SessionScoped
public class PessoaMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private Pessoa pessoa = new Pessoa();

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public void validarEmail(FacesContext context, UIComponent toValidate, Object value) {
		String email = (String) value;
		if (email.indexOf("@") == -1) {
			((UIInput) toValidate).setValid(false);
			FacesMessage message = new FacesMessage("O email não é válido!");
			context.addMessage(toValidate.getClientId(context), message);
		}
	}
	
	public Collection<SelectItem> getSexos(){
		Collection<SelectItem> itens = new ArrayList<SelectItem>();
		for (Sexo enums : Sexo.values()) {
			itens.add(new SelectItem(enums,enums.name()));
		}
		return itens;
	}
	
	public void salvar() {
		System.out.println(this.pessoa);
	}
	
	public void novo() {
		pessoa = new Pessoa();
	}
	
	

}
