package it.main.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "capi_progetto")
public class CapoProgetto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;

	@OneToMany(mappedBy = "capoProgetto")
	@JsonIgnoreProperties({"capoProgetto"})
	private List<Missione> missioni;
	
	public CapoProgetto() {}

	public CapoProgetto(String nome, String cognome) {
		super();
		this.nome = nome;
		this.cognome = cognome;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public List<Missione> getMissioni() {
		return missioni;
	}

	public void setMissioni(List<Missione> missioni) {
		this.missioni = missioni;
	}
	
	

}
