package it.main.utils;

import java.sql.SQLException;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.ListJoin;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.SetJoin;

import org.hibernate.Session;

import it.main.model.Meta;
import it.main.model.Meta_;
import it.main.model.Astronauta;
import it.main.model.Astronauta_;
import it.main.model.CapoProgetto;
import it.main.model.CapoProgetto_;
import it.main.model.Mezzo;
import it.main.model.Mezzo_;
import it.main.model.Missione;
import it.main.model.Missione_;

//Singleton
public class UtilsDAONasa {
	
	protected static EntityManager em;
    protected static EntityManagerFactory emf;
    protected static EntityTransaction tx = null;
    private static UtilsDAONasa dao;
    
    // Attraverso l’EntityManagerFactory instanziamo un oggetto EntityManager e l’oggetto Transaction
   	private UtilsDAONasa(){
        emf = Persistence.createEntityManagerFactory("persistence");
        em = emf.createEntityManager();
        tx = em.getTransaction();
    }
    
    public static UtilsDAONasa getInstance()
	{
		if (emf == null) {
			dao = new UtilsDAONasa();
		}
		return dao;
	}

	public void newAstronauta(Astronauta astronauta) throws SQLException {
		tx.begin();
		em.merge(astronauta);
		tx.commit();
	}
	
	public void newCapoProgetto(CapoProgetto capoProgetto) throws SQLException {
		tx.begin();
		em.merge(capoProgetto);
		tx.commit();
	}
	
	public void newMezzo(Mezzo mezzo) throws SQLException {
		tx.begin();
		em.merge(mezzo);
		tx.commit();
	}
	
	public void newMissione(Missione missione) throws SQLException {
		tx.begin();
		//em.persist(missione);
		em.merge(missione);
		tx.commit();
	}

	public List<Astronauta> getAstronauti() {
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Astronauta> cq = cb.createQuery(Astronauta.class);
    	Root<Astronauta> astronauta = cq.from(Astronauta.class);
    	cq.select(astronauta);							  
    	TypedQuery<Astronauta> q = em.createQuery(cq);      
    	List<Astronauta> allAstronauti = q.getResultList();
    	return allAstronauti;
	}

	public List<CapoProgetto> getCapiProgetto() {
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<CapoProgetto> cq = cb.createQuery(CapoProgetto.class);
    	Root<CapoProgetto> capoProgetto = cq.from(CapoProgetto.class);
    	cq.select(capoProgetto);							  
    	TypedQuery<CapoProgetto> q = em.createQuery(cq);      
    	List<CapoProgetto> allCapiProgetto = q.getResultList();
    	return allCapiProgetto;
	}
	
	public List<Mezzo> getMezzi() {
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Mezzo> cq = cb.createQuery(Mezzo.class);
    	Root<Mezzo> mezzo = cq.from(Mezzo.class);
    	cq.select(mezzo);							  
    	TypedQuery<Mezzo> q = em.createQuery(cq);      
    	List<Mezzo> allMezzi = q.getResultList();
    	return allMezzi;
	}
	
	public List<Meta> getMete() {
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Meta> cq = cb.createQuery(Meta.class);
    	Root<Meta> meta = cq.from(Meta.class);
    	cq.select(meta);							  
    	TypedQuery<Meta> q = em.createQuery(cq);      
    	List<Meta> allMete = q.getResultList();
    	return allMete;
	}

	public List<Missione> getMissioni() {
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	cq.select(missione);							  
    	TypedQuery<Missione> q = em.createQuery(cq);      
    	List<Missione> allMissioni = q.getResultList();
    	return allMissioni;
	}
	
	public List<Missione> getMissioniWhereMetaEqualsToGivenMetaAndCapo(String idMeta, String idCapoProgetto){
		Meta meta = em.find(Meta.class, Integer.parseInt(idMeta));
		CapoProgetto capoProgetto = em.find(CapoProgetto.class, Integer.parseInt(idCapoProgetto));
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	Predicate p1 = cb.equal(missione.get("meta"), meta);
    	Predicate p2 = cb.equal(missione.get("capoProgetto"), capoProgetto);
    	Predicate p3 = cb.and(p1, p2);
    	cq.select(missione).where(p3);						  
    	TypedQuery<Missione> q = em.createQuery(cq);      
    	List<Missione> missioni = q.getResultList();
    	return missioni;
	}
	
