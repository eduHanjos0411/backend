package com.dudu.LicitratosBackEnd.dtos.processos;

import com.dudu.LicitratosBackEnd.entities.Usuarios;
import com.dudu.LicitratosBackEnd.enums.StatusProcesso;

import java.time.LocalDateTime;

public record ProcessoRequest(
    String nomeProcesso,
    LocalDateTime dataCriacao,
    StatusProcesso status,
    Usuarios clienteResp
) {
}
