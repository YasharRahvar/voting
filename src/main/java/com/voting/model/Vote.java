package com.voting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int voteId;

    @ManyToOne
    private PlayPackage playPackage;

    @ManyToOne
    private Person person;


}
