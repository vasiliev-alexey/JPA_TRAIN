package com.av.domain;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Emp.class)
public abstract class Emp_ {

	public static volatile SingularAttribute<Emp, Long> id;
	public static volatile SingularAttribute<Emp, String> name;
	public static volatile SingularAttribute<Emp, Float> salary;
	public static volatile SingularAttribute<Emp, Date> sDate;

}

