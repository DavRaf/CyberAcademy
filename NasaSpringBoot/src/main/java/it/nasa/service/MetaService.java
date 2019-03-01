package it.nasa.service;

import java.util.List;

import it.nasa.model.Meta;


public interface MetaService {
	
	public List<Meta> getAllMete();
	public void newMeta(Meta meta);
	public void updateMeta(int id, Meta metaDetails);
	public Meta findMetaById(int id);
	public void deleteById(int id);	

}
