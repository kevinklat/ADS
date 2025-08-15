package com.aula4.aulafinal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula4.aulafinal.entity.Mensagem;
import com.aula4.aulafinal.interfaces.IMensagemService;
import com.aula4.aulafinal.repository.MensagemRepository;

@Service
public class MensagemService implements IMensagemService {
	
	@Autowired
	private MensagemRepository mensagemRepository;
	
	
	public List<Mensagem> findAll(){
		return this.mensagemRepository.findAll();
	}
	

}
