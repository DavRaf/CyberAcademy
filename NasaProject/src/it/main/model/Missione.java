package it.main.model;

import java.io.Serializable;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "missioni")
public class Missione implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	@Column(name = "nome")
	private String nome;
	@Column(name = "descrizione")
	private String descrizione;
	
	@ManyToOne
    @JoinColumn(name = "id_capo_progetto")
	@JsonIgnoreProperties({"missioni"})
	private CapoProgetto capoProgetto;
	
	@ManyToOne
    @JoinColumn(name = "id_meta")
	@JsonIgnoreProperties({"missioni"})
	private Meta meta;
	
	@ManyToOne
    @JoinColumn(name = "id_mezzo")
	@JsonIgnoreProperties({"missioni"})
	private Mezzo mezzo;
	
	@ManyToMany
    @JoinTable(
        name = "missioni_astronauti", 
        joinColumns = { @JoinColumn(name = "id_missione")}, 
        inverseJoinColumns = { @JoinColumn(name = "id_astronauta") }
    )
	@JsonIgnoreProperties({"missioni"})
	Set<Astronauta> astronauti = new HashSet<>();
	
	public Missione() {}

	public Missione(String nome, String descrizione) {
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

	public CapoProgetto getCapoProgetto() {
		return capoProgetto;
	}

	public void setCapoProgetto(CapoProgetto capoProgetto) {
		this.capoProgetto = capoProgetto;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Mezzo getMezzo() {
		return mezzo;
	}

	public void setMezzo(Mezzo mezzo) {
		this.mezzo = mezzo;
	}

	public Set<Astronauta> getAstronauti() {
		return astronauti;
	}

	public void setAstronauti(Set<Astronauta> astronauti) {
		this.astronauti = astronauti;
	}
	
	@Override
	public String toString() {
		return "Missione [id=" + id + ", nome=" + nome + ", descrizione=" + descrizione + ", capoProgetto="
				+ capoProgetto + ", meta=" + meta + ", mezzo=" + mezzo + ", astronauti=" + astronauti + "]";
	}
	

}
