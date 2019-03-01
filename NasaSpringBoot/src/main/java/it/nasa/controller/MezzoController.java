package it.nasa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import it.nasa.serviceimpl.MezzoServiceImpl;

@RestController
@RequestMapping("/mezzo")
public class MezzoController {
	
	@Autowired
	private MezzoServiceImpl mezzoServiceImpl;

}
