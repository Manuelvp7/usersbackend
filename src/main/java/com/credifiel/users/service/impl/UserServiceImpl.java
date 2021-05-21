package com.credifiel.users.service.impl;

import com.credifiel.users.data.UserRepository;
import com.credifiel.users.entity.User;
import com.credifiel.users.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class UserServiceImpl implements UserService {

    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    UserRepository userRepository;

    @Override
    public Page<User> getUsers(int page, int size, String order, boolean asc) {
        if(asc)
            return userRepository.findAll(PageRequest.of(page, size, Sort.by(order)));
        else
            return userRepository.findAll(PageRequest.of(page, size, Sort.by(order).descending()));
    }

    @Override
    public Long addUser(User user){
        logger.info(user.toString());
        return this.userRepository.save(user).getUserid();
    }

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %d not found", username))
        );
    }

}
