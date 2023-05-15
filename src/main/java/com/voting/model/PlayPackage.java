package com.voting.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class PlayPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int PlayPackageId;

    @Column
    private Strategy strategy;

}
