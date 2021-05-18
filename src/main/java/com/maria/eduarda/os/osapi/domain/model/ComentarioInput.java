package com.maria.eduarda.os.osapi.domain.model;

import javax.validation.constraints.NotBlank;

public class ComentarioInput {

    @NotBlank
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
