package com.springChess.springChess.service;

import com.springChess.springChess.model.entities.Game;
import com.springChess.springChess.model.entities.Usuario;
import com.springChess.springChess.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario saveUsuario(Usuario u){
        return usuarioRepository.save(u);

    }

}
