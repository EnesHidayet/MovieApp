package org.enes.repository;

import org.enes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.TreeMap;
import java.util.TreeSet;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByEmailAndPassword(String email, String password);

    Optional<User> findByEmailAndPassword(String email, String password);

    List<User>findAllByOrderByName();

    boolean existsByNameContainingIgnoreCase(String name);

    List<User> findAllByNameContainingIgnoreCase(String name);

    Optional<User> findByEmailIgnoreCase(String email);

    boolean existsByEmailContainingIgnoreCase(String email);
}
