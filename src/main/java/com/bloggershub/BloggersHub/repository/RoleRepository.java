package com.bloggershub.BloggersHub.repository;


import com.bloggershub.BloggersHub.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface RoleRepository extends JpaRepository<Role, Long>{
    Role findByName(String name);
}
