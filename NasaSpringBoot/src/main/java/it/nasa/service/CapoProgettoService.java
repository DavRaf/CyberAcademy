package it.nasa.service;

import java.util.List;

import it.nasa.model.CapoProgetto;


public interface CapoProgettoService {
	
	public List<CapoProgetto> getAllCapiProgetto();
	public void newCapoProgetto(CapoProgetto capoProgetto);
	public void updateCapoProgetto(int id, CapoProgetto capoProgettoDetails);
	public CapoProgetto findCapoProgettoById(int id);
	public void deleteAll();	
	public void deleteById(int id);	
	public void delete(CapoProgetto capoProgetto);	
	public boolean existsById(int id);

}
