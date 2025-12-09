package com.dudu.LicitratosBackEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "pendencias")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Pendencias {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_pendencia")
    private UUID id_pendencia;

    @Column(name = "data_criacao_pendencia")
    private LocalDateTime data_criacao_pendencia;

    @ManyToOne()
    @JoinColumn(name = "processo_referente")
    private Processos processo_referente;

    @ManyToOne()
    @JoinColumn(name = "cliente_referente")
    private Usuarios cliente_referente;

}
