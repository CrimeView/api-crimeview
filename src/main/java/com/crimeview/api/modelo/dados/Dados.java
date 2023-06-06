package com.crimeview.api.modelo.dados;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import com.crimeview.api.util.entity.EntidadeAuditavel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Dados")
@Where(clause = "status_dado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Dados extends EntidadeAuditavel {

    @Column
    private String regiao;

    @Column
    private LocalDate data;

    @Column
    private String natureza;

    @Column
    private String municipio;

    @Column
    private String vitima;

    @Column(name = "status_dado")
    private Boolean statusDado;

    private Integer id_usuario;

}
