package com.ooad.group12.bedstore.repository;

import com.ooad.group12.bedstore.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

    Optional<User> findByIdAndActiveIsTrue(Long userId);

    Optional<User> findByEmailAndPassword(String email, String password);
    Optional<User> findByEmail(String email);

}
