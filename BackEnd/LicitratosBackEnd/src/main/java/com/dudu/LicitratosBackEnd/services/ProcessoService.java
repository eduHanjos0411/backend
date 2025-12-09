package com.dudu.LicitratosBackEnd.services;


import com.dudu.LicitratosBackEnd.dtos.processos.ProcessoRequest;
import com.dudu.LicitratosBackEnd.dtos.processos.ProcessoResponse;
import com.dudu.LicitratosBackEnd.entities.Processos;
import com.dudu.LicitratosBackEnd.repositories.ProcessoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ProcessoService {

    private final ProcessoRepository pRepo;

    public ProcessoService(ProcessoRepository pRepo) {
        this.pRepo = pRepo;
    }

    public ProcessoResponse criarProcesso(ProcessoRequest pr) {
        Processos novoProcesso = new Processos();
        novoProcesso.setNome_processo(pr.nomeProcesso());
        novoProcesso.setData_criacao_processo(pr.dataCriacao());
        novoProcesso.setStatus_processo(pr.status());
        novoProcesso.setCliente_responsavel(pr.clienteResp());
        pRepo.save(novoProcesso);
        return new ProcessoResponse(pr);
    }

    public List<ProcessoResponse> listarTodosProcessos() {
        return pRepo.findAll().stream().map(ProcessoResponse::new).toList();
    }

    public void excluirProcesso(UUID id) {
        pRepo.deleteById(id);
    }
}
