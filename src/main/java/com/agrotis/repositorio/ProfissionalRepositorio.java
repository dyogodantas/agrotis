package com.agrotis.repositorio;

import com.agrotis.entidade.Profissional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissionalRepositorio extends JpaRepository<Profissional, Integer> {
}
