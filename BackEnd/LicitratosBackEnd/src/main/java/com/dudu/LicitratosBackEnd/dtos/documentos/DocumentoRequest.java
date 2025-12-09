package com.dudu.LicitratosBackEnd.dtos.documentos;

import com.dudu.LicitratosBackEnd.entities.Processos;

import java.time.LocalDateTime;

public record DocumentoRequest(
        String nomeDoc,
        float tamanhoDoc,
        LocalDateTime dataCriacao,
        Processos processoReferente
) {
}
