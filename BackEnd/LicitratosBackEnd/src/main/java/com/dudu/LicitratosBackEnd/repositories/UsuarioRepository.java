package com.dudu.LicitratosBackEnd.repositories;

import com.dudu.LicitratosBackEnd.entities.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, UUID> {
}
