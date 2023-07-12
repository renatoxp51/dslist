package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

/* Controlador que permite a comunicação do front-end com o backend
 * Na arquitetura do projeto temos que o Controlador (classe atual, GameController) 
 * acessará a camada de serviço (no caso, GameService) 
 * que acessará a camada de acesso aos dados (GameRepository) */

@RestController
@RequestMapping(value = "/lists")
public class GameListController {
	
	@Autowired
	private GameListService gameListService;
	
	@GetMapping
	public List<GameListDTO> findAll() {
		
		List<GameListDTO> resultado = gameListService.findAll();
		return resultado;
		
	}
	
	/*
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id) {
		
		GameDTO resultado = gameService.findById(id);
		return resultado;
		
	}
	*/

}
