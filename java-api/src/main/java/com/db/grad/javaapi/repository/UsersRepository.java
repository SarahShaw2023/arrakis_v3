package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.Book;
import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, String> {
    @Query(nativeQuery = true, value = "select * from users")
    List<User> getUsers();
    @Query(nativeQuery = true, value = "select * from users where email = :email")
    List<User> getUserByEmail(String email);
    @Query(nativeQuery = true, value = "select * from users where name = :name")
    List<User> getUserByUserName(String name);


}
