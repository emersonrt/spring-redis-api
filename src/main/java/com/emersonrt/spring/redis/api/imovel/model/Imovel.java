package com.emersonrt.spring.redis.api.imovel.model;

import java.io.Serializable;
import java.math.BigDecimal;

public class Imovel implements Serializable {

    private Long id;
    private String endereco;
    private BigDecimal preco;
    private BigDecimal area;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public BigDecimal getArea() {
        return area;
    }

    public void setArea(BigDecimal area) {
        this.area = area;
    }
}
