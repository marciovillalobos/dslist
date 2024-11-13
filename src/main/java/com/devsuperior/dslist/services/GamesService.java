package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.entities.Games;
import com.devsuperior.dslist.repositories.GamesRepository;

@Service
public class GamesService {
	
	@Autowired
	private GamesRepository gamesRepository;
	
	public List<Games> findAll(){
		List<Games> result = gamesRepository.findAll();
		return result;
	}
}
