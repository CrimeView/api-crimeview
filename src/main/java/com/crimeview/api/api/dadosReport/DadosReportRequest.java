package com.crimeview.api.api.dadosReport;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import org.springframework.cglib.core.Local;

import com.crimeview.api.modelo.dadosReport.DadosReport;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DadosReportRequest {

    private String regiao;

    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate data = LocalDate.now();

    private String natureza;

    private String municipio;

    private Integer vitima;

    private Boolean statusDado;

    private Integer id_usuario;

    public DadosReport build() {
        return DadosReport.builder()
                .regiao(regiao)
                .data(data)
                .natureza(natureza)
                .municipio(municipio)
                .vitima(vitima)
                .statusDado(statusDado)
                .id_usuario(id_usuario)
                .build();
    }
}
