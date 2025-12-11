package com.dudu.LicitratosBackEnd.dtos.usuario;

import com.dudu.LicitratosBackEnd.entities.Usuario;

public record UsuarioResponse(
        String nome,
        String email
) {

    public UsuarioResponse(Usuario u) {
        this(
                u.getNome_usuario(),
                u.getEmail_usuario()
        );
    }
}

