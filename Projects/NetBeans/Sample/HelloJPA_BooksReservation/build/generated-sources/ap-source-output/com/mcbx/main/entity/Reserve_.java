package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Reserve.class)
public abstract class Reserve_ {

	public static volatile SingularAttribute<Reserve, Integer> copies;
	public static volatile SingularAttribute<Reserve, String> notes;
	public static volatile SingularAttribute<Reserve, Books> books;
	public static volatile SingularAttribute<Reserve, ReservePK> reservePK;
	public static volatile SingularAttribute<Reserve, Date> reserveddate;
	public static volatile SingularAttribute<Reserve, Members> members;
	public static volatile SingularAttribute<Reserve, Date> reservedlimitdate;
	public static volatile SingularAttribute<Reserve, String> status;

}

