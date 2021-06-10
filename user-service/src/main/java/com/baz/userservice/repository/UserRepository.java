package com.baz.userservice.repository;

import com.baz.userservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByUserId(Long userId);
}
