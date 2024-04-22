package com.springChess.springChess.model;

public class Game {
    private Integer id;
    private String logs;

    public Game(Integer id) {
        this.id = id;
        this.logs = "";
    }

    public Game(Integer id, String logs) {
        this.id = id;
        this.logs = logs;
    }

    public void saveMove(int startRow, int startCol, int destRow, int destCol){

        this.logs += startRow + "," + startCol + ";";
        this.logs += destRow + "," + destCol + ";";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogs() {
        return logs;
    }

    public void setLogs(String logs) {
        this.logs = logs;
    }
}

