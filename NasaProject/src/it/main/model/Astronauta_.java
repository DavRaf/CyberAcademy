package it.main.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-25T10:30:27.097+0100")
@StaticMetamodel(Astronauta.class)
public class Astronauta_ {
	public static volatile SingularAttribute<Astronauta, Integer> id;
	public static volatile SingularAttribute<Astronauta, String> nome;
	public static volatile SingularAttribute<Astronauta, String> cognome;
	public static volatile SetAttribute<Astronauta, Missione> missioni;
}
