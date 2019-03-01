package it.nasa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.nasa.model.Missione;
import it.nasa.serviceimpl.MissioneServiceImpl;

@RestController
@RequestMapping("/missione")
public class MissioneController {
	
	@Autowired
	private MissioneServiceImpl missioneServiceImpl;
	
	@GetMapping()
	public List<Missione> getAllMissioni() {
		return missioneServiceImpl.getAllMissioni();
	}

	@PostMapping()
	public void newMissione(@RequestBody Missione missione) {
		missioneServiceImpl.newMissione(missione);
	}

	@PutMapping("/{id}")
	public void updateMissione(@PathVariable int id, @RequestBody Missione missioneDetails) {
		missioneServiceImpl.updateMissione(id, missioneDetails);
	}

	@GetMapping("/{id}")
	public Missione findMissioneById(@PathVariable int id) {
		return missioneServiceImpl.findMissioneById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		missioneServiceImpl.deleteById(id);
		
	}


}
