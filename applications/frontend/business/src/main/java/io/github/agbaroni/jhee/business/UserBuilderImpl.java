package io.github.agbaroni.jhee.business;

import io.github.agbaroni.jhee.business.client.UserBuilder;
import io.github.agbaroni.jhee.persistence.User;

import java.io.Serializable;

import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote({ UserBuilder.class })
@Stateful
public class UserBuilderImpl implements UserBuilder {

    private static final long serialVersionUID = 77712325231814L;

    @PersistenceContext
    private EntityManager entityManager;

    private String firstName;
    private String lastName;
    private String userName;

    // @PrePassivate
    // public void clean() {
    // 	firstName = null;
    // 	lastName = null;
    // 	userName = null;
    // }

    @Override
    public String getFirstName() {
	return firstName;
    }

    @Override
    public String getLastName() {
	return lastName;
    }

    @Override
    public String getUserName() {
	return userName;
    }

    @Override
    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    @Override
    public void setUserName(String userName) {
	this.userName = userName;
    }

    @Override
    public void save() {
	var user = new User(userName);

	user.setFirstName(firstName);
	user.setLastName(lastName);

	entityManager.persist(user);
    }
}
