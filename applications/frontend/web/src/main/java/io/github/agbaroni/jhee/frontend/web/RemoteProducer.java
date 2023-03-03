package io.github.agbaroni.jhee.frontend.web;

import io.github.agbaroni.jhee.backend.business.client.UserBuilder;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;

// @ApplicationScoped
public class RemoteProducer implements Serializable {

    private static final long serialVersionUID = 12930164319534L;

    // @Produces
    // @SessionScoped
    public UserBuilder getUserBuilder() throws NamingException {
	return (UserBuilder) new InitialContext().lookup("ejb:jhee-backend-0.1.0-SNAPSHOT/io.github.agbaroni-jhee-backend-business-0.1.0-SNAPSHOT/UserBuilderImpl!io.github.agbaroni.jhee.backend.business.client.UserBuilder?stateful");
    }
}
