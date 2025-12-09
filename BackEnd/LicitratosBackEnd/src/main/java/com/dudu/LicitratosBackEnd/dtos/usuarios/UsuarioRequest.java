package com.dudu.LicitratosBackEnd.dtos.usuarios;

public record UsuarioRequest(
        String nome,
        String email,
        String senha
) {
}
