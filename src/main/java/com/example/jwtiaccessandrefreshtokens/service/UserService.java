package com.example.jwtiaccessandrefreshtokens.service;

import com.example.jwtiaccessandrefreshtokens.domain.Role;
import com.example.jwtiaccessandrefreshtokens.domain.User;

import java.util.List;

public interface UserService {

    User saveUser(User user);
    Role saveRole(Role role);
    void addRoleToUser(String username,String roleName);
    User getUser(String username);
    List<User> getUsers();
}
