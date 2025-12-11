package com.dudu.LicitratosBackEnd.entities;

import com.dudu.LicitratosBackEnd.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@Data @AllArgsConstructor @NoArgsConstructor
public class Usuario {

    @Id
    @Column(name = "id_usuario", length = 36, nullable = false)
    private String idUsuario; // Mapeado como String (para UUID/CHAR)

    @Column(name = "nome_usuario", length = 55)
    private String nomeUsuario;

    @Column(name = "email_usuario", length = 50, unique = true) // Assumindo que o email deve ser único
    private String emailUsuario;


    @Column(name = "senha_usuario", length = 50)
    private String senhaUsuario;

    @Enumerated(EnumType.STRING) // Garante que o nome do ENUM seja salvo como String
    @Column(name = "role_usuario")
    private Role roleUsuario;

    @OneToMany(
            mappedBy = "clienteResponsavel", // Nome do campo na entidade Processo que contém o @ManyToOne
            cascade = CascadeType.ALL, // Se o usuário for excluído, os processos relacionados também serão
            fetch = FetchType.LAZY // Carrega os processos somente quando solicitados
    )
    @JsonIgnore
    private Set<Processo> processos;
}
