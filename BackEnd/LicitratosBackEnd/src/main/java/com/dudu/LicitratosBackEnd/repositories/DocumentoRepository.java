package com.dudu.LicitratosBackEnd.repositories;

import com.dudu.LicitratosBackEnd.entities.Documentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DocumentoRepository extends JpaRepository<Documentos, UUID> {
}
