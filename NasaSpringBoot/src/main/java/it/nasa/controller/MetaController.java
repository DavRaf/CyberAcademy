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

import it.nasa.model.Meta;
import it.nasa.serviceimpl.MetaServiceImpl;

@RestController
@RequestMapping("/meta")
public class MetaController {
	
	@Autowired
	private MetaServiceImpl metaServiceImpl;
	
	@GetMapping()
	public List<Meta> getAllMete() {
		return metaServiceImpl.getAllMete();
	}

	@PostMapping()
	public void newMeta(@RequestBody Meta meta) {
		metaServiceImpl.newMeta(meta);
	}

	@PutMapping("/{id}")
	public void updateMeta(@PathVariable int id, @RequestBody Meta metaDetails) {
		metaServiceImpl.updateMeta(id, metaDetails);
	}

	@GetMapping("/{id}")
	public Meta findMetaById(@PathVariable int id) {
		return metaServiceImpl.findMetaById(id);
	}

	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable int id) {
		metaServiceImpl.deleteById(id);
		
	}


}
