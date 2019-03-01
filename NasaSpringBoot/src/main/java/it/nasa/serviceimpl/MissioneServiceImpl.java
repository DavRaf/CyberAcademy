package it.nasa.serviceimpl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.nasa.model.Missione;
import it.nasa.repository.MissioneRepository;
import it.nasa.service.MissioneService;

@Service
public class MissioneServiceImpl implements MissioneService {
	
	@Autowired
	private MissioneRepository missioneRepository;
	
	@Override
	public List<Missione> getAllMissioni() {
		// TODO Auto-generated method stub
		return missioneRepository.findAll();
	}

	@Override
	public void newMissione(Missione missione) {
		// TODO Auto-generated method stub
		missioneRepository.save(missione);
	}

	@Override
	public void updateMissione(int id, Missione missioneDetails) {
		Missione missione = findMissioneById(id);
		missione.setNome(missioneDetails.getNome());
		missione.setDescrizione(missioneDetails.getDescrizione());
		missione.setAstronauti(missioneDetails.getAstronauti());
		missione.setMezzo(missioneDetails.getMezzo());
		missione.setMeta(missioneDetails.getMeta());
		missione.setCapoProgetto(missioneDetails.getCapoProgetto());
		missioneRepository.save(missione);
	}

	@Override
	public Missione findMissioneById(int id) {
		return missioneRepository.findById(id).get();
	}

	@Override
	public void deleteById(int id) {
		missioneRepository.deleteById(id);
		
	}

}