	public List<Missione> getMissioniJoinAstronauti(String cognomeAstronauta){
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	SetJoin<Missione, Astronauta> missioni_astronauti = missione.join(Missione_.astronauti);
    	Predicate predicate = cb.equal(missioni_astronauti.get(Astronauta_.cognome), cognomeAstronauta);
    	cq.where(predicate);
    	return em.createQuery(cq).getResultList();
    	/*System.out.println(missioni_astronauti.<String>get(Astronauta_.nome));
    	TypedQuery<Missione> q = em.createQuery(cq);      
    	List<Missione> missioni = q.getResultList();
    	return missioni;*/
	}
	
	public List<Missione> getMissioniJoinMete(String nomeMeta){
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	Join<Missione, Meta> missioni_mete = missione.join(Missione_.meta);
    	Predicate predicate = cb.equal(missioni_mete.get(Meta_.nome), nomeMeta);
    	cq.where(predicate);
    	return em.createQuery(cq).getResultList();
    	/*System.out.println(missioni_astronauti.<String>get(Astronauta_.nome));
    	TypedQuery<Missione> q = em.createQuery(cq);      
    	List<Missione> missioni = q.getResultList();
    	return missioni;*/
	}
	
	public List<Missione> getMissioniJoinMezzi(String nomeMezzo){
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	Join<Missione, Mezzo> missioni_mezzi = missione.join(Missione_.mezzo);
    	Predicate predicate = cb.equal(missioni_mezzi.get(Mezzo_.nome), nomeMezzo);
    	cq.where(predicate);
    	return em.createQuery(cq).getResultList();
	}
	
	public Astronauta findAstronauta(int id) {
		Astronauta astronauta = em.find(Astronauta.class, id);
    	return astronauta;
	}

	public Meta findMeta(int id) {
		Meta meta = em.find(Meta.class, id);
    	return meta;
	}

	public CapoProgetto findCapoProgetto(int id) {
		CapoProgetto capoProgetto = em.find(CapoProgetto.class, id);
    	return capoProgetto;
	}

	public Mezzo findMezzo(int id) {
		Mezzo mezzo = em.find(Mezzo.class, id);
    	return mezzo;
	}

	public Missione findMissione(int id) {
		Missione missione = em.find(Missione.class, id);
		return missione;
	}

	public void updateMissione(Missione newMissione) {
		tx.begin();
		System.out.println(newMissione.getNome());
		Missione missione = em.find(Missione.class, newMissione.getId());
		missione.setNome(newMissione.getNome());
		missione.setDescrizione(newMissione.getDescrizione());
		missione.setAstronauti(newMissione.getAstronauti());
		missione.setCapoProgetto(newMissione.getCapoProgetto());
		missione.setMezzo(newMissione.getMezzo());
		missione.setMeta(newMissione.getMeta());
		//em.merge(missione);
		tx.commit();
	}
	
	public void deleteMissione(Missione missione) {
		tx.begin();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaDelete<Missione> delete = cb.createCriteriaDelete(Missione.class);
        Root e = delete.from(Missione.class);
        delete.where(cb.equal(e.get("id"), missione.getId()));
        em.createQuery(delete).executeUpdate();
        tx.commit();
    }
	
	public void updateAstronauta(Astronauta astronautaToUpdate) {
		tx.begin();
		Astronauta astronauta = em.find(Astronauta.class, astronautaToUpdate.getId());
		astronauta.setNome(astronautaToUpdate.getNome());
		astronauta.setCognome(astronautaToUpdate.getCognome());
		astronauta.setMissioni(astronautaToUpdate.getMissioni());
		tx.commit();
	}

	public void deleteAstronauta(Astronauta astronautaToDelete) {
		tx.begin();
       	Astronauta astronauta = em.find(Astronauta.class, astronautaToDelete.getId());
       	em.remove(astronauta);
        tx.commit();
	}

	public void updateCapoProgetto(CapoProgetto capoProgettoToUpdate) {
		tx.begin();
		CapoProgetto capoProgetto = em.find(CapoProgetto.class, capoProgettoToUpdate.getId());
		capoProgetto.setNome(capoProgettoToUpdate.getNome());
		capoProgetto.setCognome(capoProgettoToUpdate.getCognome());
		capoProgetto.setMissioni(capoProgettoToUpdate.getMissioni());
		tx.commit();	
	}
	
