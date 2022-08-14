package com.javainuse.springbootsecurity.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table
public class Address {
    //frgtgtgt
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User users;

    public Address() {
    }

    public Address(Long id, String city, String street, User user) {
        this.id = id;
        this.city = city;
        this.street = street;
        this.users = user;
    }

}
