package com.dudu.LicitratosBackEnd.entities;

import com.dudu.LicitratosBackEnd.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "usuario")
@Data @NoArgsConstructor @AllArgsConstructor
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_usuario;

    private String nome_usuario;

    private String email_usuario;

    private String senha_usuario;

    private Role role;

}

