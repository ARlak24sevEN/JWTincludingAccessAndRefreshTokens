package com.example.jwtiaccessandrefreshtokens.repo;

import com.example.jwtiaccessandrefreshtokens.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role,Long> {
    Role findByName(String name);
}
