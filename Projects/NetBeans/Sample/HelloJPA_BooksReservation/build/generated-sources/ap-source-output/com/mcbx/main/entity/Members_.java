package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Members.class)
public abstract class Members_ {

	public static volatile SingularAttribute<Members, Date> dateofbirth;
	public static volatile SingularAttribute<Members, String> firstname;
	public static volatile SingularAttribute<Members, String> phonenumber2;
	public static volatile SingularAttribute<Members, String> phonenumber1;
	public static volatile SingularAttribute<Members, String> gender;
	public static volatile SingularAttribute<Members, String> address2;
	public static volatile CollectionAttribute<Members, Reserve> reserveCollection;
	public static volatile SingularAttribute<Members, String> address1;
	public static volatile SingularAttribute<Members, String> idnumber;
	public static volatile CollectionAttribute<Members, Borrow> borrowCollection;
	public static volatile SingularAttribute<Members, Membersimage> membersimage;
	public static volatile SingularAttribute<Members, String> emailaddress;
	public static volatile SingularAttribute<Members, String> membertype;
	public static volatile SingularAttribute<Members, Integer> idmembers;
	public static volatile SingularAttribute<Members, Character> middleinitial;
	public static volatile SingularAttribute<Members, String> lastname;
	public static volatile SingularAttribute<Members, Date> registereddate;
	public static volatile SingularAttribute<Members, String> password;
	public static volatile SingularAttribute<Members, Boolean> isblocked;
	public static volatile SingularAttribute<Members, String> username;

}

