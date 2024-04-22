package com.springChess.springChess.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springChess.springChess.model.Board;
import com.springChess.springChess.model.MoveRequest;
import com.springChess.springChess.model.Position;
import com.springChess.springChess.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/board")
public class BoardController {

    @Autowired
    private BoardService boardService;

    private final ObjectMapper objectMapper;

    public BoardController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
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
        System.out.println("x: " + x + ", y:" + y);
        JsonNode nodeBoard = moveRequest.getBoard();
        Board board = objectMapper.treeToValue(nodeBoard, Board.class);
        board.setPosition(new Position(x, y));
        return board;
    }


}
