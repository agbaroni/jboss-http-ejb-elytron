package io.github.agbaroni.jhee.persistence;

import java.io.Serializable;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbTransient;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

@Entity
@NamedQueries({
	@NamedQuery(name = User.SELECT_ALL, query = "SELECT u FROM User u")
    })
@Table(indexes = {
	@Index(columnList = "USER_NAME"),
	@Index(columnList = "FIRST_NAME,LAST_NAME")
    },
    name = "USERS",
    uniqueConstraints = {
	@UniqueConstraint(columnNames = { "FIRST_NAME", "LAST_NAME" })
    })
public class User implements Serializable {

    private static final long serialVersionUID = 30646253642198L;

    public static final String SELECT_ALL = "User.selectAll";

    @Column(name = "USER_NAME")
    @Id
    private String userName;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @Column(name = "AGE")
    @JsonbProperty(nillable = true)
    private Integer age;

    @Column(name = "VERSION")
    @JsonbTransient
    @Version
    private Integer version = 0;

    public User() {
    }

    public User(String userName) {
	this.userName = userName;
    }

    public String getUserName() {
	return userName;
    }

    public String getFirstName() {
	return firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public Integer getAge() {
	return age;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public void setAge(int age) {
	this.age = age;
    }

    public void setUserName(String userName) {
	this.userName = userName;
    }
}
