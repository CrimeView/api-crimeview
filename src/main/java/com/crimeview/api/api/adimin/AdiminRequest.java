package com.crimeview.api.api.adimin;

import com.crimeview.api.modelo.adimin.Adimin;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdiminRequest {

   private String email;

   private String senha;

   public Adimin build() {

       return Adimin.builder()
               .email(email)
               .senha(senha)
               .build();
   }
}

