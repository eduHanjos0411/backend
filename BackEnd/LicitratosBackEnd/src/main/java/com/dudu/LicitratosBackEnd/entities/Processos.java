package com.dudu.LicitratosBackEnd.entities;

import com.dudu.LicitratosBackEnd.enums.StatusProcesso;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Table(name = "processos")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Processos {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_processo")
    private UUID id_processo;

    @Column(name = "nome_processo")
    private String nome_processo;

    @Column(name = "data_criacao_processo")
    private LocalDateTime data_criacao_processo;

    @Enumerated(EnumType.STRING)
    @Column(name = "status_processo")
    private StatusProcesso status_processo;

    @ManyToOne
    @JoinColumn(name = "cliente_responsavel")
    private Usuarios cliente_responsavel;

    @OneToMany(mappedBy = "processo_referente")
    private List<Documentos> documentos;

    @OneToMany(mappedBy = "processo_referente")
    private List<Pendencias> pendencias;
}
