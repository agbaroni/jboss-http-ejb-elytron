package io.github.agbaroni.jhee.business.client;

import java.io.Serializable;

public interface UserBuilder extends Serializable {

    String getFirstName();

    String getLastName();

    String getUserName();

    void save();

    void setFirstName(String firstName);

    void setLastName(String lastName);

    void setUserName(String userName);
}
