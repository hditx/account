package com.stratosphere.account.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
public class Account implements Serializable {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    private String email;

    private String password;

    private Date lastLogin;

    private Date created;

    private boolean isActive;

    @OneToMany(mappedBy = "account")
    private Set<Phone> phones;

    public Account() {
    }

    public Account(String id, String name, String email, String password, Set phones) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.phones = phones;
        this.lastLogin = null;
        this.created = new Date();
        this.isActive = true;
    }

    @Override
    public String toString() {
        return "{" +
                " \"id\":\"" + id + "\"" +
                ", \"name\":'" + name + "\"" +
                ", \"email\":'" + email + "\"" +
                ", \"password\":\"" + password + "\"" +
                ", \"phones\":" + phones +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Set<Phone> getPhones() {
        return phones;
    }

    public void setPhones(Set<Phone> phones) {
        this.phones = phones;
    }
}
