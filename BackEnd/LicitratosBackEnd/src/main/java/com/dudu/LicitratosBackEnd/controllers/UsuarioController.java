package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.dtos.usuarios.UsuarioRequest;
import com.dudu.LicitratosBackEnd.dtos.usuarios.UsuarioResponse;
import com.dudu.LicitratosBackEnd.services.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    private final UsuarioService uService;

    public UsuarioController(UsuarioService service, UsuarioService uService) {
        this.uService = uService;
    }

    @PostMapping
    public ResponseEntity<UsuarioResponse> novoUsuario(@RequestBody UsuarioRequest ur) {
        UsuarioResponse uRes = uService.novoUsuario(ur);

        return ResponseEntity.status(HttpStatus.CREATED).body(uRes);
    }

    @GetMapping
    public ResponseEntity<List<UsuarioResponse>> listarUsuarios() {
        List<UsuarioResponse> lista = uService.listarUsuarios();
        return ResponseEntity.ok(lista);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> atualizarUsuario(@PathVariable UUID id, @RequestBody UsuarioRequest ur) {
        UsuarioResponse uRes = uService.atualizarUsuario(id, ur);
        return ResponseEntity.ok("Usuário alterado com sucesso");

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable  UUID id) {
        uService.excluirUsuario(id);
        return ResponseEntity.ok().build();
    }
}
