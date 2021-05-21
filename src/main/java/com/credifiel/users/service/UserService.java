package com.credifiel.users.service;

import com.credifiel.users.entity.User;
import org.springframework.data.domain.Page;

import java.util.List;


public interface UserService {

    public Page<User> getUsers(int page, int size, String order, boolean asc);
    public Long addUser(User user);
    public User getUserByUsername(String username);

}
