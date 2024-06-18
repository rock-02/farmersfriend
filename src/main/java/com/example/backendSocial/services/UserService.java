package com.example.backendSocial.services;

import com.example.backendSocial.Entity.FeedBack;
import com.example.backendSocial.Entity.User;

public interface UserService {

    public User findUserByID(Long id) throws Exception;

    public User findUserByEmail(String email) throws Exception;

    public User findUserByJwt(String jwt) throws Exception;

    public User updateUser(User user, User updateuser) throws Exception;

    public FeedBack createFeedBack(User user, FeedBack feedBack) throws Exception;

}
