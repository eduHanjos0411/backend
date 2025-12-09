package com.dudu.LicitratosBackEnd.dtos.processos;



import com.dudu.LicitratosBackEnd.entities.Processos;

import java.time.LocalDateTime;

public record ProcessoResponse(
        String nomeProcesso,
        LocalDateTime dataCriacao,
        String nomeCliente
) {
    public ProcessoResponse(ProcessoRequest pr) {
        this(
                pr.nomeProcesso(),
                pr.dataCriacao(),
                pr.clienteResp().getNome_usuario()
        );
    }

    public ProcessoResponse(Processos p) {
        this(
                p.getNome_processo(),
                p.getData_criacao_processo(),
                p.getCliente_responsavel().getNome_usuario()
        );
    }
}
