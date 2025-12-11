package com.dudu.LicitratosBackEnd.entities;

import com.dudu.LicitratosBackEnd.enums.StatusProcesso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "processos")
@Data @NoArgsConstructor @AllArgsConstructor
public class Processo {

    @Id
    @Column(name = "id_processo", length = 36, nullable = false)
    private String idProcesso;

    @Column(name = "nome_processo", length = 50)
    private String nomeProcesso;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    @Enumerated(EnumType.STRING) // Define como o ENUM será salvo no DB (como String)
    @Column(name = "status_processo")
    private StatusProcesso statusProcesso;

    @ManyToOne(fetch = FetchType.LAZY) // Muitos processos para Um Usuário
    @JoinColumn(name = "cliente_responsavel", nullable = false) // Especifica o nome EXATO da coluna FK no DB
    private Usuario clienteResponsavel;

}
