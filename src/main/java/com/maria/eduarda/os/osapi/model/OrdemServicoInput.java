package com.maria.eduarda.os.osapi.model;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

public class OrdemServicoInput {
    @NotBlank
    private String descricao;

    @NotNull
    private BigDecimal preco;

    @Valid
    @NotNull
    private ClienteIdInput Cliente;

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public ClienteIdInput getCliente() {
        return Cliente;
    }

    public void setCliente(ClienteIdInput cliente) {
        Cliente = cliente;
    }
}
