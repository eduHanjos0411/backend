package com.dudu.LicitratosBackEnd.services;

import com.dudu.LicitratosBackEnd.dtos.usuarios.UsuarioRequest;
import com.dudu.LicitratosBackEnd.dtos.usuarios.UsuarioResponse;
import com.dudu.LicitratosBackEnd.entities.Usuarios;
import com.dudu.LicitratosBackEnd.enums.Role;
import com.dudu.LicitratosBackEnd.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UsuarioService {

    private final UsuarioRepository uRepo;

    public UsuarioService(UsuarioRepository uRepo) {
        this.uRepo = uRepo;
    }

    public UsuarioResponse novoUsuario(UsuarioRequest request) {
        Usuarios novo = new Usuarios();
        novo.setNome_usuario(request.nome());
        novo.setEmail_usuario(request.email());
        novo.setSenha_usuario(request.senha());
        novo.setRole_usuario(Role.USUARIO);
        uRepo.save(novo);

        return new UsuarioResponse(request);
    }

    public List<UsuarioResponse> listarUsuarios() {
        return uRepo.findAll().stream().map(UsuarioResponse::new).toList();
    }

    public UsuarioResponse atualizarUsuario(UUID id, UsuarioRequest ur) {
        Usuarios alterar = uRepo.findById(id).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        alterar.setNome_usuario(ur.nome());
        alterar.setEmail_usuario(ur.email());
        alterar.setSenha_usuario(ur.senha());
        uRepo.save(alterar);
        return new UsuarioResponse(alterar);
    }

    public void excluirUsuario(UUID id) {
        uRepo.deleteById(id);
    }
}
