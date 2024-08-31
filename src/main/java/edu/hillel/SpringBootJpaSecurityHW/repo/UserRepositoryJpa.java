package edu.hillel.SpringBootJpaSecurityHW.repo;

import edu.hillel.SpringBootJpaSecurityHW.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJpa extends JpaRepository<User, Long> {
    Optional<User> findUserByName(String name);
}
