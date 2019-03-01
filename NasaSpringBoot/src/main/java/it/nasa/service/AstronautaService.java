package it.nasa.service;

import java.util.List;
import java.util.Set;

import it.nasa.model.Astronauta;

public interface AstronautaService {
	
	public List<Astronauta> getAllAstronauti();
	public void newAstronauta(Astronauta astronauta);
	public void updateAstronauta(int id, Astronauta astronautaDetails);
	public Astronauta findAstronautaById(int id);
	public void deleteAll();	
	public void deleteById(int id);	
	public void delete(Astronauta astronauta);	
	public boolean existsById(int id);
	
	public List<Astronauta> findByNome(String nome);
	public List<Astronauta> findByCognome(String cognome);
	public List<Astronauta> findByNomeAndCognome(String nome, String cognome);
	public List<Astronauta> findByNomeOrCognome(String nome, String cognome);
	public List<Astronauta> findByNomeContaining(String word);
	public List<Astronauta> findByCognomeContaining(String word);
	public List<Astronauta> findByNomeNot(String nome);
	public List<Astronauta> findByCognomeNot(String cognome);
	public List<Astronauta> findByNomeIn(Set<String> nomi);
	public List<Astronauta> findByCognomeIn(Set<String> cognomi);
	public List<Astronauta> findByMissioniNome(String nome);
	public List<Astronauta> findByMissioniCapoProgettoCognome(String cognome);
	public List<Astronauta> findByMissioniMetaNome(String nome);
	public List<Astronauta> findByMissioniMezzoNome(String nome);
	public List<Astronauta> findByMissioniNomeNot(String nome);
	public List<Astronauta> findByMissioniCapoProgettoCognomeNot(String cognome);
	public List<Astronauta> findByMissioniMetaNomeNot(String nome);
	public List<Astronauta> findByMissioniMezzoNomeNot(String nome);
	public List<Astronauta> findByMissioniNomeContaining(String word);
	public List<Astronauta> findByMissioniCapoProgettoCognomeContaining(String word);
	public List<Astronauta> findByMissioniMetaNomeContaining(String word);
	public List<Astronauta> findByMissioniMezzoNomeContaining(String word);
	public List<Astronauta> findByMissioniNomeIn(Set<String> nomi);
	public List<Astronauta> findByMissioniCapoProgettoCognomeIn(Set<String> cognomi);
	public List<Astronauta> findByMissioniMetaNomeIn(Set<String> nomi);
	public List<Astronauta> findByMissioniMezzoNomeIn(Set<String> nomi);
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMetaNome(String cognomeCapoProgetto, String nomeMeta);
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMezzoNome(String cognomeCapoProgetto, String nomeMezzo);
	public List<Astronauta> findByMissioniMetaNomeAndMissioniMezzoNome(String nomeMeta, String nomeMezzo);
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMetaNome(String cognomeCapoProgetto, String nomeMeta);
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMezzoNome(String cognomeCapoProgetto, String nomeMezzo);
	public List<Astronauta> findByMissioniMetaNomeOrMissioniMezzoNome(String nomeMeta, String nomeMezzo);


}
