package com.aulaspdm.aulafinalminha.interfaces;

import java.util.List;

import com.aulaspdm.aulafinalminha.entidade.Mensagem;

/* Interface é uma classe padrão, a classe que usar ela tem que ter os mesmo metodos*/

public interface IMensagemService {
	
	List<Mensagem> findAll();

}
