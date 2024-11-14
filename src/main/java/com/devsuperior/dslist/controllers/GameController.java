package com.devsuperior.dslist.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GamesDTO;
import com.devsuperior.dslist.dto.GamesMinDTO;
import com.devsuperior.dslist.services.GamesService;

@RestController
@RequestMapping(value = "/games")
public class GameController {
	
	@Autowired
	private GamesService gamesService;
	
	@GetMapping(value = "/{id}")
	public GamesDTO findById(@PathVariable Long id){
		GamesDTO result = gamesService.findById(id);
		return result;
	}
	
	@GetMapping
	public List<GamesMinDTO> findAll(){
		List<GamesMinDTO> result = gamesService.findAll();
		return result;
	}
}
