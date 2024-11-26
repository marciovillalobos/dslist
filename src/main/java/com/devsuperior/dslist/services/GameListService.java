package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GamesRepository;

@Service
public class GameListService {

	@Autowired
	private GameListRepository gamesListRepository;

	@Autowired
	private GamesRepository gamesRepository;

	@Transactional(readOnly = true)
	public List<GameListDTO> findAll() {
		List<GameList> result = gamesListRepository.findAll();
		return result.stream().map(gameList -> new GameListDTO(gameList)).toList();
	}
	
	@Transactional
	public void move(Long listId, int sourceIndex, int destonationIndex) {
		List<GameMinProjection> result = gamesRepository.searchByList(listId);
		GameMinProjection obj = result.remove(sourceIndex);
		result.add(destonationIndex, obj);
		int min = sourceIndex < destonationIndex ? sourceIndex : destonationIndex;
		int max = sourceIndex < destonationIndex ? destonationIndex : sourceIndex;
		
		for(int i = min; i<max; i++) {
			gamesListRepository.updateBelongingPosition(listId, result.get(i).getId(), i);
		}
	}

}
