package com.aula4.aulafinal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula4.aulafinal.entity.Usuario;
import com.aula4.aulafinal.interfaces.IUsuarioService;
import com.aula4.aulafinal.repository.UsuarioRepository;

@Service
public class UsuarioService implements IUsuarioService {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Override
	public Usuario findByUsuario(Usuario usuario){
    	Optional<Usuario> usuarioConsultado = this.usuarioRepository.findById(usuario.getUsuario());
    	
    	if (!usuarioConsultado.isEmpty() && usuarioConsultado.get().getPassword().equals(usuario.getPassword())) {
    		return usuarioConsultado.get();
    	} else {
    		return null;
    	}
    	
    }

}

