package it.nasa.service;

import java.util.List;

import it.nasa.model.Missione;

public interface MissioneService {
	
	public List<Missione> getAllMissioni();
	public void newMissione(Missione missione);
	public void updateMissione(int id, Missione missioneDetails);
	public Missione findMissioneById(int id);
	public void deleteById(int id);


}
