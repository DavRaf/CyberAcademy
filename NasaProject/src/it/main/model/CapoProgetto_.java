package it.main.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2019-02-25T10:24:21.214+0100")
@StaticMetamodel(CapoProgetto.class)
public class CapoProgetto_ {
	public static volatile SingularAttribute<CapoProgetto, Integer> id;
	public static volatile SingularAttribute<CapoProgetto, String> nome;
	public static volatile SingularAttribute<CapoProgetto, String> cognome;
	public static volatile ListAttribute<CapoProgetto, Missione> missioni;
}
