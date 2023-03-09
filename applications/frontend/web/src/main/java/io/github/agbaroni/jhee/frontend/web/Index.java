package io.github.agbaroni.jhee.frontend.web;

import io.github.agbaroni.jhee.backend.business.client.UserBuilder;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import javax.naming.InitialContext;

@Named
@SessionScoped
public class Index implements Serializable {

    private static final long serialVersionUID = 12265166420150L;

    @Inject
    private UserBuilder userBuilder;

    private String message;

    public Object add() {
	setFirstName(null);
	setLastName(null);
	setUserName(null);

	message = null;

	return null;
    }

    public Object confirmFirstName() {
	return null;
    }

    public Object confirmLastName() {
	userBuilder.save();

	message = "OK";

	return null;
    }

    public Object confirmUserName() {
	return null;
    }

    public String getFirstName() {
	return userBuilder.getFirstName();
    }

    public String getLastName() {
	return userBuilder.getLastName();
    }

    public String getUserName() {
	return userBuilder.getUserName();
    }

    public String getMessage() {
	return message;
    }

    public boolean isFirstNameEnabled() {
	return getUserName() != null;
    }

    public boolean isLastNameEnabled() {
	return getFirstName() != null;
    }

    public void setFirstName(String firstName) {
	userBuilder.setFirstName(firstName);
    }

    public void setLastName(String lastName) {
	userBuilder.setLastName(lastName);
    }

    public void setUserName(String userName) {
	userBuilder.setUserName(userName);
    }
}
