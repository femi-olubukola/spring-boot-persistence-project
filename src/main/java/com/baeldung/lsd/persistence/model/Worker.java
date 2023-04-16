package com.baeldung.lsd.persistence.model;

import jakarta.persistence.*;


@Entity
@Table
public class Worker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, updatable = false)
    private String email;
    private String firstName;
    private String lastName;

    public Worker() {}
}
