package io.github.agbaroni.jhee.backend.business;

import io.github.agbaroni.jhee.backend.business.client.UserBuilder;
import io.github.agbaroni.jhee.persistence.User;

import java.io.Serializable;

import javax.ejb.PrePassivate;
import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Remote({ UserBuilder.class })
@Stateful
public class UserBuilderImpl implements UserBuilder {

    private static final Logger logger = LoggerFactory.getLogger(UserBuilderImpl.class);
    private static final long serialVersionUID = 27658224355538L;

    @PersistenceContext
    private EntityManager entityManager;

    private String firstName;
    private String lastName;
    private String userName;

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
	logger.info("Saving firstName = " + firstName);

	this.firstName = firstName;
    }

    @Override
    public void setLastName(String lastName) {
	logger.info("Saving lastName = " + lastName);

	this.lastName = lastName;
    }

    @Override
    public void setUserName(String userName) {
	logger.info("Saving userName = " + userName);

	this.userName = userName;
    }

    @Override
    public void save() {
	var user = new User(userName);

	user.setFirstName(firstName);
	user.setLastName(lastName);

	entityManager.persist(user);

	logger.info("Persisted new user");
    }
}
