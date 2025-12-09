package com.dudu.LicitratosBackEnd.repositories;

import com.dudu.LicitratosBackEnd.entities.Processos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProcessoRepository extends JpaRepository<Processos, UUID> {
}
