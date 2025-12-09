package com.dudu.LicitratosBackEnd.dtos.pendencias;

import com.dudu.LicitratosBackEnd.entities.Processos;
import com.dudu.LicitratosBackEnd.entities.Usuarios;

import java.time.LocalDateTime;

public record PendenciaRequest(
        LocalDateTime dataCriacao,
        Processos processReferente,
        Usuarios clienteReferente
) {

}
