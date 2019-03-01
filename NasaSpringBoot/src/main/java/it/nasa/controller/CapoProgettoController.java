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

import it.nasa.model.CapoProgetto;
import it.nasa.serviceimpl.CapoProgettoServiceImpl;

@RestController
@RequestMapping("/capoProgetto")
public class CapoProgettoController {
	
	@Autowired
	private CapoProgettoServiceImpl capoProgettoServiceImpl;
	
	@GetMapping()
	public List<CapoProgetto> getAllCapiProgetto(){
		return capoProgettoServiceImpl.getAllCapiProgetto();
	}
	
	@GetMapping("/{id}")
	public CapoProgetto findCapoProgettoById(@PathVariable int id){
		return capoProgettoServiceImpl.findCapoProgettoById(id);
	}
	
	@PostMapping()
	public void newCapoProgetto(@RequestBody CapoProgetto capoProgetto) {
		capoProgettoServiceImpl.newCapoProgetto(capoProgetto);
	}
	
	@PutMapping("/{id}")
	public void updateCapoProgetto(@PathVariable int id, @RequestBody CapoProgetto capoProgettoDetails) {
		capoProgettoServiceImpl.updateCapoProgetto(id, capoProgettoDetails);
	}
	
	@DeleteMapping("/{id}")
	public void deleteCapoProgettoById(@PathVariable int id) {
		capoProgettoServiceImpl.deleteById(id);;
	}

}
