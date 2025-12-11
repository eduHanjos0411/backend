package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.entities.Usuario;
import com.dudu.LicitratosBackEnd.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios") // URL base: http://localhost:8081/api/usuarios
public class UsuarioController {

    private final UsuarioService usuarioService;

    @Autowired
    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    // Configuração de CORS local (Se não estiver usando a configuração global)
    // @CrossOrigin(origins = "http://localhost:5173")

    /**
     * Endpoint para Cadastro de Usuário (POST /api/usuarios)
     * Recebe o JSON do frontend (seu postData) e retorna o usuário criado (Status 201).
     */
    @PostMapping
    public ResponseEntity<Usuario> cadastrarUsuario(@RequestBody Usuario usuario) {
        // A senha é criptografada e o ID é gerado dentro do Service
        Usuario novoUsuario = usuarioService.criarUsuario(usuario);
        return new ResponseEntity<>(novoUsuario, HttpStatus.CREATED);
    }

    /**
     * Endpoint para Listar Todos os Usuários (GET /api/usuarios)
     */
    @GetMapping
    public ResponseEntity<List<Usuario>> listarTodos() {
        List<Usuario> usuarios = usuarioService.buscarTodos();
        return ResponseEntity.ok(usuarios);
    }

    /**
     * Endpoint para Buscar Usuário por ID (GET /api/usuarios/{id})
     */
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> buscarPorId(@PathVariable String id) {
        return usuarioService.buscarPorId(id)
                .map(ResponseEntity::ok) // Se encontrado, retorna 200 OK
                .orElseGet(() -> ResponseEntity.notFound().build()); // Se não, retorna 404 Not Found
    }

    /**
     * Endpoint para Atualizar Usuário (PUT /api/usuarios/{id})
     */
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizarUsuario(@PathVariable String id, @RequestBody Usuario usuario) {
        return usuarioService.atualizarUsuario(id, usuario)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para Deletar Usuário (DELETE /api/usuarios/{id})
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarUsuario(@PathVariable String id) {
        try {
            usuarioService.deletarUsuario(id);
            return ResponseEntity.noContent().build(); // Retorna 204 No Content (sucesso sem corpo)
        } catch (Exception e) {
            // Em um ambiente real, você trataria exceções específicas (ex: Usuário não encontrado)
            return ResponseEntity.notFound().build();
        }
    }
}