	public void deleteCapoProgetto(CapoProgetto capoProgettoToDelete) {
		tx.begin();
       	CapoProgetto capoProgetto = em.find(CapoProgetto.class, capoProgettoToDelete.getId());
       	em.remove(capoProgetto);
        tx.commit();
	}

	public void newMeta(Meta meta) throws SQLException {
		tx.begin();
		em.merge(meta);
		tx.commit();
	}
	
	public void updateMeta(Meta metaToUpdate) {
		tx.begin();
		Meta meta = em.find(Meta.class, metaToUpdate.getId());
		meta.setNome(metaToUpdate.getNome());
		meta.setDescrizione(metaToUpdate.getDescrizione());
		meta.setMissioni(metaToUpdate.getMissioni());
		tx.commit();	
	}

	public void deleteMeta(Meta metaToDelete) {
		tx.begin();
       	Meta meta = em.find(Meta.class, metaToDelete.getId());
       	em.remove(meta);
        tx.commit();
	}
	
	public void updateMezzo(Mezzo mezzoToUpdate) {
		tx.begin();
		Mezzo mezzo = em.find(Mezzo.class, mezzoToUpdate.getId());
		mezzo.setNome(mezzoToUpdate.getNome());
		mezzo.setDescrizione(mezzoToUpdate.getDescrizione());
		mezzo.setMissioni(mezzoToUpdate.getMissioni());
		tx.commit();	
	}

	public void deleteMezzo(Mezzo mezzoToDelete) {
		tx.begin();
       	Mezzo mezzo = em.find(Mezzo.class, mezzoToDelete.getId());
       	em.remove(mezzo);
        tx.commit();
	}

	public List<Missione> getMissioniFilterBy(String nomeMissione, String nomeMezzo, String nomeMeta, String cognomeAstronauta, String cognomeCapoProgetto) {;
		CriteriaBuilder cb = em.getCriteriaBuilder(); 
    	CriteriaQuery<Missione> cq = cb.createQuery(Missione.class);
    	Root<Missione> missione = cq.from(Missione.class);
    	SetJoin<Missione, Astronauta> missioni_astronauti = missione.join(Missione_.astronauti);
    	Join<Missione, Mezzo> missioni_mezzi = missione.join(Missione_.mezzo);
    	Join<Missione, Meta> missioni_mete = missione.join(Missione_.meta);
    	Join<Missione, CapoProgetto> missioni_capi_progetto = missione.join(Missione_.capoProgetto);
    	Predicate predicate = cb.and();
		if (!cognomeAstronauta.equals("")) {
	    	predicate = cb.like(missioni_astronauti.get(Astronauta_.cognome), cb.parameter(String.class, "cognomeAstronauta"));		
		}
		if (!nomeMezzo.equals("")) {
	    	predicate = cb.and(predicate, cb.like(missioni_mezzi.get(Mezzo_.nome), cb.parameter(String.class, "nomeMezzo")));
		}
		if (!nomeMeta.equals("")) {
	    	predicate = cb.and(predicate, cb.like(missioni_mete.get(Meta_.nome), cb.parameter(String.class, "nomeMeta")));
		}
		if (!cognomeCapoProgetto.equals("")) {
			predicate = cb.and(predicate, cb.like(missioni_capi_progetto.get(CapoProgetto_.cognome), cb.parameter(String.class, "cognomeCapoProgetto")));	
		}
		if (!nomeMissione.equals("")) {
			predicate = cb.and(predicate, cb.like(missione.get(Missione_.nome), cb.parameter(String.class, "nomeMissione")));	
		}
	    cq.where(predicate);
	    TypedQuery<Missione> typedQuery = em.createQuery(cq);
	    if (!cognomeAstronauta.equals("")) {
	    	typedQuery.setParameter("cognomeAstronauta", "%" + cognomeAstronauta + "%");
		}
		if (!nomeMezzo.equals("")) {
			typedQuery.setParameter("nomeMezzo", "%" + nomeMezzo + "%");
		}
		if (!nomeMeta.equals("")) {
			typedQuery.setParameter("nomeMeta", "%" + nomeMeta + "%");
		}
		if (!cognomeCapoProgetto.equals("")) {
			typedQuery.setParameter("cognomeCapoProgetto", "%" + cognomeCapoProgetto + "%");
		}
		if (!nomeMissione.equals("")) {
	    	typedQuery.setParameter("nomeMissione", "%" + nomeMissione + "%");
		}
		return typedQuery.getResultList();
	}

    
}
