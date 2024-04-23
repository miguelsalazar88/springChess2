package com.springChess.springChess.service;

import com.springChess.springChess.model.entities.Game;
import com.springChess.springChess.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;

    public Game saveGame(Game g){
        return gameRepository.save(g);
    }

    public Game getGame(Long id){
        return gameRepository.getById(id);
    }

    public List<Game> getAllGames(){
        return gameRepository.findAll();
    }

}
