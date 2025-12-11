package com.dudu.LicitratosBackEnd.repositories;

import com.dudu.LicitratosBackEnd.entities.Processo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProcessoRepository extends JpaRepository<Processo, String> {

    List<Processo> findByClienteResponsavelIdUsuario(String idUsuario);
}
