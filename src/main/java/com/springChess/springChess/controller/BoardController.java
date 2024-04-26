package com.springChess.springChess.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springChess.springChess.model.Board;
import com.springChess.springChess.model.Utils;
import com.springChess.springChess.model.entities.Game;
import com.springChess.springChess.model.MoveRequest;
import com.springChess.springChess.model.Position;
import com.springChess.springChess.repository.GameRepository;
import com.springChess.springChess.service.BoardService;
import com.springChess.springChess.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private GameService gameService;
    @Autowired
    private BoardService boardService;

    private final ObjectMapper objectMapper;
    @Autowired
    private GameRepository gameRepository;

    private final SimpMessagingTemplate simpMessagingTemplate;

    public BoardController(ObjectMapper objectMapper, SimpMessagingTemplate simpMessagingTemplate) {
        this.objectMapper = objectMapper;
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    @GetMapping("/newGame")
    public ResponseEntity<Board> newGame(){
        return ResponseEntity.ok(boardService.newGame());
    }


    @PostMapping("/move")
    public Board movePiece(@RequestBody MoveRequest moveRequest) throws JsonProcessingException {
        // Aquí puedes acceder a los datos recibidos en el cuerpo de la solicitud
        int x = moveRequest.getX();
        int y = moveRequest.getY();
        System.out.println("El id es: " + moveRequest.getGameId());
        JsonNode nodeBoard = moveRequest.getBoard();
        Board board = objectMapper.treeToValue(nodeBoard, Board.class);
        board.setPosition(new Position(x, y));
        simpMessagingTemplate.convertAndSend("/topic/game-progress/" + moveRequest.getGameId(), board);
        return board;
    }

    @PostMapping("/save")
    public Game saveGame(@RequestBody JsonNode requestBody){
        Game game = new Game();
        String logs = requestBody.get("logs").asText();
        game.setLogs(logs);
        gameService.saveGame(game);
        return game;
    }

    @GetMapping("/all")
    public List<Game> getAllGames(){
        return gameService.getAllGames();
    }

    @GetMapping("/loadGame")
    public ResponseEntity<Board> getGame(Long id){

        if(id == -1){
            return ResponseEntity.ok(boardService.newGame());
        }
        System.out.println(id);
        Game savedGame = gameService.getGame(id);
        Board board = Utils.createGame();
        board = Utils.updateBoard(board, savedGame);
        return ResponseEntity.ok(board);
    }


}
