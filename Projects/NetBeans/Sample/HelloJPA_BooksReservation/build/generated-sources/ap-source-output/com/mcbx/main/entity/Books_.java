package com.mcbx.main.entity;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Books.class)
public abstract class Books_ {

	public static volatile SingularAttribute<Books, Date> acquireddate;
	public static volatile CollectionAttribute<Books, Logsborrowedbooks> logsborrowedbooksCollection;
	public static volatile SingularAttribute<Books, Integer> idbooks;
	public static volatile SingularAttribute<Books, Double> cost;
	public static volatile CollectionAttribute<Books, Reserve> reserveCollection;
	public static volatile SingularAttribute<Books, Double> purchasedcost;
	public static volatile SingularAttribute<Books, String> isbn;
	public static volatile CollectionAttribute<Books, Borrow> borrowCollection;
	public static volatile SingularAttribute<Books, String> description;
	public static volatile SingularAttribute<Books, String> language;
	public static volatile SingularAttribute<Books, Boolean> isborrowable;
	public static volatile CollectionAttribute<Books, Bookssubjects> bookssubjectsCollection;
	public static volatile SingularAttribute<Books, String> title;
	public static volatile SingularAttribute<Books, Category> categoryName;
	public static volatile SingularAttribute<Books, Booksimage> booksimage;
	public static volatile CollectionAttribute<Books, Booksauthors> booksauthorsCollection;
	public static volatile SingularAttribute<Books, Integer> pages;
	public static volatile CollectionAttribute<Books, Bookspublishers> bookspublishersCollection;
	public static volatile SingularAttribute<Books, String> barcode;
	public static volatile SingularAttribute<Books, Integer> copynumber;

}

