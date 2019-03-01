package it.nasa.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nasa.repository.MezzoRepository;
import it.nasa.service.MezzoService;

@Service
public class MezzoServiceImpl implements MezzoService {
	
	@Autowired
	private MezzoRepository mezzoRepository;

}
