package by.academy.domain.hibernate;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Credentials.class)
public abstract class Credentials_ {

	public static volatile SingularAttribute<Credentials, String> password;
	public static volatile SingularAttribute<Credentials, String> login;

	public static final String PASSWORD = "password";
	public static final String LOGIN = "login";

}

