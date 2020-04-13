package com.mcbx.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Authors.class)
public abstract class Authors_ {

	public static volatile CollectionAttribute<Authors, Booksauthors> booksauthorsCollection;
	public static volatile SingularAttribute<Authors, String> firstname;
	public static volatile SingularAttribute<Authors, Integer> idauthors;
	public static volatile SingularAttribute<Authors, String> contactinformation;
	public static volatile SingularAttribute<Authors, String> lastname;

}

