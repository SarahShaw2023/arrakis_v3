package com.db.grad.javaapi.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "book_users")
@IdClass(BookUser.class)
public class BookUser implements Serializable {
    //TODO: How to handle foreign key?
    @Id
    @Column(nullable = false)
    private int book_id;
    @Id
    @Column(nullable = false)
    private int user_id;

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

//    //    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Book.class)
//    @ManyToOne(optional = false)
//    @JoinColumn(name="book_id", referencedColumnName = "id", nullable = false)
////    @OnDelete(action = OnDeleteAction.CASCADE)
//    private Book book;
//
//    //    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Book.class)
//    @ManyToOne(optional = false)
//    @JoinColumn(name="user_id", referencedColumnName = "id", nullable = false)
//    private User user;
//
//
//    public void setBook(Book b) {
//        book = b;
//    }
//    public Book getBook() {
//        return book;
//    }
//
//    public void getUser(User u) {
//        user = u;
//    }
//    public User getUser() {
//        return user;
//    }
}
