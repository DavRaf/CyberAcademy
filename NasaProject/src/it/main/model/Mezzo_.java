package it.main.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-25T10:24:21.344+0100")
@StaticMetamodel(Mezzo.class)
public class Mezzo_ {
	public static volatile SingularAttribute<Mezzo, Integer> id;
	public static volatile SingularAttribute<Mezzo, String> nome;
	public static volatile SingularAttribute<Mezzo, String> descrizione;
	public static volatile ListAttribute<Mezzo, Missione> missioni;
}
