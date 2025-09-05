package br.com.nead.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
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

	public Collection<SelectItem> getSexos() {
		Collection<SelectItem> itens = new ArrayList<SelectItem>();
		for (Sexo enums : Sexo.values()) {
			itens.add(new SelectItem(enums, enums.name()));
		}
		return itens;
	}

	public void salvar() {
		System.out.println(this.pessoa);
	}

	public void novo() {
		pessoa = new Pessoa();
	}

	public List<Pessoa> getPessoas() {
		List<Pessoa> pessoas = new ArrayList<Pessoa>();

		pessoas.add(new Pessoa(null, "Leila", 8700.00, "Administar os rebeldes", "pleia@gmail.com", new Date(), Sexo.FEMININO,
				"Gerente)"));
		pessoas.add(new Pessoa(null,"Anakin SkyWalker", 8700.00, "Estudar a força", "anakin@gmail.com", new Date(),
				Sexo.MASCULINO, "Anikilar os Jedi"));
		pessoas.add(new Pessoa(null,"Kevin", 4000.00, "Programar", "kevin@gmail.com", new Date(),
				Sexo.MASCULINO, "Jogador"));
		pessoas.add(new Pessoa(null,"Isaac", 4000.00, "Brincar", "isaac@gmail.com", new Date(),
				Sexo.MASCULINO, "Chorar"));
		pessoas.add(new Pessoa(null,"Fernanda", 4000.00, "Trabalhar", "kevin@gmail.com", new Date(),
				Sexo.FEMININO, "Salão"));

		return pessoas;
	}
	
	public String editar(Pessoa p) {
		this.pessoa = p;
		return "cadastro.xhtml";
	}
	
	public void alteraSalario(AjaxBehaviorEvent event) {
		System.out.println("Executando o metodo [alteraSalario]");
		UIInput cbsexo = (UIInput) event.getSource();
		Sexo sexo = (cbsexo.getValue().toString().equals("FEMININO"))? Sexo.FEMININO: Sexo.MASCULINO;
		double novoSalario = (sexo == Sexo.FEMININO)? pessoa.getSalario()*1.1: pessoa.getSalario();
		
		pessoa.setSalario(novoSalario);

	}

}
