package io.github.agbaroni.jhee.frontend.web;

import io.github.agbaroni.jhee.backend.business.client.UserBuilder;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class RemoteProducer implements Serializable {

    private static final Logger logger = LoggerFactory.getLogger(RemoteProducer.class);
    private static final long serialVersionUID = 12930164319534L;

    @Produces
    public UserBuilder getUserBuilder() throws NamingException {
	logger.info("Looking up the remote EJB ...");

	return (UserBuilder) new InitialContext().lookup("ejb:jhee-backend-0.1.0-SNAPSHOT/io.github.agbaroni-jhee-backend-business-0.1.0-SNAPSHOT/UserBuilderImpl!io.github.agbaroni.jhee.backend.business.client.UserBuilder?stateful");
    }
}
