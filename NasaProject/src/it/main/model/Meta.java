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
@Table(name = "mete")
public class Meta implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) 
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descrizione")
	private String descrizione;

	@OneToMany(mappedBy = "meta")
	@JsonIgnoreProperties({"meta"})
	private List<Missione> missioni;
	
	public Meta() {}

	public Meta(String nome, String descrizione) {
		super();
		this.nome = nome;
		this.descrizione = descrizione;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public List<Missione> getMissioni() {
		return missioni;
	}

	public void setMissioni(List<Missione> missioni) {
		this.missioni = missioni;
	}
	
	

}
