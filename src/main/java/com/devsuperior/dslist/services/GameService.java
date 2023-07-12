package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameRepository;

/* Registra o GameService como um componente do sistema */
@Service
public class GameService {

	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findAll() {
		
		List<Game> resultado = gameRepository.findAll();
		List<GameMinDTO> dto = resultado.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
	
	@Transactional(readOnly = true)
	public GameDTO findById(Long id) {
		
		Game resultado = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(resultado);
		
		/* realizar um tratamento futuramente para caso o id não existir */
				
		return dto;
	}
	
	@Transactional(readOnly = true)
	public List<GameMinDTO> findByList(Long listid) {
		
		List<GameMinProjection> resultado = gameRepository.searchByList(listid);
		List<GameMinDTO> dto = resultado.stream().map(x -> new GameMinDTO(x)).toList();
		return dto;
		
	}
	
}
