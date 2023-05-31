package com.crimeview.api.modelo.adimin;


<<<<<<< HEAD


=======
>>>>>>> dc956d05a7acc83faa5a6f05a7b8986209369647
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
<<<<<<< HEAD
@Table(name = "Adimin")
=======
@Table(name = "Admin")
>>>>>>> dc956d05a7acc83faa5a6f05a7b8986209369647
@Where(clause = "habilitado = true")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adimin extends EntidadeAuditavel  {

   @Column
   private String email;

   @Column
   private String senha;


}
