package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.dtos.pendencias.PendenciaRequest;
import com.dudu.LicitratosBackEnd.dtos.pendencias.PendenciaResponse;
import com.dudu.LicitratosBackEnd.services.PendenciaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/pendencias")
public class PendenciaController {

    private final PendenciaService penService;

    public PendenciaController(PendenciaService penS, PendenciaService penService) {
        this.penService = penService;

    }

    @PostMapping
    public ResponseEntity<PendenciaResponse> novaPendencia(@RequestBody PendenciaRequest pr) {
        penService.novaPendencia(pr);
        return ResponseEntity.status(HttpStatus.CREATED).body(new PendenciaResponse(pr));
    }

    @GetMapping
    public ResponseEntity<List<PendenciaResponse>> listarPendencias() {
        List<PendenciaResponse> listaPendencias = penService.listarPendencias();
        return ResponseEntity.ok(listaPendencias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> exluirPendencia(UUID id) {
        penService.excluirPendencia(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }


}
