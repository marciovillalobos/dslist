package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.entities.Games;
import com.devsuperior.dslist.services.GamesService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GamesService gamesService;
	
	@GetMapping
	public List<GamesMinDTO> findAll(){
		List<Games> result = gamesService.findAll();
		List<GamesMinDTO> dto = result.stream().map(games -> new GamesMinDTO(games)).toList();
		return dto;
	}
}
