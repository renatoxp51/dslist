package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;

/* Esse componente possui uma ferramenta integrada do framework chamada "JpaRepository"
 * Essa ferramenta facilta o desenvolvimento e ela é responsável por realizar a consulta dos games na base de dados
 * Além disso essa ferramenta também possui todas as funções básicas, como a busca do registro pelo Id */

public interface GameRepository extends JpaRepository<Game, Long> {
	
}
