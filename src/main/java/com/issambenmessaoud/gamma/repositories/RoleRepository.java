package com.issambenmessaoud.gamma.repositories;

import com.issambenmessaoud.gamma.models.ERole;
import com.issambenmessaoud.gamma.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    Optional<Role> findByName(ERole name);
}
