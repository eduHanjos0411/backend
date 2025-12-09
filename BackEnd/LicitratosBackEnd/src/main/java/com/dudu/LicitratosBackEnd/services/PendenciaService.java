package com.dudu.LicitratosBackEnd.services;

import com.dudu.LicitratosBackEnd.dtos.pendencias.PendenciaRequest;
import com.dudu.LicitratosBackEnd.dtos.pendencias.PendenciaResponse;
import com.dudu.LicitratosBackEnd.entities.Pendencias;
import com.dudu.LicitratosBackEnd.repositories.PendenciaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PendenciaService {

    private final PendenciaRepository penRepo;

    public PendenciaService(PendenciaRepository penRepo) {
        this.penRepo = penRepo;
    }

    public PendenciaResponse novaPendencia(PendenciaRequest pr) {
        Pendencias novaPendencia = new Pendencias();
        novaPendencia.setData_criacao_pendencia(pr.dataCriacao());
        novaPendencia.setProcesso_referente(pr.processReferente());
        novaPendencia.setCliente_referente(pr.clienteReferente());
        penRepo.save(novaPendencia);

        return new PendenciaResponse(pr);
    }

    public List<PendenciaResponse> listarPendencias() {
        return penRepo.findAll().stream().map(PendenciaResponse::new).toList();
    }

    public void excluirPendencia(UUID id) {
        penRepo.deleteById(id);
    }
}
