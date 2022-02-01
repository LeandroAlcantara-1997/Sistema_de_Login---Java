package com.github.leandroalcantara_1997.api_sistema_login.repository;

import java.util.Optional;

import com.github.leandroalcantara_1997.api_sistema_login.entity.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    public Optional<User> findByUser(String user);
}
