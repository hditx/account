package com.stratosphere.account.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "account")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Log
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

}
