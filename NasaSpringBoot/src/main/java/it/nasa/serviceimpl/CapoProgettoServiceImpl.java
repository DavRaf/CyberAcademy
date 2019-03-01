package it.nasa.serviceimpl;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nasa.model.CapoProgetto;
import it.nasa.repository.CapoProgettoRepository;
import it.nasa.service.CapoProgettoService;

@Service
public class CapoProgettoServiceImpl implements CapoProgettoService {
	
	@Autowired
	private CapoProgettoRepository capoProgettoRepository;
	
	@Override
	public List<CapoProgetto> getAllCapiProgetto() {
		return capoProgettoRepository.findAll();
	}

	@Override
	public void newCapoProgetto(CapoProgetto capoProgetto) {
		capoProgettoRepository.save(capoProgetto);
	}

	@Override
	public void updateCapoProgetto(int id, CapoProgetto capoProgettoDetails) {
		Optional<CapoProgetto> a = capoProgettoRepository.findById(id);
		CapoProgetto capoProgetto = a.get();
		capoProgetto.setNome(capoProgettoDetails.getNome());
		capoProgetto.setCognome(capoProgettoDetails.getCognome());
		capoProgetto.setMissioni(capoProgettoDetails.getMissioni());
		capoProgettoRepository.save(capoProgetto);
	}

	@Override
	public CapoProgetto findCapoProgettoById(int id) {
		return capoProgettoRepository.findById(id).get();
		//return astronautaRepository.getOne(id);
	}
	
	@Override
	public void deleteAll() {
		capoProgettoRepository.deleteAll();
	}
	
	@Override
	public void deleteById(int id) {
		capoProgettoRepository.deleteById(id);;
	}
	
	@Override
	public void delete(CapoProgetto capoProgetto) {
		capoProgettoRepository.delete(capoProgetto);
	}
	
	@Override
	public boolean existsById(int id) {
		return capoProgettoRepository.existsById(id);
	}

}
