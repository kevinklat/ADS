package com.aula4.aulafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula4.aulafinal.entity.Usuario;


@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, String> {	

}
