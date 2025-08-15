package com.aulaspdm.aulafinalminha.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aulaspdm.aulafinalminha.entidade.Mensagem;

/* É a classe que se comunica com o banco de dados, contem os metodos de insert, update, delete, etc.
 * Ao estender para classe JpaRepository deve ser do tipo interface.
*/

@Repository
public interface MensagemRepositorio extends JpaRepository<Mensagem, Integer> {
	
}
