package com.aula4.aulafinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula4.aulafinal.entity.Mensagem;

@Repository
public interface MensagemRepository extends JpaRepository<Mensagem, Integer> {

}
