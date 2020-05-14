package com.example.userservicejpa.repository;

import com.example.userservicejpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);

    @Query(value = "SELECT user_name FROM user", nativeQuery = true)
    Iterable<String> findAllUsernames();
}
