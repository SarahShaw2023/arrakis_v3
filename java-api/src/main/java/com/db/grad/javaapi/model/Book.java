package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "books")
public class Book {
    @Id
    private int id;
    private String name;

//    @OneToMany(mappedBy = "Book", targetEntity = BookUser.class, fetch = FetchType.EAGER)
//    private Set<BookUser> bookUserSet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
