package br.com.mb;

import java.io.Serializable;

import javax.annotation.PreDestroy;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.entity.Usuario;
import br.com.service.UsuarioService;

@Named("inicioMB")
@SessionScoped
public class InicioMB implements Serializable {

	private static final long serialVersionUID = 1L;

    private Usuario usuario;

    @Inject
    private UsuarioService usuService;

    private EntityManager em;
    private EntityManagerFactory managerfactory;

    public InicioMB() {
        super();
        this.usuario = new Usuario();
        managerfactory = Persistence.createEntityManagerFactory("Uniasselvi");
        em = managerfactory.createEntityManager();
    }

	@PreDestroy
	public void destruirClasse() {
		System.out.println("Destruindo objeto");

		if (em != null) {
			em.close();
		}
		em = null;

		if (managerfactory != null) {
			managerfactory.close();
		}
		managerfactory = null;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String validarUsuario() {
		Usuario usu = usuService.validarUsuario(usuario.getUsuario(), usuario.getSenha(), em);
		if (usu != null) {
			return "interno";
		} else {
			
			FacesMessage mensagem = new FacesMessage("Erro", "Usuario ou senha invalido!");
			FacesContext.getCurrentInstance().addMessage(null, mensagem);
			return "index";
		}
	}

	public String logout() {
		usuario = new Usuario();
		return "index";
	}
	
	public String voltarPaginaInicial() {
		return "interno";
	}
}
