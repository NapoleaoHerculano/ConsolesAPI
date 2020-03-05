package com.treino.consoles.dto;

import com.treino.consoles.domain.Fabricante;

import java.io.Serializable;

public class FabricanteDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private String pais;
    private String anoFundacao;

    public FabricanteDTO(){

    }

    public FabricanteDTO(Fabricante fabricante){
        this.id = fabricante.getId();
        this.nome = fabricante.getNome();
        this.pais = fabricante.getPais();
        this.anoFundacao = fabricante.getAnoFundacao();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAnoFundacao() {
        return anoFundacao;
    }

    public void setAnoFundacao(String anoFundacao) {
        this.anoFundacao = anoFundacao;
    }
}
