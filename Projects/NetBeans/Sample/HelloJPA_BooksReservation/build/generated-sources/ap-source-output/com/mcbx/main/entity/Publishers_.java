package com.mcbx.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Publishers.class)
public abstract class Publishers_ {

	public static volatile SingularAttribute<Publishers, Integer> idpublishers;
	public static volatile SingularAttribute<Publishers, String> city;
	public static volatile SingularAttribute<Publishers, String> name;
	public static volatile SingularAttribute<Publishers, String> contactinformation;
	public static volatile CollectionAttribute<Publishers, Bookspublishers> bookspublishersCollection;

}

