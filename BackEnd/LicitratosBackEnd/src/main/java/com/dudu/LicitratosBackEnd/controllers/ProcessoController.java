package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.dtos.processos.ProcessoRequest;
import com.dudu.LicitratosBackEnd.dtos.processos.ProcessoResponse;
import com.dudu.LicitratosBackEnd.services.ProcessoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/processos")
public class ProcessoController {

    private final ProcessoService pService;


    public ProcessoController(ProcessoService pService) {
        this.pService = pService;
    }

    @PostMapping
    public ResponseEntity<ProcessoResponse> novoProcesso(@RequestBody ProcessoRequest pr) {
        pService.criarProcesso(pr);
        return  ResponseEntity.status(HttpStatus.CREATED).body(new ProcessoResponse(pr));
    }

    @GetMapping
    public ResponseEntity<List<ProcessoResponse>> listarProcessos() {
        List<ProcessoResponse> processos = pService.listarTodosProcessos();
        return ResponseEntity.ok(processos);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarProcesso(UUID id) {
        pService.excluirProcesso(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
