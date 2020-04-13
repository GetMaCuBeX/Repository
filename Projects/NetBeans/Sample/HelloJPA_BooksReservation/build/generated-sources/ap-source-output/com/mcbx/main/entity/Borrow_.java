package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Borrow.class)
public abstract class Borrow_ {

	public static volatile SingularAttribute<Borrow, Integer> copies;
	public static volatile SingularAttribute<Borrow, String> notes;
	public static volatile SingularAttribute<Borrow, Books> books;
	public static volatile SingularAttribute<Borrow, Double> finedamount;
	public static volatile SingularAttribute<Borrow, Members> members;
	public static volatile SingularAttribute<Borrow, Date> borroweddate;
	public static volatile SingularAttribute<Borrow, BorrowPK> borrowPK;
	public static volatile SingularAttribute<Borrow, Date> borrowedduedate;
	public static volatile SingularAttribute<Borrow, Date> returneddate;
	public static volatile SingularAttribute<Borrow, String> remarks;
	public static volatile SingularAttribute<Borrow, Integer> returnedcopies;
	public static volatile SingularAttribute<Borrow, String> status;

}

