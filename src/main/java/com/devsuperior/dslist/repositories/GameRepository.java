package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;

/* Esse componente possui uma ferramenta integrada do framework chamada "JpaRepository"
 * Essa ferramenta facilta o desenvolvimento e ela é responsável por realizar a consulta dos games na base de dados
 * Além disso essa ferramenta também possui todas as funções básicas, como a busca do registro pelo Id */

public interface GameRepository extends JpaRepository<Game, Long> {
	
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, 
			tb_game.titulo, 
			tb_game.ano AS ano, 
			tb_game.img_url AS imgUrl,
			tb_game.descricao AS descricao, 
			tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);
	
}
