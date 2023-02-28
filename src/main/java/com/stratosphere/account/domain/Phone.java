package com.stratosphere.account.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
public class Phone implements Serializable {
    @Id
    private String id;
    private long number;
    private int cityCode;
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;

    public Phone(){}

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"" +
                ", \"number\":" + number +
                ", \"cityCode\":" + cityCode +
                ", \"countryCode\":'" + countryCode + "\"" +
                ", \"account\":" + account +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    public int getCityCode() {
        return cityCode;
    }

    public void setCityCode(int cityCode) {
        this.cityCode = cityCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
