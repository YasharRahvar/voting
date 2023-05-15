package com.voting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column
    private String email;
}
