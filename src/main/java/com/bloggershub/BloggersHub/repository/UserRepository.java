package com.bloggershub.BloggersHub.repository;

import com.bloggershub.BloggersHub.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);

    User findByEmail(String email);

    List<User> findByLastNameIgnoreCase(String lastname);

    List<User> findByFirstNameIgnoreCase(String firstname);
}
