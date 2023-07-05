package com.crimeview.api.modelo.dados;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DadosRepository extends JpaRepository<Dados, Long> {
    @Query("SELECT d FROM Dados d ORDER BY d.data DESC")
    public List<Dados> findAllOrderedByDataDesc();
}
