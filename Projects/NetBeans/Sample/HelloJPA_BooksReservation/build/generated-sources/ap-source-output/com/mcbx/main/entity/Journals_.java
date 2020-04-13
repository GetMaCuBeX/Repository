package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Journals.class)
public abstract class Journals_ {

	public static volatile SingularAttribute<Journals, Date> acquireddate;
	public static volatile SingularAttribute<Journals, Double> cost;
	public static volatile SingularAttribute<Journals, Double> purchasedcost;
	public static volatile SingularAttribute<Journals, String> description;
	public static volatile SingularAttribute<Journals, Integer> idjournals;
	public static volatile SingularAttribute<Journals, String> title;
	public static volatile SingularAttribute<Journals, String> barcode;
	public static volatile SingularAttribute<Journals, Category> categoryName;
	public static volatile SingularAttribute<Journals, Integer> copynumber;

}

