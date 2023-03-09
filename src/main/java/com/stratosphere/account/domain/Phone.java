package com.stratosphere.account.domain;

import lombok.*;
import lombok.extern.java.Log;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "phone")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Log
@Builder(access = AccessLevel.PUBLIC)
public class Phone implements Serializable {
    @Id
    private String id;
    private long number;
    private int cityCode;
    private String countryCode;

    @ManyToOne
    @JoinColumn(name = "account_id", nullable = false)
    private Account account;


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
}
