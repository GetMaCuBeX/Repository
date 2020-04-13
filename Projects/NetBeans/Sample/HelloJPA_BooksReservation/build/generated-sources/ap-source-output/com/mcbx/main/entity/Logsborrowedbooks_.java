package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Logsborrowedbooks.class)
public abstract class Logsborrowedbooks_ {

	public static volatile SingularAttribute<Logsborrowedbooks, Date> borroweddate;
	public static volatile SingularAttribute<Logsborrowedbooks, Integer> idlogsborrowedbooks;
	public static volatile SingularAttribute<Logsborrowedbooks, Books> booksIdbooks;

}

