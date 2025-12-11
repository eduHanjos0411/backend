package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.dtos.usuario.UsuarioRequest;
import com.dudu.LicitratosBackEnd.dtos.usuario.UsuarioResponse;
import com.dudu.LicitratosBackEnd.entities.Usuario;
import com.dudu.LicitratosBackEnd.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/usuarios")
public class UsuarioController {
    private final UsuarioService uService;

    public UsuarioController(UsuarioService uService) {
        this.uService = uService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> novoUsuario(@RequestBody UsuarioRequest ur) {
        UsuarioResponse novo = uService.novoUsuario(ur);
        return ResponseEntity.status(HttpStatus.CREATED).body(novo);
    }
}
