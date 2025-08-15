package com.aulaspdm.aulafinalminha.servicos;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aulaspdm.aulafinalminha.entidade.Mensagem;
import com.aulaspdm.aulafinalminha.interfaces.IMensagemService;
import com.aulaspdm.aulafinalminha.repositorio.MensagemRepositorio;

/* */

@Service
public class MensagemService  implements IMensagemService{
	
	/* Inject da camada inteface*/
	@Autowired
	private MensagemRepositorio mensagemRepositorio;
	
	public List<Mensagem> findAll(){
		return this.mensagemRepositorio.findAll();
	}
	
	

}
