package com.example.jwtiaccessandrefreshtokens.repo;

import com.example.jwtiaccessandrefreshtokens.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
