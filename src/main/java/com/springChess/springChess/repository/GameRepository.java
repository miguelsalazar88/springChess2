package com.springChess.springChess.repository;

import com.springChess.springChess.model.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {

}
