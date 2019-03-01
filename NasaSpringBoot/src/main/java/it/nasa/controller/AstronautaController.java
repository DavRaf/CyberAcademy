package it.nasa.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.nasa.model.Astronauta;
import it.nasa.serviceimpl.AstronautaServiceImpl;

@RestController
@RequestMapping("/astronauta")
public class AstronautaController {
	
	@Autowired
	private AstronautaServiceImpl astronautaServiceImpl;
	
	@GetMapping()
	public List<Astronauta> getAllAstronauti(){
		return astronautaServiceImpl.getAllAstronauti();
	}
	
	@GetMapping("/{id}")
	public Astronauta findAstronautaById(@PathVariable int id){
		return astronautaServiceImpl.findAstronautaById(id);
	}
	
	@GetMapping("/isPresent/{id}")
	public boolean existsAstronautaById(@PathVariable int id) {
		return astronautaServiceImpl.existsById(id);
	}
	
	@PostMapping()
	public void newAstronauta(@RequestBody Astronauta astronauta) {
		astronautaServiceImpl.newAstronauta(astronauta);
	}
	
	@PutMapping("/{id}")
	public void updateAstronauta(@PathVariable int id, @RequestBody Astronauta astronautaDetails) {
		astronautaServiceImpl.updateAstronauta(id, astronautaDetails);
	}
	
	@DeleteMapping("/all")
	public void deleteAllAstronauti() {
		astronautaServiceImpl.deleteAll();
	}
	
	@DeleteMapping("/{id}")
	public void deleteAstronautaById(@PathVariable int id) {
		astronautaServiceImpl.deleteById(id);;
	}
	
	@DeleteMapping()
	public void deleteAstronauta(@RequestBody Astronauta astronauta) {
		astronautaServiceImpl.delete(astronauta);
	}
	
	@GetMapping("/getByNome/{nome}")
	public List<Astronauta> findByNome(@PathVariable String nome) {
		return astronautaServiceImpl.findByNome(nome);
	}

	@GetMapping("/getByCognome/{cognome}")
	public List<Astronauta> findByCognome(@PathVariable String cognome) {
		return astronautaServiceImpl.findByCognome(cognome);
	}

	@GetMapping("/getByNomeAndCognome/{nome}/{cognome}")
	public List<Astronauta> findByNomeAndCognome(@PathVariable String nome, @PathVariable String cognome) {
		return astronautaServiceImpl.findByNomeAndCognome(nome, cognome);
	}

	@GetMapping("/getByNomeOrCognome/{nome}/{cognome}")
	public List<Astronauta> findByNomeOrCognome(@PathVariable String nome, @PathVariable String cognome) {
		return astronautaServiceImpl.findByNomeOrCognome(nome, cognome);
	}

