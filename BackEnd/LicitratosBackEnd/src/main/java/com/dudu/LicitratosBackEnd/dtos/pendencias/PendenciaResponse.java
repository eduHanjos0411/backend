package com.dudu.LicitratosBackEnd.dtos.pendencias;

import com.dudu.LicitratosBackEnd.entities.Pendencias;
import com.dudu.LicitratosBackEnd.entities.Processos;
import com.dudu.LicitratosBackEnd.entities.Usuarios;

import java.time.LocalDateTime;

public record PendenciaResponse(
        LocalDateTime dataCriacao,
        Processos processoReferente,
        Usuarios clienteReferente
) {
    public PendenciaResponse(Pendencias p) {
        this(
                p.getData_criacao_pendencia(),
                p.getProcesso_referente(),
                p.getCliente_referente()
        );
    }

    public PendenciaResponse(PendenciaRequest pr) {
        this(
                pr.dataCriacao(),
                pr.processReferente(),
                pr.clienteReferente()
        );
    }
}
