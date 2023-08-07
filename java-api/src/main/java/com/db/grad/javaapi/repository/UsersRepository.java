package com.db.grad.javaapi.repository;

import com.db.grad.javaapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends JpaRepository<User, Integer> {
    @Query(nativeQuery = true, value = "select * from users")
    List<User> getUsers();

    @Query(nativeQuery = true, value = "select * from users as u where u.username = :username")
    List<User> findUser(String username);
  
    @Query(nativeQuery = true, value = "SELECT * FROM users WHERE id = :id")
    List<User> getUserById(int id);

    @Query(nativeQuery = true, value = "SELECT * FROM users as u WHERE u.email = :email")
    List<User> findUserByEmail(String email);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE users SET password = :password WHERE id = :id")
    List<User> updateUserPwd(String password, int id);
}