	@GetMapping("/getByNomeContaining/{word}")
	public List<Astronauta> findByNomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByNomeContaining(word);
	}

	@GetMapping("/getByCognomeContaining/{word}")
	public List<Astronauta> findByCognomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByCognomeContaining(word);
	}

	@GetMapping("/getByNomeNot/{nome}")
	public List<Astronauta> findByNomeNot(@PathVariable String nome) {
		return astronautaServiceImpl.findByNomeNot(nome);
	}

	@GetMapping("/getByCognomeNot/{cognome}")
	public List<Astronauta> findByCognomeNot(@PathVariable String cognome) {
		return astronautaServiceImpl.findByCognomeNot(cognome);
	}

	@GetMapping("/getByNomeIn")
	public List<Astronauta> findByNomeIn(@RequestBody Set<String> nomi) {
		return astronautaServiceImpl.findByNomeIn(nomi);
	}

	@GetMapping("/getByCognomeIn")
	public List<Astronauta> findByCognomeIn(@RequestBody Set<String> cognomi) {
		return astronautaServiceImpl.findByCognomeIn(cognomi);
	}

	@GetMapping("/getByNomeMissione/{nome}")
	public List<Astronauta> findByMissioniNome(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniNome(nome);
	}

	@GetMapping("/getByCognomeCapoProgetto/{cognome}")
	public List<Astronauta> findByMissioniCapoProgettoCognome(@PathVariable String cognome) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognome(cognome);
	}

	@GetMapping("/getByNomeMeta/{nome}")
	public List<Astronauta> findByMissioniMetaNome(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniMetaNome(nome);
	}

	@GetMapping("/getByNomeMezzo/{nome}")
	public List<Astronauta> findByMissioniMezzoNome(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniMezzoNome(nome);
	}

	@GetMapping("/getByNomeMissioneNot/{nome}")
	public List<Astronauta> findByMissioniNomeNot(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniNomeNot(nome);
	}

	@GetMapping("/getByCognomeCapoProgettoNot/{cognome}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeNot(@PathVariable String cognome) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeNot(cognome);
	}

	@GetMapping("/getByNomeMetaNot/{nome}")
	public List<Astronauta> findByMissioniMetaNomeNot(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniMetaNomeNot(nome);
	}

	@GetMapping("/getByNomeMezzoNot/{nome}")
	public List<Astronauta> findByMissioniMezzoNomeNot(@PathVariable String nome) {
		return astronautaServiceImpl.findByMissioniMezzoNomeNot(nome);
	}

	@GetMapping("/getByNomeMissioneContaining/{word}")
	public List<Astronauta> findByMissioniNomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByMissioniNomeContaining(word);
	}

	@GetMapping("/getByCognomeCapoProgettoContaining/{word}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeContaining(word);
	}

	@GetMapping("/getByNomeMetaContaining/{word}")
	public List<Astronauta> findByMissioniMetaNomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByMissioniMetaNomeContaining(word);
	}

	@GetMapping("/getByNomeMezzoContaining/{word}")
	public List<Astronauta> findByMissioniMezzoNomeContaining(@PathVariable String word) {
		return astronautaServiceImpl.findByMissioniMezzoNomeContaining(word);
	}

	@GetMapping("/getByNomeMissioneIn")
	public List<Astronauta> findByMissioniNomeIn(@RequestBody Set<String> nomi) {
		return astronautaServiceImpl.findByMissioniNomeIn(nomi);
	}
	
	@GetMapping("/getByCognomeCapoProgettoIn")
	public List<Astronauta> findByMissioniCapoProgettoCognomeIn(@RequestBody Set<String> cognomi) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeIn(cognomi);
	}
	
	@GetMapping("/getByNomeMetaIn")
	public List<Astronauta> findByMissioniMetaNomeIn(@RequestBody Set<String> nomi) {
		return astronautaServiceImpl.findByMissioniMetaNomeIn(nomi);
	}

	@GetMapping("/getByNomeMezzoIn")
	public List<Astronauta> findByMissioniMezzoNomeIn(@RequestBody Set<String> nomi) {
		return astronautaServiceImpl.findByMissioniMezzoNomeIn(nomi);
	}

	@GetMapping("/getByCognomeCapoProgettoAndNomeMeta/{cognomeCapoProgetto}/{nomeMeta}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMetaNome(@PathVariable String cognomeCapoProgetto,
			@PathVariable String nomeMeta) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeAndMissioniMetaNome(cognomeCapoProgetto, nomeMeta);
	}

	@GetMapping("/getByCognomeCapoProgettoAndNomeMezzo/{cognomeCapoProgetto}/{nomeMezzo}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeAndMissioniMezzoNome(@PathVariable String cognomeCapoProgetto,
			@PathVariable String nomeMezzo) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeAndMissioniMezzoNome(cognomeCapoProgetto, nomeMezzo);
	}

	@GetMapping("/getByNomeMetaAndNomeMezzo/{nomeMeta}/{nomeMezzo}")
	public List<Astronauta> findByMissioniMetaNomeAndMissioniMezzoNome(@PathVariable String nomeMeta, @PathVariable String nomeMezzo) {
		return astronautaServiceImpl.findByMissioniMetaNomeAndMissioniMezzoNome(nomeMeta, nomeMezzo);
	}

	@GetMapping("/getByCognomeCapoProgettoOrNomeMeta/{cognomeCapoProgetto}/{nomeMeta}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMetaNome(@PathVariable String cognomeCapoProgetto,
			@PathVariable String nomeMeta) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeOrMissioniMetaNome(cognomeCapoProgetto, nomeMeta);
	}

	@GetMapping("/getByCognomeCapoProgettoOrNomeMezzo/{cognomeCapoProgetto}/{nomeMezzo}")
	public List<Astronauta> findByMissioniCapoProgettoCognomeOrMissioniMezzoNome(@PathVariable String cognomeCapoProgetto,
			@PathVariable String nomeMezzo) {
		return astronautaServiceImpl.findByMissioniCapoProgettoCognomeOrMissioniMezzoNome(cognomeCapoProgetto, nomeMezzo);
	}

	@GetMapping("/getByNomeMetaOrNomeMezzo/{nomeMeta}/{nomeMezzo}")
	public List<Astronauta> findByMissioniMetaNomeOrMissioniMezzoNome(@PathVariable String nomeMeta, @PathVariable String nomeMezzo) {
		return astronautaServiceImpl.findByMissioniMetaNomeOrMissioniMezzoNome(nomeMeta, nomeMezzo);
	}

}
