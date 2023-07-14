package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

@Service
public class GameListService {

	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		
		List<GameList> resultado = gameListRepository.findAll();
		
		/* faz com que cada objeto da lista original (resultado) seja um GameListDTO */
		List<GameListDTO> dto = resultado.stream().map(x -> new GameListDTO(x)).toList();
		return dto;
		
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destinationIndex) {
		
		List<GameMinProjection> lista = gameRepository.searchByList(listId);
		
		GameMinProjection obj = lista.remove(sourceIndex);
		
		lista.add(destinationIndex, obj);
		
		int min = sourceIndex < destinationIndex ? sourceIndex : destinationIndex;
		int max = sourceIndex < destinationIndex ? destinationIndex : sourceIndex;
		
		for (int i = min; i<= max; i++) {
			
			gameListRepository.updateBelongingPosition(listId, lista.get(i).getId(), i);
			
		}
		
	}
		
}
