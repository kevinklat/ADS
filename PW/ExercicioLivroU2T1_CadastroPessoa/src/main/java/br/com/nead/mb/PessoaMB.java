package br.com.nead.mb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.model.SelectItem;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import br.com.nead.model.Pessoa;
import br.com.nead.model.Pessoa.Sexo;

@Named
@SessionScoped
public class PessoaMB implements Serializable {
	private static final long serialVersionUID = 1L;

	private List<Pessoa> pessoas;
	@PersistenceContext
	private EntityManager manager;
	@Resource
	UserTransaction tx;
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
		try {
			tx.begin();
			if (pessoa.getId() == null)// criando a pessoa
				manager.persist(pessoa);
			else // alterando a pessoa
				manager.merge(pessoa);
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void remover(Pessoa p) {
		try {
			tx.begin();
			manager.remove(manager.merge(p));
			tx.commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void novo() {
		pessoa = new Pessoa();
	}

	public List<Pessoa> getPessoas() {
		Query q = manager.createQuery("select a from Pessoa a", Pessoa.class);
		List<Pessoa> pessoas = q.getResultList();
		return pessoas;
	}

	public String editar(Pessoa p) {
		this.pessoa = p;
		return "cadastro.xhtml";
	}

	public void alteraSalario(AjaxBehaviorEvent event) {
		System.out.println("Executando o metodo [alteraSalario]");
		UIInput cbsexo = (UIInput) event.getSource();
		Sexo sexo = (cbsexo.getValue().toString().equals("FEMININO")) ? Sexo.FEMININO : Sexo.MASCULINO;
		double novoSalario = (sexo == Sexo.FEMININO) ? pessoa.getSalario() * 1.1 : pessoa.getSalario();

		pessoa.setSalario(novoSalario);

	}

}
