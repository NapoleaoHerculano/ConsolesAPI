package com.treino.consoles.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Fabricante implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String pais;
	private String anoFundacao;
	
	@OneToMany(mappedBy="fabricante", cascade = CascadeType.ALL)
	private List<Console> consoles = new ArrayList<>();
	
	public Fabricante() {
		
	}

	public Fabricante(Integer id, String nome, String pais, String anoFundacao) {
		super();
		this.id = id;
		this.nome = nome;
		this.pais = pais;
		this.anoFundacao = anoFundacao;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fabricante other = (Fabricante) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<Console> getConsoles() {
		return consoles;
	}

	public void setConsoles(List<Console> consoles) {
		this.consoles = consoles;
	}
	
	
	
}
