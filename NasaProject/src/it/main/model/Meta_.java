package it.main.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-25T10:24:21.334+0100")
@StaticMetamodel(Meta.class)
public class Meta_ {
	public static volatile SingularAttribute<Meta, Integer> id;
	public static volatile SingularAttribute<Meta, String> nome;
	public static volatile SingularAttribute<Meta, String> descrizione;
	public static volatile ListAttribute<Meta, Missione> missioni;
}
