package com.meghashyam.banksearch.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "branches")
public class Banksearch {

    @Id
    @Column(name = "ifsc", length = 11, unique = true, nullable = false)
    private String ifsc;

    @Column(name = "bank_id")
    private int bank_id;

    @Column(name = "branch", length = 74)
    private String branch;

    @Column(name = "address", length = 195)
    private String address;

    @Column(name = "city", length = 50)
    private String city;

    @Column(name = "district", length = 50)
    private String district;

    @Column(name = "state", length = 26)
    private String state;


    public String getIfsc() {

        return ifsc;
    }


    public int getBankId() {

        return bank_id;
    }


    public String getBranch() {

        return branch;
    }


    public String getAddress() {

        return address;
    }


    public String getCity() {

        return city;
    }


    public String getDistrict() {

        return district;
    }


    public String getState() {

        return state;
    }
}
