package com.crimeview.api.modelo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DadosRepository extends JpaRepository<Dados, Long> {
    List<Dados> findAllByStatusDadoTrue();
    Dados findByIdAndStatusDado(Long id, boolean statusDado);
}
