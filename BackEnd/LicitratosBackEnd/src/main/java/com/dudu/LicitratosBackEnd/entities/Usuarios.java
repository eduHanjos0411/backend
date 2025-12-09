package com.dudu.LicitratosBackEnd.entities;

import com.dudu.LicitratosBackEnd.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "usuarios")
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuarios {
    @Id @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_usuario")
    private UUID id_usuario;

    @Column(name = "nome_usuario")
    private String nome_usuario;

    @Column(name = "email_usuario")
    private String email_usuario;

    @Column(name = "senha_usuario")
    private String senha_usuario;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_usuario")
    private Role role_usuario;

    @OneToMany(mappedBy = "cliente_responsavel")
    private List<Processos> processos;

    @OneToMany(mappedBy = "cliente_referente")
    private List<Pendencias> pendencias;
}
