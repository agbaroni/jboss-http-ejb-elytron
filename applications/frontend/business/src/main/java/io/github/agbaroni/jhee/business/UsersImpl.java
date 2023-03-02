package io.github.agbaroni.jhee.business;

import io.github.agbaroni.jhee.business.client.Users;
import io.github.agbaroni.jhee.persistence.User;

import java.io.Serializable;
import java.util.List;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Remote({ Users.class })
@Stateless
public class UsersImpl implements Users {

    private static final long serialVersionUID = 77712325231814L;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findAll() {
	var query = entityManager.createNamedQuery(User.SELECT_ALL, User.class);

	return query.getResultList();
    }

    @Override
    public void createUser(User user) {
	entityManager.persist(user);
    }
}
