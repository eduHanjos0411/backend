package com.dudu.LicitratosBackEnd.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "documentos")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Documentos {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id_documento;

    @Column(name = "nome_documento")
    private String nome_documento;

    @Column(name = "tipo_documento")
    private String tipo_documento ;

    @Column(name = "data_criacao_documento")
    private LocalDateTime data_criacao_documento;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] dados;

    @ManyToOne()
    @JoinColumn(name = "processo_referente")
    private Processos processo_referente;
}
