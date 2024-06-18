package com.example.backendSocial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.backendSocial.Entity.FeedBack;
import com.example.backendSocial.Entity.User;
import com.example.backendSocial.services.UserService;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public User findUserBYJwt(@RequestHeader("Authorization") String token) throws Exception {

        User user = userService.findUserByJwt(token);

        if (user == null) {
            throw new Exception("User not found or invalid token");
        } else {
            return user;
        }

    }

    @PutMapping("/user")
    public User updateUser(@RequestHeader("Authorization") String token, @RequestBody User updateuser)
            throws Exception {

        User user = userService.findUserByJwt(token);

        if (user == null) {
            throw new Exception("User not found or invalid token");
        } else {
            return userService.updateUser(user, updateuser);
        }

    }

    @PostMapping("/user/feedback")
    public FeedBack createFeedBack(@RequestHeader("Authorization") String token, @RequestBody FeedBack feedBack)
            throws Exception {

        User user = userService.findUserByJwt(token);

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("user --> " + user);
        System.out.println();
        System.out.println();
        System.out.println();
        if (user == null) {
            throw new Exception("User not found or invalid token");
        } else {
            return userService.createFeedBack(user, feedBack);
        }

    }
}
