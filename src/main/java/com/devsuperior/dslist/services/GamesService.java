package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GamesDTO;
import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.entities.Games;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GamesRepository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;
	
	@Transactional(readOnly = true)
	public GamesDTO findById(Long id) {
		Games result = gamesRepository.findById(id).get();
		return new GamesDTO(result);
	}
	
	@Transactional(readOnly = true)
	public List<GamesMinDTO> findAll(){
		List<Games> result = gamesRepository.findAll();
		return result.stream().map(games -> new GamesMinDTO(games)).toList();
	}
	
	@Transactional(readOnly = true)
	public List<GamesMinDTO> findByList(Long listId){
		List<GameMinProjection> result = gamesRepository.searchByList(listId);
		return result.stream().map(projection -> new GamesMinDTO(projection)).toList();
	}
	
}
