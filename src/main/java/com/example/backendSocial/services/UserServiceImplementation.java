package com.example.backendSocial.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.backendSocial.Entity.FeedBack;
import com.example.backendSocial.Entity.User;
import com.example.backendSocial.config.jwtProvider;
import com.example.backendSocial.repositories.FeedbackRepository;
import com.example.backendSocial.repositories.UserRepository;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private FeedbackRepository feedBackRepository;

    @Override
    public User findUserByID(Long id) throws Exception {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()) {
            throw new Exception("User not found");
        }

        return user.get();

    }

    @Override
    public User findUserByEmail(String email) throws Exception {

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UnsupportedOperationException("User not found");
        }

        return user;

    }

    @Override
    public User findUserByJwt(String jwt) throws Exception {
        String email = jwtProvider.getEmailFromJwtToken(jwt);

        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UnsupportedOperationException("User not found");
        }

        return user;
    }

    @Override
    public User updateUser(User user, User updateuser) throws Exception {
        if (updateuser.getFirstName() != null && !updateuser.getFirstName().isEmpty()) {
            user.setFirstName(updateuser.getFirstName());
        }

        if (updateuser.getLastName() != null && !updateuser.getLastName().isEmpty()) {
            user.setLastName(updateuser.getLastName());
        }

        if (updateuser.getPhoneNumber() != null && !updateuser.getPhoneNumber().isEmpty()) {
            user.setPhoneNumber(updateuser.getPhoneNumber());
        }

        if (updateuser.getProfilePicture() != null && !updateuser.getProfilePicture().isEmpty()) {
            user.setProfilePicture(updateuser.getProfilePicture());
        }

        if (updateuser.getDistrict() != null && !updateuser.getDistrict().isEmpty()) {
            user.setDistrict(updateuser.getDistrict());
        }

        if (updateuser.getState() != null && !updateuser.getState().isEmpty()) {
            user.setState(updateuser.getState());
        }

        if (updateuser.getLocation() != null && !updateuser.getLocation().isEmpty()) {
            user.setLocation(updateuser.getLocation());
        }

        try {
            User updatedUser = userRepository.save(user);
            return updatedUser;
        } catch (Exception e) {
            throw new Exception("Error updating user: " + e.getMessage());
        }
    }

    @Override
    public FeedBack createFeedBack(User user, FeedBack feedBack) throws Exception {

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("user --> " + user);
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        try {
            FeedBack newFeedBack = new FeedBack();
            newFeedBack.setEmail(feedBack.getEmail());
            newFeedBack.setMessage(feedBack.getMessage());
            newFeedBack.setName(feedBack.getName());
            newFeedBack.setSubject(feedBack.getSubject());
            newFeedBack.setUser(user);
            FeedBack createdFeedBack = feedBackRepository.save(newFeedBack);
            return createdFeedBack;
        } catch (Exception e) {
            throw new Exception("Error creating feedback: " + e.getMessage());
        }
    }
}
