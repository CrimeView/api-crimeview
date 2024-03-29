package com.crimeview.api.util.entity;

import org.springframework.web.bind.annotation.CrossOrigin;

import com.crimeview.api.util.exception.PreenchimentoException;

@CrossOrigin
public abstract class GenericController {
 
    protected void validarPreenchimentoChave(String chave) {

        if (chave == null || chave.equals("")) {
            throw new PreenchimentoException(PreenchimentoException.MSG_CHAVE_NAO_INFORMADA);
        }
    }
}

