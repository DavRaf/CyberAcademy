package it.main.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-25T10:24:21.353+0100")
@StaticMetamodel(Missione.class)
public class Missione_ {
	public static volatile SingularAttribute<Missione, Integer> id;
	public static volatile SingularAttribute<Missione, String> nome;
	public static volatile SingularAttribute<Missione, String> descrizione;
	public static volatile SingularAttribute<Missione, CapoProgetto> capoProgetto;
	public static volatile SingularAttribute<Missione, Meta> meta;
	public static volatile SingularAttribute<Missione, Mezzo> mezzo;
	public static volatile SetAttribute<Missione, Astronauta> astronauti;
}
