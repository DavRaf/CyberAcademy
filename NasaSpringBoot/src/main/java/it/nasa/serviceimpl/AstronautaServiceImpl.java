package it.nasa.serviceimpl;

import java.util.List;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nasa.model.Astronauta;
import it.nasa.repository.AstronautaRepository;
import it.nasa.service.AstronautaService;

@Service
public class AstronautaServiceImpl implements AstronautaService {
	
	@Autowired
	private AstronautaRepository astronautaRepository;

	@Override
	public List<Astronauta> getAllAstronauti() {
		return astronautaRepository.findAll();
	}

	@Override
	public void newAstronauta(Astronauta astronauta) {
		astronautaRepository.save(astronauta);
	}

	@Override
	public void updateAstronauta(int id, Astronauta astronautaDetails) {
		Optional<Astronauta> a = astronautaRepository.findById(id);
		Astronauta astronauta = a.get();
		astronauta.setNome(astronautaDetails.getNome());
		astronauta.setCognome(astronautaDetails.getCognome());
		astronauta.setMissioni(astronautaDetails.getMissioni());
		astronautaRepository.save(astronauta);
	}

	@Override
	public Astronauta findAstronautaById(int id) {
		return astronautaRepository.findById(id).get();
		//return astronautaRepository.getOne(id);
	}
	
	@Override
	public void deleteAll() {
		astronautaRepository.deleteAll();
	}
	
	@Override
	public void deleteById(int id) {
		astronautaRepository.deleteById(id);;
	}
	
	@Override
	public void delete(Astronauta astronauta) {
		astronautaRepository.delete(astronauta);
	}
	
	@Override
	public boolean existsById(int id) {
		return astronautaRepository.existsById(id);
	}

	@Override
	public List<Astronauta> findByNome(String nome) {
		return astronautaRepository.findByNome(nome);
	}

	@Override
	public List<Astronauta> findByCognome(String cognome) {
		return astronautaRepository.findByCognome(cognome);
	}

	@Override
	public List<Astronauta> findByNomeAndCognome(String nome, String cognome) {
		return astronautaRepository.findByNomeAndCognome(nome, cognome);
	}

	@Override
	public List<Astronauta> findByNomeOrCognome(String nome, String cognome) {
		return astronautaRepository.findByNomeOrCognome(nome, cognome);
	}

	@Override
	public List<Astronauta> findByNomeContaining(String word) {
		return astronautaRepository.findByNomeContaining(word);
	}

	@Override
	public List<Astronauta> findByCognomeContaining(String word) {
		return astronautaRepository.findByCognomeContaining(word);
	}

	@Override
	public List<Astronauta> findByNomeNot(String nome) {
		return astronautaRepository.findByNomeNot(nome);
	}

	@Override
	public List<Astronauta> findByCognomeNot(String cognome) {
		return astronautaRepository.findByCognomeNot(cognome);
	}

	@Override
	public List<Astronauta> findByNomeIn(Set<String> nomi) {
		return astronautaRepository.findByNomeIn(nomi);
	}

	@Override
	public List<Astronauta> findByCognomeIn(Set<String> cognomi) {
		return astronautaRepository.findByCognomeIn(cognomi);
	}

	@Override
	public List<Astronauta> findByMissioniNome(String nome) {
		return astronautaRepository.findByMissioniNome(nome);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognome(String cognome) {
		return astronautaRepository.findByMissioniCapoProgettoCognome(cognome);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNome(String nome) {
		return astronautaRepository.findByMissioniMetaNome(nome);
	}

	@Override
	public List<Astronauta> findByMissioniMezzoNome(String nome) {
		return astronautaRepository.findByMissioniMezzoNome(nome);
	}

	@Override
	public List<Astronauta> findByMissioniNomeNot(String nome) {
		return astronautaRepository.findByMissioniNomeNot(nome);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeNot(String cognome) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeNot(cognome);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNomeNot(String nome) {
		return astronautaRepository.findByMissioniMetaNomeNot(nome);
	}

	@Override
	public List<Astronauta> findByMissioniMezzoNomeNot(String nome) {
		return astronautaRepository.findByMissioniMezzoNomeNot(nome);
	}

	@Override
	public List<Astronauta> findByMissioniNomeContaining(String word) {
		return astronautaRepository.findByMissioniNomeContaining(word);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeContaining(String word) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeContaining(word);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNomeContaining(String word) {
		return astronautaRepository.findByMissioniMetaNomeContaining(word);
	}

	@Override
	public List<Astronauta> findByMissioniMezzoNomeContaining(String word) {
		return astronautaRepository.findByMissioniMezzoNomeContaining(word);
	}

	@Override
	public List<Astronauta> findByMissioniNomeIn(Set<String> nomi) {
		return astronautaRepository.findByMissioniNomeIn(nomi);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeIn(Set<String> cognomi) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeIn(cognomi);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNomeIn(Set<String> nomi) {
		return astronautaRepository.findByMissioniMetaNomeIn(nomi);
	}

	@Override
	public List<Astronauta> findByMissioniMezzoNomeIn(Set<String> nomi) {
		return astronautaRepository.findByMissioniMezzoNomeIn(nomi);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMetaNome(String cognomeCapoProgetto,
			String nomeMeta) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeAndMissioniMetaNome(cognomeCapoProgetto, nomeMeta);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMezzoNome(String cognomeCapoProgetto,
			String nomeMezzo) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeAndMissioniMezzoNome(cognomeCapoProgetto, nomeMezzo);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNomeAndMissioniMezzoNome(String nomeMeta, String nomeMezzo) {
		return astronautaRepository.findByMissioniMetaNomeAndMissioniMezzoNome(nomeMeta, nomeMezzo);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMetaNome(String cognomeCapoProgetto,
			String nomeMeta) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeOrMissioniMetaNome(cognomeCapoProgetto, nomeMeta);
	}

	@Override
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMezzoNome(String cognomeCapoProgetto,
			String nomeMezzo) {
		return astronautaRepository.findByMissioniCapoProgettoCognomeOrMissioniMezzoNome(cognomeCapoProgetto, nomeMezzo);
	}

	@Override
	public List<Astronauta> findByMissioniMetaNomeOrMissioniMezzoNome(String nomeMeta, String nomeMezzo) {
		return astronautaRepository.findByMissioniMetaNomeOrMissioniMezzoNome(nomeMeta, nomeMezzo);
	}

}
