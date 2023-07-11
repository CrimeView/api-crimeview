package com.crimeview.api.modelo.dadosReport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DadosReportRepository extends JpaRepository<DadosReport, Long> {
    @Query("SELECT d FROM DadosReport d ORDER BY d.data DESC")
    public List<DadosReport> findAllOrderedByDataDesc();

    @Query("SELECT d FROM DadosReport d WHERE d.id_usuario = :id_usuario")
    public List<DadosReport> findAllByUsuarioId(@Param("id_usuario") String id_usuario);
}
