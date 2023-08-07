package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.BookUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookUsersRepository extends JpaRepository<BookUser, Integer> {
    @Query(nativeQuery = true, value = "select * from book_users")
    List<BookUser> getBookUsers();

    @Query(nativeQuery = true, value = "select book_id from book_users as bu where bu.user_id = :userID")
    List<Integer> getBookIDsByUserID(int userID);
}
