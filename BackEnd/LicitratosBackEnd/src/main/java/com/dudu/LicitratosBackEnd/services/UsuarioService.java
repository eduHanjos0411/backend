package com.dudu.LicitratosBackEnd.services;

import com.dudu.LicitratosBackEnd.dtos.usuario.UsuarioRequest;
import com.dudu.LicitratosBackEnd.dtos.usuario.UsuarioResponse;
import com.dudu.LicitratosBackEnd.entities.Usuario;
import com.dudu.LicitratosBackEnd.repositories.UsuarioRepository;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository uRepo;

    public UsuarioService(UsuarioRepository uRepo) {
        this.uRepo = uRepo;
    }

    public UsuarioResponse novoUsuario(UsuarioRequest ur) {
        Usuario novo = new Usuario();
        novo.setNome_usuario(ur.nome());
        novo.setEmail_usuario(ur.email());
        novo.setSenha_usuario(ur.senha());
        uRepo.save(novo);
        return  new UsuarioResponse(novo);
    }
}

