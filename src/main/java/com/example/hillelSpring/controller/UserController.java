package com.example.hillelSpring.controller;

import com.example.hillelSpring.model.User;
import com.example.hillelSpring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value ="/{id}", produces = "application/json")
    public User get(@PathVariable Integer id) {
        System.out.println(id);
        return userService.getUser();
    }

    @PostMapping (produces = "application/json")
    public User updateUser(@RequestBody User user) {
        System.out.println(user);
        return User.builder().name("I'm updated user").build();
    }

    @PutMapping (produces = "application/json")
    public User saveUser(@RequestBody User user) {
        System.out.println(user);
        return user;
    }

    @DeleteMapping (value ={"/{id}"})
    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteUser(@PathVariable Integer id) {
        if (id == 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not found");
        }
        System.out.println("Removing user with id = " + id);
    }

    @ExceptionHandler({NullPointerException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody String handleException() {
        System.out.println("Sorry, not working!");
        return " ";
    }
}
