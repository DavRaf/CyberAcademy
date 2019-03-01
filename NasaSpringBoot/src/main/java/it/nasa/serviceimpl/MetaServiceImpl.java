package it.nasa.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nasa.model.Meta;
import it.nasa.repository.MetaRepository;
import it.nasa.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService {
	
	@Autowired
	private MetaRepository metaRepository;

	@Override
	public List<Meta> getAllMete() {
		// TODO Auto-generated method stub
		return metaRepository.findAll();
	}

	@Override
	public void newMeta(Meta meta) {
		// TODO Auto-generated method stub
		metaRepository.save(meta);
	}

	@Override
	public void updateMeta(int id, Meta metaDetails) {
		Meta meta = findMetaById(id);
		meta.setNome(metaDetails.getNome());
		meta.setDescrizione(metaDetails.getDescrizione());
		meta.setMissioni(metaDetails.getMissioni());
		metaRepository.save(meta);
	}

	@Override
	public Meta findMetaById(int id) {
		return metaRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		metaRepository.deleteById(id);
		
	}

}
