package com.dudu.LicitratosBackEnd.dtos.usuarios;

import com.dudu.LicitratosBackEnd.entities.Usuarios;

public record UsuarioResponse(
        String nome,
        String email
) {

    public UsuarioResponse(UsuarioRequest ur) {
        this(
                ur.nome(),
                ur.email()
        );
    }

    public UsuarioResponse(Usuarios u) {
        this (
                u.getNome_usuario(),
                u.getEmail_usuario()
        );
    }
}
