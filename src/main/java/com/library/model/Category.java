package com.library.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Category(String fiction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public Category(String fiction) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}