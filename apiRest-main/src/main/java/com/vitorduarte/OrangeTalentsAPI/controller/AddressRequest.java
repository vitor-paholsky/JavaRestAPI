package com.vitorduarte.OrangeTalentsAPI.controller;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class AddressRequest {
    @NotNull
    private Long userId;
    @NotEmpty
    private String cep;
    @NotEmpty
    private String numero;

    private String complemento;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }
}
