package com.crimeview.api.modelo.dadosReport;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DadosReportRepository extends JpaRepository<DadosReport, Long> {
    @Query("SELECT d FROM DadosReport d ORDER BY d.data DESC")
    public List<DadosReport> findAllOrderedByDataDesc();
}
