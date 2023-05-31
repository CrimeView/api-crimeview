package com.crimeview.api.api.adimin;

import java.time.LocalDate;

import javax.validation.constraints.Email;

import com.fasterxml.jackson.annotation.JsonFormat;

import com.crimeview.api.api.adimin.AdiminController;
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

   private String senha;

   private String email;


   public Adimin build() {
    
       return Adimin.builder()
               .senha(senha)
               .email(email)
               
}
