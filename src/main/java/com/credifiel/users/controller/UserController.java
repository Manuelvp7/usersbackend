package com.credifiel.users.controller;

import com.credifiel.users.entity.User;
import com.credifiel.users.service.UserService;
import com.credifiel.users.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping
    public ResponseEntity<Page<User>> getUsers(@RequestParam( required = false, value = "page", defaultValue = "0") int page,
                                               @RequestParam( required = false, value = "size", defaultValue = "10") int size,
                                               @RequestParam( required = false, value = "field", defaultValue = "firstname") String field,
                                               @RequestParam( required = false, value = "asc", defaultValue = "true") boolean asc

    ){
        return  new ResponseEntity<>(userService.getUsers(page, size, field, asc), HttpStatus.OK);
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<User> getByUsername(@PathVariable("username") String username){
        return new ResponseEntity<>(userService.getUserByUsername(username), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Long> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED) ;
    }

}
