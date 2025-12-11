package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.entities.Processo;
import com.dudu.LicitratosBackEnd.enums.StatusProcesso;
import com.dudu.LicitratosBackEnd.services.ProcessoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/processos") // URL base: http://localhost:8081/api/processos
public class ProcessoController {

    private final ProcessoService processoService;

    @Autowired
    public ProcessoController(ProcessoService processoService) {
        this.processoService = processoService;
    }

    /**
     * Endpoint para Criar Processo (POST /api/processos)
     * O corpo da requisição deve incluir o objeto Usuario (com apenas o ID) no campo 'clienteResponsavel'.
     * Exemplo de JSON: { "nomeProcesso": "...", "clienteResponsavel": { "idUsuario": "..." } }
     */
    @PostMapping
    public ResponseEntity<Processo> criarProcesso(@RequestBody Processo processo) {
        try {
            Processo novoProcesso = processoService.criarProcesso(processo);
            novoProcesso.setStatusProcesso(StatusProcesso.INICIADO);
            return new ResponseEntity<>(novoProcesso, HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            // Captura a exceção lançada no Service se o cliente não for encontrado
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    /**
     * Endpoint para Buscar Processo por ID (GET /api/processos/{id})
     */
    @GetMapping("/{id}")
    public ResponseEntity<Processo> buscarPorId(@PathVariable String id) {
        return processoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    /**
     * Endpoint para buscar Processos por Cliente ID (GET /api/processos/cliente/{clienteId})
     * Chama o método implementado no Service, que usa o Repository para buscar os processos relacionados.
     */
    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<Processo>> buscarPorClienteId(@PathVariable String clienteId) {
        List<Processo> processos = processoService.buscarPorClienteId(clienteId);

        if (processos.isEmpty()) {
            return ResponseEntity.noContent().build(); // 204 No Content se a lista estiver vazia
        }
        return ResponseEntity.ok(processos);
    }

    // *Outros métodos CRUD (PUT, DELETE) do Processo seriam implementados aqui.*
}