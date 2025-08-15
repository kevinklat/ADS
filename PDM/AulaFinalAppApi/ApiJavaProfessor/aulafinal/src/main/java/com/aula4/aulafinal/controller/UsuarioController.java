package com.aula4.aulafinal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aula4.aulafinal.entity.Usuario;
import com.aula4.aulafinal.interfaces.IUsuarioService;

@RestController
@RequestMapping("/api/login")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> findByUsuario(@RequestBody Usuario usuario) {
    	
    	Usuario usuarioResposta = usuarioService.findByUsuario(usuario);
    	
    	if (usuarioResposta != null) {
    		return ResponseEntity.ok(usuarioResposta);
    		
    	} else {
    		return ResponseEntity.status(401).build();
    		
    	}
    	
    }
	
}
