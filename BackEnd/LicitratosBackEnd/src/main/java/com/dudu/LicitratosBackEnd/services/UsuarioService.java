package com.dudu.LicitratosBackEnd.services;


import com.dudu.LicitratosBackEnd.entities.Usuario;
import com.dudu.LicitratosBackEnd.enums.Role;
import com.dudu.LicitratosBackEnd.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Cria um novo usuário, gerando o UUID e criptografando a senha.
     *
     * @param novoUsuario Objeto Usuario com nome, email, senha, etc.
     * @return Usuario salvo (com senha criptografada).
     */
    public Usuario criarUsuario(Usuario novoUsuario) {
        // 1. Geração do ID (se não for gerado pelo banco)
        if (novoUsuario.getIdUsuario() == null || novoUsuario.getIdUsuario().isEmpty()) {
            novoUsuario.setIdUsuario(UUID.randomUUID().toString());
        }
        novoUsuario.setRoleUsuario(Role.USUARIO);

        novoUsuario.setSenhaUsuario(novoUsuario.getSenhaUsuario());

        // 3. Salva no banco de dados
        return usuarioRepository.save(novoUsuario);
    }

    // Método para buscar por ID
    public Optional<Usuario> buscarPorId(String id) {
        return usuarioRepository.findById(id);
    }

    // Método para buscar todos
    public List<Usuario> buscarTodos() {
        return usuarioRepository.findAll();
    }

    // Método para atualizar
    public Optional<Usuario> atualizarUsuario(String id, Usuario dadosAtualizados) {
        return usuarioRepository.findById(id).map(usuarioExistente -> {

            // Lógica de atualização
            usuarioExistente.setNomeUsuario(dadosAtualizados.getNomeUsuario());
            usuarioExistente.setEmailUsuario(dadosAtualizados.getEmailUsuario());
            usuarioExistente.setRoleUsuario(dadosAtualizados.getRoleUsuario());

            // A senha só deve ser atualizada se for passada uma nova.
            if (dadosAtualizados.getSenhaUsuario() != null && !dadosAtualizados.getSenhaUsuario().isEmpty()) {
                String novaSenhaHash = dadosAtualizados.getSenhaUsuario();
                usuarioExistente.setSenhaUsuario(novaSenhaHash);
            }

            return usuarioRepository.save(usuarioExistente);
        });
    }

    // Método para deletar
    public void deletarUsuario(String id) {
        usuarioRepository.deleteById(id);
    }
}

