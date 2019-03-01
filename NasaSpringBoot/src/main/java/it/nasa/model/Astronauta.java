package it.nasa.model;

import java.io.Serializable;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "astronauti")
public class Astronauta implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "cognome")
	private String cognome;
	
	@ManyToMany(mappedBy = "astronauti")
	@JsonIgnoreProperties({"astronauti"})
    private Set<Missione> missioni = new HashSet<>();
	
	public Astronauta() {}
	
	public Astronauta(String nome, String cognome) {
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

	public Set<Missione> getMissioni() {
		return missioni;
	}

	public void setMissioni(Set<Missione> missioni) {
		this.missioni = missioni;
	}
	
	

}
