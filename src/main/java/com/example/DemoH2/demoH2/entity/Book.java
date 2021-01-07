package com.example.DemoH2.demoH2.entity;

import javax.persistence.*;

@Entity
@Table( name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "genre")
    private String genre;

    public Book() { }

    public Book(String name, String genre) {
        this.name = name;
        this.genre = genre;
    }

    public Book(int id, String name, String genre) {
        this.id = id;
        this.name = name;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public Boolean checkBook() { return id <=    0; }
}
