package com.aula4.aulafinal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula4.aulafinal.entity.Mensagem;
import com.aula4.aulafinal.interfaces.IMensagemService;

@RestController
@RequestMapping("/api/mensagens")
public class MensagemController {

	@Autowired
	private IMensagemService iMensagemService;
	
	@GetMapping("/consultar")
	public ResponseEntity<List<Mensagem>> listarMensagens(){
		
		return ResponseEntity.ok(iMensagemService.findAll());
		
	}
	
}
