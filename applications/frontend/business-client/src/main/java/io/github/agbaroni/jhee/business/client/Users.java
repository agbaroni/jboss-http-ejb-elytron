package io.github.agbaroni.jhee.business.client;

import io.github.agbaroni.jhee.persistence.User;

import java.io.Serializable;
import java.util.List;

public interface Users extends Serializable {

    public List<User> findAll();

    public void createUser(User user);
}
