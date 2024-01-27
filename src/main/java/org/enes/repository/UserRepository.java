package org.enes.repository;

import org.enes.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

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

    @Query(value = "SELECT * FROM tbl_user WHERE LENGTH(password) > :passwordLength", nativeQuery = true)
    List<User> findByPasswordLengthGreaterThan(@Param("passwordLength") int passwordLength);

    List<User> findByEmailEndingWith(String email);
}
