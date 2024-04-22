package com.springChess.springChess.model;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.stereotype.Component;

@Component
public class MoveRequest {
    private int x;
    private int y;
    private JsonNode board;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public JsonNode getBoard() {
        return board;
    }

    public void setBoard(JsonNode board) {
        this.board = board;
    }
}
