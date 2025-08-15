package com.aulaspdm.aulafinalminha.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aulaspdm.aulafinalminha.entidade.Mensagem;
import com.aulaspdm.aulafinalminha.interfaces.IMensagemService;

/* Camada controler é onde recebe a requisição do frontend 
 * e consultar as demais camadas e responder pro cliente.
 * Adicionar a anotação @RestController.
 * Adicinar a anotação @RequestMapping - onde é definido o caminho da api.
 * Injetar a interface Service com a anotação @Autowired.
 * Adicionar a anotação @GetMapping pra 
 */

@RestController
@RequestMapping("/api/mensagens")
public class MensagemControlador {
	
	@Autowired
	private IMensagemService iMensagemService;
	
	@GetMapping
	public ResponseEntity<List<Mensagem>> listarMensagem(){
		
		return ResponseEntity.ok(iMensagemService.findAll());
		
		
	}

}
