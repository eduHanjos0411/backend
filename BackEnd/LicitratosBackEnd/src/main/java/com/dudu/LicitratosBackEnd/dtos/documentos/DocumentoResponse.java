package com.dudu.LicitratosBackEnd.dtos.documentos;

import com.dudu.LicitratosBackEnd.entities.Documentos;
import com.dudu.LicitratosBackEnd.entities.Processos;

import java.time.LocalDateTime;

public record DocumentoResponse(
        String nomeDoc,
        float tamanhoDoc,
        LocalDateTime dataCriacao,
        Processos processoReferente
) {
    public  DocumentoResponse(Documentos d) {
        this(
                d.getNome_documento(),
                d.getTamanho_documento(),
                d.getData_criacao_documento(),
                d.getProcesso_referente()
        );
    }

    public DocumentoResponse(DocumentoRequest dr) {
        this(
                dr.nomeDoc(),
                dr.tamanhoDoc(),
                dr.dataCriacao(),
                dr.processoReferente()
        );
    }
}
