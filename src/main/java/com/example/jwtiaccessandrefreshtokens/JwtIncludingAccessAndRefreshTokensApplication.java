package com.example.jwtiaccessandrefreshtokens;

import com.example.jwtiaccessandrefreshtokens.domain.Role;
import com.example.jwtiaccessandrefreshtokens.domain.User;
import com.example.jwtiaccessandrefreshtokens.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class JwtIncludingAccessAndRefreshTokensApplication {

    public static void main(String[] args) {
        SpringApplication.run(JwtIncludingAccessAndRefreshTokensApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner run (UserService userService) {
        return args -> {
            userService.saveRole(new Role(null, "ROLE_USER"));
            userService.saveRole(new Role(null, "ROLE_Manager"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));
            userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

            userService.saveUser(new User(null, "Jhon travolta", "john", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Will Smith", "will", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Jim Carry", "jim", "1234", new ArrayList<>()));
            userService.saveUser(new User(null, "Arlak Abdulloh", "arlak", "1234", new ArrayList<>()));

            userService.addRoleToUser("john", "ROLE_User");
            userService.addRoleToUser("john", "ROLE_Manager");
            userService.addRoleToUser("will", "ROLE_Manager");
            userService.addRoleToUser("jim", "ROLE_ADMIN");
            userService.addRoleToUser("arlak", "ROLE_SUPER_ADMIN");
            userService.addRoleToUser("arlak", "ROLE_ADMIN");
            userService.addRoleToUser("arlak", "ROLE_User");
        };
    }

}
