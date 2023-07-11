package com.devsuperior.dslist.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

/* Controlador que permite a comunicação do front-end com o backend
 * Na arquitetura do projeto temos que o Controlador (classe atual, GameController) 
 * acessará a camada de serviço (no caso, GameService) 
 * que acessará a camada de acesso aos dados (GameRepository) */

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GameService gameService;
	
	@GetMapping
	public List<GameMinDTO> findAll() {
		
		List<GameMinDTO> resultado = gameService.findAll();
		return resultado;
		
	}

}
