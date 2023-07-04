package com.crimeview.api.modelo.dadosReport;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;
import org.springframework.data.annotation.CreatedDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "DadosReport")
@Where(clause = "status_dado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DadosReport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String regiao;

    @Column
    @CreatedDate
    private LocalDate data;

    @Column
    private String natureza;

    @Column
    private String municipio;

    @Column
    private Integer vitima;

    @Column(name = "status_dado")
    private Boolean statusDado;

    private Integer id_usuario;

}
