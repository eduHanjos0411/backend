package com.dudu.LicitratosBackEnd.controllers;

import com.dudu.LicitratosBackEnd.dtos.noticias.NoticiaRequest;
import com.dudu.LicitratosBackEnd.dtos.noticias.NoticiaResponse;
import com.dudu.LicitratosBackEnd.services.NoticiaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    private final NoticiaService nService;

    public NoticiaController(NoticiaService nService) {
        this.nService = nService;
    }

    @PostMapping
    public ResponseEntity<NoticiaResponse> novaNoticia(@RequestBody NoticiaRequest nr) {
        nService.novaNoticia(nr);
        return ResponseEntity.status(HttpStatus.CREATED).body(new NoticiaResponse(nr));
    }

    @GetMapping
    public ResponseEntity<List<NoticiaResponse>> listarNoticias() {
        List<NoticiaResponse> listaNoticias = nService.listarNoticias();

        return ResponseEntity.ok(listaNoticias);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirNoticia(UUID id) {
        nService.excluirNoticias(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
