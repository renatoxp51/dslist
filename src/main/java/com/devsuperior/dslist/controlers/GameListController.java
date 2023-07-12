package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

/* Controlador que permite a comunicação do front-end com o backend
 * Na arquitetura do projeto temos que o Controlador (classe atual, GameController) 
 * acessará a camada de serviço (no caso, GameService) 
 * que acessará a camada de acesso aos dados (GameRepository) */

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		
		List<GameListDTO> resultado = gameListService.findAll();
		return resultado;
		
	}
	
	
	@GetMapping(value = "/{list_id}/games")
	public List<GameMinDTO> findById(@PathVariable Long list_id) {
		
		List<GameMinDTO> resultado = gameService.findByList(list_id);
		return resultado;
		
	}
	

}
