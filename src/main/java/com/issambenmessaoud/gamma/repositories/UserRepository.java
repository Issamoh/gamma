package com.issambenmessaoud.gamma.repositories;

import com.issambenmessaoud.gamma.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
        Optional<User> findByUsername(String UserName);
        Boolean existsByUsername(String UserName);
        Boolean existsByEmail(String Email);
        Boolean existsByTel(String Tel);
}
