package com.mcbx.main.entity;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subjects.class)
public abstract class Subjects_ {

	public static volatile SingularAttribute<Subjects, String> name;
	public static volatile SingularAttribute<Subjects, Integer> idsubjects;
	public static volatile CollectionAttribute<Subjects, Bookssubjects> bookssubjectsCollection;

}

