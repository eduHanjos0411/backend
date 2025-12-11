package com.dudu.LicitratosBackEnd.services;

import com.dudu.LicitratosBackEnd.entities.Processo;
import com.dudu.LicitratosBackEnd.entities.Usuario;
import com.dudu.LicitratosBackEnd.repositories.ProcessoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProcessoService {

    private final ProcessoRepository processoRepository;
    private final UsuarioService usuarioService; // Para buscar o cliente responsável

    @Autowired
    public ProcessoService(ProcessoRepository processoRepository, UsuarioService usuarioService) {
        this.processoRepository = processoRepository;
        this.usuarioService = usuarioService;
    }

    /**
     * Cria um novo processo, configurando data e garantindo o relacionamento.
     * @param novoProcesso O objeto Processo a ser salvo.
     * @return Processo salvo.
     */
    public Processo criarProcesso(Processo novoProcesso) {
        // 1. Lógica de Negócio: Geração do ID e Data de Criação
        if (novoProcesso.getIdProcesso() == null || novoProcesso.getIdProcesso().isEmpty()) {
            novoProcesso.setIdProcesso(UUID.randomUUID().toString());
        }
        if (novoProcesso.getDataCriacao() == null) {
            novoProcesso.setDataCriacao(LocalDateTime.now());
        }

        // 2. Lógica de Relacionamento: Garante que o Cliente Responsável existe
        // Isso evita salvar um processo com um cliente inválido (Se o cliente for fornecido)
        Usuario cliente = novoProcesso.getClienteResponsavel();
        if (cliente != null && cliente.getIdUsuario() != null) {
            Optional<Usuario> usuarioExistente = usuarioService.buscarPorId(cliente.getIdUsuario());

            if (usuarioExistente.isPresent()) {
                // Seta o objeto Usuario gerenciado pelo JPA
                novoProcesso.setClienteResponsavel(usuarioExistente.get());
            } else {
                throw new IllegalArgumentException("Cliente Responsável com ID " + cliente.getIdUsuario() + " não encontrado.");
            }
        }

        return processoRepository.save(novoProcesso);
    }

    // Método para buscar por ID
    public Optional<Processo> buscarPorId(String id) {
        return processoRepository.findById(id);
    }


    public List<Processo> buscarPorClienteId(String clienteId) {
        return processoRepository.findByClienteResponsavelIdUsuario(clienteId);
    }

    // Método para deletar
    public void deletarProcesso(String id) {
        processoRepository.deleteById(id);
    }
}