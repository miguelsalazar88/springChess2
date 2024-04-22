package com.springChess.springChess.model.entities;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
    @OneToMany
    private ArrayList<Game> userGames;

    public Usuario(String username, String password) {
        this.username = username;
        this.password = password;
        this.userGames = new ArrayList<Game>();


    }

    public Usuario() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Game> getUserGames() {
        return userGames;
    }

    public void setUserGames(ArrayList<Game> userGames) {
        this.userGames = userGames;
    }


}
