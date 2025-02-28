package com.silo.monitoring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.silo.monitoring.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

