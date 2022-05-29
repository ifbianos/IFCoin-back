package com.ifba.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Wallet {

    @Id
    private Long Id;
    private Double ifCoin;


}
