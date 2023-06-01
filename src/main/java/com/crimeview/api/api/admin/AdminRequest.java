package com.crimeview.api.api.admin;

import com.crimeview.api.modelo.admin.Admin;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminRequest {

   private String email;

   private String senha;

   public Admin build() {

       return Admin.builder()
               .email(email)
               .senha(senha)
               .build();
   }
}

