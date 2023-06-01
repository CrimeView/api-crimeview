package com.crimeview.api.modelo.admin;




import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.crimeview.api.util.entity.EntidadeAuditavel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "Admin")
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends EntidadeAuditavel  {

   @Column
   private String email;

   @Column
   private String senha;


}
