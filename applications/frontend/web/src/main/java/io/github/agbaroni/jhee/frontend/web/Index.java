package io.github.agbaroni.jhee.frontend.web;

import io.github.agbaroni.jhee.backend.business.client.UserBuilder;

import java.io.Serializable;
import java.util.Properties;

import javax.annotation.PostConstruct;
// import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
// import javax.inject.Inject;
import javax.inject.Named;

// import javax.naming.Context;
import javax.naming.InitialContext;

@Named
@SessionScoped
public class Index implements Serializable {

    private static final long serialVersionUID = 12265166420150L;

    // @EJB(lookup = "ejb:jhee-backend-0.1.0-SNAPSHOT/io.github.agbaroni-jhee-backend-business-0.1.0-SNAPSHOT/UserBuilderImpl!io.github.agbaroni.jhee.backend.business.client.UserBuilder?stateful")
    private UserBuilder userBuilder;

    private String message;

    @PostConstruct
    public void init() {
	try {
	    userBuilder = (UserBuilder) new InitialContext().lookup("ejb:jhee-backend-0.1.0-SNAPSHOT/io.github.agbaroni-jhee-backend-business-0.1.0-SNAPSHOT/UserBuilderImpl!io.github.agbaroni.jhee.backend.business.client.UserBuilder?stateful");
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

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
	System.out.println(userBuilder.hashCode());

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
